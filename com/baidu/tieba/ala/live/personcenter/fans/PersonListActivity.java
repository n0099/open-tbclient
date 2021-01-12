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
/* loaded from: classes10.dex */
public class PersonListActivity extends BaseActivity<PersonListActivity> {
    private TextView bIw;
    private c hgE;
    private LinearLayout hgF;
    private TextView hgG;
    private ImageView hgH;
    private f hgI;
    private BdListView mListView;
    private NavigationBar mNavigationBar;
    private int hgJ = 0;
    private f.a hgK = new f.a() { // from class: com.baidu.tieba.ala.live.personcenter.fans.PersonListActivity.1
        @Override // com.baidu.tieba.ala.live.personcenter.fans.f.a
        public void aD(String str, boolean z) {
            if (!StringUtils.isNull(str)) {
                PersonListActivity.this.showToast(str);
            }
            PersonListActivity.this.bXs();
        }

        @Override // com.baidu.tieba.ala.live.personcenter.fans.f.a
        public e a(e eVar, boolean z) {
            if (eVar == null || ListUtils.isEmpty(eVar.bmp())) {
                PersonListActivity.this.bXs();
                return null;
            }
            PersonListActivity.this.mListView.setVisibility(0);
            PersonListActivity.this.hgF.setVisibility(8);
            PersonListActivity.this.hgE.a(eVar);
            return null;
        }
    };
    private View.OnClickListener gLU = new View.OnClickListener() { // from class: com.baidu.tieba.ala.live.personcenter.fans.PersonListActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a aVar;
            if (view != null && (view.getTag() instanceof Integer)) {
                int intValue = ((Integer) view.getTag()).intValue();
                if (PersonListActivity.this.hgE != null && ViewHelper.checkUpIsLogin(PersonListActivity.this.getPageContext().getPageActivity()) && (aVar = (a) PersonListActivity.this.hgE.getItem(intValue)) != null && aVar.userId != null) {
                    boolean z = aVar.aMc != 0;
                    aVar.aMc = z ? 0 : 1;
                    PersonListActivity.this.hgE.notifyDataSetChanged();
                    com.baidu.live.data.f fVar = new com.baidu.live.data.f();
                    fVar.setUserId(aVar.userId);
                    fVar.setPortrait(aVar.portrait);
                    fVar.setPageId(PersonListActivity.this.getUniqueId());
                    fVar.setIsAttention(z ? false : true);
                    fVar.setFrom("source_person_card");
                    com.baidu.live.view.a.VF().a(aVar.userId, fVar);
                }
            }
        }
    };
    private CustomMessageListener gKA = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.live.personcenter.fans.PersonListActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage;
            if ((customResponsedMessage instanceof UpdateAttentionMessage) && (updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage) != null && updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid)) {
                if (!updateAttentionMessage.getData().isSucc) {
                    if (PersonListActivity.this.hgE != null) {
                        PersonListActivity.this.hgE.aB(updateAttentionMessage.getData().toUid, !updateAttentionMessage.getData().isAttention);
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
                    PersonListActivity.this.showToast(PersonListActivity.this.getResources().getString(a.h.sdk_attention_success_toast));
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!isFinishing()) {
            setContentView(a.g.sdk_prc_person_list_activity);
            initData(bundle);
            initUI();
            loadData();
            registerListener(this.gKA);
        }
    }

    private void initData(Bundle bundle) {
        this.hgI = new f(this, this.hgK);
        if (bundle != null) {
            this.hgI.bu(bundle.getBoolean("follow", false));
            this.hgI.setId(bundle.getString("user_id"));
            this.hgJ = bundle.getInt("user_sex");
            this.hgI.setSex(this.hgJ);
            return;
        }
        Intent intent = getIntent();
        this.hgI.bu(intent.getBooleanExtra("follow", false));
        this.hgI.setId(intent.getStringExtra("user_id"));
        this.hgJ = intent.getIntExtra("user_sex", 0);
        this.hgI.setSex(this.hgJ);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("follow", this.hgI.bXt());
        bundle.putString("user_id", this.hgI.getId());
        bundle.putInt("user_sex", this.hgJ);
    }

    private void initUI() {
        this.mNavigationBar = (NavigationBar) findViewById(a.f.view_navigation_bar);
        this.bIw = this.mNavigationBar.setCenterTextTitle("");
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.mNavigationBar.onChangeSkinType(getPageContext(), 0);
        this.mListView = (BdListView) findViewById(a.f.list);
        this.hgE = new c(getPageContext(), true, this.hgJ);
        this.hgE.v(this.gLU);
        this.mListView.setAdapter((ListAdapter) this.hgE);
        this.hgF = (LinearLayout) findViewById(a.f.empty_layout);
        this.hgG = (TextView) findViewById(a.f.ala_empty_view_text);
        this.hgH = (ImageView) findViewById(a.f.ala_empty_view_img);
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String id = this.hgI.getId();
        if (currentAccount != null && currentAccount.equals(id)) {
            this.bIw.setText(a.h.sdk_prc_fans);
        } else if (this.hgJ == 2) {
            this.bIw.setText(a.h.sdk_prc_attention_to_her);
        } else {
            this.bIw.setText(a.h.sdk_prc_attention_to_him);
        }
    }

    private void loadData() {
        this.hgI.bXu();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bXs() {
        this.hgF.setVisibility(0);
        this.mListView.setVisibility(8);
        if (this.hgI.getId() != null && this.hgI.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
            this.hgG.setText(a.h.sdk_prc_not_have_fans_hk);
            this.hgH.setImageResource(a.e.sdk_pic_live_empty01_qm);
            return;
        }
        this.hgG.setText(a.h.sdk_prc_not_have_fans_hk);
        this.hgH.setImageResource(a.e.sdk_pic_live_empty01_qm);
    }
}
