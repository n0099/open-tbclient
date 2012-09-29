package com.baidu.tieba.frs;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tieba.BaseActivity;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.account.LoginActivity;
import com.baidu.tieba.data.Config;
import com.baidu.tieba.data.GoodData;
import com.baidu.tieba.data.RequestResponseCode;
import com.baidu.tieba.data.ThreadData;
import com.baidu.tieba.home.CreateBarActivity;
import com.baidu.tieba.model.FrsModel;
import com.baidu.tieba.pb.PbActivity;
import com.baidu.tieba.person.PersonListActivity;
import com.baidu.tieba.util.DatabaseService;
import com.baidu.tieba.util.NetWork;
import com.baidu.tieba.util.NetWorkCore;
import com.baidu.tieba.util.NetWorkErr;
import com.baidu.tieba.util.TiebaLog;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.write.WriteActivity;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class FrsActivity extends BaseActivity {
    private static final int DIALOG_UNLIKE = 1;
    private static final String FLAG = "flag";
    private static final String FROM = "from";
    public static final int FRS_FLAG_ADD_SEARCH_HIS = 1;
    public static final int FRS_FLAG_NORMAL = 0;
    public static final String FRS_FROM_LIKE = "tb_forumlist";
    public static final String FRS_FROM_SEARCH = "tb_searchlist";
    public static final String FRS_TO_PB = "tb_frslist";
    public static final int HERDER_TYPE_LIKE = 1;
    public static final int HERDER_TYPE_PRE = 2;
    private static final int MENU_ID_LIKE = 3;
    private static final int MENU_ID_POST = 0;
    private static final int MENU_ID_REFRESH = 1;
    private static final int MENU_ID_UNLIKE = 4;
    private static final int MENU_ID_VIEWGOOD = 2;
    private static final String NAME = "name";
    public static final String REFRESH_TO_FRS = "tb_frslist";
    private static final int UPDATA_TYPE_LIKE = 4;
    private static final int UPDATA_TYPE_LIKE_MENU = 5;
    private static final int UPDATA_TYPE_NEXT = 1;
    private static final int UPDATA_TYPE_PREVIOUS = 2;
    private static final int UPDATA_TYPE_REFRESH = 3;
    private static final int UPDATA_TYPE_SIGN = 6;
    private static final String URL_ST_TYPE = "st_type";
    private String mForumSuffix;
    private static volatile long mPbLoadTime = 0;
    private static volatile int mNetError = 0;
    private boolean mIsFirst = true;
    private int mType = 3;
    private String mForum = null;
    private String mFrom = null;
    private int mFlag = 0;
    private String mGoodName = null;
    private long mGoodId = 0;
    private int mIsGood = 0;
    private int mPn = 1;
    private boolean isShowMenu = true;
    private String mThreadId = null;
    private boolean mIsRefresh = false;
    private Button mButtonBack = null;
    private TextView mFrsTitle = null;
    private LinearLayout mBtGood = null;
    private Button mButtonWrite = null;
    private Button mButtonRefresh = null;
    private ListView mListFrs = null;
    private FrsAdapter mAdapterFrs = null;
    private FrsAsyncTask mFrsTask = null;
    private FrsModel mModel = null;
    private ProgressBar mProgress = null;
    private TextView mForumNoExist = null;
    private LinearLayout mForumNoExistLayout = null;
    private TextView mForumNoExistLayoutText = null;
    private ImageView mTitleGood = null;
    private Button mCreateForumBotton = null;
    private FrsLikeAsyncTask mFrsLikeTask = null;
    private FrsSignAsyncTask mFrsSignTask = null;
    private Menu mMenu = null;
    private String mSource = null;
    private String mUid = null;
    private ThreadData mThreanData = null;
    private boolean isSigning = false;
    private AlertDialog mDialogGood = null;
    private View mDialogView = null;
    private DialogGoodAdapter mDialogAdapter = null;
    private LinearLayout mPageTitle = null;
    AlertDialog mMenuFrs = null;

    public static void startAcitivity(Context context, String name, String from) {
        Intent intent = new Intent(context, FrsActivity.class);
        if (name != null && name.length() > 0) {
            intent.putExtra("name", name);
            intent.putExtra(FROM, from);
            context.startActivity(intent);
        }
    }

    public static void startAcitivity(Context context, String name, String from, int flag) {
        Intent intent = new Intent(context, FrsActivity.class);
        if (name != null && name.length() > 0) {
            intent.putExtra("name", name);
            intent.putExtra(FROM, from);
            intent.putExtra(FLAG, flag);
            context.startActivity(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.BaseActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frs_activity);
        initUI();
        this.mUid = TiebaApplication.getCurrentAccount();
        if (savedInstanceState != null) {
            this.mForum = savedInstanceState.getString("name");
            this.mFrom = savedInstanceState.getString(FROM);
            this.mFlag = savedInstanceState.getInt(FLAG, 0);
        } else {
            Intent intent = getIntent();
            this.mForum = intent.getStringExtra("name");
            this.mFrom = intent.getStringExtra(FROM);
            this.mFlag = intent.getIntExtra(FLAG, 0);
        }
        if (this.mForum != null && this.mForum.length() > 0) {
            if (this.mFrom == null || this.mFrom.length() <= 0) {
                this.mFrom = FRS_FROM_LIKE;
            }
            this.mSource = this.mFrom;
            refresh();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.BaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        try {
            if (this.mFrsTask != null) {
                this.mFrsTask.cancel();
                this.mFrsTask = null;
            }
            if (this.mFrsLikeTask != null) {
                this.mFrsLikeTask.cancel();
                this.mFrsLikeTask = null;
            }
            if (this.mAdapterFrs != null) {
                this.mAdapterFrs.releaseProgressBar();
            }
            this.mProgress.setVisibility(8);
            System.gc();
        } catch (Exception e) {
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("name", this.mForum);
        outState.putString(FROM, this.mFrom);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == -1) {
            switch (requestCode) {
                case RequestResponseCode.REQUEST_LOGIN_WRITE /* 1100001 */:
                    writeBlog();
                    return;
                case RequestResponseCode.REQUEST_LOGIN_LIKE /* 1100002 */:
                    execLike();
                    return;
                case RequestResponseCode.REQUEST_LOGIN_FRS_HOST /* 1100011 */:
                    gotoPbHost(this.mThreanData);
                    return;
                case RequestResponseCode.REQUEST_LOGIN_FRS_REVERSE /* 1100012 */:
                    gotoPbReverse();
                    return;
                case RequestResponseCode.REQUEST_LOGIN_CREATE_BAR /* 1100013 */:
                    createBar();
                    return;
                case RequestResponseCode.REQUEST_LOGIN_SIGN /* 1100014 */:
                    execSign();
                    return;
                case RequestResponseCode.REQUEST_WRITE_NEW /* 1300003 */:
                    refresh();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.BaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        String id = TiebaApplication.getCurrentAccount();
        if (this.mUid == null && id != null && id.length() > 0) {
            this.mUid = id;
            if (this.mModel != null && this.mModel.getAnti() != null) {
                this.mModel.getAnti().setIfpost(1);
            }
        }
    }

    private void initUI() {
        this.mForumSuffix = getText(R.string.forum).toString();
        this.mIsFirst = true;
        this.mForum = "";
        this.mFrom = "";
        this.mFlag = 0;
        this.mIsGood = 0;
        this.mGoodId = 0L;
        this.mGoodName = "";
        this.mPn = 1;
        this.mType = 3;
        this.mFrsTitle = (TextView) findViewById(R.id.frs_tv_title);
        this.mTitleGood = (ImageView) findViewById(R.id.frs_tv_title_good);
        this.mButtonBack = (Button) findViewById(R.id.frs_bt_back);
        this.mButtonBack.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                FrsActivity.this.finish();
            }
        });
        this.mButtonWrite = (Button) findViewById(R.id.frs_bt_post);
        this.mButtonWrite.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                FrsActivity.this.writeBlog();
            }
        });
        this.mButtonRefresh = (Button) findViewById(R.id.frs_bt_refresh);
        this.mButtonRefresh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                FrsActivity.this.mSource = "tb_frslist";
                FrsActivity.this.refresh();
            }
        });
        this.mListFrs = (ListView) findViewById(R.id.frs_lv_thread);
        this.mAdapterFrs = new FrsAdapter(this, null);
        this.mListFrs.setAdapter((ListAdapter) this.mAdapterFrs);
        this.mListFrs.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.frs.FrsActivity.4
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                ListView tmpList = (ListView) arg0;
                FrsAdapter adapter = (FrsAdapter) tmpList.getAdapter();
                long index = adapter.getItemId(arg2);
                if (index == -1) {
                    if (adapter.getHeaderType() != 2 || FrsActivity.this.mPn <= 1) {
                        FrsActivity.this.mType = 4;
                        FrsActivity.this.execLike();
                        return;
                    }
                    FrsActivity frsActivity = FrsActivity.this;
                    frsActivity.mPn--;
                    FrsActivity.this.mType = 2;
                    FrsActivity.this.exec();
                } else if (index == -2) {
                    FrsActivity.this.mPn++;
                    FrsActivity.this.mType = 1;
                    FrsActivity.this.exec();
                } else {
                    ThreadData data = (ThreadData) adapter.getItem(arg2);
                    if (data != null) {
                        PbActivity.startAcitivity(FrsActivity.this, data.getId(), "tb_frslist");
                    }
                }
            }
        });
        this.mListFrs.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.frs.FrsActivity.5
            @Override // android.widget.AdapterView.OnItemLongClickListener
            public boolean onItemLongClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                ListView tmpList = (ListView) arg0;
                FrsAdapter adapter = (FrsAdapter) tmpList.getAdapter();
                long index = adapter.getItemId(arg2);
                if (index != -1 && index != -2) {
                    ThreadData data = (ThreadData) adapter.getItem(arg2);
                    FrsActivity.this.mThreadId = data.getId();
                    FrsActivity.this.prepareFrsMenuDialog(data);
                    FrsActivity.this.mMenuFrs.show();
                    return false;
                }
                return false;
            }
        });
        this.mProgress = (ProgressBar) findViewById(R.id.frs_progress);
        setIsRefresh(false);
        this.mForumNoExist = (TextView) findViewById(R.id.frs_noexist);
        this.mForumNoExist.setVisibility(8);
        this.mForumNoExistLayoutText = (TextView) findViewById(R.id.frs_noexist_text);
        this.mPageTitle = (LinearLayout) findViewById(R.id.frs_title);
        this.mBtGood = (LinearLayout) findViewById(R.id.frs_ll_bt_good);
        this.mBtGood.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                FrsActivity.this.showGoodDialog();
            }
        });
        this.mForumNoExistLayout = (LinearLayout) findViewById(R.id.frs_noexist_layout);
        this.mCreateForumBotton = (Button) findViewById(R.id.frs_bt_create);
        this.mCreateForumBotton.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                FrsActivity.this.createBar();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void createBar() {
        String id = TiebaApplication.getCurrentAccount();
        if (id == null || id.length() <= 0) {
            LoginActivity.startActivity((Activity) this, getString(R.string.login_to_use), true, (int) RequestResponseCode.REQUEST_LOGIN_CREATE_BAR);
            return;
        }
        CreateBarActivity.startActivity(this, this.mForum, true);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void writeBlog() {
        String id = TiebaApplication.getCurrentAccount();
        if (id == null || id.length() <= 0) {
            if (this.mModel != null && this.mModel.getAnti() != null) {
                this.mModel.getAnti().setIfpost(1);
            }
            LoginActivity.startActivity((Activity) this, getString(R.string.login_to_use), true, (int) RequestResponseCode.REQUEST_LOGIN_WRITE);
        } else if (this.mModel != null) {
            WriteActivity.startAcitivityForResult(this, this.mModel.getForum().getId(), this.mForum, this.mModel.getAnti());
        }
    }

    private boolean isAnonymityUser(ThreadData thread) {
        String id;
        return thread == null || thread.getAuthor() == null || (id = thread.getAuthor().getId()) == null || id.equals("0");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void prepareFrsMenuDialog(final ThreadData thread) {
        boolean isAnonymous = isAnonymityUser(thread);
        DialogInterface.OnClickListener menuFrsListener = new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.frs.FrsActivity.8
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int item) {
                switch (item) {
                    case 0:
                        if (FrsActivity.this.mThreadId != null) {
                            PbActivity.startAcitivity(FrsActivity.this, FrsActivity.this.mThreadId, "tb_frslist");
                            return;
                        }
                        return;
                    case 1:
                        FrsActivity.this.gotoPbHost(thread);
                        return;
                    case 2:
                        FrsActivity.this.gotoPbReverse();
                        return;
                    default:
                        return;
                }
            }
        };
        String menuView = getString(R.string.view);
        String menuHost = getString(R.string.view_host);
        String menuReverse = getString(R.string.view_reverse);
        AlertDialog.Builder builderLike = new AlertDialog.Builder(this);
        builderLike.setTitle(R.string.operation);
        if (isAnonymous) {
            builderLike.setItems(new String[]{menuView, menuReverse}, menuFrsListener);
        } else {
            builderLike.setItems(new String[]{menuView, menuHost, menuReverse}, menuFrsListener);
        }
        this.mMenuFrs = builderLike.create();
        this.mMenuFrs.setCanceledOnTouchOutside(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gotoPbHost(ThreadData thread) {
        String id = TiebaApplication.getCurrentAccount();
        if (id == null || id.length() <= 0) {
            this.mThreanData = thread;
            LoginActivity.startActivity((Activity) this, getString(R.string.login_to_use), true, (int) RequestResponseCode.REQUEST_LOGIN_FRS_HOST);
            return;
        }
        boolean isAnonymous = isAnonymityUser(thread);
        if (this.mThreadId != null) {
            if (!isAnonymous) {
                PbActivity.startAcitivity(this, this.mThreadId, true, true, "tb_frslist");
            } else {
                PbActivity.startAcitivity(this, this.mThreadId, false, false, "tb_frslist");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gotoPbReverse() {
        String id = TiebaApplication.getCurrentAccount();
        if (id == null || id.length() <= 0) {
            LoginActivity.startActivity((Activity) this, getString(R.string.login_to_use), true, (int) RequestResponseCode.REQUEST_LOGIN_FRS_REVERSE);
        } else if (this.mThreadId != null) {
            PbActivity.startAcitivity(this, this.mThreadId, false, false, "tb_frslist");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showGoodDialog() {
        if (this.mDialogGood == null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            this.mDialogGood = builder.create();
            this.mDialogGood.setCanceledOnTouchOutside(true);
            LayoutInflater mInflater = getLayoutInflater();
            this.mDialogView = mInflater.inflate(R.layout.dialog_good, (ViewGroup) null);
            ListView list = (ListView) this.mDialogView.findViewById(R.id.frs_dia_list);
            this.mDialogAdapter = new DialogGoodAdapter(this, null);
            list.setAdapter((ListAdapter) this.mDialogAdapter);
            list.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.frs.FrsActivity.9
                @Override // android.widget.AdapterView.OnItemClickListener
                public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                    FrsActivity.this.mDialogGood.dismiss();
                    ListView tmpList = (ListView) arg0;
                    GoodData data = (GoodData) tmpList.getAdapter().getItem(arg2);
                    if (data.getClass_id() != DialogGoodAdapter.FRS_ALLTHREAD_CLASS_ID) {
                        FrsActivity.this.mIsGood = 1;
                        FrsActivity.this.mGoodId = data.getClass_id();
                        FrsActivity.this.mGoodName = data.getClass_name();
                        FrsActivity.this.mPn = 1;
                        FrsActivity.this.mType = 3;
                        FrsActivity.this.exec();
                        return;
                    }
                    FrsActivity.this.refresh();
                }
            });
        }
        if (this.mDialogAdapter != null) {
            this.mDialogAdapter.setData(this.mModel.getForum().getGood_classify());
            this.mDialogAdapter.notifyDataSetInvalidated();
        }
        this.mDialogGood.show();
        this.mDialogGood.setContentView(this.mDialogView);
        int y = (this.mPageTitle.getTop() + this.mPageTitle.getHeight()) - 5;
        WindowManager.LayoutParams wmParams = this.mDialogGood.getWindow().getAttributes();
        wmParams.gravity = 49;
        wmParams.y = y;
        wmParams.alpha = 1.0f;
        wmParams.width = UtilHelper.dip2px(this, 160.0f);
        wmParams.height = -2;
        this.mDialogGood.getWindow().setAttributes(wmParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refresh() {
        this.mIsGood = 0;
        this.mGoodId = 0L;
        this.mGoodName = "";
        this.mPn = 1;
        this.mType = 3;
        exec();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setIsRefresh(boolean b) {
        this.mIsRefresh = b;
        if (b) {
            this.mProgress.setVisibility(0);
        } else {
            this.mProgress.setVisibility(8);
        }
    }

    private boolean getIsRefresh() {
        return this.mIsRefresh;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void exec() {
        switch (this.mType) {
            case 1:
                if (this.mAdapterFrs.getIsProcessNext()) {
                    return;
                }
                break;
            case 2:
                if (this.mAdapterFrs.getIsProcessPre()) {
                    return;
                }
                break;
            case 3:
                if (getIsRefresh()) {
                    return;
                }
                break;
        }
        StringBuffer address = new StringBuffer(30);
        address.append(Config.SERVER_ADDRESS);
        address.append(Config.FRS_ADDRESS);
        ArrayList<BasicNameValuePair> param = new ArrayList<>();
        BasicNameValuePair tmp = new BasicNameValuePair("kw", this.mForum);
        param.add(tmp);
        BasicNameValuePair tmp2 = new BasicNameValuePair(PersonListActivity.TAG_PAGE, String.valueOf(this.mPn));
        param.add(tmp2);
        if (this.mIsGood == 1) {
            BasicNameValuePair tmp3 = new BasicNameValuePair("is_good", NetWorkCore.NET_TYPE_NET);
            param.add(tmp3);
            BasicNameValuePair tmp4 = new BasicNameValuePair("cid", String.valueOf(this.mGoodId));
            param.add(tmp4);
        }
        if (this.mSource != null) {
            BasicNameValuePair st_type = new BasicNameValuePair(URL_ST_TYPE, this.mSource);
            param.add(st_type);
        }
        cancelAsyncTask();
        this.mFrsTask = new FrsAsyncTask(address.toString(), param, this.mType);
        this.mFrsTask.execute(address.toString(), param);
    }

    public void execSign() {
        this.mType = 6;
        String id = TiebaApplication.getCurrentAccount();
        if (id == null || id.length() <= 0) {
            LoginActivity.startActivity((Activity) this, getString(R.string.login_to_use), true, (int) RequestResponseCode.REQUEST_LOGIN_SIGN);
        } else if (this.mModel != null && !this.isSigning) {
            String address = String.valueOf("") + "http://c.tieba.baidu.com/c/c/forum/sign";
            ArrayList<BasicNameValuePair> param = new ArrayList<>();
            BasicNameValuePair tmp = new BasicNameValuePair("kw", this.mForum);
            param.add(tmp);
            cancelAsyncTask();
            this.mFrsSignTask = new FrsSignAsyncTask(address.toString(), param, this.mType);
            this.mFrsSignTask.execute(address.toString(), param);
        }
    }

    public void execLike() {
        String id = TiebaApplication.getCurrentAccount();
        if (id == null || id.length() <= 0) {
            LoginActivity.startActivity((Activity) this, getString(R.string.login_to_use), true, (int) RequestResponseCode.REQUEST_LOGIN_LIKE);
        } else if (this.mModel != null) {
            if (!this.mAdapterFrs.getIsProcessPre() || this.mType != 4) {
                int isLike = this.mModel.getForum().isIs_like();
                StringBuffer address = new StringBuffer(30);
                address.append(Config.SERVER_ADDRESS);
                if (isLike == 1) {
                    address.append(Config.UNLIKE_ADDRESS);
                } else {
                    address.append(Config.LIKE_ADDRESS);
                }
                ArrayList<BasicNameValuePair> param = new ArrayList<>();
                BasicNameValuePair tmp = new BasicNameValuePair("fid", this.mModel.getForum().getId());
                param.add(tmp);
                BasicNameValuePair tmp2 = new BasicNameValuePair("kw", this.mForum);
                param.add(tmp2);
                cancelAsyncTask();
                this.mFrsLikeTask = new FrsLikeAsyncTask(address.toString(), param, this.mType);
                this.mFrsLikeTask.execute(address.toString(), param);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hiddenGoodBar() {
        if (this.mIsFirst) {
            this.mBtGood.setVisibility(4);
        } else {
            this.mBtGood.setClickable(false);
        }
    }

    private void showGoodBar() {
        if (this.mIsGood == 0) {
            this.mFrsTitle.setText(this.mForum.concat(this.mForumSuffix));
        } else {
            this.mFrsTitle.setText(this.mGoodName);
        }
        if (this.mIsFirst) {
            this.mBtGood.setVisibility(0);
        } else {
            this.mBtGood.setClickable(true);
        }
    }

    private void processFlag() {
        switch (this.mFlag) {
            case 1:
                DatabaseService.saveOneSearchData(this.mForum);
                break;
        }
        this.mFlag = 0;
    }

    private void processFirst() {
        this.mIsFirst = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshFrs() {
        this.mListFrs.setVisibility(0);
        this.mButtonWrite.setVisibility(0);
        this.mButtonRefresh.setVisibility(0);
        try {
            if (this.mModel != null) {
                this.mForum = this.mModel.getForum().getName();
                showGoodBar();
                processFlag();
                processFirst();
                ArrayList<ThreadData> list = this.mModel.getThread_list();
                if (list != null) {
                    this.mAdapterFrs.setData(list);
                    if (this.mPn == 1 && this.mIsGood == 0 && this.mModel.getThread_list().size() > 0) {
                        this.mAdapterFrs.setHaveHeader(true);
                        this.mAdapterFrs.setHeaderType(1);
                        if (this.mModel.getForum().getSignData().getForumRank() == -1) {
                            if (this.mModel.getForum().isIs_like() == 0) {
                                this.mAdapterFrs.setOnlyLike(false);
                            } else {
                                this.mAdapterFrs.setHaveHeader(false);
                            }
                        } else if (this.mModel.getForum().isIs_like() == 0 && this.mModel.getForum().getSignData().getSigned() == 0) {
                            this.mAdapterFrs.setLikeSign(false, false);
                        } else if (this.mModel.getForum().isIs_like() != 0 && this.mModel.getForum().getSignData().getSigned() == 0) {
                            this.mAdapterFrs.setOnlySigned(false, String.valueOf(this.mModel.getForum().getSignData().getForumRank()));
                        } else if (this.mModel.getForum().isIs_like() == 0 && this.mModel.getForum().getSignData().getSigned() != 0) {
                            this.mAdapterFrs.setOnlyLike(false);
                        } else {
                            this.mAdapterFrs.setHaveHeader(false);
                        }
                    } else if (this.mPn > 1) {
                        this.mAdapterFrs.setHaveHeader(true);
                        this.mAdapterFrs.setHeaderType(2);
                    } else {
                        this.mAdapterFrs.setHaveHeader(false);
                    }
                    if (this.mModel.getPage().getHave_more() == 1) {
                        this.mAdapterFrs.setHaveFooter(true);
                    } else {
                        this.mAdapterFrs.setHaveFooter(false);
                    }
                    this.mAdapterFrs.setIsProcessNext(false);
                    this.mAdapterFrs.setIsProcessPre(false);
                    this.mAdapterFrs.notifyDataSetInvalidated();
                    if (this.mType == 1) {
                        this.mListFrs.setSelection(1);
                    } else if (this.mAdapterFrs.getHaveHeader()) {
                        this.mListFrs.setSelection(0);
                    } else {
                        this.mListFrs.setSelection(0);
                    }
                    this.mForumNoExist.setVisibility(8);
                    setIsRefresh(false);
                    refreshMenu();
                }
                if ((list == null || list.size() <= 0) && this.mIsGood != 1) {
                    this.mForumNoExist.setText(R.string.frs_nodata);
                    this.mForumNoExist.setVisibility(0);
                }
            }
        } catch (Exception ex) {
            TiebaLog.e(getClass().getName(), "", "HomeActivity.refreshFrs error = " + ex.getMessage());
        }
    }

    private void cancelAsyncTask() {
        if (this.mFrsTask != null) {
            this.mFrsTask.cancel();
            this.mFrsTask = null;
        }
        if (this.mFrsLikeTask != null) {
            this.mFrsLikeTask.cancel();
            this.mFrsLikeTask = null;
        }
        if (this.mFrsSignTask != null) {
            this.mFrsSignTask.cancel();
            this.mFrsSignTask = null;
        }
        setIsRefresh(false);
        this.mAdapterFrs.setIsProcessNext(false);
        this.mAdapterFrs.setIsProcessPre(false);
        this.mAdapterFrs.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class FrsAsyncTask extends AsyncTask<Object, Integer, FrsModel> {
        ArrayList<BasicNameValuePair> mParams;
        private int mUpdateType;
        private String mUrl;
        private NetWork mNetwork = null;
        private volatile long mStartTime = 0;

        public FrsAsyncTask(String url, ArrayList<BasicNameValuePair> param, int type) {
            this.mUrl = null;
            this.mUpdateType = 3;
            this.mParams = null;
            this.mUrl = url;
            this.mParams = param;
            this.mUpdateType = type;
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            FrsActivity.this.hiddenGoodBar();
            this.mStartTime = System.nanoTime();
            switch (this.mUpdateType) {
                case 1:
                    FrsActivity.this.mAdapterFrs.setIsProcessNext(true);
                    FrsActivity.this.mAdapterFrs.notifyDataSetChanged();
                    return;
                case 2:
                    FrsActivity.this.mAdapterFrs.setIsProcessPre(true);
                    FrsActivity.this.mAdapterFrs.notifyDataSetChanged();
                    return;
                case 3:
                    FrsActivity.this.setIsRefresh(true);
                    return;
                default:
                    return;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.AsyncTask
        public FrsModel doInBackground(Object... params) {
            FrsModel frsData = null;
            try {
                this.mNetwork = new NetWork(this.mUrl);
                this.mNetwork.setPostData(this.mParams);
                if (FrsActivity.mPbLoadTime != 0) {
                    this.mNetwork.addPostData("ctime", String.valueOf(FrsActivity.mPbLoadTime));
                }
                if (FrsActivity.mNetError != 0) {
                    this.mNetwork.addPostData("net_error", String.valueOf(FrsActivity.mNetError));
                }
                this.mNetwork.setContext(FrsActivity.this);
                String data = this.mNetwork.postNetData();
                if (this.mNetwork.isRequestSuccess()) {
                    FrsModel frsData2 = new FrsModel();
                    try {
                        frsData2.parserJson(data);
                        frsData = frsData2;
                    } catch (Exception e) {
                        ex = e;
                        frsData = frsData2;
                        TiebaLog.e(getClass().getName(), "", "FrsAsyncTask.doInBackground error = " + ex.getMessage());
                        return frsData;
                    }
                }
                if (this.mNetwork.isNetSuccess()) {
                    FrsActivity.mPbLoadTime = 0L;
                    FrsActivity.mNetError = 0;
                } else {
                    FrsActivity.mNetError = 1;
                }
            } catch (Exception e2) {
                ex = e2;
            }
            return frsData;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(FrsModel data) {
            switch (this.mUpdateType) {
                case 1:
                    FrsActivity.this.mAdapterFrs.setIsProcessNext(false);
                    FrsActivity.this.mAdapterFrs.notifyDataSetChanged();
                    break;
                case 2:
                    FrsActivity.this.mAdapterFrs.setIsProcessPre(false);
                    FrsActivity.this.mAdapterFrs.notifyDataSetChanged();
                    break;
                case 3:
                    FrsActivity.this.setIsRefresh(false);
                    break;
            }
            if (data != null) {
                FrsActivity.this.mModel = data;
                FrsActivity.this.refreshFrs();
                long end_time = System.nanoTime();
                FrsActivity.mPbLoadTime = (end_time - this.mStartTime) / 1000000000;
            } else {
                processError();
            }
            FrsActivity.this.mFrsTask = null;
            FrsActivity.this.mSource = null;
            System.gc();
        }

        @Override // android.os.AsyncTask
        protected void onCancelled() {
            super.onCancelled();
        }

        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.cancelNetConnect();
                this.mNetwork = null;
            }
            super.cancel(true);
        }

        private void processError() {
            if (FrsActivity.this.mIsFirst) {
                if (this.mNetwork != null) {
                    if (this.mNetwork.isNetSuccess()) {
                        if (this.mNetwork.getErrorCode() == 3) {
                            FrsActivity.this.isShowMenu = false;
                            FrsActivity.this.mForumNoExist.setText(R.string.frs_noforum);
                            FrsActivity.this.mForum = FrsActivity.this.mForum.replace(" ", "");
                            String mForumShort = FrsActivity.this.mForum;
                            if (mForumShort.length() > 31) {
                                mForumShort = String.valueOf(mForumShort.substring(0, 31)) + "...";
                            }
                            String info = String.valueOf(mForumShort) + FrsActivity.this.getString(R.string.frs_remind_noforum);
                            SpannableString noForum = new SpannableString(info);
                            noForum.setSpan(new ForegroundColorSpan(Color.rgb(229, 4, 0)), 0, mForumShort.length(), 33);
                            FrsActivity.this.mForumNoExistLayout.setVisibility(0);
                            FrsActivity.this.mForumNoExistLayoutText.setText(noForum);
                            FrsActivity.this.mBtGood.setVisibility(0);
                            FrsActivity.this.mBtGood.setClickable(false);
                            FrsActivity.this.mFrsTitle.setText(R.string.frs_create_forum);
                            FrsActivity.this.mTitleGood.setVisibility(8);
                            FrsActivity.this.mListFrs.setVisibility(8);
                            FrsActivity.this.mButtonRefresh.setVisibility(4);
                            FrsActivity.this.mButtonRefresh.setClickable(false);
                            FrsActivity.this.mButtonWrite.setVisibility(4);
                            FrsActivity.this.mButtonWrite.setClickable(false);
                            return;
                        }
                        FrsActivity.this.showToast(this.mNetwork.getErrorString());
                        return;
                    }
                    FrsActivity.this.showToast(this.mNetwork.getErrorString());
                    return;
                }
                return;
            }
            FrsActivity.this.showToast(this.mNetwork.getErrorString());
            FrsActivity.this.mBtGood.setClickable(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class FrsSignAsyncTask extends AsyncTask<Object, Integer, Integer> {
        ArrayList<BasicNameValuePair> mParams;
        private int mUpdateType;
        private String mUrl;
        private NetWork mNetwork = null;
        private String result = null;

        public FrsSignAsyncTask(String url, ArrayList<BasicNameValuePair> param, int type) {
            this.mUrl = null;
            this.mUpdateType = 3;
            this.mParams = null;
            this.mUrl = url;
            this.mParams = param;
            this.mUpdateType = type;
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            FrsActivity.this.setIsRefresh(true);
            FrsActivity.this.isSigning = true;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.AsyncTask
        public Integer doInBackground(Object... arg0) {
            int i;
            try {
                this.mNetwork = new NetWork(this.mUrl);
                this.mNetwork.setPostData(this.mParams);
                this.mNetwork.setIsNeedTbs(true);
                this.mNetwork.setContext(FrsActivity.this);
                this.result = this.mNetwork.postNetData();
                if (this.mNetwork.isNetSuccess()) {
                    int errCode = this.mNetwork.getErrorCode();
                    if (errCode == 0) {
                        i = 0;
                    } else if (errCode == 160002) {
                        i = Integer.valueOf((int) NetWorkErr.HAVE_SIGNED);
                    } else {
                        i = -1;
                    }
                } else {
                    i = -1;
                }
                return i;
            } catch (Exception ex) {
                TiebaLog.e(getClass().getName(), "", "FrsAsyncTask.doInBackground error = " + ex.getMessage());
                return -1;
            }
        }

        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.cancelNetConnect();
                this.mNetwork = null;
            }
            FrsActivity.this.isSigning = false;
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(Integer data) {
            FrsActivity.this.isSigning = false;
            switch (this.mUpdateType) {
                case 4:
                    FrsActivity.this.mAdapterFrs.setIsProcessPre(false);
                    FrsActivity.this.mAdapterFrs.notifyDataSetChanged();
                    break;
            }
            if (data.intValue() == 0) {
                FrsActivity.this.mModel.getForum().getSignData().parserJson(this.result);
                String rank = String.valueOf(FrsActivity.this.mModel.getForum().getSignData().getUserSignRank());
                if (FrsActivity.this.mModel.getForum().isIs_like() == 0) {
                    FrsActivity.this.mAdapterFrs.setSign(true);
                    FrsActivity.this.mAdapterFrs.notifyDataSetChanged();
                    String toast = FrsActivity.this.getResources().getString(R.string.sign_success_toast);
                    FrsActivity.this.showToast(toast.replace("?", rank));
                } else {
                    FrsActivity.this.mAdapterFrs.setOnlySigned(true, rank);
                    FrsActivity.this.mAdapterFrs.notifyDataSetChanged();
                }
            } else {
                if (data.intValue() == 160002) {
                    FrsActivity.this.mAdapterFrs.setSign(true);
                    FrsActivity.this.mAdapterFrs.notifyDataSetChanged();
                    FrsActivity.this.mModel.getForum().getSignData().setIsSigned(1);
                }
                FrsActivity.this.showToast(this.mNetwork.getErrorString());
            }
            FrsActivity.this.setIsRefresh(false);
            FrsActivity.this.mFrsSignTask = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class FrsLikeAsyncTask extends AsyncTask<Object, Integer, Integer> {
        private NetWork mNetwork = null;
        ArrayList<BasicNameValuePair> mParams;
        private int mUpdateType;
        private String mUrl;

        public FrsLikeAsyncTask(String url, ArrayList<BasicNameValuePair> param, int type) {
            this.mUrl = null;
            this.mUpdateType = 3;
            this.mParams = null;
            this.mUrl = url;
            this.mParams = param;
            this.mUpdateType = type;
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            switch (this.mUpdateType) {
                case 4:
                    FrsActivity.this.setIsRefresh(true);
                    return;
                default:
                    return;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.AsyncTask
        public Integer doInBackground(Object... params) {
            int i;
            try {
                this.mNetwork = new NetWork(this.mUrl);
                this.mNetwork.setPostData(this.mParams);
                this.mNetwork.setIsNeedTbs(true);
                this.mNetwork.setContext(FrsActivity.this);
                this.mNetwork.postNetData();
                if (this.mNetwork.isNetSuccess()) {
                    int errCode = this.mNetwork.getErrorCode();
                    if (errCode == 0) {
                        i = 0;
                    } else if (errCode == 22) {
                        i = -2;
                    } else {
                        i = -1;
                    }
                } else {
                    i = -1;
                }
                return i;
            } catch (Exception ex) {
                TiebaLog.e(getClass().getName(), "", "FrsAsyncTask.doInBackground error = " + ex.getMessage());
                return -1;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(Integer data) {
            switch (this.mUpdateType) {
                case 4:
                    FrsActivity.this.mAdapterFrs.setIsProcessPre(false);
                    FrsActivity.this.mAdapterFrs.notifyDataSetChanged();
                    break;
            }
            if (data.intValue() == 0) {
                int isLike = FrsActivity.this.mModel.getForum().isIs_like() == 1 ? 0 : 1;
                FrsActivity.this.mModel.getForum().setIs_like(isLike);
                if (isLike == 1) {
                    FrsActivity.this.showToast(FrsActivity.this.getString(R.string.like_success));
                } else {
                    FrsActivity.this.showToast(FrsActivity.this.getString(R.string.success));
                }
                FrsActivity.this.mAdapterFrs.setLike(true);
                FrsActivity.this.mAdapterFrs.notifyDataSetChanged();
            } else if (data.intValue() == -2) {
                FrsActivity.this.mModel.getForum().setIs_like(1);
                FrsActivity.this.showToast(this.mNetwork.getErrorString());
                FrsActivity.this.mAdapterFrs.setLike(true);
                FrsActivity.this.mAdapterFrs.notifyDataSetChanged();
            } else {
                FrsActivity.this.showToast(this.mNetwork.getErrorString());
            }
            FrsActivity.this.setIsRefresh(false);
            FrsActivity.this.mFrsLikeTask = null;
        }

        @Override // android.os.AsyncTask
        protected void onCancelled() {
            super.onCancelled();
        }

        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.cancelNetConnect();
                this.mNetwork = null;
            }
            super.cancel(true);
        }
    }

    private void refreshMenu() {
        if (this.mMenu != null) {
            try {
                MenuItem menuPost = this.mMenu.findItem(0);
                MenuItem menuRefresh = this.mMenu.findItem(1);
                MenuItem menuViewGood = this.mMenu.findItem(2);
                MenuItem menuLike = this.mMenu.findItem(3);
                MenuItem menuUnlike = this.mMenu.findItem(4);
                if (menuPost != null) {
                    menuPost.setVisible(true);
                }
                if (menuRefresh != null) {
                    menuRefresh.setVisible(true);
                }
                if (menuViewGood != null) {
                    menuViewGood.setVisible(true);
                }
                if (this.mModel == null) {
                    if (menuPost != null) {
                        menuPost.setEnabled(false);
                    }
                    if (menuViewGood != null) {
                        menuViewGood.setEnabled(false);
                    }
                    if (menuUnlike != null) {
                        menuUnlike.setEnabled(false);
                    }
                    if (menuLike != null) {
                        menuLike.setEnabled(false);
                    }
                } else {
                    if (menuPost != null) {
                        menuPost.setEnabled(true);
                    }
                    if (menuViewGood != null) {
                        menuViewGood.setEnabled(true);
                    }
                    if (menuUnlike != null) {
                        menuUnlike.setEnabled(true);
                    }
                    if (menuLike != null) {
                        menuLike.setEnabled(true);
                    }
                }
                if (this.mModel.getForum().isIs_like() == 1) {
                    if (menuUnlike != null) {
                        menuUnlike.setVisible(true);
                    }
                    if (menuLike != null) {
                        menuLike.setVisible(false);
                        return;
                    }
                    return;
                }
                if (menuUnlike != null) {
                    menuUnlike.setVisible(false);
                }
                if (menuLike != null) {
                    menuLike.setVisible(true);
                }
            } catch (Exception ex) {
                TiebaLog.e("FrsActivity", "onPrepareOptionsMenu", "exp: " + ex.toString());
            }
        }
    }

    @Override // android.app.Activity
    public void onOptionsMenuClosed(Menu menu) {
        super.onOptionsMenuClosed(menu);
    }

    @Override // android.app.Activity
    public boolean onPrepareOptionsMenu(Menu menu) {
        refreshMenu();
        return super.onPrepareOptionsMenu(menu);
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        this.mMenu = menu;
        menu.add(0, 0, 1, getString(R.string.write_msg)).setIcon(R.drawable.menu_post);
        menu.add(0, 1, 2, getString(R.string.refresh)).setIcon(R.drawable.menu_refresh);
        menu.add(0, 2, 3, getString(R.string.view_good)).setIcon(R.drawable.menu_view_good);
        menu.add(0, 3, 4, getString(R.string.like_forum_menu)).setIcon(R.drawable.menu_unlike);
        menu.add(0, 4, 4, getString(R.string.unlike)).setIcon(R.drawable.menu_unlike);
        return true;
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case 0:
                writeBlog();
                break;
            case 1:
                if (this.mForum != null && this.mForum.length() > 0) {
                    refresh();
                    break;
                }
                break;
            case 2:
                showGoodDialog();
                break;
            case 3:
                this.mType = 5;
                execLike();
                break;
            case 4:
                showDialog(1);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case 1:
                return new AlertDialog.Builder(this).setTitle(R.string.alerm_title).setIcon(R.drawable.dialogue_quit).setMessage(R.string.unlike_info).setPositiveButton(getString(R.string.confirm), new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.frs.FrsActivity.10
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface arg0, int arg1) {
                        FrsActivity.this.mType = 5;
                        FrsActivity.this.execLike();
                    }
                }).setNegativeButton(getString(R.string.cancel), (DialogInterface.OnClickListener) null).create();
            default:
                return super.onCreateDialog(id);
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode != 82 || this.isShowMenu) {
            return super.onKeyDown(keyCode, event);
        }
        return true;
    }
}
