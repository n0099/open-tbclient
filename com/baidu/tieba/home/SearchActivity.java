package com.baidu.tieba.home;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tieba.BaseActivity;
import com.baidu.tieba.R;
import com.baidu.tieba.data.Config;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.model.SuggestModel;
import com.baidu.tieba.util.DatabaseService;
import com.baidu.tieba.util.NetWork;
import com.baidu.tieba.util.TiebaLog;
import com.baidu.tieba.util.UtilHelper;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class SearchActivity extends BaseActivity {
    private EditText mEditSearch = null;
    private Button mButtonDel = null;
    private Button mButtonSearch = null;
    private Button mButtonBack = null;
    private View.OnClickListener mOnClickListener = null;
    private FrameLayout mListLayout = null;
    private ListView mListSearch = null;
    private SearchAdapter mAdapterSearch = null;
    private ListView mListSuggest = null;
    private SearchAdapter mAdapterSuggest = null;
    private ProgressBar mProgress = null;
    private Button mBtSearchFooter = null;
    private View mListFooter = null;
    private TextView mTextNoData = null;
    private SuggestModel mModelSuggest = null;
    private HomeSuggestAsyncTask mSuggestTask = null;
    private String mSearchKey = null;
    private Handler mHandler = new Handler();
    private Runnable mSuggestRunnble = new Runnable() { // from class: com.baidu.tieba.home.SearchActivity.1
        @Override // java.lang.Runnable
        public void run() {
            try {
                if (SearchActivity.this.mSearchKey != null && SearchActivity.this.mSearchKey.length() > 0) {
                    StringBuffer address = new StringBuffer(30);
                    address.append(Config.SERVER_ADDRESS);
                    address.append(Config.SUGGEST_ADDRESS);
                    BasicNameValuePair param = new BasicNameValuePair("q", SearchActivity.this.mSearchKey);
                    SearchActivity.this.cancelAsyncTask();
                    SearchActivity.this.mSuggestTask = new HomeSuggestAsyncTask(address.toString(), param, true);
                    SearchActivity.this.mSuggestTask.execute(address.toString(), param);
                }
            } catch (Exception ex) {
                TiebaLog.e(getClass().getName(), "mSuggestRunnble.run", "error = " + ex.getMessage());
            }
        }
    };

    public static void startActivity(Context context, String title) {
        Intent intent = new Intent(context, SearchActivity.class);
        context.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.BaseActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_dialog_search);
        init();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.BaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        releaseProgressBar();
        cancelAsyncTask();
    }

    public void cancelAsyncTask() {
        this.mHandler.removeCallbacks(this.mSuggestRunnble);
        if (this.mSuggestTask != null) {
            this.mSuggestTask.cancel();
            this.mSuggestTask = null;
        }
    }

    public void init() {
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.home.SearchActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (v == SearchActivity.this.mButtonBack) {
                    SearchActivity.this.finish();
                }
            }
        };
        this.mButtonBack = (Button) findViewById(R.id.back);
        this.mButtonBack.setOnClickListener(this.mOnClickListener);
        LayoutInflater mInflater = getLayoutInflater();
        this.mListFooter = mInflater.inflate(R.layout.home_dialog_search_footer, (ViewGroup) null);
        this.mTextNoData = (TextView) findViewById(R.id.text_no_data);
        this.mEditSearch = (EditText) findViewById(R.id.home_et_search);
        this.mEditSearch.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.home.SearchActivity.3
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean hasFocus) {
                if (!hasFocus) {
                    UtilHelper.hideSoftKeyPad(SearchActivity.this, view);
                }
            }
        });
        View.OnClickListener enterForumListener = new View.OnClickListener() { // from class: com.baidu.tieba.home.SearchActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                String data = SearchActivity.this.mEditSearch.getText().toString();
                FrsActivity.startAcitivity(SearchActivity.this, data, FrsActivity.FRS_FROM_SEARCH, 1);
                if (data != null && data.length() != 0) {
                    SearchActivity.this.finish();
                }
            }
        };
        this.mButtonSearch = (Button) findViewById(R.id.home_bt_search_s);
        this.mButtonSearch.setOnClickListener(enterForumListener);
        this.mButtonSearch.setEnabled(false);
        this.mButtonSearch.setTextColor(getResources().getColor(R.color.gray));
        this.mButtonDel = (Button) findViewById(R.id.home_bt_search_del);
        this.mButtonDel.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.home.SearchActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                SearchActivity.this.mEditSearch.setText("");
            }
        });
        this.mEditSearch.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.home.SearchActivity.6
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                SearchActivity.this.mSearchKey = s.toString().trim();
                if (SearchActivity.this.mSearchKey.length() <= 0) {
                    SearchActivity.this.cancelAsyncTask();
                    SearchActivity.this.showHistory();
                    return;
                }
                SearchActivity.this.showSuggest();
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                int length = s.toString().trim().length();
                if (length == 0) {
                    SearchActivity.this.mButtonSearch.setEnabled(false);
                    SearchActivity.this.mButtonSearch.setTextColor(SearchActivity.this.getResources().getColor(R.color.gray));
                    SearchActivity.this.mButtonDel.setVisibility(8);
                    return;
                }
                SearchActivity.this.mButtonSearch.setEnabled(true);
                SearchActivity.this.mButtonSearch.setTextColor(SearchActivity.this.getResources().getColor(17170444));
                SearchActivity.this.mButtonDel.setVisibility(0);
            }
        });
        this.mListLayout = (FrameLayout) findViewById(R.id.home_search_list);
        this.mListSearch = (ListView) findViewById(R.id.home_lv_search);
        this.mBtSearchFooter = (Button) this.mListFooter.findViewById(R.id.home_bt_search_footer);
        this.mBtSearchFooter.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.home.SearchActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                new AlertDialog.Builder(SearchActivity.this).setTitle("提醒").setIcon(R.drawable.dialogue_quit).setMessage("确认清除搜索记录？").setPositiveButton("确认", new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.home.SearchActivity.7.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialog, int which) {
                        DatabaseService.delAllSearchData();
                        SearchActivity.this.showHistory();
                    }
                }).setNegativeButton("取消", new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.home.SearchActivity.7.2
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                }).create().show();
            }
        });
        this.mListSearch.addFooterView(this.mListFooter, null, true);
        this.mAdapterSearch = new SearchAdapter(this, null);
        this.mListSearch.setAdapter((ListAdapter) this.mAdapterSearch);
        this.mListSearch.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.home.SearchActivity.8
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                ListView tmpList = (ListView) arg0;
                String data = (String) tmpList.getAdapter().getItem(arg2);
                DatabaseService.saveOneSearchData(data);
                FrsActivity.startAcitivity(SearchActivity.this, data, FrsActivity.FRS_FROM_SEARCH);
                SearchActivity.this.mAdapterSearch.adjust(arg2);
                SearchActivity.this.mAdapterSearch.notifyDataSetChanged();
                SearchActivity.this.finish();
            }
        });
        this.mListSuggest = (ListView) findViewById(R.id.home_lv_suggest);
        this.mAdapterSuggest = new SearchAdapter(this, null);
        this.mListSuggest.setAdapter((ListAdapter) this.mAdapterSuggest);
        this.mListSuggest.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.home.SearchActivity.9
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                ListView tmpList = (ListView) arg0;
                String data = (String) tmpList.getAdapter().getItem(arg2);
                FrsActivity.startAcitivity(SearchActivity.this, data, FrsActivity.FRS_FROM_SEARCH, 1);
                SearchActivity.this.finish();
            }
        });
        AbsListView.OnScrollListener scrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.home.SearchActivity.10
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                if (scrollState == 2 || scrollState == 1) {
                    UtilHelper.hideSoftKeyPad(SearchActivity.this, view);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
            }
        };
        this.mListSuggest.setOnScrollListener(scrollListener);
        this.mListSearch.setOnScrollListener(scrollListener);
        this.mProgress = (ProgressBar) findViewById(R.id.home_progress_search);
        this.mProgress.setVisibility(8);
        this.mEditSearch.setText("");
        this.mEditSearch.requestFocus();
        showHistory();
        ShowSoftKeyPadDelay(this.mEditSearch, 150);
    }

    public void releaseProgressBar() {
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
    }

    public void closeSearch() {
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showHistory() {
        this.mListSuggest.setVisibility(8);
        ArrayList<String> hisList = DatabaseService.getAllSearchData();
        if (hisList != null && hisList.size() > 0) {
            this.mListLayout.setVisibility(0);
            this.mListSearch.setVisibility(0);
            this.mListSuggest.setVisibility(8);
            this.mTextNoData.setVisibility(8);
            this.mAdapterSearch.setData(hisList);
            this.mAdapterSearch.notifyDataSetInvalidated();
            return;
        }
        this.mListLayout.setVisibility(8);
        this.mTextNoData.setVisibility(0);
        this.mTextNoData.setText(R.string.text_no_search_record);
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
                    this.mTextNoData.setVisibility(0);
                    this.mTextNoData.setText(R.string.text_no_suggest);
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
            SearchActivity.this.mProgress.setVisibility(0);
            SearchActivity.this.mTextNoData.setVisibility(8);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.AsyncTask
        public SuggestModel doInBackground(Object... params) {
            SuggestModel suggestData = null;
            try {
                this.mNetwork = new NetWork(this.mUrl);
                this.mNetwork.addPostData(this.mParam);
                String data = this.mNetwork.postNetData();
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
            SearchActivity.this.mProgress.setVisibility(8);
            if (data != null) {
                SearchActivity.this.mModelSuggest = data;
                SearchActivity.this.refresh();
            }
            SearchActivity.this.mSuggestTask = null;
        }

        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.cancelNetConnect();
                this.mNetwork = null;
            }
            SearchActivity.this.mProgress.setVisibility(8);
            super.cancel(true);
        }
    }
}
