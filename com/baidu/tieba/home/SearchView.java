package com.baidu.tieba.home;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import com.baidu.tieba.R;
import com.baidu.tieba.data.Config;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.model.SuggestModel;
import com.baidu.tieba.util.DatabaseService;
import com.baidu.tieba.util.NetWork;
import com.baidu.tieba.util.TiebaLog;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class SearchView {
    private HomeActivity mActivity;
    private EditText mEditSearch = null;
    private Button mButtonDel = null;
    private Button mButtonSearch = null;
    private FrameLayout mListLayout = null;
    private ListView mListSearch = null;
    private SearchAdapter mAdapterSearch = null;
    private ListView mListSuggest = null;
    private SearchAdapter mAdapterSuggest = null;
    private ProgressBar mProgress = null;
    private Button mBtSearchFooter = null;
    private View mListFooter = null;
    private SuggestModel mModelSuggest = null;
    private HomeSuggestAsyncTask mSuggestTask = null;
    private Dialog mDialogSearch = null;
    private View mDialogView = null;
    private String mSearchKey = null;
    private Handler mHandler = new Handler();
    private Runnable mSuggestRunnble = new Runnable() { // from class: com.baidu.tieba.home.SearchView.1
        @Override // java.lang.Runnable
        public void run() {
            try {
                if (SearchView.this.mSearchKey != null && SearchView.this.mSearchKey.length() > 0) {
                    StringBuffer address = new StringBuffer(30);
                    address.append(Config.SERVER_ADDRESS);
                    address.append(Config.SUGGEST_ADDRESS);
                    BasicNameValuePair param = new BasicNameValuePair("q", SearchView.this.mSearchKey);
                    SearchView.this.cancelAsyncTask();
                    SearchView.this.mSuggestTask = new HomeSuggestAsyncTask(address.toString(), param, true);
                    SearchView.this.mSuggestTask.execute(address.toString(), param);
                }
            } catch (Exception ex) {
                TiebaLog.e(getClass().getName(), "mSuggestRunnble.run", "error = " + ex.getMessage());
            }
        }
    };

    public SearchView(Activity m) {
        this.mActivity = null;
        this.mActivity = (HomeActivity) m;
    }

    public void cancelAsyncTask() {
        this.mHandler.removeCallbacks(this.mSuggestRunnble);
        if (this.mSuggestTask != null) {
            this.mSuggestTask.cancel();
            this.mSuggestTask = null;
        }
    }

    public void init() {
    }

    public void exec() {
        this.mActivity.setHomeType(3);
        if (this.mDialogSearch == null) {
            this.mDialogSearch = new Dialog(this.mActivity, R.style.search_dialog);
            LayoutInflater mInflater = this.mActivity.getLayoutInflater();
            try {
                this.mDialogView = mInflater.inflate(R.layout.home_dialog_search, (ViewGroup) null);
                this.mListFooter = mInflater.inflate(R.layout.home_dialog_search_footer, (ViewGroup) null);
            } catch (Exception ex) {
                TiebaLog.e("SearchView", "exec", "error = " + ex.getMessage());
            }
            this.mDialogSearch.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.home.SearchView.2
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialog) {
                    SearchView.this.mActivity.setHomeType(1);
                    SearchView.this.cancelAsyncTask();
                }
            });
            this.mEditSearch = (EditText) this.mDialogView.findViewById(R.id.home_et_search);
            this.mEditSearch.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.home.SearchView.3
                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    SearchView.this.mSearchKey = s.toString();
                    if (SearchView.this.mSearchKey.length() > 0) {
                        SearchView.this.showSuggest();
                        return;
                    }
                    SearchView.this.cancelAsyncTask();
                    SearchView.this.showHistory();
                }

                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable s) {
                }
            });
            this.mEditSearch.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.home.SearchView.4
                @Override // android.view.View.OnFocusChangeListener
                public void onFocusChange(View v, boolean hasFocus) {
                }
            });
            this.mButtonDel = (Button) this.mDialogView.findViewById(R.id.home_bt_search_del);
            this.mButtonDel.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.home.SearchView.5
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    SearchView.this.mEditSearch.setText("");
                }
            });
            this.mButtonSearch = (Button) this.mDialogView.findViewById(R.id.home_bt_search_s);
            this.mButtonSearch.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.home.SearchView.6
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    String data = SearchView.this.mEditSearch.getText().toString();
                    FrsActivity.startAcitivity(SearchView.this.mActivity, data, FrsActivity.FRS_FROM_SEARCH, 1);
                    if (data != null && data.length() != 0) {
                        SearchView.this.mDialogSearch.dismiss();
                    }
                }
            });
            this.mListLayout = (FrameLayout) this.mDialogView.findViewById(R.id.home_search_list);
            this.mListSearch = (ListView) this.mDialogView.findViewById(R.id.home_lv_search);
            this.mBtSearchFooter = (Button) this.mListFooter.findViewById(R.id.home_bt_search_footer);
            this.mBtSearchFooter.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.home.SearchView.7
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    new AlertDialog.Builder(SearchView.this.mActivity).setTitle("提醒").setIcon(R.drawable.dialogue_quit).setMessage("确认清除搜索记录？").setPositiveButton("确认", new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.home.SearchView.7.2
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialog, int which) {
                            DatabaseService.delAllSearchData();
                            SearchView.this.showHistory();
                        }
                    }).setNegativeButton("取消", new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.home.SearchView.7.1
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    }).create().show();
                }
            });
            this.mListSearch.addFooterView(this.mListFooter, null, true);
            this.mAdapterSearch = new SearchAdapter(this.mActivity, null);
            this.mListSearch.setAdapter((ListAdapter) this.mAdapterSearch);
            this.mListSearch.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.home.SearchView.8
                @Override // android.widget.AdapterView.OnItemClickListener
                public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                    ListView tmpList = (ListView) arg0;
                    String data = (String) tmpList.getAdapter().getItem(arg2);
                    DatabaseService.saveOneSearchData(data);
                    FrsActivity.startAcitivity(SearchView.this.mActivity, data, FrsActivity.FRS_FROM_SEARCH);
                    SearchView.this.mAdapterSearch.adjust(arg2);
                    SearchView.this.mAdapterSearch.notifyDataSetChanged();
                    SearchView.this.mDialogSearch.dismiss();
                }
            });
            this.mListSuggest = (ListView) this.mDialogView.findViewById(R.id.home_lv_suggest);
            this.mAdapterSuggest = new SearchAdapter(this.mActivity, null);
            this.mListSuggest.setAdapter((ListAdapter) this.mAdapterSuggest);
            this.mListSuggest.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.home.SearchView.9
                @Override // android.widget.AdapterView.OnItemClickListener
                public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                    ListView tmpList = (ListView) arg0;
                    String data = (String) tmpList.getAdapter().getItem(arg2);
                    FrsActivity.startAcitivity(SearchView.this.mActivity, data, FrsActivity.FRS_FROM_SEARCH, 1);
                    SearchView.this.mDialogSearch.dismiss();
                }
            });
            this.mDialogSearch.getWindow().setSoftInputMode(20);
        }
        this.mDialogSearch.show();
        this.mDialogSearch.setContentView(this.mDialogView);
        WindowManager.LayoutParams wmParams = this.mDialogSearch.getWindow().getAttributes();
        wmParams.gravity = 51;
        wmParams.x = 0;
        wmParams.y = 0;
        wmParams.width = -1;
        wmParams.height = -1;
        this.mDialogSearch.getWindow().setAttributes(wmParams);
        this.mProgress = (ProgressBar) this.mDialogView.findViewById(R.id.home_progress_search);
        this.mProgress.setVisibility(8);
        this.mEditSearch.setText("");
        this.mEditSearch.requestFocus();
        showHistory();
        showSoftInput();
    }

    public void releaseProgressBar() {
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
    }

    public void closeSearch() {
        if (this.mDialogSearch != null) {
            this.mDialogSearch.dismiss();
        }
        releaseProgressBar();
    }

    private void showSoftInput() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() { // from class: com.baidu.tieba.home.SearchView.10
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                InputMethodManager imm = (InputMethodManager) SearchView.this.mActivity.getSystemService("input_method");
                imm.toggleSoftInput(0, 2);
            }
        }, 100L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showHistory() {
        this.mListSuggest.setVisibility(8);
        ArrayList<String> hisList = DatabaseService.getAllSearchData();
        if (hisList != null && hisList.size() > 0) {
            this.mListLayout.setVisibility(0);
            this.mListSearch.setVisibility(0);
            this.mListSuggest.setVisibility(8);
            this.mAdapterSearch.setData(hisList);
            this.mAdapterSearch.notifyDataSetInvalidated();
            return;
        }
        this.mListLayout.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showSuggest() {
        this.mListLayout.setVisibility(8);
        this.mHandler.removeCallbacks(this.mSuggestRunnble);
        this.mHandler.postDelayed(this.mSuggestRunnble, 500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refresh() {
        try {
            if (this.mModelSuggest != null) {
                ArrayList<String> list = this.mModelSuggest.getForum_list();
                if (list != null && list.size() > 0) {
                    this.mListLayout.setVisibility(0);
                    this.mListSearch.setVisibility(8);
                    this.mListSuggest.setVisibility(0);
                    this.mAdapterSuggest.setData(list);
                    this.mAdapterSuggest.notifyDataSetInvalidated();
                } else {
                    this.mListLayout.setVisibility(8);
                }
            }
        } catch (Exception ex) {
            TiebaLog.e(getClass().getName(), "", "HomeActivity.refresh error = " + ex.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class HomeSuggestAsyncTask extends AsyncTask<Object, Integer, SuggestModel> {
        private NetWork mNetwork = null;
        BasicNameValuePair mParam;
        private String mUrl;

        public HomeSuggestAsyncTask(String url, BasicNameValuePair param, boolean isRefresh) {
            this.mUrl = null;
            this.mParam = null;
            this.mUrl = url;
            this.mParam = param;
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            SearchView.this.mProgress.setVisibility(0);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.AsyncTask
        public SuggestModel doInBackground(Object... params) {
            Exception ex;
            SuggestModel suggestData = null;
            try {
                this.mNetwork = new NetWork(this.mUrl);
                this.mNetwork.addPostData(this.mParam);
                String data = this.mNetwork.postNetData();
                TiebaLog.i("HomeLikeAsyncTask", "doInBackground", "net data.size: " + String.valueOf(data.length()));
                if (!this.mNetwork.isRequestSuccess() || data == null) {
                    return null;
                }
                SuggestModel suggestData2 = new SuggestModel();
                try {
                    suggestData2.parserJson(data);
                    return suggestData2;
                } catch (Exception e) {
                    ex = e;
                    suggestData = suggestData2;
                    TiebaLog.e(getClass().getName(), "", "doInBackground error = " + ex.getMessage());
                    return suggestData;
                }
            } catch (Exception e2) {
                ex = e2;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(SuggestModel data) {
            SearchView.this.mProgress.setVisibility(8);
            if (data != null) {
                SearchView.this.mModelSuggest = data;
                SearchView.this.refresh();
            } else if (this.mNetwork != null) {
            }
            SearchView.this.mSuggestTask = null;
        }

        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.cancelNetConnect();
                this.mNetwork = null;
            }
            SearchView.this.mProgress.setVisibility(8);
            super.cancel(true);
        }
    }
}
