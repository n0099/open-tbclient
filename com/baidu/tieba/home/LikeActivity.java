package com.baidu.tieba.home;

import android.app.ActivityGroup;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import com.baidu.tieba.BaseActivity;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.Config;
import com.baidu.tieba.data.ForumData;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.model.BarlistModel;
import com.baidu.tieba.util.DatabaseService;
import com.baidu.tieba.util.NetWork;
import com.baidu.tieba.util.StringHelper;
import com.baidu.tieba.util.TiebaLog;
import java.util.ArrayList;
import java.util.Date;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class LikeActivity extends BaseActivity {
    private static final int MENU_ID_DEL = 1;
    private static final int MENU_ID_ENTER = 0;
    private ListView mListForum = null;
    private ProgressBar mProgress = null;
    private LikeAdapter mAdapter = null;
    private HomeLikeAsyncTask mLikeTask = null;
    private BarlistModel mModelLike = null;
    private UnlikeAsyncTask mUnlikeTask = null;
    private AlertDialog mAffirmDialog = null;
    private DialogInterface.OnClickListener mAffirmListener = null;
    private ForumData mCurrentForum = null;
    AlertDialog mMenuLike = null;
    AlertDialog mMenuUnlike = null;
    private SearchView mSearchView = null;
    private DialogInterface.OnClickListener mDialogMenuListener = new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.home.LikeActivity.1
        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialog, int item) {
            switch (item) {
                case 0:
                    if (LikeActivity.this.mCurrentForum != null) {
                        String name = LikeActivity.this.mCurrentForum.getName();
                        if (StringHelper.isForumName(name)) {
                            FrsActivity.startAcitivity(LikeActivity.this, name, FrsActivity.FRS_FROM_LIKE);
                            return;
                        }
                        return;
                    }
                    return;
                case 1:
                    LikeActivity.this.execDel();
                    return;
                default:
                    return;
            }
        }
    };
    private View.OnClickListener mForumOnclick = new View.OnClickListener() { // from class: com.baidu.tieba.home.LikeActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            ForumData data = null;
            if (v.getTag() instanceof ForumData) {
                data = (ForumData) v.getTag();
            }
            if (data != null) {
                String name = data.getName();
                if (StringHelper.isForumName(name)) {
                    FrsActivity.startAcitivity(LikeActivity.this, name, FrsActivity.FRS_FROM_LIKE);
                }
            }
        }
    };
    private View.OnClickListener mHeaderOnclick = new View.OnClickListener() { // from class: com.baidu.tieba.home.LikeActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            LikeActivity.this.mListForum.setSelection(0);
            LikeActivity.this.showSearch();
        }
    };
    private View.OnLongClickListener mForumOnLongclick = new View.OnLongClickListener() { // from class: com.baidu.tieba.home.LikeActivity.4
        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View v) {
            LikeActivity.this.mCurrentForum = null;
            ForumData data = null;
            if (v.getTag() instanceof ForumData) {
                data = (ForumData) v.getTag();
            }
            if (data != null) {
                LikeActivity.this.mCurrentForum = data;
                String name = data.getName();
                int like = data.isIs_like();
                if (StringHelper.isForumName(name)) {
                    if (like == 1) {
                        LikeActivity.this.mMenuLike.show();
                    } else {
                        LikeActivity.this.mMenuUnlike.show();
                    }
                }
            }
            return true;
        }
    };
    private AdapterView.OnItemClickListener mForumListOnclick = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.home.LikeActivity.5
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
            ListView tmpList = (ListView) arg0;
            if (arg2 == tmpList.getAdapter().getCount() - 1) {
                LikeActivity.this.exec(true);
            }
        }
    };
    private View.OnKeyListener mOnKyeListener = new View.OnKeyListener() { // from class: com.baidu.tieba.home.LikeActivity.6
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
        setContentView(R.layout.like_activity);
        init();
        exec(false);
    }

    public void closeSearch() {
        if (this.mSearchView != null) {
            this.mSearchView.closeSearch();
        }
    }

    public void closeDialog() {
        closeSearch();
        if (this.mMenuLike != null) {
            this.mMenuLike.dismiss();
        }
        if (this.mMenuUnlike != null) {
            this.mMenuUnlike.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.BaseActivity, android.app.Activity
    public void onDestroy() {
        this.mProgress.setVisibility(8);
        this.mAdapter.releaseProgressBar();
        if (this.mSearchView != null) {
            this.mSearchView.releaseProgressBar();
        }
        super.onDestroy();
    }

    private void init() {
        this.mListForum = (ListView) findViewById(R.id.home_lv_forum);
        this.mListForum.setItemsCanFocus(true);
        this.mAdapter = new LikeAdapter(this, null);
        this.mAdapter.setForumOnClickListener(this.mForumOnclick);
        this.mAdapter.setForumOnLongClickListener(this.mForumOnLongclick);
        this.mAdapter.setHeaderOnClickListener(this.mHeaderOnclick);
        this.mListForum.setAdapter((ListAdapter) this.mAdapter);
        this.mListForum.setOnItemClickListener(this.mForumListOnclick);
        this.mListForum.setOnKeyListener(this.mOnKyeListener);
        CharSequence[] itemsLike = {getString(R.string.enter_forum), getString(R.string.delete)};
        AlertDialog.Builder builderLike = new AlertDialog.Builder(getParent());
        builderLike.setTitle(getString(R.string.operation));
        builderLike.setItems(itemsLike, this.mDialogMenuListener);
        this.mMenuLike = builderLike.create();
        this.mMenuLike.setCanceledOnTouchOutside(true);
        CharSequence[] itemsUnlike = {getString(R.string.enter_forum), getString(R.string.delete)};
        AlertDialog.Builder builderUnlike = new AlertDialog.Builder(getParent());
        builderUnlike.setTitle(getString(R.string.operation));
        builderUnlike.setItems(itemsUnlike, this.mDialogMenuListener);
        this.mMenuUnlike = builderUnlike.create();
        this.mMenuUnlike.setCanceledOnTouchOutside(true);
        this.mProgress = (ProgressBar) findViewById(R.id.home_progress_like);
        this.mProgress.setVisibility(8);
    }

    public void cancelAsyncTask() {
        if (this.mLikeTask != null) {
            this.mLikeTask.cancel();
            this.mLikeTask = null;
        }
        if (this.mUnlikeTask != null) {
            this.mUnlikeTask.cancel();
            this.mUnlikeTask = null;
        }
    }

    public void showSearch() {
        if (this.mSearchView == null) {
            this.mSearchView = new SearchView(getParent());
        }
        this.mSearchView.exec();
    }

    public void exec(boolean isRefresh) {
        String data;
        if ((isRefresh || this.mModelLike == null || TiebaApplication.app.getLikeChanged()) && TiebaApplication.getCurrentAccount() != null) {
            if (!isRefresh && (data = DatabaseService.getLikeData()) != null && data.length() > 0) {
                BarlistModel barlistData = new BarlistModel();
                barlistData.parserJson(data);
                if (!barlistData.isSucc()) {
                    TiebaLog.i("HomeLikeAsyncTask", "doInBackground", "cache data format err");
                    DatabaseService.delLikeData();
                } else {
                    TiebaLog.i("HomeLikeAsyncTask", "doInBackground", "cache data.size: " + String.valueOf(data.length()));
                    this.mModelLike = barlistData;
                    refresh();
                    return;
                }
            }
            if (this.mLikeTask == null) {
                StringBuffer address = new StringBuffer(30);
                address.append(Config.SERVER_ADDRESS);
                address.append(Config.FORUM_ADDRESS);
                BasicNameValuePair param = new BasicNameValuePair("ctime", String.valueOf(System.currentTimeMillis()));
                cancelAsyncTask();
                this.mLikeTask = new HomeLikeAsyncTask(address.toString(), param, isRefresh);
                this.mLikeTask.execute(address.toString(), param);
            }
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
                    this.mAffirmListener = new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.home.LikeActivity.7
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface arg0, int which) {
                            if (which == -1) {
                                if (LikeActivity.this.mUnlikeTask == null) {
                                    LikeActivity.this.mUnlikeTask = new UnlikeAsyncTask(LikeActivity.this.mCurrentForum);
                                    LikeActivity.this.mUnlikeTask.execute(new ForumData[0]);
                                    return;
                                }
                                return;
                            }
                            LikeActivity.this.mAffirmDialog.dismiss();
                        }
                    };
                    builder.setPositiveButton(getString(R.string.confirm), this.mAffirmListener);
                    builder.setNegativeButton(getString(R.string.cancel), this.mAffirmListener);
                    this.mAffirmDialog = builder.create();
                }
                this.mAffirmDialog.show();
            } else if (this.mUnlikeTask == null) {
                this.mUnlikeTask = new UnlikeAsyncTask(this.mCurrentForum);
                this.mUnlikeTask.execute(new ForumData[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refresh() {
        ArrayList<ForumData> list;
        try {
            Date updateTime = this.mModelLike.getTime();
            Date nowTime = new Date();
            StringBuffer str = new StringBuffer();
            str.append("最后更新：");
            if (nowTime.getYear() == updateTime.getYear() && nowTime.getMonth() == updateTime.getMonth() && nowTime.getDate() == updateTime.getDate()) {
                str.append("今天");
                str.append(StringHelper.getDateStringHm(updateTime));
            } else {
                str.append(StringHelper.getDateStringMdHm(updateTime));
            }
            this.mAdapter.setUpdateTime(str.toString());
            if (this.mModelLike != null && (list = this.mModelLike.getForum_list()) != null) {
                this.mAdapter.setData(list);
                this.mAdapter.notifyDataSetInvalidated();
            }
        } catch (Exception ex) {
            TiebaLog.e(getClass().getName(), "", "HomeActivity.refresh error = " + ex.getMessage());
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onSearchRequested() {
        return getParent() instanceof ActivityGroup ? getParent().onSearchRequested() : super.onSearchRequested();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class HomeLikeAsyncTask extends AsyncTask<Object, Integer, BarlistModel> {
        boolean mIsRefresh;
        private NetWork mNetwork = null;
        BasicNameValuePair mParam;
        private String mUrl;

        public HomeLikeAsyncTask(String url, BasicNameValuePair param, boolean isRefresh) {
            this.mUrl = null;
            this.mParam = null;
            this.mIsRefresh = true;
            this.mUrl = url;
            this.mParam = param;
            this.mIsRefresh = isRefresh;
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            if (!this.mIsRefresh) {
                LikeActivity.this.mProgress.setVisibility(0);
            } else {
                LikeActivity.this.mAdapter.setIsRefresh(true);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.AsyncTask
        public BarlistModel doInBackground(Object... params) {
            BarlistModel barlistData = null;
            try {
                this.mNetwork = new NetWork(this.mUrl);
                this.mNetwork.addPostData(this.mParam);
                String data = this.mNetwork.postNetData();
                TiebaLog.i("HomeLikeAsyncTask", "doInBackground", "net data.size: " + String.valueOf(data.length()));
                if (!this.mNetwork.isRequestSuccess() || data == null) {
                    return null;
                }
                BarlistModel barlistData2 = new BarlistModel();
                try {
                    barlistData2.parserJson(data);
                    if (barlistData2.isSucc()) {
                        DatabaseService.cashLikeData(data);
                        return barlistData2;
                    }
                    return null;
                } catch (Exception e) {
                    ex = e;
                    barlistData = barlistData2;
                    TiebaLog.e(getClass().getName(), "", "doInBackground error = " + ex.getMessage());
                    return barlistData;
                }
            } catch (Exception e2) {
                ex = e2;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(BarlistModel data) {
            if (!this.mIsRefresh) {
                LikeActivity.this.mProgress.setVisibility(8);
            } else {
                LikeActivity.this.mAdapter.setIsRefresh(false);
            }
            if (data != null) {
                LikeActivity.this.mModelLike = data;
                TiebaApplication.app.setLikeChanged(false);
                LikeActivity.this.refresh();
            } else if (this.mNetwork != null) {
                LikeActivity.this.showToast(this.mNetwork.getErrorString());
            }
            LikeActivity.this.mLikeTask = null;
        }

        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.cancelNetConnect();
                this.mNetwork = null;
            }
            LikeActivity.this.mProgress.setVisibility(8);
            super.cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class UnlikeAsyncTask extends AsyncTask<ForumData, Integer, String> {
        private ForumData mData;
        private NetWork mNetwork = null;

        public UnlikeAsyncTask(ForumData data) {
            this.mData = null;
            this.mData = data;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public String doInBackground(ForumData... params) {
            ForumData data = this.mData;
            if (data != null) {
                try {
                    if (data.getId() != null && data.getName() != null) {
                        this.mNetwork = new NetWork("http://c.tieba.baidu.com/c/c/forum/unfavolike");
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
            LikeActivity.this.mUnlikeTask = null;
            LikeActivity.this.mProgress.setVisibility(8);
            if (this.mNetwork != null) {
                if (this.mNetwork.isRequestSuccess()) {
                    ArrayList<ForumData> datas = LikeActivity.this.mModelLike.getForum_list();
                    if (datas != null) {
                        datas.remove(this.mData);
                        if (LikeActivity.this.mAdapter != null) {
                            LikeActivity.this.mAdapter.setData(datas);
                            LikeActivity.this.mAdapter.notifyDataSetChanged();
                        }
                    }
                    if (!TiebaApplication.app.getLikeChanged()) {
                        TiebaApplication.app.setLikeChanged(true);
                        DatabaseService.delLikeData();
                    }
                    LikeActivity.this.showToast(LikeActivity.this.getString(R.string.success));
                    return;
                }
                LikeActivity.this.showToast(this.mNetwork.getErrorString());
            }
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            LikeActivity.this.mProgress.setVisibility(0);
        }

        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.cancelNetConnect();
                this.mNetwork = null;
            }
            LikeActivity.this.mProgress.setVisibility(8);
            LikeActivity.this.mUnlikeTask = null;
            super.cancel(true);
        }
    }
}
