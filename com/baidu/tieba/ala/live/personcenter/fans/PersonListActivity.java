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
import com.baidu.live.r.a;
import com.baidu.live.tbadk.BaseActivity;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.ViewHelper;
import com.baidu.live.tbadk.core.view.NavigationBar;
import com.baidu.live.tbadk.coreextra.message.UpdateAttentionMessage;
import com.baidu.tieba.ala.live.personcenter.fans.f;
/* loaded from: classes2.dex */
public class PersonListActivity extends BaseActivity<PersonListActivity> {
    private TextView ayC;
    private c eHN;
    private LinearLayout eHO;
    private TextView eHP;
    private ImageView eHQ;
    private f eHR;
    private BdListView mListView;
    private NavigationBar mNavigationBar;
    private int eHS = 0;
    private f.a eHT = new f.a() { // from class: com.baidu.tieba.ala.live.personcenter.fans.PersonListActivity.1
        @Override // com.baidu.tieba.ala.live.personcenter.fans.f.a
        public void Y(String str, boolean z) {
            if (!StringUtils.isNull(str)) {
                PersonListActivity.this.showToast(str);
            }
            PersonListActivity.this.bey();
        }

        @Override // com.baidu.tieba.ala.live.personcenter.fans.f.a
        public e a(e eVar, boolean z) {
            if (eVar == null || ListUtils.isEmpty(eVar.ayU())) {
                PersonListActivity.this.bey();
                return null;
            }
            PersonListActivity.this.mListView.setVisibility(0);
            PersonListActivity.this.eHO.setVisibility(8);
            PersonListActivity.this.eHN.a(eVar);
            return null;
        }
    };
    private View.OnClickListener esv = new View.OnClickListener() { // from class: com.baidu.tieba.ala.live.personcenter.fans.PersonListActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a aVar;
            if (view != null && (view.getTag() instanceof Integer)) {
                int intValue = ((Integer) view.getTag()).intValue();
                if (PersonListActivity.this.eHN != null && ViewHelper.checkUpIsLogin(PersonListActivity.this.getPageContext().getPageActivity()) && (aVar = (a) PersonListActivity.this.eHN.getItem(intValue)) != null && aVar.userId != null) {
                    boolean z = aVar.eHG != 0;
                    aVar.eHG = z ? 0 : 1;
                    PersonListActivity.this.eHN.notifyDataSetChanged();
                    com.baidu.live.data.b bVar = new com.baidu.live.data.b();
                    bVar.setUserId(aVar.userId);
                    bVar.setPortrait(aVar.portrait);
                    bVar.setPageId(PersonListActivity.this.getUniqueId());
                    bVar.setIsAttention(z ? false : true);
                    com.baidu.live.view.a.yR().a(aVar.userId, bVar);
                }
            }
        }
    };
    private CustomMessageListener ern = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.live.personcenter.fans.PersonListActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage;
            if ((customResponsedMessage instanceof UpdateAttentionMessage) && (updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage) != null && updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid)) {
                if (!updateAttentionMessage.getData().isSucc) {
                    if (PersonListActivity.this.eHN != null) {
                        PersonListActivity.this.eHN.X(updateAttentionMessage.getData().toUid, !updateAttentionMessage.getData().isAttention);
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
        registerListener(this.ern);
    }

    private void initData(Bundle bundle) {
        this.eHR = new f(this, this.eHT);
        if (bundle != null) {
            this.eHR.iC(bundle.getBoolean("follow", false));
            this.eHR.setId(bundle.getString("user_id"));
            this.eHS = bundle.getInt("user_sex");
            this.eHR.setSex(this.eHS);
            return;
        }
        Intent intent = getIntent();
        this.eHR.iC(intent.getBooleanExtra("follow", false));
        this.eHR.setId(intent.getStringExtra("user_id"));
        this.eHS = intent.getIntExtra("user_sex", 0);
        this.eHR.setSex(this.eHS);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("follow", this.eHR.bez());
        bundle.putString("user_id", this.eHR.getId());
        bundle.putInt("user_sex", this.eHS);
    }

    private void initUI() {
        this.mNavigationBar = (NavigationBar) findViewById(a.g.view_navigation_bar);
        this.ayC = this.mNavigationBar.setCenterTextTitle("");
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.mNavigationBar.onChangeSkinType(getPageContext(), 0);
        this.mListView = (BdListView) findViewById(a.g.list);
        this.eHN = new c(getPageContext(), true, this.eHS);
        this.eHN.s(this.esv);
        this.mListView.setAdapter((ListAdapter) this.eHN);
        this.eHO = (LinearLayout) findViewById(a.g.empty_layout);
        this.eHP = (TextView) findViewById(a.g.ala_empty_view_text);
        this.eHQ = (ImageView) findViewById(a.g.ala_empty_view_img);
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String id = this.eHR.getId();
        if (currentAccount != null && currentAccount.equals(id)) {
            this.ayC.setText(a.i.sdk_prc_fans);
        } else if (this.eHS == 2) {
            this.ayC.setText(a.i.sdk_prc_attention_to_her);
        } else {
            this.ayC.setText(a.i.sdk_prc_attention_to_him);
        }
    }

    private void loadData() {
        this.eHR.beA();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bey() {
        this.eHO.setVisibility(0);
        this.mListView.setVisibility(8);
        if (this.eHR.getId() != null && this.eHR.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
            this.eHP.setText(a.i.sdk_prc_not_have_fans_hk);
            this.eHQ.setImageResource(a.f.sdk_pic_live_empty01_qm);
            return;
        }
        this.eHP.setText(a.i.sdk_prc_not_have_fans_hk);
        this.eHQ.setImageResource(a.f.sdk_pic_live_empty01_qm);
    }
}
