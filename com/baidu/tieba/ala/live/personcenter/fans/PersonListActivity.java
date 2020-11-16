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
    private TextView bDl;
    private c gQh;
    private LinearLayout gQi;
    private TextView gQj;
    private ImageView gQk;
    private f gQl;
    private BdListView mListView;
    private NavigationBar mNavigationBar;
    private int gQm = 0;
    private f.a gQn = new f.a() { // from class: com.baidu.tieba.ala.live.personcenter.fans.PersonListActivity.1
        @Override // com.baidu.tieba.ala.live.personcenter.fans.f.a
        public void aB(String str, boolean z) {
            if (!StringUtils.isNull(str)) {
                PersonListActivity.this.showToast(str);
            }
            PersonListActivity.this.bUU();
        }

        @Override // com.baidu.tieba.ala.live.personcenter.fans.f.a
        public e a(e eVar, boolean z) {
            if (eVar == null || ListUtils.isEmpty(eVar.bkv())) {
                PersonListActivity.this.bUU();
                return null;
            }
            PersonListActivity.this.mListView.setVisibility(0);
            PersonListActivity.this.gQi.setVisibility(8);
            PersonListActivity.this.gQh.a(eVar);
            return null;
        }
    };
    private View.OnClickListener gwe = new View.OnClickListener() { // from class: com.baidu.tieba.ala.live.personcenter.fans.PersonListActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a aVar;
            if (view != null && (view.getTag() instanceof Integer)) {
                int intValue = ((Integer) view.getTag()).intValue();
                if (PersonListActivity.this.gQh != null && ViewHelper.checkUpIsLogin(PersonListActivity.this.getPageContext().getPageActivity()) && (aVar = (a) PersonListActivity.this.gQh.getItem(intValue)) != null && aVar.userId != null) {
                    boolean z = aVar.aNb != 0;
                    aVar.aNb = z ? 0 : 1;
                    PersonListActivity.this.gQh.notifyDataSetChanged();
                    com.baidu.live.data.f fVar = new com.baidu.live.data.f();
                    fVar.setUserId(aVar.userId);
                    fVar.setPortrait(aVar.portrait);
                    fVar.setPageId(PersonListActivity.this.getUniqueId());
                    fVar.setIsAttention(z ? false : true);
                    fVar.setFrom("source_person_card");
                    com.baidu.live.view.a.VO().a(aVar.userId, fVar);
                }
            }
        }
    };
    private CustomMessageListener guJ = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.live.personcenter.fans.PersonListActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage;
            if ((customResponsedMessage instanceof UpdateAttentionMessage) && (updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage) != null && updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid)) {
                if (!updateAttentionMessage.getData().isSucc) {
                    if (PersonListActivity.this.gQh != null) {
                        PersonListActivity.this.gQh.az(updateAttentionMessage.getData().toUid, !updateAttentionMessage.getData().isAttention);
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
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!isFinishing()) {
            setContentView(a.g.sdk_prc_person_list_activity);
            initData(bundle);
            initUI();
            loadData();
            registerListener(this.guJ);
        }
    }

    private void initData(Bundle bundle) {
        this.gQl = new f(this, this.gQn);
        if (bundle != null) {
            this.gQl.mE(bundle.getBoolean("follow", false));
            this.gQl.setId(bundle.getString("user_id"));
            this.gQm = bundle.getInt("user_sex");
            this.gQl.setSex(this.gQm);
            return;
        }
        Intent intent = getIntent();
        this.gQl.mE(intent.getBooleanExtra("follow", false));
        this.gQl.setId(intent.getStringExtra("user_id"));
        this.gQm = intent.getIntExtra("user_sex", 0);
        this.gQl.setSex(this.gQm);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("follow", this.gQl.bUV());
        bundle.putString("user_id", this.gQl.getId());
        bundle.putInt("user_sex", this.gQm);
    }

    private void initUI() {
        this.mNavigationBar = (NavigationBar) findViewById(a.f.view_navigation_bar);
        this.bDl = this.mNavigationBar.setCenterTextTitle("");
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.mNavigationBar.onChangeSkinType(getPageContext(), 0);
        this.mListView = (BdListView) findViewById(a.f.list);
        this.gQh = new c(getPageContext(), true, this.gQm);
        this.gQh.u(this.gwe);
        this.mListView.setAdapter((ListAdapter) this.gQh);
        this.gQi = (LinearLayout) findViewById(a.f.empty_layout);
        this.gQj = (TextView) findViewById(a.f.ala_empty_view_text);
        this.gQk = (ImageView) findViewById(a.f.ala_empty_view_img);
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String id = this.gQl.getId();
        if (currentAccount != null && currentAccount.equals(id)) {
            this.bDl.setText(a.h.sdk_prc_fans);
        } else if (this.gQm == 2) {
            this.bDl.setText(a.h.sdk_prc_attention_to_her);
        } else {
            this.bDl.setText(a.h.sdk_prc_attention_to_him);
        }
    }

    private void loadData() {
        this.gQl.bUW();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bUU() {
        this.gQi.setVisibility(0);
        this.mListView.setVisibility(8);
        if (this.gQl.getId() != null && this.gQl.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
            this.gQj.setText(a.h.sdk_prc_not_have_fans_hk);
            this.gQk.setImageResource(a.e.sdk_pic_live_empty01_qm);
            return;
        }
        this.gQj.setText(a.h.sdk_prc_not_have_fans_hk);
        this.gQk.setImageResource(a.e.sdk_pic_live_empty01_qm);
    }
}
