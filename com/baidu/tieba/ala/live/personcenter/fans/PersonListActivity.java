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
import com.baidu.live.tbadk.BaseActivity;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.ViewHelper;
import com.baidu.live.tbadk.core.view.NavigationBar;
import com.baidu.live.tbadk.coreextra.message.UpdateAttentionMessage;
import com.baidu.live.u.a;
import com.baidu.tieba.ala.live.personcenter.fans.f;
/* loaded from: classes3.dex */
public class PersonListActivity extends BaseActivity<PersonListActivity> {
    private TextView aWU;
    private c fqO;
    private LinearLayout fqP;
    private TextView fqQ;
    private ImageView fqR;
    private f fqS;
    private BdListView mListView;
    private NavigationBar mNavigationBar;
    private int fqT = 0;
    private f.a fqU = new f.a() { // from class: com.baidu.tieba.ala.live.personcenter.fans.PersonListActivity.1
        @Override // com.baidu.tieba.ala.live.personcenter.fans.f.a
        public void ae(String str, boolean z) {
            if (!StringUtils.isNull(str)) {
                PersonListActivity.this.showToast(str);
            }
            PersonListActivity.this.bqf();
        }

        @Override // com.baidu.tieba.ala.live.personcenter.fans.f.a
        public e a(e eVar, boolean z) {
            if (eVar == null || ListUtils.isEmpty(eVar.aJB())) {
                PersonListActivity.this.bqf();
                return null;
            }
            PersonListActivity.this.mListView.setVisibility(0);
            PersonListActivity.this.fqP.setVisibility(8);
            PersonListActivity.this.fqO.a(eVar);
            return null;
        }
    };
    private View.OnClickListener fby = new View.OnClickListener() { // from class: com.baidu.tieba.ala.live.personcenter.fans.PersonListActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a aVar;
            if (view != null && (view.getTag() instanceof Integer)) {
                int intValue = ((Integer) view.getTag()).intValue();
                if (PersonListActivity.this.fqO != null && ViewHelper.checkUpIsLogin(PersonListActivity.this.getPageContext().getPageActivity()) && (aVar = (a) PersonListActivity.this.fqO.getItem(intValue)) != null && aVar.userId != null) {
                    boolean z = aVar.fqH != 0;
                    aVar.fqH = z ? 0 : 1;
                    PersonListActivity.this.fqO.notifyDataSetChanged();
                    com.baidu.live.data.b bVar = new com.baidu.live.data.b();
                    bVar.setUserId(aVar.userId);
                    bVar.setPortrait(aVar.portrait);
                    bVar.setPageId(PersonListActivity.this.getUniqueId());
                    bVar.setIsAttention(z ? false : true);
                    bVar.setFrom("source_person_card");
                    com.baidu.live.view.a.Hs().a(aVar.userId, bVar);
                }
            }
        }
    };
    private CustomMessageListener fae = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.live.personcenter.fans.PersonListActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage;
            if ((customResponsedMessage instanceof UpdateAttentionMessage) && (updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage) != null && updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid)) {
                if (!updateAttentionMessage.getData().isSucc) {
                    if (PersonListActivity.this.fqO != null) {
                        PersonListActivity.this.fqO.ac(updateAttentionMessage.getData().toUid, !updateAttentionMessage.getData().isAttention);
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
        if (!isFinishing()) {
            setContentView(a.h.sdk_prc_person_list_activity);
            initData(bundle);
            initUI();
            loadData();
            registerListener(this.fae);
        }
    }

    private void initData(Bundle bundle) {
        this.fqS = new f(this, this.fqU);
        if (bundle != null) {
            this.fqS.jM(bundle.getBoolean("follow", false));
            this.fqS.setId(bundle.getString("user_id"));
            this.fqT = bundle.getInt("user_sex");
            this.fqS.setSex(this.fqT);
            return;
        }
        Intent intent = getIntent();
        this.fqS.jM(intent.getBooleanExtra("follow", false));
        this.fqS.setId(intent.getStringExtra("user_id"));
        this.fqT = intent.getIntExtra("user_sex", 0);
        this.fqS.setSex(this.fqT);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("follow", this.fqS.bqg());
        bundle.putString("user_id", this.fqS.getId());
        bundle.putInt("user_sex", this.fqT);
    }

    private void initUI() {
        this.mNavigationBar = (NavigationBar) findViewById(a.g.view_navigation_bar);
        this.aWU = this.mNavigationBar.setCenterTextTitle("");
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.mNavigationBar.onChangeSkinType(getPageContext(), 0);
        this.mListView = (BdListView) findViewById(a.g.list);
        this.fqO = new c(getPageContext(), true, this.fqT);
        this.fqO.t(this.fby);
        this.mListView.setAdapter((ListAdapter) this.fqO);
        this.fqP = (LinearLayout) findViewById(a.g.empty_layout);
        this.fqQ = (TextView) findViewById(a.g.ala_empty_view_text);
        this.fqR = (ImageView) findViewById(a.g.ala_empty_view_img);
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String id = this.fqS.getId();
        if (currentAccount != null && currentAccount.equals(id)) {
            this.aWU.setText(a.i.sdk_prc_fans);
        } else if (this.fqT == 2) {
            this.aWU.setText(a.i.sdk_prc_attention_to_her);
        } else {
            this.aWU.setText(a.i.sdk_prc_attention_to_him);
        }
    }

    private void loadData() {
        this.fqS.bqh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqf() {
        this.fqP.setVisibility(0);
        this.mListView.setVisibility(8);
        if (this.fqS.getId() != null && this.fqS.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
            this.fqQ.setText(a.i.sdk_prc_not_have_fans_hk);
            this.fqR.setImageResource(a.f.sdk_pic_live_empty01_qm);
            return;
        }
        this.fqQ.setText(a.i.sdk_prc_not_have_fans_hk);
        this.fqR.setImageResource(a.f.sdk_pic_live_empty01_qm);
    }
}
