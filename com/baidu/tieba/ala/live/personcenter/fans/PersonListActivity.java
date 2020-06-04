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
    private c fET;
    private LinearLayout fEU;
    private TextView fEV;
    private ImageView fEW;
    private f fEX;
    private BdListView mListView;
    private NavigationBar mNavigationBar;
    private int fEY = 0;
    private f.a fEZ = new f.a() { // from class: com.baidu.tieba.ala.live.personcenter.fans.PersonListActivity.1
        @Override // com.baidu.tieba.ala.live.personcenter.fans.f.a
        public void ar(String str, boolean z) {
            if (!StringUtils.isNull(str)) {
                PersonListActivity.this.showToast(str);
            }
            PersonListActivity.this.bvZ();
        }

        @Override // com.baidu.tieba.ala.live.personcenter.fans.f.a
        public e a(e eVar, boolean z) {
            if (eVar == null || ListUtils.isEmpty(eVar.aPw())) {
                PersonListActivity.this.bvZ();
                return null;
            }
            PersonListActivity.this.mListView.setVisibility(0);
            PersonListActivity.this.fEU.setVisibility(8);
            PersonListActivity.this.fET.a(eVar);
            return null;
        }
    };
    private View.OnClickListener fpl = new View.OnClickListener() { // from class: com.baidu.tieba.ala.live.personcenter.fans.PersonListActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a aVar;
            if (view != null && (view.getTag() instanceof Integer)) {
                int intValue = ((Integer) view.getTag()).intValue();
                if (PersonListActivity.this.fET != null && ViewHelper.checkUpIsLogin(PersonListActivity.this.getPageContext().getPageActivity()) && (aVar = (a) PersonListActivity.this.fET.getItem(intValue)) != null && aVar.userId != null) {
                    boolean z = aVar.fEM != 0;
                    aVar.fEM = z ? 0 : 1;
                    PersonListActivity.this.fET.notifyDataSetChanged();
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
    private CustomMessageListener fnS = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.live.personcenter.fans.PersonListActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage;
            if ((customResponsedMessage instanceof UpdateAttentionMessage) && (updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage) != null && updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid)) {
                if (!updateAttentionMessage.getData().isSucc) {
                    if (PersonListActivity.this.fET != null) {
                        PersonListActivity.this.fET.ap(updateAttentionMessage.getData().toUid, !updateAttentionMessage.getData().isAttention);
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
            registerListener(this.fnS);
        }
    }

    private void initData(Bundle bundle) {
        this.fEX = new f(this, this.fEZ);
        if (bundle != null) {
            this.fEX.kf(bundle.getBoolean("follow", false));
            this.fEX.setId(bundle.getString("user_id"));
            this.fEY = bundle.getInt("user_sex");
            this.fEX.setSex(this.fEY);
            return;
        }
        Intent intent = getIntent();
        this.fEX.kf(intent.getBooleanExtra("follow", false));
        this.fEX.setId(intent.getStringExtra("user_id"));
        this.fEY = intent.getIntExtra("user_sex", 0);
        this.fEX.setSex(this.fEY);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("follow", this.fEX.bwa());
        bundle.putString("user_id", this.fEX.getId());
        bundle.putInt("user_sex", this.fEY);
    }

    private void initUI() {
        this.mNavigationBar = (NavigationBar) findViewById(a.g.view_navigation_bar);
        this.bem = this.mNavigationBar.setCenterTextTitle("");
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.mNavigationBar.onChangeSkinType(getPageContext(), 0);
        this.mListView = (BdListView) findViewById(a.g.list);
        this.fET = new c(getPageContext(), true, this.fEY);
        this.fET.s(this.fpl);
        this.mListView.setAdapter((ListAdapter) this.fET);
        this.fEU = (LinearLayout) findViewById(a.g.empty_layout);
        this.fEV = (TextView) findViewById(a.g.ala_empty_view_text);
        this.fEW = (ImageView) findViewById(a.g.ala_empty_view_img);
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String id = this.fEX.getId();
        if (currentAccount != null && currentAccount.equals(id)) {
            this.bem.setText(a.i.sdk_prc_fans);
        } else if (this.fEY == 2) {
            this.bem.setText(a.i.sdk_prc_attention_to_her);
        } else {
            this.bem.setText(a.i.sdk_prc_attention_to_him);
        }
    }

    private void loadData() {
        this.fEX.bwb();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bvZ() {
        this.fEU.setVisibility(0);
        this.mListView.setVisibility(8);
        if (this.fEX.getId() != null && this.fEX.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
            this.fEV.setText(a.i.sdk_prc_not_have_fans_hk);
            this.fEW.setImageResource(a.f.sdk_pic_live_empty01_qm);
            return;
        }
        this.fEV.setText(a.i.sdk_prc_not_have_fans_hk);
        this.fEW.setImageResource(a.f.sdk_pic_live_empty01_qm);
    }
}
