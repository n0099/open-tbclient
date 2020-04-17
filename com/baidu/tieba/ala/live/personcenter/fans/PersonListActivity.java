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
    private TextView aWP;
    private c fqJ;
    private LinearLayout fqK;
    private TextView fqL;
    private ImageView fqM;
    private f fqN;
    private BdListView mListView;
    private NavigationBar mNavigationBar;
    private int fqO = 0;
    private f.a fqP = new f.a() { // from class: com.baidu.tieba.ala.live.personcenter.fans.PersonListActivity.1
        @Override // com.baidu.tieba.ala.live.personcenter.fans.f.a
        public void ae(String str, boolean z) {
            if (!StringUtils.isNull(str)) {
                PersonListActivity.this.showToast(str);
            }
            PersonListActivity.this.bqh();
        }

        @Override // com.baidu.tieba.ala.live.personcenter.fans.f.a
        public e a(e eVar, boolean z) {
            if (eVar == null || ListUtils.isEmpty(eVar.aJD())) {
                PersonListActivity.this.bqh();
                return null;
            }
            PersonListActivity.this.mListView.setVisibility(0);
            PersonListActivity.this.fqK.setVisibility(8);
            PersonListActivity.this.fqJ.a(eVar);
            return null;
        }
    };
    private View.OnClickListener fbt = new View.OnClickListener() { // from class: com.baidu.tieba.ala.live.personcenter.fans.PersonListActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a aVar;
            if (view != null && (view.getTag() instanceof Integer)) {
                int intValue = ((Integer) view.getTag()).intValue();
                if (PersonListActivity.this.fqJ != null && ViewHelper.checkUpIsLogin(PersonListActivity.this.getPageContext().getPageActivity()) && (aVar = (a) PersonListActivity.this.fqJ.getItem(intValue)) != null && aVar.userId != null) {
                    boolean z = aVar.fqC != 0;
                    aVar.fqC = z ? 0 : 1;
                    PersonListActivity.this.fqJ.notifyDataSetChanged();
                    com.baidu.live.data.b bVar = new com.baidu.live.data.b();
                    bVar.setUserId(aVar.userId);
                    bVar.setPortrait(aVar.portrait);
                    bVar.setPageId(PersonListActivity.this.getUniqueId());
                    bVar.setIsAttention(z ? false : true);
                    bVar.setFrom("source_person_card");
                    com.baidu.live.view.a.Ht().a(aVar.userId, bVar);
                }
            }
        }
    };
    private CustomMessageListener eZZ = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.live.personcenter.fans.PersonListActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage;
            if ((customResponsedMessage instanceof UpdateAttentionMessage) && (updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage) != null && updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid)) {
                if (!updateAttentionMessage.getData().isSucc) {
                    if (PersonListActivity.this.fqJ != null) {
                        PersonListActivity.this.fqJ.ac(updateAttentionMessage.getData().toUid, !updateAttentionMessage.getData().isAttention);
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
            registerListener(this.eZZ);
        }
    }

    private void initData(Bundle bundle) {
        this.fqN = new f(this, this.fqP);
        if (bundle != null) {
            this.fqN.jM(bundle.getBoolean("follow", false));
            this.fqN.setId(bundle.getString("user_id"));
            this.fqO = bundle.getInt("user_sex");
            this.fqN.setSex(this.fqO);
            return;
        }
        Intent intent = getIntent();
        this.fqN.jM(intent.getBooleanExtra("follow", false));
        this.fqN.setId(intent.getStringExtra("user_id"));
        this.fqO = intent.getIntExtra("user_sex", 0);
        this.fqN.setSex(this.fqO);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("follow", this.fqN.bqi());
        bundle.putString("user_id", this.fqN.getId());
        bundle.putInt("user_sex", this.fqO);
    }

    private void initUI() {
        this.mNavigationBar = (NavigationBar) findViewById(a.g.view_navigation_bar);
        this.aWP = this.mNavigationBar.setCenterTextTitle("");
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.mNavigationBar.onChangeSkinType(getPageContext(), 0);
        this.mListView = (BdListView) findViewById(a.g.list);
        this.fqJ = new c(getPageContext(), true, this.fqO);
        this.fqJ.t(this.fbt);
        this.mListView.setAdapter((ListAdapter) this.fqJ);
        this.fqK = (LinearLayout) findViewById(a.g.empty_layout);
        this.fqL = (TextView) findViewById(a.g.ala_empty_view_text);
        this.fqM = (ImageView) findViewById(a.g.ala_empty_view_img);
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String id = this.fqN.getId();
        if (currentAccount != null && currentAccount.equals(id)) {
            this.aWP.setText(a.i.sdk_prc_fans);
        } else if (this.fqO == 2) {
            this.aWP.setText(a.i.sdk_prc_attention_to_her);
        } else {
            this.aWP.setText(a.i.sdk_prc_attention_to_him);
        }
    }

    private void loadData() {
        this.fqN.bqj();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqh() {
        this.fqK.setVisibility(0);
        this.mListView.setVisibility(8);
        if (this.fqN.getId() != null && this.fqN.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
            this.fqL.setText(a.i.sdk_prc_not_have_fans_hk);
            this.fqM.setImageResource(a.f.sdk_pic_live_empty01_qm);
            return;
        }
        this.fqL.setText(a.i.sdk_prc_not_have_fans_hk);
        this.fqM.setImageResource(a.f.sdk_pic_live_empty01_qm);
    }
}
