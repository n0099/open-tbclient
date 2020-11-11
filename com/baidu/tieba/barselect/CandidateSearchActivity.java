package com.baidu.tieba.barselect;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdRecyclerView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.BlockPopInfoData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.data.CommitVoteResMsg;
import com.baidu.tieba.R;
import com.baidu.tieba.barselect.model.CandidateSearchHttpResMsg;
import com.baidu.tieba.barselect.model.CandidateSearchSocketResMsg;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.util.f;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes21.dex */
public class CandidateSearchActivity extends BaseActivity {
    private List<com.baidu.tieba.barselect.data.a> dataList;
    private ImageView gEO;
    private BdRecyclerView hQT;
    private b hQU;
    private com.baidu.tieba.barselect.model.a hQV;
    private View hQW;
    private EditText hQX;
    private ImageView hQY;
    private TextView hQZ;
    private String mForumId;
    private NavigationBar mNavigationBar;
    private View mNoDataView;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.CandidateSearchActivity.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() != CandidateSearchActivity.this.hQZ.getId()) {
                if (view.getId() == CandidateSearchActivity.this.hQY.getId()) {
                    CandidateSearchActivity.this.hQX.setText("");
                    CandidateSearchActivity.this.hQT.setVisibility(0);
                    CandidateSearchActivity.this.mNoDataView.setVisibility(8);
                    CandidateSearchActivity.this.hQU.setData(new ArrayList());
                    return;
                }
                return;
            }
            CandidateSearchActivity.this.finish();
        }
    };
    private com.baidu.adp.framework.listener.a hRa = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_CANDIDATE_SEARCH, 309641) { // from class: com.baidu.tieba.barselect.CandidateSearchActivity.2
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage != null) {
                com.baidu.tieba.barselect.data.a aVar = null;
                if (responsedMessage instanceof CandidateSearchHttpResMsg) {
                    aVar = ((CandidateSearchHttpResMsg) responsedMessage).candidateData;
                } else if (responsedMessage instanceof CandidateSearchSocketResMsg) {
                    aVar = ((CandidateSearchSocketResMsg) responsedMessage).candidateData;
                }
                if (responsedMessage.getError() != 0 || aVar == null) {
                    CandidateSearchActivity.this.hQT.setVisibility(8);
                    CandidateSearchActivity.this.mNoDataView.setVisibility(0);
                    return;
                }
                CandidateSearchActivity.this.hQT.setVisibility(0);
                CandidateSearchActivity.this.mNoDataView.setVisibility(8);
                if (CandidateSearchActivity.this.hQX.getText() != null) {
                    aVar.hRu = CandidateSearchActivity.this.hQX.getText().toString();
                }
                if (CandidateSearchActivity.this.dataList != null) {
                    CandidateSearchActivity.this.dataList.clear();
                } else {
                    CandidateSearchActivity.this.dataList = new ArrayList();
                }
                CandidateSearchActivity.this.dataList.add(aVar);
                CandidateSearchActivity.this.hQU.setData(CandidateSearchActivity.this.dataList);
            }
        }
    };
    private TextView.OnEditorActionListener mOnEditorActionListener = new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.barselect.CandidateSearchActivity.3
        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            if (i == 3) {
                if (CandidateSearchActivity.this.hQX.getText() != null && !TextUtils.isEmpty(CandidateSearchActivity.this.hQX.getText().toString()) && !TextUtils.isEmpty(CandidateSearchActivity.this.mForumId)) {
                    CandidateSearchActivity.this.hQV.x(com.baidu.adp.lib.f.b.toInt(CandidateSearchActivity.this.hQX.getText().toString(), 0), com.baidu.adp.lib.f.b.toLong(CandidateSearchActivity.this.mForumId, 0L));
                }
                return true;
            }
            return false;
        }
    };
    private HttpMessageListener hRb = new HttpMessageListener(CmdConfigHttp.CMD_BAR_VOTE) { // from class: com.baidu.tieba.barselect.CandidateSearchActivity.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null) {
                int error = httpResponsedMessage.getError();
                if (error == 0) {
                    l.showToast(TbadkCoreApplication.getInst(), R.string.bar_manager_vote_success);
                    if (CandidateSearchActivity.this.dataList != null) {
                        for (com.baidu.tieba.barselect.data.a aVar : CandidateSearchActivity.this.dataList) {
                            aVar.hRv = true;
                        }
                    }
                } else if (error == 3250023) {
                    f.a(error, "", (f.a) null);
                } else if (error == 3250021) {
                    if (httpResponsedMessage instanceof CommitVoteResMsg) {
                        f.a(error, ((CommitVoteResMsg) httpResponsedMessage).getTokenData(), (f.a) null);
                    }
                } else if (error == 3250002 || error == 3250004) {
                    BlockPopInfoData blockPopInfoData = new BlockPopInfoData();
                    blockPopInfoData.block_info = at.isEmpty(httpResponsedMessage.getErrorString()) ? TbadkCoreApplication.getInst().getString(R.string.block_user_tip) : httpResponsedMessage.getErrorString();
                    blockPopInfoData.ahead_info = TbadkCoreApplication.getInst().getString(R.string.block_user_feed);
                    blockPopInfoData.ok_info = TbadkCoreApplication.getInst().getString(R.string.know);
                    blockPopInfoData.ahead_url = "http://tieba.baidu.com/mo/q/userappeal";
                    AntiHelper.a(CandidateSearchActivity.this, blockPopInfoData);
                } else {
                    l.showToast(TbadkCoreApplication.getInst(), httpResponsedMessage.getErrorString());
                }
            }
        }
    };
    private TextWatcher mTextWatcher = new TextWatcher() { // from class: com.baidu.tieba.barselect.CandidateSearchActivity.5
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            CandidateSearchActivity.this.ol(!StringUtils.isNull(editable.toString()));
        }
    };
    private Runnable hRc = new Runnable() { // from class: com.baidu.tieba.barselect.CandidateSearchActivity.6
        @Override // java.lang.Runnable
        public void run() {
            if (CandidateSearchActivity.this.hQX != null) {
                CandidateSearchActivity.this.hQX.requestFocus();
                l.showSoftKeyPad(CandidateSearchActivity.this, CandidateSearchActivity.this.hQX);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_candidate_search);
        if (getIntent() != null) {
            this.mForumId = getIntent().getStringExtra("forum_id");
        }
        bCV();
        this.hQT = (BdRecyclerView) findViewById(R.id.recycler_view);
        this.hQT.setLayoutManager(new LinearLayoutManager(this));
        this.mNoDataView = findViewById(R.id.text_no_data);
        this.hQU = new b();
        this.hQT.setAdapter(this.hQU);
        registerListener(this.hRa);
        registerListener(this.hRb);
        this.hQV = new com.baidu.tieba.barselect.model.a(getPageContext());
        com.baidu.adp.lib.f.e.mY().postDelayed(this.hRc, 100L);
    }

    private void bCV() {
        this.mNavigationBar = (NavigationBar) findViewById(R.id.navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.hQW = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, R.layout.candidate_search_navigation_view, (View.OnClickListener) null);
        this.gEO = (ImageView) this.hQW.findViewById(R.id.search_bar_icon);
        this.hQX = (EditText) this.hQW.findViewById(R.id.home_et_search);
        this.hQY = (ImageView) this.hQW.findViewById(R.id.home_bt_search_del);
        this.hQY.setOnClickListener(this.mOnClickListener);
        this.hQZ = (TextView) this.hQW.findViewById(R.id.home_bt_search_cancel_s);
        ol(false);
        this.hQZ.setText(getString(R.string.cancel));
        this.hQZ.setOnClickListener(this.mOnClickListener);
        this.hQX.setOnEditorActionListener(this.mOnEditorActionListener);
        this.hQX.addTextChangedListener(this.mTextWatcher);
    }

    public void ol(boolean z) {
        this.hQY.setVisibility(z ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        ap.setViewTextColor(this.mNoDataView, R.color.cp_cont_d);
        SvgManager.brn().a(this.gEO, R.drawable.icon_pure_topbar_search44_svg, R.color.cp_cont_d, (SvgManager.SvgResourceStateType) null);
        this.hQX.setHintTextColor(ap.getColor(R.color.cp_cont_e));
        ap.setNavbarTitleColor(this.hQX, R.color.cp_cont_b, R.color.s_navbar_title_color);
        SvgManager.brn().a(this.hQY, R.drawable.icon_pure_search_empty16_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        ap.setViewTextColor(this.hQZ, R.color.cp_link_tip_a, 1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.hRc);
    }
}
