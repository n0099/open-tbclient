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
import com.baidu.live.k.a;
import com.baidu.live.tbadk.BaseActivity;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.ViewHelper;
import com.baidu.live.tbadk.core.view.NavigationBar;
import com.baidu.live.tbadk.coreextra.message.UpdateAttentionMessage;
import com.baidu.tieba.ala.live.personcenter.fans.g;
/* loaded from: classes6.dex */
public class PersonListActivity extends BaseActivity<PersonListActivity> {
    private TextView aqv;
    private c dRN;
    private LinearLayout dRO;
    private TextView dRP;
    private ImageView dRQ;
    private g dRR;
    private BdListView mListView;
    private NavigationBar mNavigationBar;
    private int dRS = 0;
    private g.a dRT = new g.a() { // from class: com.baidu.tieba.ala.live.personcenter.fans.PersonListActivity.1
        @Override // com.baidu.tieba.ala.live.personcenter.fans.g.a
        public void U(String str, boolean z) {
            if (!StringUtils.isNull(str)) {
                PersonListActivity.this.showToast(str);
            }
            PersonListActivity.this.aMA();
        }

        @Override // com.baidu.tieba.ala.live.personcenter.fans.g.a
        public f a(f fVar, boolean z) {
            if (fVar == null || ListUtils.isEmpty(fVar.ahD())) {
                PersonListActivity.this.aMA();
                return null;
            }
            PersonListActivity.this.mListView.setVisibility(0);
            PersonListActivity.this.dRO.setVisibility(8);
            PersonListActivity.this.dRN.a(fVar);
            return null;
        }
    };
    private View.OnClickListener dFX = new View.OnClickListener() { // from class: com.baidu.tieba.ala.live.personcenter.fans.PersonListActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a aVar;
            if (view != null && (view.getTag() instanceof Integer)) {
                int intValue = ((Integer) view.getTag()).intValue();
                if (PersonListActivity.this.dRN != null && ViewHelper.checkUpIsLogin(PersonListActivity.this.getPageContext().getPageActivity()) && (aVar = (a) PersonListActivity.this.dRN.getItem(intValue)) != null && aVar.userId != null) {
                    boolean z = aVar.dRG != 0;
                    aVar.dRG = z ? 0 : 1;
                    PersonListActivity.this.dRN.notifyDataSetChanged();
                    com.baidu.live.data.b bVar = new com.baidu.live.data.b();
                    bVar.setUserId(aVar.userId);
                    bVar.setPortrait(aVar.portrait);
                    bVar.setPageId(PersonListActivity.this.getUniqueId());
                    bVar.setIsAttention(z ? false : true);
                    com.baidu.live.view.a.wx().a(aVar.userId, bVar);
                }
            }
        }
    };
    private CustomMessageListener dFe = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.live.personcenter.fans.PersonListActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage;
            if ((customResponsedMessage instanceof UpdateAttentionMessage) && (updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage) != null && updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid)) {
                if (!updateAttentionMessage.getData().isSucc) {
                    if (PersonListActivity.this.dRN != null) {
                        PersonListActivity.this.dRN.T(updateAttentionMessage.getData().toUid, !updateAttentionMessage.getData().isAttention);
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
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(a.h.sdk_prc_person_list_activity);
        initData(bundle);
        initUI();
        loadData();
        registerListener(this.dFe);
    }

    private void initData(Bundle bundle) {
        this.dRR = new g(this, this.dRT);
        if (bundle != null) {
            this.dRR.hi(bundle.getBoolean("follow", false));
            this.dRR.setId(bundle.getString("user_id"));
            this.dRS = bundle.getInt("user_sex");
            this.dRR.setSex(this.dRS);
            return;
        }
        Intent intent = getIntent();
        this.dRR.hi(intent.getBooleanExtra("follow", false));
        this.dRR.setId(intent.getStringExtra("user_id"));
        this.dRS = intent.getIntExtra("user_sex", 0);
        this.dRR.setSex(this.dRS);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("follow", this.dRR.aMB());
        bundle.putString("user_id", this.dRR.getId());
        bundle.putInt("user_sex", this.dRS);
    }

    private void initUI() {
        this.mNavigationBar = (NavigationBar) findViewById(a.g.view_navigation_bar);
        this.aqv = this.mNavigationBar.setCenterTextTitle("");
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.mNavigationBar.onChangeSkinType(getPageContext(), 0);
        this.mListView = (BdListView) findViewById(a.g.list);
        this.dRN = new c(getPageContext(), true, this.dRS);
        this.dRN.r(this.dFX);
        this.mListView.setAdapter((ListAdapter) this.dRN);
        this.dRO = (LinearLayout) findViewById(a.g.empty_layout);
        this.dRP = (TextView) findViewById(a.g.ala_empty_view_text);
        this.dRQ = (ImageView) findViewById(a.g.ala_empty_view_img);
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String id = this.dRR.getId();
        if (currentAccount != null && currentAccount.equals(id)) {
            this.aqv.setText(a.i.sdk_prc_fans);
        } else if (this.dRS == 2) {
            this.aqv.setText(a.i.sdk_prc_attention_to_her);
        } else {
            this.aqv.setText(a.i.sdk_prc_attention_to_him);
        }
    }

    private void loadData() {
        this.dRR.aMC();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aMA() {
        this.dRO.setVisibility(0);
        this.mListView.setVisibility(8);
        if (this.dRR.getId() != null && this.dRR.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
            this.dRP.setText(a.i.sdk_prc_not_have_fans_hk);
            this.dRQ.setImageResource(a.f.sdk_pic_live_empty01_qm);
            return;
        }
        this.dRP.setText(a.i.sdk_prc_not_have_fans_hk);
        this.dRQ.setImageResource(a.f.sdk_pic_live_empty01_qm);
    }
}
