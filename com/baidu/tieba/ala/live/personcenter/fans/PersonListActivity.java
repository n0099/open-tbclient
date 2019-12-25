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
import com.baidu.live.q.a;
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
    private TextView axT;
    private c eGD;
    private LinearLayout eGE;
    private TextView eGF;
    private ImageView eGG;
    private f eGH;
    private BdListView mListView;
    private NavigationBar mNavigationBar;
    private int eGI = 0;
    private f.a eGJ = new f.a() { // from class: com.baidu.tieba.ala.live.personcenter.fans.PersonListActivity.1
        @Override // com.baidu.tieba.ala.live.personcenter.fans.f.a
        public void Y(String str, boolean z) {
            if (!StringUtils.isNull(str)) {
                PersonListActivity.this.showToast(str);
            }
            PersonListActivity.this.bed();
        }

        @Override // com.baidu.tieba.ala.live.personcenter.fans.f.a
        public e a(e eVar, boolean z) {
            if (eVar == null || ListUtils.isEmpty(eVar.ayB())) {
                PersonListActivity.this.bed();
                return null;
            }
            PersonListActivity.this.mListView.setVisibility(0);
            PersonListActivity.this.eGE.setVisibility(8);
            PersonListActivity.this.eGD.a(eVar);
            return null;
        }
    };
    private View.OnClickListener erj = new View.OnClickListener() { // from class: com.baidu.tieba.ala.live.personcenter.fans.PersonListActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a aVar;
            if (view != null && (view.getTag() instanceof Integer)) {
                int intValue = ((Integer) view.getTag()).intValue();
                if (PersonListActivity.this.eGD != null && ViewHelper.checkUpIsLogin(PersonListActivity.this.getPageContext().getPageActivity()) && (aVar = (a) PersonListActivity.this.eGD.getItem(intValue)) != null && aVar.userId != null) {
                    boolean z = aVar.eGw != 0;
                    aVar.eGw = z ? 0 : 1;
                    PersonListActivity.this.eGD.notifyDataSetChanged();
                    com.baidu.live.data.b bVar = new com.baidu.live.data.b();
                    bVar.setUserId(aVar.userId);
                    bVar.setPortrait(aVar.portrait);
                    bVar.setPageId(PersonListActivity.this.getUniqueId());
                    bVar.setIsAttention(z ? false : true);
                    com.baidu.live.view.a.yy().a(aVar.userId, bVar);
                }
            }
        }
    };
    private CustomMessageListener eqb = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.live.personcenter.fans.PersonListActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage;
            if ((customResponsedMessage instanceof UpdateAttentionMessage) && (updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage) != null && updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid)) {
                if (!updateAttentionMessage.getData().isSucc) {
                    if (PersonListActivity.this.eGD != null) {
                        PersonListActivity.this.eGD.X(updateAttentionMessage.getData().toUid, !updateAttentionMessage.getData().isAttention);
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
        registerListener(this.eqb);
    }

    private void initData(Bundle bundle) {
        this.eGH = new f(this, this.eGJ);
        if (bundle != null) {
            this.eGH.is(bundle.getBoolean("follow", false));
            this.eGH.setId(bundle.getString("user_id"));
            this.eGI = bundle.getInt("user_sex");
            this.eGH.setSex(this.eGI);
            return;
        }
        Intent intent = getIntent();
        this.eGH.is(intent.getBooleanExtra("follow", false));
        this.eGH.setId(intent.getStringExtra("user_id"));
        this.eGI = intent.getIntExtra("user_sex", 0);
        this.eGH.setSex(this.eGI);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("follow", this.eGH.bee());
        bundle.putString("user_id", this.eGH.getId());
        bundle.putInt("user_sex", this.eGI);
    }

    private void initUI() {
        this.mNavigationBar = (NavigationBar) findViewById(a.g.view_navigation_bar);
        this.axT = this.mNavigationBar.setCenterTextTitle("");
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.mNavigationBar.onChangeSkinType(getPageContext(), 0);
        this.mListView = (BdListView) findViewById(a.g.list);
        this.eGD = new c(getPageContext(), true, this.eGI);
        this.eGD.t(this.erj);
        this.mListView.setAdapter((ListAdapter) this.eGD);
        this.eGE = (LinearLayout) findViewById(a.g.empty_layout);
        this.eGF = (TextView) findViewById(a.g.ala_empty_view_text);
        this.eGG = (ImageView) findViewById(a.g.ala_empty_view_img);
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String id = this.eGH.getId();
        if (currentAccount != null && currentAccount.equals(id)) {
            this.axT.setText(a.i.sdk_prc_fans);
        } else if (this.eGI == 2) {
            this.axT.setText(a.i.sdk_prc_attention_to_her);
        } else {
            this.axT.setText(a.i.sdk_prc_attention_to_him);
        }
    }

    private void loadData() {
        this.eGH.bef();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bed() {
        this.eGE.setVisibility(0);
        this.mListView.setVisibility(8);
        if (this.eGH.getId() != null && this.eGH.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
            this.eGF.setText(a.i.sdk_prc_not_have_fans_hk);
            this.eGG.setImageResource(a.f.sdk_pic_live_empty01_qm);
            return;
        }
        this.eGF.setText(a.i.sdk_prc_not_have_fans_hk);
        this.eGG.setImageResource(a.f.sdk_pic_live_empty01_qm);
    }
}
