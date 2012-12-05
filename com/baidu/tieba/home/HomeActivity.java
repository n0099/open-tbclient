package com.baidu.tieba.home;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import com.baidu.tieba.BaseActivity;
import com.baidu.tieba.MainTabActivity;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.account.LoginActivity;
import com.baidu.tieba.data.AntiData;
import com.baidu.tieba.data.Config;
import com.baidu.tieba.data.LikeForumData;
import com.baidu.tieba.data.LikeReturnData;
import com.baidu.tieba.data.RequestResponseCode;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.model.LikeForumModel;
import com.baidu.tieba.more.AboutActivity;
import com.baidu.tieba.more.AccountActivity;
import com.baidu.tieba.util.DatabaseService;
import com.baidu.tieba.util.NetWork;
import com.baidu.tieba.util.StringHelper;
import com.baidu.tieba.util.TiebaLog;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.write.WriteActivity;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class HomeActivity extends BaseActivity {
    private static final int MENU_ID_ABOUT = 4;
    private static final int MENU_ID_ACCOUNT = 2;
    private static final int MENU_ID_DEL = 1;
    private static final int MENU_ID_ENTER = 0;
    private static final int MENU_ID_FEEDBACK = 3;
    private static final int MENU_ID_QUIT = 5;
    private static final int MENU_ID_SETUP = 1;
    private ListView mListForum = null;
    private ProgressBar mProgress = null;
    private EnterForumAdapter mAdapter = null;
    private Like_Recommend_AsyncTask mLikeRecommendTask = null;
    private LikeForumModel mModelLike = null;
    private UnlikeAsyncTask mUnlikeTask = null;
    private AlertDialog mAffirmDialog = null;
    private DialogInterface.OnClickListener mAffirmListener = null;
    private LikeForumData mCurrentForum = null;
    private LikeAsyncTask mLikeTask = null;
    AlertDialog mMenuLike = null;
    AlertDialog mMenuUnlike = null;
    private Boolean mIsLogin = false;
    private DialogInterface.OnClickListener mDialogMenuListener = new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.home.HomeActivity.1
        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialog, int item) {
            switch (item) {
                case 0:
                    if (HomeActivity.this.mCurrentForum != null) {
                        String name = HomeActivity.this.mCurrentForum.getName();
                        if (StringHelper.isForumName(name)) {
                            FrsActivity.startAcitivity(HomeActivity.this, name, FrsActivity.FRS_FROM_LIKE);
                            return;
                        }
                        return;
                    }
                    return;
                case 1:
                    HomeActivity.this.execDel();
                    return;
                default:
                    return;
            }
        }
    };
    private View.OnClickListener mLikeForumOnclick = new View.OnClickListener() { // from class: com.baidu.tieba.home.HomeActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            String id = TiebaApplication.getCurrentAccount();
            if (id != null && id.length() > 0) {
                if (HomeActivity.this.mLikeTask == null && v != null && v.getTag() != null && (v.getTag() instanceof LikeForumData)) {
                    HomeActivity.this.mLikeTask = new LikeAsyncTask((LikeForumData) v.getTag());
                    HomeActivity.this.mLikeTask.execute(new Object[0]);
                    return;
                }
                return;
            }
            LoginActivity.startActivity((Activity) HomeActivity.this, HomeActivity.this.getString(R.string.login_to_use), true, (int) RequestResponseCode.REQUEST_LOGIN_LIKE);
        }
    };
    private View.OnClickListener mWantLoginOnclick = new View.OnClickListener() { // from class: com.baidu.tieba.home.HomeActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            LoginActivity.startActivity(HomeActivity.this, MainTabActivity.GOTO_HOME, HomeActivity.this.getString(R.string.login_home_tab), (int) RequestResponseCode.REQUEST_LOGIN_USE);
        }
    };
    private View.OnClickListener mForumOnclick = new View.OnClickListener() { // from class: com.baidu.tieba.home.HomeActivity.4
        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            LikeForumData data = null;
            if (v.getTag() instanceof LikeForumData) {
                data = (LikeForumData) v.getTag();
            }
            if (data != null) {
                String name = data.getName();
                if (StringHelper.isForumName(name)) {
                    FrsActivity.startAcitivity(HomeActivity.this, name, FrsActivity.FRS_FROM_LIKE);
                }
            }
        }
    };
    private View.OnLongClickListener mForumOnLongclick = new View.OnLongClickListener() { // from class: com.baidu.tieba.home.HomeActivity.5
        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View v) {
            HomeActivity.this.mCurrentForum = null;
            LikeForumData data = null;
            if (v.getTag() instanceof LikeForumData) {
                data = (LikeForumData) v.getTag();
            }
            if (data != null) {
                HomeActivity.this.mCurrentForum = data;
                String name = data.getName();
                int like = data.isIs_like();
                if (StringHelper.isForumName(name)) {
                    if (like == 1) {
                        HomeActivity.this.mMenuLike.show();
                    } else {
                        HomeActivity.this.mMenuUnlike.show();
                    }
                }
            }
            return true;
        }
    };
    private View.OnKeyListener mOnKyeListener = new View.OnKeyListener() { // from class: com.baidu.tieba.home.HomeActivity.6
        @Override // android.view.View.OnKeyListener
        public boolean onKey(View v, int keyCode, KeyEvent event) {
            if (v instanceof ListView) {
                ListView list = (ListView) v;
                if (event.getAction() == 0) {
                    if (keyCode == 21) {
                        View view = list.getSelectedView();
                        if (view == null) {
                            KeyEvent e1 = new KeyEvent(0, 19);
                            list.dispatchKeyEvent(e1);
                            return true;
                        }
                        return false;
                    } else if (keyCode == 22) {
                        View view2 = list.getSelectedView();
                        if (view2 == null) {
                            KeyEvent e12 = new KeyEvent(0, 20);
                            list.dispatchKeyEvent(e12);
                            return true;
                        }
                        return false;
                    } else {
                        return false;
                    }
                }
                return false;
            }
            return false;
        }
    };

    @Override // com.baidu.tieba.BaseActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);
        initUI();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.BaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        exec(false);
    }

    @Override // android.app.Activity
    public boolean onPrepareOptionsMenu(Menu menu) {
        try {
            MenuItem item = menu.findItem(1);
            item.setVisible(true);
            if (!TiebaApplication.isBaiduAccountManager()) {
                MenuItem item2 = menu.findItem(2);
                item2.setVisible(true);
            }
            MenuItem item3 = menu.findItem(3);
            item3.setVisible(true);
            MenuItem item4 = menu.findItem(4);
            item4.setVisible(true);
            MenuItem item5 = menu.findItem(5);
            item5.setVisible(true);
        } catch (Exception ex) {
            TiebaLog.e("HomeActivity", "onPrepareOptionsMenu", "exp: " + ex.toString());
        }
        return super.onPrepareOptionsMenu(menu);
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0, 1, 1, getString(R.string.setup)).setIcon(R.drawable.menu_setup);
        if (!TiebaApplication.isBaiduAccountManager()) {
            menu.add(0, 2, 2, getString(R.string.account)).setIcon(R.drawable.menu_account);
        }
        menu.add(0, 3, 3, getString(R.string.feedback)).setIcon(R.drawable.menu_feedback);
        menu.add(0, 4, 4, getString(R.string.about)).setIcon(R.drawable.menu_about);
        menu.add(0, 5, 5, getString(R.string.quit)).setIcon(R.drawable.menu_quit);
        return true;
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case 1:
                MainTabActivity.startActivity(this, MainTabActivity.GOTO_MORE);
                break;
            case 2:
                AccountActivity.startActivity(this);
                break;
            case 3:
                AntiData anti = new AntiData();
                anti.setIfpost(1);
                WriteActivity.startActivityFeedBack(this, Config.POSITION_PAGER_ID, Config.POSITION_PAGER_NAME, anti);
                break;
            case 4:
                AboutActivity.startActivity(this);
                break;
            case 5:
                UtilHelper.quitDialog(this);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.BaseActivity, android.app.Activity
    public void onDestroy() {
        this.mProgress.setVisibility(8);
        this.mAdapter.releaseProgressBar();
        super.onDestroy();
    }

    public void closeDialog() {
        if (this.mMenuLike != null) {
            this.mMenuLike.dismiss();
        }
        if (this.mMenuUnlike != null) {
            this.mMenuUnlike.dismiss();
        }
    }

    private void initUI() {
        this.mListForum = (ListView) findViewById(R.id.enter_forum_lv_forum);
        this.mAdapter = new EnterForumAdapter(this, null);
        this.mAdapter.setForumOnClickListener(this.mForumOnclick);
        this.mAdapter.setForumOnLongClickListener(this.mForumOnLongclick);
        this.mAdapter.setWantLoginClickListener(this.mWantLoginOnclick);
        this.mAdapter.setLikeForumClickListener(this.mLikeForumOnclick);
        this.mListForum.setAdapter((ListAdapter) this.mAdapter);
        this.mListForum.setOnKeyListener(this.mOnKyeListener);
        this.mListForum.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.home.HomeActivity.7
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long id) {
                if (HomeActivity.this.mAdapter.getItem(arg2) != null) {
                    if (HomeActivity.this.mAdapter.getItem(arg2) instanceof LikeForumData) {
                        LikeForumData data = (LikeForumData) HomeActivity.this.mAdapter.getItem(arg2);
                        if (data != null) {
                            String name = data.getName();
                            if (StringHelper.isForumName(name)) {
                                FrsActivity.startAcitivity(HomeActivity.this, name, FrsActivity.FRS_FROM_LIKE);
                            }
                        }
                    } else if (HomeActivity.this.mAdapter.getItem(arg2).equals(6)) {
                        HomeActivity.this.mAdapter.setHasShowedMoreLike();
                        HomeActivity.this.mAdapter.notifyDataSetChanged();
                        TiebaApplication.app.setShowAllLikeItems();
                    } else if (HomeActivity.this.mAdapter.getItem(arg2).equals(0)) {
                        SearchActivity.startActivity(HomeActivity.this, HomeActivity.this.getString(R.string.home));
                    }
                }
            }
        });
        CharSequence[] itemsLike = {getString(R.string.enter_forum), getString(R.string.delete)};
        AlertDialog.Builder builderLike = new AlertDialog.Builder(this);
        builderLike.setTitle(getString(R.string.operation));
        builderLike.setItems(itemsLike, this.mDialogMenuListener);
        this.mMenuLike = builderLike.create();
        this.mMenuLike.setCanceledOnTouchOutside(true);
        CharSequence[] itemsUnlike = {getString(R.string.enter_forum), getString(R.string.delete)};
        AlertDialog.Builder builderUnlike = new AlertDialog.Builder(this);
        builderUnlike.setTitle(getString(R.string.operation));
        builderUnlike.setItems(itemsUnlike, this.mDialogMenuListener);
        this.mMenuUnlike = builderUnlike.create();
        this.mMenuUnlike.setCanceledOnTouchOutside(true);
        this.mProgress = (ProgressBar) findViewById(R.id.enter_forum_progress);
        this.mProgress.setVisibility(8);
        Button buttonRefresh = (Button) findViewById(R.id.refresh);
        buttonRefresh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.home.HomeActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                HomeActivity.this.exec(true);
            }
        });
    }

    public void cancelAsyncTask() {
        if (this.mLikeRecommendTask != null) {
            this.mLikeRecommendTask.cancel();
            this.mLikeRecommendTask = null;
        }
        if (this.mUnlikeTask != null) {
            this.mUnlikeTask.cancel();
            this.mUnlikeTask = null;
        }
        if (this.mLikeTask != null) {
            this.mLikeTask.cancel();
            this.mLikeTask = null;
        }
    }

    public void exec(boolean isRefresh) {
        String data;
        this.mIsLogin = Boolean.valueOf((TiebaApplication.getCurrentAccount() == null || TiebaApplication.getCurrentAccountName() == null) ? false : true);
        if (!isRefresh) {
            if (this.mIsLogin.booleanValue()) {
                data = DatabaseService.getLikeData();
            } else {
                data = DatabaseService.getLikeData("0");
            }
            if (data != null && data.length() > 0) {
                LikeForumModel barlistData = new LikeForumModel();
                barlistData.parserJson(data);
                if (!barlistData.isSucc()) {
                    TiebaLog.i("Like_Recommend_AsyncTask", "doInBackground", "cache data format err");
                    if (this.mIsLogin.booleanValue()) {
                        DatabaseService.delLikeData();
                    } else {
                        DatabaseService.delLikeData("0");
                    }
                } else {
                    TiebaLog.i("Like_Recommend_AsyncTask", "doInBackground", "cache data.size: " + String.valueOf(data.length()));
                    this.mModelLike = barlistData;
                    refresh();
                    return;
                }
            }
        }
        if (this.mLikeRecommendTask == null) {
            StringBuffer address = new StringBuffer(30);
            address.append(Config.SERVER_ADDRESS);
            address.append(Config.GET_LIKE_RECOMMEDN_ADDRESS);
            ArrayList<BasicNameValuePair> params = new ArrayList<>();
            BasicNameValuePair param = new BasicNameValuePair("ctime", String.valueOf(System.currentTimeMillis()));
            params.add(param);
            cancelAsyncTask();
            this.mLikeRecommendTask = new Like_Recommend_AsyncTask(address.toString(), params);
            this.mLikeRecommendTask.execute(address.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void execDel() {
        if (this.mCurrentForum != null) {
            if (this.mCurrentForum.isIs_like() == 1) {
                if (this.mAffirmDialog == null) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(getParent());
                    builder.setTitle(R.string.alerm_title);
                    builder.setIcon(R.drawable.dialogue_quit);
                    builder.setMessage(R.string.delete_like_info);
                    this.mAffirmListener = new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.home.HomeActivity.9
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface arg0, int which) {
                            if (which == -1) {
                                if (HomeActivity.this.mUnlikeTask == null) {
                                    HomeActivity.this.mUnlikeTask = new UnlikeAsyncTask(HomeActivity.this.mCurrentForum);
                                    HomeActivity.this.mUnlikeTask.execute(new LikeForumData[0]);
                                    return;
                                }
                                return;
                            }
                            HomeActivity.this.mAffirmDialog.dismiss();
                        }
                    };
                    builder.setPositiveButton(getString(R.string.confirm), this.mAffirmListener);
                    builder.setNegativeButton(getString(R.string.cancel), this.mAffirmListener);
                    this.mAffirmDialog = builder.create();
                }
                this.mAffirmDialog.show();
            } else if (this.mUnlikeTask == null) {
                this.mUnlikeTask = new UnlikeAsyncTask(this.mCurrentForum);
                this.mUnlikeTask.execute(new LikeForumData[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refresh() {
        try {
            if (this.mModelLike != null) {
                if (this.mModelLike.getRecommend_Forums() == null || this.mModelLike.getRecommend_Forums().size() == 0) {
                    this.mListForum.setBackgroundColor(getResources().getColor(R.color.enter_forum_bg_nodata_color));
                } else {
                    this.mListForum.setBackgroundColor(getResources().getColor(R.color.enter_forum_bg_normal_color));
                }
                this.mAdapter.setData(this.mModelLike);
                this.mAdapter.setLoginState(this.mIsLogin);
                this.mAdapter.notifyDataSetChanged();
            }
        } catch (Exception ex) {
            TiebaLog.e(getClass().getName(), "refresh", ex.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class Like_Recommend_AsyncTask extends AsyncTask<Object, Integer, LikeForumModel> {
        private NetWork mNetwork = null;
        ArrayList<BasicNameValuePair> mParam;
        private String mUrl;

        public Like_Recommend_AsyncTask(String url, ArrayList<BasicNameValuePair> param) {
            this.mUrl = null;
            this.mParam = null;
            this.mUrl = url;
            this.mParam = param;
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            HomeActivity.this.mProgress.setVisibility(0);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.AsyncTask
        public LikeForumModel doInBackground(Object... params) {
            LikeForumModel barlistData = null;
            try {
                this.mNetwork = new NetWork(this.mUrl);
                this.mNetwork.setPostData(this.mParam);
                String data = this.mNetwork.postNetData();
                if (this.mNetwork.isRequestSuccess() && data != null) {
                    LikeForumModel barlistData2 = new LikeForumModel();
                    try {
                        barlistData2.parserJson(data);
                        if (barlistData2.isSucc()) {
                            HomeActivity.this.mIsLogin = Boolean.valueOf(barlistData2.getIsLogin() == 1);
                            if (HomeActivity.this.mIsLogin.booleanValue()) {
                                DatabaseService.cashLikeData(data);
                                barlistData = barlistData2;
                            } else {
                                DatabaseService.cashLikeData(data, "0");
                                barlistData = barlistData2;
                            }
                        } else {
                            barlistData = null;
                        }
                    } catch (Exception e) {
                        ex = e;
                        barlistData = barlistData2;
                        TiebaLog.e(getClass().getName(), "", "doInBackground error = " + ex.getMessage());
                        return barlistData;
                    }
                }
            } catch (Exception e2) {
                ex = e2;
            }
            return barlistData;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(LikeForumModel data) {
            HomeActivity.this.mProgress.setVisibility(8);
            if (data != null) {
                HomeActivity.this.mModelLike = data;
                TiebaApplication.app.setLikeChanged(false);
                HomeActivity.this.refresh();
            } else if (this.mNetwork != null) {
                HomeActivity.this.showToast(this.mNetwork.getErrorString());
            }
            HomeActivity.this.mLikeRecommendTask = null;
        }

        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.cancelNetConnect();
                this.mNetwork = null;
            }
            HomeActivity.this.mProgress.setVisibility(8);
            super.cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class UnlikeAsyncTask extends AsyncTask<LikeForumData, Integer, String> {
        private LikeForumData mData;
        private NetWork mNetwork = null;

        public UnlikeAsyncTask(LikeForumData data) {
            this.mData = null;
            this.mData = data;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public String doInBackground(LikeForumData... params) {
            LikeForumData data = this.mData;
            if (data != null) {
                try {
                    if (data.getId() != null && data.getName() != null) {
                        this.mNetwork = new NetWork("http://c.tieba.baidu.com/c/c/forum/unfavo");
                        this.mNetwork.addPostData("fid", data.getId());
                        this.mNetwork.addPostData("kw", data.getName());
                        this.mNetwork.addPostData("favo_type", String.valueOf(data.getFavo_type()));
                        this.mNetwork.setIsNeedTbs(true);
                        this.mNetwork.postNetData();
                        return null;
                    }
                    return null;
                } catch (Exception ex) {
                    TiebaLog.e(getClass().getName(), "doInBackground", ex.getMessage());
                    return null;
                }
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(String result) {
            super.onPostExecute((UnlikeAsyncTask) result);
            HomeActivity.this.mUnlikeTask = null;
            HomeActivity.this.mProgress.setVisibility(8);
            if (this.mNetwork != null) {
                if (this.mNetwork.isRequestSuccess()) {
                    ArrayList<LikeForumData> datas = HomeActivity.this.mModelLike.getLike_Forums();
                    if (datas != null) {
                        datas.remove(this.mData);
                        if (HomeActivity.this.mAdapter != null) {
                            HomeActivity.this.refresh();
                        }
                    }
                    if (!TiebaApplication.app.getLikeChanged()) {
                        TiebaApplication.app.setLikeChanged(true);
                        DatabaseService.delLikeData();
                    }
                    HomeActivity.this.showToast(HomeActivity.this.getString(R.string.success));
                    return;
                }
                HomeActivity.this.showToast(this.mNetwork.getErrorString());
            }
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            HomeActivity.this.mProgress.setVisibility(0);
        }

        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.cancelNetConnect();
                this.mNetwork = null;
            }
            HomeActivity.this.mProgress.setVisibility(8);
            HomeActivity.this.mUnlikeTask = null;
            super.cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class LikeAsyncTask extends AsyncTask<Object, Integer, LikeForumData> {
        private LikeForumData mData;
        private volatile NetWork mNetwork = null;
        private volatile boolean mHaveLike = false;

        public LikeAsyncTask(LikeForumData data) {
            this.mData = null;
            this.mData = data;
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            HomeActivity.this.mProgress.setVisibility(0);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.AsyncTask
        public LikeForumData doInBackground(Object... params) {
            try {
                this.mNetwork = new NetWork("http://c.tieba.baidu.com/c/c/forum/like");
                if (this.mData.getName() != null && this.mData.getName().length() > 0) {
                    this.mNetwork.addPostData("kw", this.mData.getName());
                }
                if (this.mData.getId() != null && this.mData.getId().length() > 0) {
                    this.mNetwork.addPostData("fid", this.mData.getId());
                }
                this.mNetwork.setIsNeedTbs(true);
                String data = this.mNetwork.postNetData();
                if (this.mNetwork.getErrorCode() == 22) {
                    this.mHaveLike = true;
                }
                if (this.mNetwork.isNetSuccess() && data != null) {
                    LikeReturnData likeReturnData = new LikeReturnData();
                    likeReturnData.parserJson(data);
                    return likeReturnData.getLikeReturnData();
                }
            } catch (Exception ex) {
                TiebaLog.e(getClass().getName(), "doInBackground", ex.getMessage());
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(LikeForumData data) {
            HomeActivity.this.mProgress.setVisibility(8);
            HomeActivity.this.mLikeTask = null;
            ArrayList<LikeForumData> recommendDatas = HomeActivity.this.mModelLike.getRecommend_Forums();
            ArrayList<LikeForumData> likeDatas = HomeActivity.this.mModelLike.getLike_Forums();
            if (this.mHaveLike) {
                HomeActivity.this.showToast(this.mNetwork.getErrorString());
            } else if (data != null) {
                if (recommendDatas != null) {
                    if (likeDatas != null) {
                        this.mData.setUser_level(data.getUser_level());
                        this.mData.setIs_like(1);
                        likeDatas.add(this.mData);
                    }
                    recommendDatas.remove(this.mData);
                    if (HomeActivity.this.mAdapter != null) {
                        HomeActivity.this.refresh();
                    }
                }
                if (!TiebaApplication.app.getLikeChanged()) {
                    TiebaApplication.app.setLikeChanged(true);
                    DatabaseService.delLikeData();
                }
                if (data.isIs_like() == 1) {
                    HomeActivity.this.showToast(HomeActivity.this.getString(R.string.like_success_and_addto_list));
                } else {
                    HomeActivity.this.showToast(HomeActivity.this.getString(R.string.like_success_and_addto_list));
                }
            } else {
                HomeActivity.this.showToast(this.mNetwork.getErrorString());
            }
        }

        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.cancelNetConnect();
                this.mNetwork = null;
            }
            HomeActivity.this.mProgress.setVisibility(8);
            HomeActivity.this.mLikeTask = null;
            super.cancel(true);
        }
    }
}
