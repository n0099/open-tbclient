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
    private TextView bem;
    private c fEI;
    private LinearLayout fEJ;
    private TextView fEK;
    private ImageView fEL;
    private f fEM;
    private BdListView mListView;
    private NavigationBar mNavigationBar;
    private int fEN = 0;
    private f.a fEO = new f.a() { // from class: com.baidu.tieba.ala.live.personcenter.fans.PersonListActivity.1
        @Override // com.baidu.tieba.ala.live.personcenter.fans.f.a
        public void ar(String str, boolean z) {
            if (!StringUtils.isNull(str)) {
                PersonListActivity.this.showToast(str);
            }
            PersonListActivity.this.bvX();
        }

        @Override // com.baidu.tieba.ala.live.personcenter.fans.f.a
        public e a(e eVar, boolean z) {
            if (eVar == null || ListUtils.isEmpty(eVar.aPw())) {
                PersonListActivity.this.bvX();
                return null;
            }
            PersonListActivity.this.mListView.setVisibility(0);
            PersonListActivity.this.fEJ.setVisibility(8);
            PersonListActivity.this.fEI.a(eVar);
            return null;
        }
    };
    private View.OnClickListener fpa = new View.OnClickListener() { // from class: com.baidu.tieba.ala.live.personcenter.fans.PersonListActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a aVar;
            if (view != null && (view.getTag() instanceof Integer)) {
                int intValue = ((Integer) view.getTag()).intValue();
                if (PersonListActivity.this.fEI != null && ViewHelper.checkUpIsLogin(PersonListActivity.this.getPageContext().getPageActivity()) && (aVar = (a) PersonListActivity.this.fEI.getItem(intValue)) != null && aVar.userId != null) {
                    boolean z = aVar.fEB != 0;
                    aVar.fEB = z ? 0 : 1;
                    PersonListActivity.this.fEI.notifyDataSetChanged();
                    com.baidu.live.data.d dVar = new com.baidu.live.data.d();
                    dVar.setUserId(aVar.userId);
                    dVar.setPortrait(aVar.portrait);
                    dVar.setPageId(PersonListActivity.this.getUniqueId());
                    dVar.setIsAttention(z ? false : true);
                    dVar.setFrom("source_person_card");
                    com.baidu.live.view.a.Jl().a(aVar.userId, dVar);
                }
            }
        }
    };
    private CustomMessageListener fnH = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.live.personcenter.fans.PersonListActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage;
            if ((customResponsedMessage instanceof UpdateAttentionMessage) && (updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage) != null && updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid)) {
                if (!updateAttentionMessage.getData().isSucc) {
                    if (PersonListActivity.this.fEI != null) {
                        PersonListActivity.this.fEI.ap(updateAttentionMessage.getData().toUid, !updateAttentionMessage.getData().isAttention);
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
            registerListener(this.fnH);
        }
    }

    private void initData(Bundle bundle) {
        this.fEM = new f(this, this.fEO);
        if (bundle != null) {
            this.fEM.kf(bundle.getBoolean("follow", false));
            this.fEM.setId(bundle.getString("user_id"));
            this.fEN = bundle.getInt("user_sex");
            this.fEM.setSex(this.fEN);
            return;
        }
        Intent intent = getIntent();
        this.fEM.kf(intent.getBooleanExtra("follow", false));
        this.fEM.setId(intent.getStringExtra("user_id"));
        this.fEN = intent.getIntExtra("user_sex", 0);
        this.fEM.setSex(this.fEN);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("follow", this.fEM.bvY());
        bundle.putString("user_id", this.fEM.getId());
        bundle.putInt("user_sex", this.fEN);
    }

    private void initUI() {
        this.mNavigationBar = (NavigationBar) findViewById(a.g.view_navigation_bar);
        this.bem = this.mNavigationBar.setCenterTextTitle("");
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.mNavigationBar.onChangeSkinType(getPageContext(), 0);
        this.mListView = (BdListView) findViewById(a.g.list);
        this.fEI = new c(getPageContext(), true, this.fEN);
        this.fEI.s(this.fpa);
        this.mListView.setAdapter((ListAdapter) this.fEI);
        this.fEJ = (LinearLayout) findViewById(a.g.empty_layout);
        this.fEK = (TextView) findViewById(a.g.ala_empty_view_text);
        this.fEL = (ImageView) findViewById(a.g.ala_empty_view_img);
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String id = this.fEM.getId();
        if (currentAccount != null && currentAccount.equals(id)) {
            this.bem.setText(a.i.sdk_prc_fans);
        } else if (this.fEN == 2) {
            this.bem.setText(a.i.sdk_prc_attention_to_her);
        } else {
            this.bem.setText(a.i.sdk_prc_attention_to_him);
        }
    }

    private void loadData() {
        this.fEM.bvZ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bvX() {
        this.fEJ.setVisibility(0);
        this.mListView.setVisibility(8);
        if (this.fEM.getId() != null && this.fEM.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
            this.fEK.setText(a.i.sdk_prc_not_have_fans_hk);
            this.fEL.setImageResource(a.f.sdk_pic_live_empty01_qm);
            return;
        }
        this.fEK.setText(a.i.sdk_prc_not_have_fans_hk);
        this.fEL.setImageResource(a.f.sdk_pic_live_empty01_qm);
    }
}
