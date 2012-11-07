package com.baidu.tieba.frs;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tieba.BaseActivity;
import com.baidu.tieba.MainTabActivity;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.account.LoginActivity;
import com.baidu.tieba.account.PvThread;
import com.baidu.tieba.data.Config;
import com.baidu.tieba.data.GoodData;
import com.baidu.tieba.data.MediaData;
import com.baidu.tieba.data.RequestResponseCode;
import com.baidu.tieba.data.ThreadData;
import com.baidu.tieba.home.CreateBarActivity;
import com.baidu.tieba.model.FrsModel;
import com.baidu.tieba.pb.PbActivity;
import com.baidu.tieba.person.PersonListActivity;
import com.baidu.tieba.util.AsyncImageLoader;
import com.baidu.tieba.util.DatabaseService;
import com.baidu.tieba.util.NetWork;
import com.baidu.tieba.util.NetWorkCore;
import com.baidu.tieba.util.NetWorkErr;
import com.baidu.tieba.util.TiebaLog;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.view.FrsImageView;
import com.baidu.tieba.view.ImageViewDialog;
import com.baidu.tieba.write.WriteActivity;
import com.baidu.tieba.write.WriteImageActivity;
import com.baidu.tieba.write.WriteUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class FrsActivity extends BaseActivity {
    private static final String BACK_SPECIAL = "back_special";
    private static final int DIALOG_UNLIKE = 1;
    private static final String FLAG = "flag";
    private static final String FROM = "from";
    public static final String FROM_SHORT_CUT = "from_short_cut";
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
    private static final int WRITE_PIC = 1;
    private static final int WRITE_TEXT = 0;
    private String mForumSuffix;
    private static volatile long mPbLoadTime = 0;
    private static volatile long mPbLoadDataSize = 0;
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
    private boolean isShowMenu = false;
    private String mThreadId = null;
    private boolean mIsRefresh = false;
    private Button mButtonBack = null;
    private TextView mFrsTitle = null;
    private LinearLayout mBtGood = null;
    private Button mButtonWrite = null;
    private Button mButtonRefresh = null;
    private Button mButtonCamera = null;
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
    private AlertDialog mSelectImageDialog = null;
    private String mSource = null;
    private String mUid = null;
    private ThreadData mThreanData = null;
    private boolean isSigning = false;
    private Button mGoHomeButton = null;
    private LinearLayout mBottomLayout = null;
    private AlertDialog mDialogGood = null;
    private View mDialogView = null;
    private DialogGoodAdapter mDialogAdapter = null;
    private LinearLayout mPageTitle = null;
    AlertDialog mMenuFrs = null;
    private Handler mHandler = null;
    private AsyncImageLoader mBigImageLoader = null;
    private ImageViewDialog mImageViewDialog = null;
    private Runnable mGetImageRunnble = new Runnable() { // from class: com.baidu.tieba.frs.FrsActivity.1
        @Override // java.lang.Runnable
        public void run() {
            boolean supportHold;
            try {
                int start = FrsActivity.this.mListFrs.getFirstVisiblePosition();
                int end = FrsActivity.this.mListFrs.getLastVisiblePosition();
                int image_num = 0;
                NetWorkCore.NetworkStateInfo info = NetWorkCore.getStatusInfo(FrsActivity.this);
                FrsActivity.this.mAdapterFrs.getImageLoader().clearHoldUrl();
                if (info == NetWorkCore.NetworkStateInfo.WIFI || info == NetWorkCore.NetworkStateInfo.ThreeG) {
                    supportHold = true;
                } else {
                    supportHold = false;
                }
                FrsActivity.this.mAdapterFrs.getImageLoader().setSupportHoldUrl(supportHold);
                for (int i = start; i < FrsActivity.this.mAdapterFrs.getCount(); i++) {
                    if (supportHold || i <= end) {
                        ThreadData data = (ThreadData) FrsActivity.this.mAdapterFrs.getItem(i);
                        if (data != null) {
                            ArrayList<MediaData> content = data.getMedias();
                            int contentSize = content.size();
                            if (TiebaApplication.app.getIsAbstractState() && image_num < 13) {
                                for (int j = 0; j < contentSize; j++) {
                                    if (content.get(j).getType() == 3) {
                                        if (image_num >= 13) {
                                            break;
                                        }
                                        image_num++;
                                        FrsActivity.this.mAdapterFrs.getImageLoader().loadImage(content.get(j).getPicUrl(), new AsyncImageLoader.ImageCallback() { // from class: com.baidu.tieba.frs.FrsActivity.1.1
                                            @Override // com.baidu.tieba.util.AsyncImageLoader.ImageCallback
                                            public void imageLoaded(Bitmap bitmap, String imageUrl, boolean iscached) {
                                                FrsImageView view;
                                                if (bitmap != null && (view = (FrsImageView) FrsActivity.this.mListFrs.findViewWithTag(imageUrl)) != null) {
                                                    view.invalidate();
                                                }
                                            }
                                        });
                                    }
                                }
                            }
                            if (supportHold && image_num >= 13 && 0 >= 30) {
                                return;
                            }
                        }
                    } else {
                        return;
                    }
                }
            } catch (Exception ex) {
                TiebaLog.e("PbActivity", "mGetImageRunnble.run", "error = " + ex.getMessage());
            }
        }
    };
    private AdapterView.OnItemLongClickListener frsItemLongClickListener = new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.frs.FrsActivity.2
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
    };

    public static void startAcitivity(Context context, String name, String from) {
        startAcitivityBackSpecial(context, name, from, false);
    }

    public static void startAcitivityBackSpecial(Context context, String name, String from, boolean special) {
        Intent intent = new Intent(context, FrsActivity.class);
        if (name != null && name.length() > 0) {
            intent.putExtra("name", name);
            intent.putExtra("from", from);
            intent.putExtra("back_special", special);
            context.startActivity(intent);
        }
    }

    public static void startAcitivity(Context context, String name, String from, int flag) {
        Intent intent = new Intent(context, FrsActivity.class);
        if (name != null && name.length() > 0) {
            intent.putExtra("name", name);
            intent.putExtra("from", from);
            intent.putExtra(FLAG, flag);
            context.startActivity(intent);
        }
    }

    public static Intent getIntent(Context context, String name) {
        if (name == null || name.length() <= 0) {
            return null;
        }
        Intent intent = new Intent(context, FrsActivity.class);
        intent.putExtra("name", name);
        return intent;
    }

    private void initBigImageLoader() {
        this.mBigImageLoader = new AsyncImageLoader(this);
        this.mBigImageLoader.setIsPv(true);
        int width = UtilHelper.dip2px(this, 234.0f);
        if (width > 350) {
            width = Config.PB_IMAGE_NEW_MAX_WIDTH;
        }
        this.mBigImageLoader.setImagesize(width, (int) (width * 1.62f));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.BaseActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (dealShortCut()) {
            setContentView(R.layout.frs_activity);
            this.mHandler = new Handler();
            initBigImageLoader();
            initUI();
            this.mUid = TiebaApplication.getCurrentAccount();
            if (savedInstanceState != null) {
                this.mForum = savedInstanceState.getString("name");
                this.mFrom = savedInstanceState.getString("from");
                this.mFlag = savedInstanceState.getInt(FLAG, 0);
            } else {
                Intent intent = getIntent();
                this.mForum = intent.getStringExtra("name");
                this.mFrom = intent.getStringExtra("from");
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
    }

    private boolean dealShortCut() {
        boolean from_short_cut = getIntent().getBooleanExtra(FROM_SHORT_CUT, false);
        if (from_short_cut) {
            ActivityManager am = (ActivityManager) getSystemService("activity");
            List<ActivityManager.RunningTaskInfo> list = am.getRunningTasks(10);
            Iterator<ActivityManager.RunningTaskInfo> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                ActivityManager.RunningTaskInfo runningTaskInfo = it.next();
                if (runningTaskInfo.topActivity.getClassName().equals(getClass().getName())) {
                    if (runningTaskInfo.numActivities <= 1) {
                        MainTabActivity.startActivity(this, MainTabActivity.GOTO_MORE, 2, getIntent().getStringExtra("name"));
                        finish();
                        return false;
                    }
                }
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.BaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.mGetImageRunnble);
        }
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
            if (this.mProgress != null) {
                this.mProgress.setVisibility(8);
            }
            System.gc();
        } catch (Exception e) {
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("name", this.mForum);
        outState.putString("from", this.mFrom);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == -1) {
            switch (requestCode) {
                case RequestResponseCode.REQUEST_LOGIN_WRITE /* 1100001 */:
                    writeBlog(0);
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
                case RequestResponseCode.REQUEST_LOGIN_CAMERA_OR_IMAGE /* 1100016 */:
                    this.mSelectImageDialog.show();
                    return;
                case RequestResponseCode.REQUEST_CAMERA /* 1200001 */:
                    if (this.mModel != null && this.mModel.getForum() != null) {
                        WriteImageActivity.startActivityForResult(this, RequestResponseCode.REQUEST_CAMERA, RequestResponseCode.REQUEST_CAMERA_VIEW, null, this.mModel.getForum().getId(), this.mForum, this.mModel.getAnti());
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_ALBUM_IMAGE /* 1200002 */:
                    if (this.mModel != null && this.mModel.getForum() != null) {
                        if (data != null && data.getData() != null) {
                            WriteImageActivity.startActivityForResult(this, RequestResponseCode.REQUEST_ALBUM_IMAGE, RequestResponseCode.REQUEST_ALBUM_IMAGE_VIEW, data.getData(), this.mModel.getForum().getId(), this.mForum, this.mModel.getAnti());
                            return;
                        } else {
                            WriteUtil.getAlbumImage(this);
                            return;
                        }
                    }
                    return;
                case RequestResponseCode.REQUEST_WRITE_NEW /* 1300003 */:
                case RequestResponseCode.REQUEST_DEL_POST /* 1300004 */:
                    refresh();
                    return;
                default:
                    return;
            }
        } else if (resultCode == 0) {
            switch (requestCode) {
                case RequestResponseCode.REQUEST_CAMERA /* 1200001 */:
                case RequestResponseCode.REQUEST_ALBUM_IMAGE /* 1200002 */:
                    this.mSelectImageDialog.show();
                    return;
                case RequestResponseCode.REQUEST_ALBUM_IMAGE_VIEW /* 1200008 */:
                    WriteUtil.getAlbumImage(this);
                    return;
                case RequestResponseCode.REQUEST_CAMERA_VIEW /* 12000010 */:
                    WriteUtil.takePhoto(this);
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
        this.mGetImageRunnble.run();
    }

    public void closeActivity() {
        if (!getIntent().getBooleanExtra("back_special", false)) {
            finish();
        } else {
            MainTabActivity.startActivity(this, MainTabActivity.GOTO_RECOMMEND);
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
        this.mButtonBack.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                FrsActivity.this.closeActivity();
            }
        });
        this.mButtonWrite = (Button) findViewById(R.id.frs_bt_post);
        this.mButtonWrite.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                FrsActivity.this.writeBlog(0);
            }
        });
        this.mButtonRefresh = (Button) findViewById(R.id.frs_bt_refresh);
        this.mButtonRefresh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                FrsActivity.this.mSource = "tb_frslist";
                FrsActivity.this.refresh();
            }
        });
        this.mButtonCamera = (Button) findViewById(R.id.frs_bt_camera);
        this.mButtonCamera.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                FrsActivity.this.writeBlog(1);
            }
        });
        String[] items = {getString(R.string.take_photo), getString(R.string.album)};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getString(R.string.operation));
        builder.setItems(items, new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.frs.FrsActivity.7
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                if (which == 0) {
                    WriteUtil.takePhoto(FrsActivity.this);
                } else if (which == 1) {
                    WriteUtil.getAlbumImage(FrsActivity.this);
                }
            }
        });
        if (this.mSelectImageDialog == null) {
            this.mSelectImageDialog = builder.create();
            this.mSelectImageDialog.setCanceledOnTouchOutside(true);
        }
        this.mListFrs = (ListView) findViewById(R.id.frs_lv_thread);
        this.mAdapterFrs = new FrsAdapter(this, null, UtilHelper.dip2px(this, UtilHelper.getEquipmentWidth(this)));
        this.mAdapterFrs.setImageOnclickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (((FrsImageView) v).isLoaded()) {
                    FrsActivity.this.mBigImageLoader.cancelAllAsyncTask();
                    if (v.getTag() != null && (v.getTag() instanceof String)) {
                        Bitmap bm = FrsActivity.this.mBigImageLoader.loadImage((String) v.getTag(), new AsyncImageLoader.ImageCallback() { // from class: com.baidu.tieba.frs.FrsActivity.8.1
                            @Override // com.baidu.tieba.util.AsyncImageLoader.ImageCallback
                            public void imageLoaded(Bitmap bitmap, String imageUrl, boolean isCached) {
                                if (bitmap == null) {
                                    FrsActivity.this.errorBigImageDialog();
                                } else {
                                    FrsActivity.this.showBigImageDialog(bitmap, false);
                                }
                            }
                        });
                        if (bm == null) {
                            Bitmap small = FrsActivity.this.mAdapterFrs.getImageLoader().getPic(String.valueOf((String) v.getTag()) + "_small");
                            if (small == null) {
                                return;
                            }
                            FrsActivity.this.showBigImageDialog(small, true);
                            return;
                        }
                        FrsActivity.this.showBigImageDialog(bm, false);
                    }
                }
            }
        });
        this.mListFrs.setAdapter((ListAdapter) this.mAdapterFrs);
        this.mListFrs.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.frs.FrsActivity.9
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                ListView tmpList = (ListView) arg0;
                FrsAdapter adapter = (FrsAdapter) tmpList.getAdapter();
                long index = adapter.getItemId(arg2);
                if (index == -1) {
                    if (adapter.getHeaderType() != 2 || FrsActivity.this.mPn <= 1) {
                        FrsActivity.this.mType = 4;
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
                        boolean isAd = false;
                        final String adUrl = data.getAd_url();
                        if (adUrl != null && !adUrl.equals("")) {
                            isAd = true;
                            new Thread(new Runnable() { // from class: com.baidu.tieba.frs.FrsActivity.9.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    NetWorkCore adNetwork = new NetWorkCore(adUrl);
                                    adNetwork.getNetData();
                                }
                            }).start();
                        }
                        PbActivity.startAcitivity(FrsActivity.this, data.getId(), "tb_frslist", isAd);
                    }
                }
            }
        });
        this.mListFrs.setOnItemLongClickListener(this.frsItemLongClickListener);
        this.mProgress = (ProgressBar) findViewById(R.id.frs_progress);
        setIsRefresh(false);
        this.mForumNoExist = (TextView) findViewById(R.id.frs_noexist);
        this.mForumNoExist.setVisibility(8);
        this.mForumNoExistLayoutText = (TextView) findViewById(R.id.frs_noexist_text);
        this.mPageTitle = (LinearLayout) findViewById(R.id.frs_title);
        this.mBtGood = (LinearLayout) findViewById(R.id.frs_ll_bt_good);
        this.mBtGood.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsActivity.10
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (FrsActivity.this.getIsRefresh()) {
                    return;
                }
                FrsActivity.this.showGoodDialog();
            }
        });
        this.mForumNoExistLayout = (LinearLayout) findViewById(R.id.frs_noexist_layout);
        this.mCreateForumBotton = (Button) findViewById(R.id.frs_bt_create);
        this.mCreateForumBotton.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsActivity.11
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                FrsActivity.this.createBar();
            }
        });
        this.mListFrs.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.frs.FrsActivity.12
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView arg0, int arg1, int arg2, int arg3) {
                FrsActivity.this.mHandler.removeCallbacks(FrsActivity.this.mGetImageRunnble);
                FrsActivity.this.mHandler.postDelayed(FrsActivity.this.mGetImageRunnble, 300L);
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                if (scrollState != 0) {
                    FrsActivity.this.mListFrs.setOnItemLongClickListener(null);
                } else {
                    FrsActivity.this.mListFrs.setOnItemLongClickListener(FrsActivity.this.frsItemLongClickListener);
                }
            }
        });
        this.mGoHomeButton = (Button) findViewById(R.id.go_home);
        this.mGoHomeButton.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsActivity.13
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                MainTabActivity.startActivity(FrsActivity.this, MainTabActivity.GOTO_RECOMMEND);
                FrsActivity.this.finish();
            }
        });
        this.mBottomLayout = (LinearLayout) findViewById(R.id.frs_bottom);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void errorBigImageDialog() {
        if (this.mImageViewDialog != null) {
            this.mImageViewDialog.ImageError();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showBigImageDialog(Bitmap bm, boolean loading) {
        if (bm != null) {
            if (this.mImageViewDialog == null) {
                View view = findViewById(R.id.frs);
                this.mImageViewDialog = new ImageViewDialog(this, view.getWidth(), view.getHeight());
                this.mImageViewDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.frs.FrsActivity.14
                    @Override // android.content.DialogInterface.OnDismissListener
                    public void onDismiss(DialogInterface dialog) {
                        FrsActivity.this.closeBigImageDialog();
                    }
                });
                this.mImageViewDialog.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.frs.FrsActivity.15
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialog) {
                        FrsActivity.this.closeBigImageDialog();
                    }
                });
            }
            if (this.mImageViewDialog.isShowing()) {
                this.mImageViewDialog.setImage(bm);
            } else {
                this.mImageViewDialog.showDialog(bm, loading);
            }
            setActivityDim(0.3f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void closeBigImageDialog() {
        if (this.mBigImageLoader != null) {
            this.mBigImageLoader.cancelAllAsyncTask();
        }
        setActivityDim(1.0f);
        if (this.mImageViewDialog != null) {
            this.mImageViewDialog.setImage(null);
        }
    }

    private void setActivityDim(float alpha) {
        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.alpha = alpha;
        getWindow().setAttributes(params);
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
    public void writeBlog(int type) {
        String id = TiebaApplication.getCurrentAccount();
        if (id == null || id.length() <= 0) {
            if (this.mModel != null && this.mModel.getAnti() != null) {
                this.mModel.getAnti().setIfpost(1);
            }
            if (type == 0) {
                LoginActivity.startActivity((Activity) this, getString(R.string.login_to_use), true, (int) RequestResponseCode.REQUEST_LOGIN_WRITE);
            } else {
                LoginActivity.startActivity((Activity) this, getString(R.string.login_to_use), true, (int) RequestResponseCode.REQUEST_LOGIN_CAMERA_OR_IMAGE);
            }
        } else if (this.mModel != null) {
            if (type == 0) {
                WriteActivity.startAcitivityForResult(this, this.mModel.getForum().getId(), this.mForum, this.mModel.getAnti(), false, null);
            } else {
                this.mSelectImageDialog.show();
            }
        }
    }

    private boolean isAnonymityUser(ThreadData thread) {
        String id;
        return thread == null || thread.getAuthor() == null || (id = thread.getAuthor().getId()) == null || id.equals("0");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void prepareFrsMenuDialog(final ThreadData thread) {
        boolean isAnonymous = isAnonymityUser(thread);
        DialogInterface.OnClickListener menuFrsListener = new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.frs.FrsActivity.16
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
        boolean isAnonymous = isAnonymityUser(thread);
        if (this.mThreadId != null) {
            if (!isAnonymous) {
                PbActivity.startAcitivity(this, this.mThreadId, true, true, "tb_frslist", false);
            } else {
                PbActivity.startAcitivity(this, this.mThreadId, false, false, "tb_frslist", false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gotoPbReverse() {
        if (this.mThreadId != null) {
            PbActivity.startAcitivity(this, this.mThreadId, false, false, "tb_frslist", false);
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
            TextView tempTextView = new TextView(this);
            tempTextView.setText(getString(R.string.add_to_screen));
            tempTextView.setTextColor(-1);
            tempTextView.setTextSize(2, 18.0f);
            tempTextView.setGravity(17);
            tempTextView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.FrsActivity.17
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    FrsActivity.this.addShortcut(FrsActivity.this.mForum);
                    FrsActivity.this.mDialogGood.dismiss();
                }
            });
            list.addHeaderView(tempTextView);
            list.setAdapter((ListAdapter) this.mDialogAdapter);
            list.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.frs.FrsActivity.18
                @Override // android.widget.AdapterView.OnItemClickListener
                public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                    if (arg2 > 0) {
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
                }
            });
        }
        if (this.mDialogAdapter != null && this.mModel != null && this.mModel.getForum() != null) {
            this.mDialogAdapter.setData(this.mModel.getForum().getGood_classify());
            this.mDialogAdapter.notifyDataSetInvalidated();
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

    /* JADX INFO: Access modifiers changed from: private */
    public boolean getIsRefresh() {
        return this.mIsRefresh;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void exec() {
        BasicNameValuePair tmp;
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
        BasicNameValuePair tmp2 = new BasicNameValuePair("kw", this.mForum);
        param.add(tmp2);
        BasicNameValuePair tmp3 = new BasicNameValuePair(PersonListActivity.TAG_PAGE, String.valueOf(this.mPn));
        param.add(tmp3);
        if (TiebaApplication.app.getIsAbstractState()) {
            tmp = new BasicNameValuePair("rn", String.valueOf(35));
        } else {
            tmp = new BasicNameValuePair("rn", String.valueOf(50));
        }
        param.add(tmp);
        if (this.mIsGood == 1) {
            BasicNameValuePair tmp4 = new BasicNameValuePair("is_good", NetWorkCore.NET_TYPE_NET);
            param.add(tmp4);
            BasicNameValuePair tmp5 = new BasicNameValuePair("cid", String.valueOf(this.mGoodId));
            param.add(tmp5);
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
            if (this.mModel.getForum() != null) {
                BasicNameValuePair tmp2 = new BasicNameValuePair("fid", this.mModel.getForum().getId());
                param.add(tmp2);
            }
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
        this.mAdapterFrs.setAbstractState(TiebaApplication.app.getIsAbstractState());
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
                        if (this.mModel.getForum().getSignData().getForumRank() == -2) {
                            if (this.mModel.getForum().isIs_like() == 0) {
                                this.mAdapterFrs.setOnlyLike(false);
                            } else {
                                this.mAdapterFrs.setHaveHeader(false);
                            }
                        } else if (this.mModel.getForum().isIs_like() == 0 && this.mModel.getForum().getSignData().getSigned() == 0) {
                            this.mAdapterFrs.setLikeSign(false, false);
                        } else if (this.mModel.getForum().isIs_like() != 0) {
                            if (this.mModel.getForum().getSignData().getSigned() == 0) {
                                if (this.mModel.getForum().getSignData().getForumRank() == -1) {
                                    this.mAdapterFrs.setOnlySigned(false, String.valueOf(this.mModel.getForum().getSignData().getSignCount()), false);
                                } else {
                                    this.mAdapterFrs.setOnlySigned(false, String.valueOf(this.mModel.getForum().getSignData().getForumRank()), true);
                                }
                            } else {
                                this.mAdapterFrs.setOnlySigned(true, String.valueOf(this.mModel.getForum().getSignData().getUserSignRank()), true);
                            }
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.BaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.mAdapterFrs.getImageLoader().cancelAllAsyncTask();
        if (this.mImageViewDialog != null) {
            this.mImageViewDialog.dismiss();
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
                if (FrsActivity.mPbLoadDataSize != 0) {
                    this.mNetwork.addPostData("data_size", String.valueOf(FrsActivity.mPbLoadDataSize));
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
                        TiebaLog.i(getClass().getName(), "doInBackground", data);
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
                    FrsActivity.mPbLoadDataSize = 0L;
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
                FrsActivity.mPbLoadTime = (end_time - this.mStartTime) / 1000000;
                if (this.mNetwork != null) {
                    FrsActivity.mPbLoadDataSize = this.mNetwork.getNetDataSize();
                }
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
                            FrsActivity.this.mBottomLayout.setVisibility(8);
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
                    int bounsPoint = FrsActivity.this.mModel.getForum().getSignData().getBonusPoint();
                    FrsActivity.this.mAdapterFrs.setOnlySigned(true, rank, true);
                    FrsActivity.this.mAdapterFrs.notifyDataSetChanged();
                    String toast2 = FrsActivity.this.getResources().getString(R.string.sign_ok_bouns_point);
                    FrsActivity.this.showToast(toast2.replace("?", String.valueOf(bounsPoint)));
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
                if (this.mModel != null && this.mModel.getForum().isIs_like() == 1) {
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
                writeBlog(0);
                break;
            case 1:
                if (this.mForum != null && this.mForum.length() > 0) {
                    refresh();
                    break;
                }
                break;
            case 2:
                if (!getIsRefresh()) {
                    showGoodDialog();
                    break;
                }
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
                return new AlertDialog.Builder(this).setTitle(R.string.alerm_title).setIcon(R.drawable.dialogue_quit).setMessage(R.string.unlike_info).setPositiveButton(getString(R.string.confirm), new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.frs.FrsActivity.19
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
            if (keyCode == 4) {
                closeActivity();
                return true;
            }
            return super.onKeyDown(keyCode, event);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addShortcut(String name) {
        Intent target;
        if (name != null && (target = getIntent(this, name)) != null) {
            target.setAction("android.intent.action.MAIN");
            target.putExtra(FROM_SHORT_CUT, true);
            target.putExtra("back_special", true);
            Intent shortcut = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
            shortcut.putExtra("duplicate", false);
            shortcut.putExtra("android.intent.extra.shortcut.NAME", String.valueOf(name) + getString(R.string.bar));
            shortcut.putExtra("android.intent.extra.shortcut.INTENT", target);
            Intent.ShortcutIconResource iconRes = Intent.ShortcutIconResource.fromContext(this, R.drawable.icon);
            shortcut.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", iconRes);
            sendBroadcast(shortcut);
            PvThread pv = new PvThread(Config.ST_TYPE_ADD_TO_LAUNCHER);
            pv.start();
        }
    }
}
