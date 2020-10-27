package com.baidu.tieba.ala.live.personcenter.fans;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.message.Message;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.adp.widget.listview.BdListView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.BaseActivity;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.ViewHelper;
import com.baidu.live.tbadk.core.view.NavigationBar;
import com.baidu.live.tbadk.coreextra.message.UpdateAttentionMessage;
import com.baidu.tieba.ala.live.personcenter.fans.f;
/* loaded from: classes4.dex */
public class PersonListActivity extends BaseActivity<PersonListActivity> {
    private TextView byL;
    private c gKO;
    private LinearLayout gKP;
    private TextView gKQ;
    private ImageView gKR;
    private f gKS;
    private BdListView mListView;
    private NavigationBar mNavigationBar;
    private int gKT = 0;
    private f.a gKU = new f.a() { // from class: com.baidu.tieba.ala.live.personcenter.fans.PersonListActivity.1
        @Override // com.baidu.tieba.ala.live.personcenter.fans.f.a
        public void aB(String str, boolean z) {
            if (!StringUtils.isNull(str)) {
                PersonListActivity.this.showToast(str);
            }
            PersonListActivity.this.bTc();
        }

        @Override // com.baidu.tieba.ala.live.personcenter.fans.f.a
        public e a(e eVar, boolean z) {
            if (eVar == null || ListUtils.isEmpty(eVar.biT())) {
                PersonListActivity.this.bTc();
                return null;
            }
            PersonListActivity.this.mListView.setVisibility(0);
            PersonListActivity.this.gKP.setVisibility(8);
            PersonListActivity.this.gKO.a(eVar);
            return null;
        }
    };
    private View.OnClickListener gqJ = new View.OnClickListener() { // from class: com.baidu.tieba.ala.live.personcenter.fans.PersonListActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a aVar;
            if (view != null && (view.getTag() instanceof Integer)) {
                int intValue = ((Integer) view.getTag()).intValue();
                if (PersonListActivity.this.gKO != null && ViewHelper.checkUpIsLogin(PersonListActivity.this.getPageContext().getPageActivity()) && (aVar = (a) PersonListActivity.this.gKO.getItem(intValue)) != null && aVar.userId != null) {
                    boolean z = aVar.aNJ != 0;
                    aVar.aNJ = z ? 0 : 1;
                    PersonListActivity.this.gKO.notifyDataSetChanged();
                    com.baidu.live.data.f fVar = new com.baidu.live.data.f();
                    fVar.setUserId(aVar.userId);
                    fVar.setPortrait(aVar.portrait);
                    fVar.setPageId(PersonListActivity.this.getUniqueId());
                    fVar.setIsAttention(z ? false : true);
                    fVar.setFrom("source_person_card");
                    com.baidu.live.view.a.TX().a(aVar.userId, fVar);
                }
            }
        }
    };
    private CustomMessageListener gpo = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.live.personcenter.fans.PersonListActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage;
            if ((customResponsedMessage instanceof UpdateAttentionMessage) && (updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage) != null && updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid)) {
                if (!updateAttentionMessage.getData().isSucc) {
                    if (PersonListActivity.this.gKO != null) {
                        PersonListActivity.this.gKO.az(updateAttentionMessage.getData().toUid, !updateAttentionMessage.getData().isAttention);
                    }
                    Message<?> message = updateAttentionMessage.getmOrginalMessage();
                    if (message != null && message.getTag() != null && message.getTag().equals(PersonListActivity.this.getUniqueId())) {
                        PersonListActivity.this.showToast(updateAttentionMessage.getData().errorString);
                        return;
                    }
                    return;
                }
                Message<?> message2 = updateAttentionMessage.getmOrginalMessage();
                if (message2 != null && message2.getTag() != null && message2.getTag().equals(PersonListActivity.this.getUniqueId()) && updateAttentionMessage.getData().isAttention) {
                    PersonListActivity.this.showToast(PersonListActivity.this.getResources().getString(a.i.sdk_attention_success_toast));
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!isFinishing()) {
            setContentView(a.h.sdk_prc_person_list_activity);
            initData(bundle);
            initUI();
            loadData();
            registerListener(this.gpo);
        }
    }

    private void initData(Bundle bundle) {
        this.gKS = new f(this, this.gKU);
        if (bundle != null) {
            this.gKS.mu(bundle.getBoolean("follow", false));
            this.gKS.setId(bundle.getString("user_id"));
            this.gKT = bundle.getInt("user_sex");
            this.gKS.setSex(this.gKT);
            return;
        }
        Intent intent = getIntent();
        this.gKS.mu(intent.getBooleanExtra("follow", false));
        this.gKS.setId(intent.getStringExtra("user_id"));
        this.gKT = intent.getIntExtra("user_sex", 0);
        this.gKS.setSex(this.gKT);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("follow", this.gKS.bTd());
        bundle.putString("user_id", this.gKS.getId());
        bundle.putInt("user_sex", this.gKT);
    }

    private void initUI() {
        this.mNavigationBar = (NavigationBar) findViewById(a.g.view_navigation_bar);
        this.byL = this.mNavigationBar.setCenterTextTitle("");
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.mNavigationBar.onChangeSkinType(getPageContext(), 0);
        this.mListView = (BdListView) findViewById(a.g.list);
        this.gKO = new c(getPageContext(), true, this.gKT);
        this.gKO.t(this.gqJ);
        this.mListView.setAdapter((ListAdapter) this.gKO);
        this.gKP = (LinearLayout) findViewById(a.g.empty_layout);
        this.gKQ = (TextView) findViewById(a.g.ala_empty_view_text);
        this.gKR = (ImageView) findViewById(a.g.ala_empty_view_img);
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String id = this.gKS.getId();
        if (currentAccount != null && currentAccount.equals(id)) {
            this.byL.setText(a.i.sdk_prc_fans);
        } else if (this.gKT == 2) {
            this.byL.setText(a.i.sdk_prc_attention_to_her);
        } else {
            this.byL.setText(a.i.sdk_prc_attention_to_him);
        }
    }

    private void loadData() {
        this.gKS.bTe();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bTc() {
        this.gKP.setVisibility(0);
        this.mListView.setVisibility(8);
        if (this.gKS.getId() != null && this.gKS.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
            this.gKQ.setText(a.i.sdk_prc_not_have_fans_hk);
            this.gKR.setImageResource(a.f.sdk_pic_live_empty01_qm);
            return;
        }
        this.gKQ.setText(a.i.sdk_prc_not_have_fans_hk);
        this.gKR.setImageResource(a.f.sdk_pic_live_empty01_qm);
    }
}
