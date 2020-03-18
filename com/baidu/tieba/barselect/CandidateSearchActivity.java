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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.data.CommitVoteResMsg;
import com.baidu.tieba.R;
import com.baidu.tieba.barselect.model.CandidateSearchHttpResMsg;
import com.baidu.tieba.barselect.model.CandidateSearchSocketResMsg;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.util.f;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class CandidateSearchActivity extends BaseActivity {
    private List<com.baidu.tieba.barselect.data.a> dataList;
    private ImageView eEr;
    private BdRecyclerView fDH;
    private b fDI;
    private com.baidu.tieba.barselect.model.a fDJ;
    private View fDK;
    private EditText fDL;
    private ImageView fDM;
    private TextView fDN;
    private String mForumId;
    private NavigationBar mNavigationBar;
    private View mNoDataView;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.barselect.CandidateSearchActivity.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() != CandidateSearchActivity.this.fDN.getId()) {
                if (view.getId() == CandidateSearchActivity.this.fDM.getId()) {
                    CandidateSearchActivity.this.fDL.setText("");
                    CandidateSearchActivity.this.fDH.setVisibility(0);
                    CandidateSearchActivity.this.mNoDataView.setVisibility(8);
                    CandidateSearchActivity.this.fDI.setData(new ArrayList());
                    return;
                }
                return;
            }
            CandidateSearchActivity.this.finish();
        }
    };
    private com.baidu.adp.framework.listener.a fDO = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_CANDIDATE_SEARCH, 309641) { // from class: com.baidu.tieba.barselect.CandidateSearchActivity.2
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
                    CandidateSearchActivity.this.fDH.setVisibility(8);
                    CandidateSearchActivity.this.mNoDataView.setVisibility(0);
                    return;
                }
                CandidateSearchActivity.this.fDH.setVisibility(0);
                CandidateSearchActivity.this.mNoDataView.setVisibility(8);
                if (CandidateSearchActivity.this.fDL.getText() != null) {
                    aVar.fEh = CandidateSearchActivity.this.fDL.getText().toString();
                }
                if (CandidateSearchActivity.this.dataList != null) {
                    CandidateSearchActivity.this.dataList.clear();
                } else {
                    CandidateSearchActivity.this.dataList = new ArrayList();
                }
                CandidateSearchActivity.this.dataList.add(aVar);
                CandidateSearchActivity.this.fDI.setData(CandidateSearchActivity.this.dataList);
            }
        }
    };
    private TextView.OnEditorActionListener mOnEditorActionListener = new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.barselect.CandidateSearchActivity.3
        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            if (i == 3) {
                if (CandidateSearchActivity.this.fDL.getText() != null && !TextUtils.isEmpty(CandidateSearchActivity.this.fDL.getText().toString()) && !TextUtils.isEmpty(CandidateSearchActivity.this.mForumId)) {
                    CandidateSearchActivity.this.fDJ.v(com.baidu.adp.lib.f.b.toInt(CandidateSearchActivity.this.fDL.getText().toString(), 0), com.baidu.adp.lib.f.b.toLong(CandidateSearchActivity.this.mForumId, 0L));
                }
                return true;
            }
            return false;
        }
    };
    private HttpMessageListener fDP = new HttpMessageListener(CmdConfigHttp.CMD_BAR_VOTE) { // from class: com.baidu.tieba.barselect.CandidateSearchActivity.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null) {
                int error = httpResponsedMessage.getError();
                if (error == 0) {
                    l.showToast(TbadkCoreApplication.getInst(), (int) R.string.bar_manager_vote_success);
                    if (CandidateSearchActivity.this.dataList != null) {
                        for (com.baidu.tieba.barselect.data.a aVar : CandidateSearchActivity.this.dataList) {
                            aVar.fEi = true;
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
                    blockPopInfoData.block_info = aq.isEmpty(httpResponsedMessage.getErrorString()) ? TbadkCoreApplication.getInst().getString(R.string.block_user_tip) : httpResponsedMessage.getErrorString();
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
            CandidateSearchActivity.this.kh(!StringUtils.isNull(editable.toString()));
        }
    };
    private Runnable fDQ = new Runnable() { // from class: com.baidu.tieba.barselect.CandidateSearchActivity.6
        @Override // java.lang.Runnable
        public void run() {
            if (CandidateSearchActivity.this.fDL != null) {
                CandidateSearchActivity.this.fDL.requestFocus();
                l.showSoftKeyPad(CandidateSearchActivity.this, CandidateSearchActivity.this.fDL);
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
        bcO();
        this.fDH = (BdRecyclerView) findViewById(R.id.recycler_view);
        this.fDH.setLayoutManager(new LinearLayoutManager(this));
        this.mNoDataView = findViewById(R.id.text_no_data);
        this.fDI = new b();
        this.fDH.setAdapter(this.fDI);
        registerListener(this.fDO);
        registerListener(this.fDP);
        this.fDJ = new com.baidu.tieba.barselect.model.a(getPageContext());
        com.baidu.adp.lib.f.e.gx().postDelayed(this.fDQ, 100L);
    }

    private void bcO() {
        this.mNavigationBar = (NavigationBar) findViewById(R.id.navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.fDK = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, R.layout.candidate_search_navigation_view, (View.OnClickListener) null);
        this.eEr = (ImageView) this.fDK.findViewById(R.id.search_bar_icon);
        this.fDL = (EditText) this.fDK.findViewById(R.id.home_et_search);
        this.fDM = (ImageView) this.fDK.findViewById(R.id.home_bt_search_del);
        this.fDM.setOnClickListener(this.mOnClickListener);
        this.fDN = (TextView) this.fDK.findViewById(R.id.home_bt_search_cancel_s);
        kh(false);
        this.fDN.setText(getString(R.string.cancel));
        this.fDN.setOnClickListener(this.mOnClickListener);
        this.fDL.setOnEditorActionListener(this.mOnEditorActionListener);
        this.fDL.addTextChangedListener(this.mTextWatcher);
    }

    public void kh(boolean z) {
        this.fDM.setVisibility(z ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        am.setViewTextColor(this.mNoDataView, (int) R.color.cp_cont_d);
        SvgManager.aGG().a(this.eEr, R.drawable.icon_pure_topbar_search44_svg, R.color.cp_cont_d, (SvgManager.SvgResourceStateType) null);
        this.fDL.setHintTextColor(am.getColor(R.color.cp_cont_e));
        am.setNavbarTitleColor(this.fDL, R.color.cp_cont_b, R.color.s_navbar_title_color);
        SvgManager.aGG().a(this.fDM, R.drawable.icon_pure_search_empty16_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        am.setViewTextColor(this.fDN, R.color.cp_link_tip_a, 1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.fDQ);
    }
}
