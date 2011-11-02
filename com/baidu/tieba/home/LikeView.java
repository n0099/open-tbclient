package com.baidu.tieba.home;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
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
public class LikeView {
    private static final int MENU_ID_DEL = 1;
    private static final int MENU_ID_ENTER = 0;
    private static final int MENU_ID_LIKE = 2;
    private HomeActivity mActivity;
    private ImageButton mButtonMark = null;
    private ListView mListForum = null;
    private ProgressBar mProgress = null;
    private LikeAdapter mAdapter = null;
    private HomeLikeAsyncTask mLikeTask = null;
    private BarlistModel mModelLike = null;
    private UnlikeAsyncTask mUnlikeTask = null;
    private AlertDialog mAffirmDialog = null;
    private DialogInterface.OnClickListener mAffirmListener = null;
    private int mClickItem = -1;
    AlertDialog mMenuLike = null;
    AlertDialog mMenuUnlike = null;
    private View mListHeader = null;
    private SearchView mSearchView = null;
    private View mListFooter = null;
    private LinearLayout mLayoutRefresh = null;
    private TextView mTextRefresh = null;
    private TextView mTextUptime = null;
    private ProgressBar mProgressRefresh = null;
    private String mForumName = null;
    private DialogInterface.OnClickListener mDialogMenuListener = new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.home.LikeView.1
        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialog, int item) {
            switch (item) {
                case 0:
                    if (StringHelper.isForumName(LikeView.this.mForumName)) {
                        FrsActivity.startAcitivity(LikeView.this.mActivity, LikeView.this.mForumName, FrsActivity.FRS_FROM_LIKE);
                        return;
                    }
                    return;
                case 1:
                    LikeView.this.execDel();
                    return;
                case 2:
                    LikeView.this.mActivity.showToast("developing...");
                    return;
                default:
                    return;
            }
        }
    };

    public LikeView(Activity m) {
        this.mActivity = null;
        this.mActivity = (HomeActivity) m;
    }

    public void init() {
        this.mButtonMark = (ImageButton) this.mActivity.findViewById(R.id.home_bt_mark);
        this.mButtonMark.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.home.LikeView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                LikeView.this.mActivity.goToMark(false);
            }
        });
        this.mListForum = (ListView) this.mActivity.findViewById(R.id.home_lv_forum);
        LayoutInflater mInflater = this.mActivity.getLayoutInflater();
        this.mListHeader = mInflater.inflate(R.layout.home_like_header, (ViewGroup) null);
        this.mListHeader.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.home.LikeView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                LikeView.this.showSearch();
            }
        });
        this.mListFooter = mInflater.inflate(R.layout.home_like_footer, (ViewGroup) null);
        this.mListFooter.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.home.LikeView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                LikeView.this.exec(true);
            }
        });
        this.mLayoutRefresh = (LinearLayout) this.mListFooter.findViewById(R.id.home_like_list_control);
        this.mTextRefresh = (TextView) this.mListFooter.findViewById(R.id.home_like_tv_refresh);
        this.mTextUptime = (TextView) this.mListFooter.findViewById(R.id.home_like_tv_uptime);
        this.mProgressRefresh = (ProgressBar) this.mListFooter.findViewById(R.id.home_like_progress_refresh);
        this.mListForum.addHeaderView(this.mListHeader, null, true);
        this.mListForum.addFooterView(this.mListFooter, null, true);
        this.mAdapter = new LikeAdapter(this.mActivity, null);
        this.mListForum.setAdapter((ListAdapter) this.mAdapter);
        this.mListForum.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.home.LikeView.5
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                ListView tmpList = (ListView) arg0;
                if (arg2 == 0) {
                    LikeView.this.showSearch();
                } else if (arg2 == tmpList.getAdapter().getCount() - 1) {
                    LikeView.this.exec(true);
                } else {
                    ForumData data = (ForumData) tmpList.getAdapter().getItem(arg2);
                    if (data != null) {
                        LikeView.this.mForumName = data.getName();
                        if (StringHelper.isForumName(LikeView.this.mForumName)) {
                            FrsActivity.startAcitivity(LikeView.this.mActivity, LikeView.this.mForumName, FrsActivity.FRS_FROM_LIKE);
                        }
                    }
                }
            }
        });
        this.mListForum.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.home.LikeView.6
            @Override // android.widget.AdapterView.OnItemLongClickListener
            public boolean onItemLongClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                ListView tmpList = (ListView) arg0;
                ForumData data = (ForumData) tmpList.getAdapter().getItem(arg2);
                if (data == null) {
                    return true;
                }
                LikeView.this.mForumName = data.getName();
                int like = data.isIs_like();
                if (StringHelper.isForumName(LikeView.this.mForumName)) {
                    if (like == 1) {
                        LikeView.this.mMenuLike.show();
                    } else {
                        LikeView.this.mMenuUnlike.show();
                    }
                    LikeView.this.mClickItem = arg2 - 1;
                    return true;
                }
                return true;
            }
        });
        CharSequence[] itemsLike = {this.mActivity.getString(R.string.enter_forum), this.mActivity.getString(R.string.delete)};
        AlertDialog.Builder builderLike = new AlertDialog.Builder(this.mActivity);
        builderLike.setTitle(this.mActivity.getString(R.string.operation));
        builderLike.setItems(itemsLike, this.mDialogMenuListener);
        this.mMenuLike = builderLike.create();
        this.mMenuLike.setCanceledOnTouchOutside(true);
        CharSequence[] itemsUnlike = {this.mActivity.getString(R.string.enter_forum), this.mActivity.getString(R.string.delete)};
        AlertDialog.Builder builderUnlike = new AlertDialog.Builder(this.mActivity);
        builderUnlike.setTitle(this.mActivity.getString(R.string.operation));
        builderUnlike.setItems(itemsUnlike, this.mDialogMenuListener);
        this.mMenuUnlike = builderUnlike.create();
        this.mMenuUnlike.setCanceledOnTouchOutside(true);
        this.mProgress = (ProgressBar) this.mActivity.findViewById(R.id.home_progress_like);
        this.mProgress.setVisibility(8);
    }

    public void releaseProgressBar() {
        this.mProgress.setVisibility(8);
        this.mProgressRefresh.setVisibility(8);
        if (this.mSearchView != null) {
            this.mSearchView.releaseProgressBar();
        }
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
            this.mSearchView = new SearchView(this.mActivity);
        }
        this.mSearchView.exec();
    }

    public void closeSearch() {
        if (this.mSearchView != null) {
            this.mSearchView.closeSearch();
        }
    }

    public void exec(boolean isRefresh) {
        String data;
        this.mActivity.setVisibility(0, 8);
        this.mActivity.setHomeType(1);
        if (isRefresh || this.mModelLike == null || TiebaApplication.app.getLikeChanged()) {
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
        ArrayList<ForumData> datas;
        ForumData data = (ForumData) this.mAdapter.getItem(this.mClickItem);
        if (data != null) {
            if (data.isIs_like() == 1) {
                if (this.mAffirmDialog == null) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(this.mActivity);
                    builder.setTitle(R.string.alerm_title);
                    builder.setIcon(R.drawable.dialogue_quit);
                    builder.setMessage(R.string.delete_like_info);
                    this.mAffirmListener = new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.home.LikeView.7
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface arg0, int which) {
                            ArrayList<ForumData> datas2;
                            if (which == -1) {
                                if (LikeView.this.mUnlikeTask == null && (datas2 = LikeView.this.mModelLike.getForum_list()) != null && LikeView.this.mClickItem >= 0 && LikeView.this.mClickItem < datas2.size()) {
                                    LikeView.this.mUnlikeTask = new UnlikeAsyncTask();
                                    LikeView.this.mUnlikeTask.execute(datas2.get(LikeView.this.mClickItem));
                                    return;
                                }
                                return;
                            }
                            LikeView.this.mAffirmDialog.dismiss();
                        }
                    };
                    builder.setPositiveButton(this.mActivity.getString(R.string.confirm), this.mAffirmListener);
                    builder.setNegativeButton(this.mActivity.getString(R.string.cancel), this.mAffirmListener);
                    this.mAffirmDialog = builder.create();
                }
                this.mAffirmDialog.show();
            } else if (this.mUnlikeTask == null && (datas = this.mModelLike.getForum_list()) != null && this.mClickItem >= 0 && this.mClickItem < datas.size()) {
                this.mUnlikeTask = new UnlikeAsyncTask();
                this.mUnlikeTask.execute(datas.get(this.mClickItem));
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
            this.mTextUptime.setText(str.toString());
            if (this.mModelLike != null && (list = this.mModelLike.getForum_list()) != null) {
                this.mAdapter.setData(list);
                this.mAdapter.notifyDataSetInvalidated();
            }
        } catch (Exception ex) {
            TiebaLog.e(getClass().getName(), "", "HomeActivity.refresh error = " + ex.getMessage());
        }
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
            if (this.mIsRefresh) {
                LikeView.this.mProgressRefresh.setVisibility(0);
                LikeView.this.mTextRefresh.setText(R.string.loading);
                LikeView.this.mTextUptime.setVisibility(4);
                return;
            }
            LikeView.this.mProgress.setVisibility(0);
            LikeView.this.mLayoutRefresh.setVisibility(4);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.AsyncTask
        public BarlistModel doInBackground(Object... params) {
            Exception ex;
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
            if (this.mIsRefresh) {
                LikeView.this.mProgressRefresh.setVisibility(8);
                LikeView.this.mTextRefresh.setText(R.string.refresh);
                LikeView.this.mTextUptime.setVisibility(0);
            } else {
                LikeView.this.mProgress.setVisibility(8);
                LikeView.this.mLayoutRefresh.setVisibility(0);
            }
            if (data != null) {
                LikeView.this.mModelLike = data;
                TiebaApplication.app.setLikeChanged(false);
                LikeView.this.refresh();
            } else if (this.mNetwork != null) {
                LikeView.this.mActivity.showToast(this.mNetwork.getErrorString());
            }
            LikeView.this.mLikeTask = null;
        }

        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.cancelNetConnect();
                this.mNetwork = null;
            }
            LikeView.this.mProgress.setVisibility(8);
            super.cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class UnlikeAsyncTask extends AsyncTask<ForumData, Integer, String> {
        private NetWork mNetwork;

        private UnlikeAsyncTask() {
            this.mNetwork = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public String doInBackground(ForumData... params) {
            ForumData data = params[0];
            if (data != null) {
                try {
                    if (data.getId() != null && data.getName() != null) {
                        this.mNetwork = new NetWork("http://c.tieba.baidu.com/c/c/forum/unfavolike");
                        this.mNetwork.addPostData("fid", data.getId());
                        this.mNetwork.addPostData("kw", data.getName());
                        this.mNetwork.addPostData("favo_type", String.valueOf(data.getFavo_type()));
                        this.mNetwork.addPostData("tbs", TiebaApplication.app.getTbs());
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
            LikeView.this.mUnlikeTask = null;
            LikeView.this.mProgress.setVisibility(8);
            if (this.mNetwork != null) {
                if (this.mNetwork.isRequestSuccess()) {
                    ArrayList<ForumData> datas = LikeView.this.mModelLike.getForum_list();
                    if (datas != null && LikeView.this.mClickItem > 0 && LikeView.this.mClickItem < datas.size()) {
                        datas.remove(LikeView.this.mClickItem);
                        if (LikeView.this.mAdapter != null) {
                            LikeView.this.mAdapter.setData(datas);
                            LikeView.this.mAdapter.notifyDataSetChanged();
                        }
                    }
                    if (!TiebaApplication.app.getLikeChanged()) {
                        TiebaApplication.app.setLikeChanged(true);
                        DatabaseService.delLikeData();
                    }
                    LikeView.this.mActivity.showToast(LikeView.this.mActivity.getString(R.string.success));
                    return;
                }
                LikeView.this.mActivity.showToast(this.mNetwork.getErrorString());
            }
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            LikeView.this.mProgress.setVisibility(0);
        }

        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.cancelNetConnect();
                this.mNetwork = null;
            }
            LikeView.this.mProgress.setVisibility(8);
            LikeView.this.mUnlikeTask = null;
            super.cancel(true);
        }
    }
}
