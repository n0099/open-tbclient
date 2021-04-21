package com.baidu.tieba.barselect;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdRecyclerView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.BlockPopInfoData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.data.CommitVoteResMsg;
import com.baidu.tieba.R;
import com.baidu.tieba.barselect.model.CandidateSearchHttpResMsg;
import com.baidu.tieba.barselect.model.CandidateSearchSocketResMsg;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import d.b.c.e.p.k;
import d.b.c.e.p.l;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class CandidateSearchActivity extends BaseActivity {
    public List<d.b.j0.v.b.a> dataList;
    public CandidateSearchAdapter mAdapter;
    public TextView mButtonCancelSearch;
    public ImageView mButtonDel;
    public String mForumId;
    public d.b.j0.v.d.a mModel;
    public NavigationBar mNavigationBar;
    public View mNavigationCustomView;
    public View mNoDataView;
    public BdRecyclerView mRecyclerView;
    public ImageView mSearchIcon;
    public EditText mSearchbox;
    public View.OnClickListener mOnClickListener = new a();
    public d.b.c.c.g.a mDataResListener = new b(CmdConfigHttp.CMD_CANDIDATE_SEARCH, 309641);
    public TextView.OnEditorActionListener mOnEditorActionListener = new c();
    public HttpMessageListener mVoteListener = new d(CmdConfigHttp.CMD_BAR_VOTE);
    public TextWatcher mTextWatcher = new e();
    public Runnable mShowKeyboardRunnable = new f();

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() != CandidateSearchActivity.this.mButtonCancelSearch.getId()) {
                if (view.getId() == CandidateSearchActivity.this.mButtonDel.getId()) {
                    CandidateSearchActivity.this.mSearchbox.setText("");
                    CandidateSearchActivity.this.mRecyclerView.setVisibility(0);
                    CandidateSearchActivity.this.mNoDataView.setVisibility(8);
                    CandidateSearchActivity.this.mAdapter.setData(new ArrayList());
                    return;
                }
                return;
            }
            CandidateSearchActivity.this.finish();
        }
    }

    /* loaded from: classes4.dex */
    public class b extends d.b.c.c.g.a {
        public b(int i, int i2) {
            super(i, i2);
        }

        @Override // d.b.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage == null) {
                return;
            }
            d.b.j0.v.b.a aVar = null;
            if (responsedMessage instanceof CandidateSearchHttpResMsg) {
                aVar = ((CandidateSearchHttpResMsg) responsedMessage).candidateData;
            } else if (responsedMessage instanceof CandidateSearchSocketResMsg) {
                aVar = ((CandidateSearchSocketResMsg) responsedMessage).candidateData;
            }
            if (responsedMessage.getError() != 0 || aVar == null) {
                CandidateSearchActivity.this.mRecyclerView.setVisibility(8);
                CandidateSearchActivity.this.mNoDataView.setVisibility(0);
                return;
            }
            CandidateSearchActivity.this.mRecyclerView.setVisibility(0);
            CandidateSearchActivity.this.mNoDataView.setVisibility(8);
            if (CandidateSearchActivity.this.mSearchbox.getText() != null) {
                aVar.j = CandidateSearchActivity.this.mSearchbox.getText().toString();
            }
            if (CandidateSearchActivity.this.dataList != null) {
                CandidateSearchActivity.this.dataList.clear();
            } else {
                CandidateSearchActivity.this.dataList = new ArrayList();
            }
            CandidateSearchActivity.this.dataList.add(aVar);
            CandidateSearchActivity.this.mAdapter.setData(CandidateSearchActivity.this.dataList);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements TextView.OnEditorActionListener {
        public c() {
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            if (i == 3) {
                if (CandidateSearchActivity.this.mSearchbox.getText() != null && !TextUtils.isEmpty(CandidateSearchActivity.this.mSearchbox.getText().toString()) && !TextUtils.isEmpty(CandidateSearchActivity.this.mForumId)) {
                    CandidateSearchActivity.this.mModel.a(d.b.c.e.m.b.d(CandidateSearchActivity.this.mSearchbox.getText().toString(), 0), d.b.c.e.m.b.f(CandidateSearchActivity.this.mForumId, 0L));
                }
                return true;
            }
            return false;
        }
    }

    /* loaded from: classes4.dex */
    public class d extends HttpMessageListener {
        public d(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage == null) {
                return;
            }
            int error = httpResponsedMessage.getError();
            if (error == 0) {
                l.K(TbadkCoreApplication.getInst(), R.string.bar_manager_vote_success);
                if (CandidateSearchActivity.this.dataList != null) {
                    for (d.b.j0.v.b.a aVar : CandidateSearchActivity.this.dataList) {
                        aVar.k = true;
                    }
                }
            } else if (error == 3250023) {
                d.b.j0.d3.n0.f.b(error, "", null);
            } else if (error == 3250021) {
                if (httpResponsedMessage instanceof CommitVoteResMsg) {
                    d.b.j0.d3.n0.f.a(error, ((CommitVoteResMsg) httpResponsedMessage).getTokenData(), null);
                }
            } else if (error != 3250002 && error != 3250004) {
                l.L(TbadkCoreApplication.getInst(), httpResponsedMessage.getErrorString());
            } else {
                BlockPopInfoData blockPopInfoData = new BlockPopInfoData();
                blockPopInfoData.block_info = k.isEmpty(httpResponsedMessage.getErrorString()) ? TbadkCoreApplication.getInst().getString(R.string.block_user_tip) : httpResponsedMessage.getErrorString();
                blockPopInfoData.ahead_info = TbadkCoreApplication.getInst().getString(R.string.block_user_feed);
                blockPopInfoData.ok_info = TbadkCoreApplication.getInst().getString(R.string.know);
                blockPopInfoData.ahead_url = "http://tieba.baidu.com/mo/q/userappeal";
                AntiHelper.s(CandidateSearchActivity.this, blockPopInfoData);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements TextWatcher {
        public e() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            CandidateSearchActivity.this.setDelButtonVisible(!StringUtils.isNull(editable.toString()));
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    /* loaded from: classes4.dex */
    public class f implements Runnable {
        public f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (CandidateSearchActivity.this.mSearchbox == null) {
                return;
            }
            CandidateSearchActivity.this.mSearchbox.requestFocus();
            CandidateSearchActivity candidateSearchActivity = CandidateSearchActivity.this;
            l.J(candidateSearchActivity, candidateSearchActivity.mSearchbox);
        }
    }

    private void initNavigationBar() {
        NavigationBar navigationBar = (NavigationBar) findViewById(R.id.navigation_bar);
        this.mNavigationBar = navigationBar;
        navigationBar.showBottomLine();
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, R.layout.candidate_search_navigation_view, (View.OnClickListener) null);
        this.mNavigationCustomView = addCustomView;
        this.mSearchIcon = (ImageView) addCustomView.findViewById(R.id.search_bar_icon);
        this.mSearchbox = (EditText) this.mNavigationCustomView.findViewById(R.id.home_et_search);
        ImageView imageView = (ImageView) this.mNavigationCustomView.findViewById(R.id.home_bt_search_del);
        this.mButtonDel = imageView;
        imageView.setOnClickListener(this.mOnClickListener);
        this.mButtonCancelSearch = (TextView) this.mNavigationCustomView.findViewById(R.id.home_bt_search_cancel_s);
        setDelButtonVisible(false);
        this.mButtonCancelSearch.setText(getString(R.string.cancel));
        this.mButtonCancelSearch.setOnClickListener(this.mOnClickListener);
        this.mSearchbox.setOnEditorActionListener(this.mOnEditorActionListener);
        this.mSearchbox.addTextChangedListener(this.mTextWatcher);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        SkinManager.setViewTextColor(this.mNoDataView, R.color.CAM_X0109);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.mSearchIcon, R.drawable.icon_pure_topbar_search44_svg, R.color.CAM_X0109, null);
        this.mSearchbox.setHintTextColor(SkinManager.getColor(R.color.CAM_X0110));
        SkinManager.setNavbarTitleColor(this.mSearchbox, R.color.CAM_X0105, R.color.s_navbar_title_color);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.mButtonDel, R.drawable.icon_pure_search_empty16_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SkinManager.setViewTextColor(this.mButtonCancelSearch, R.color.CAM_X0302, 1);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_candidate_search);
        if (getIntent() != null) {
            this.mForumId = getIntent().getStringExtra("forum_id");
        }
        initNavigationBar();
        BdRecyclerView bdRecyclerView = (BdRecyclerView) findViewById(R.id.recycler_view);
        this.mRecyclerView = bdRecyclerView;
        bdRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        this.mNoDataView = findViewById(R.id.text_no_data);
        CandidateSearchAdapter candidateSearchAdapter = new CandidateSearchAdapter();
        this.mAdapter = candidateSearchAdapter;
        this.mRecyclerView.setAdapter(candidateSearchAdapter);
        registerListener(this.mDataResListener);
        registerListener(this.mVoteListener);
        this.mModel = new d.b.j0.v.d.a(getPageContext());
        d.b.c.e.m.e.a().postDelayed(this.mShowKeyboardRunnable, 100L);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        d.b.c.e.m.e.a().removeCallbacks(this.mShowKeyboardRunnable);
    }

    public void setDelButtonVisible(boolean z) {
        this.mButtonDel.setVisibility(z ? 0 : 8);
    }
}
