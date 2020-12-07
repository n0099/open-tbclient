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
    private TextView bIt;
    private c gZu;
    private LinearLayout gZv;
    private TextView gZw;
    private ImageView gZx;
    private f gZy;
    private BdListView mListView;
    private NavigationBar mNavigationBar;
    private int gZz = 0;
    private f.a gZA = new f.a() { // from class: com.baidu.tieba.ala.live.personcenter.fans.PersonListActivity.1
        @Override // com.baidu.tieba.ala.live.personcenter.fans.f.a
        public void aC(String str, boolean z) {
            if (!StringUtils.isNull(str)) {
                PersonListActivity.this.showToast(str);
            }
            PersonListActivity.this.bYD();
        }

        @Override // com.baidu.tieba.ala.live.personcenter.fans.f.a
        public e a(e eVar, boolean z) {
            if (eVar == null || ListUtils.isEmpty(eVar.bnI())) {
                PersonListActivity.this.bYD();
                return null;
            }
            PersonListActivity.this.mListView.setVisibility(0);
            PersonListActivity.this.gZv.setVisibility(8);
            PersonListActivity.this.gZu.a(eVar);
            return null;
        }
    };
    private View.OnClickListener gEN = new View.OnClickListener() { // from class: com.baidu.tieba.ala.live.personcenter.fans.PersonListActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a aVar;
            if (view != null && (view.getTag() instanceof Integer)) {
                int intValue = ((Integer) view.getTag()).intValue();
                if (PersonListActivity.this.gZu != null && ViewHelper.checkUpIsLogin(PersonListActivity.this.getPageContext().getPageActivity()) && (aVar = (a) PersonListActivity.this.gZu.getItem(intValue)) != null && aVar.userId != null) {
                    boolean z = aVar.aQa != 0;
                    aVar.aQa = z ? 0 : 1;
                    PersonListActivity.this.gZu.notifyDataSetChanged();
                    com.baidu.live.data.f fVar = new com.baidu.live.data.f();
                    fVar.setUserId(aVar.userId);
                    fVar.setPortrait(aVar.portrait);
                    fVar.setPageId(PersonListActivity.this.getUniqueId());
                    fVar.setIsAttention(z ? false : true);
                    fVar.setFrom("source_person_card");
                    com.baidu.live.view.a.Yo().a(aVar.userId, fVar);
                }
            }
        }
    };
    private CustomMessageListener gDs = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.live.personcenter.fans.PersonListActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage;
            if ((customResponsedMessage instanceof UpdateAttentionMessage) && (updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage) != null && updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid)) {
                if (!updateAttentionMessage.getData().isSucc) {
                    if (PersonListActivity.this.gZu != null) {
                        PersonListActivity.this.gZu.aA(updateAttentionMessage.getData().toUid, !updateAttentionMessage.getData().isAttention);
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
            registerListener(this.gDs);
        }
    }

    private void initData(Bundle bundle) {
        this.gZy = new f(this, this.gZA);
        if (bundle != null) {
            this.gZy.mZ(bundle.getBoolean("follow", false));
            this.gZy.setId(bundle.getString("user_id"));
            this.gZz = bundle.getInt("user_sex");
            this.gZy.setSex(this.gZz);
            return;
        }
        Intent intent = getIntent();
        this.gZy.mZ(intent.getBooleanExtra("follow", false));
        this.gZy.setId(intent.getStringExtra("user_id"));
        this.gZz = intent.getIntExtra("user_sex", 0);
        this.gZy.setSex(this.gZz);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("follow", this.gZy.bYE());
        bundle.putString("user_id", this.gZy.getId());
        bundle.putInt("user_sex", this.gZz);
    }

    private void initUI() {
        this.mNavigationBar = (NavigationBar) findViewById(a.f.view_navigation_bar);
        this.bIt = this.mNavigationBar.setCenterTextTitle("");
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.mNavigationBar.onChangeSkinType(getPageContext(), 0);
        this.mListView = (BdListView) findViewById(a.f.list);
        this.gZu = new c(getPageContext(), true, this.gZz);
        this.gZu.u(this.gEN);
        this.mListView.setAdapter((ListAdapter) this.gZu);
        this.gZv = (LinearLayout) findViewById(a.f.empty_layout);
        this.gZw = (TextView) findViewById(a.f.ala_empty_view_text);
        this.gZx = (ImageView) findViewById(a.f.ala_empty_view_img);
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String id = this.gZy.getId();
        if (currentAccount != null && currentAccount.equals(id)) {
            this.bIt.setText(a.h.sdk_prc_fans);
        } else if (this.gZz == 2) {
            this.bIt.setText(a.h.sdk_prc_attention_to_her);
        } else {
            this.bIt.setText(a.h.sdk_prc_attention_to_him);
        }
    }

    private void loadData() {
        this.gZy.bYF();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bYD() {
        this.gZv.setVisibility(0);
        this.mListView.setVisibility(8);
        if (this.gZy.getId() != null && this.gZy.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
            this.gZw.setText(a.h.sdk_prc_not_have_fans_hk);
            this.gZx.setImageResource(a.e.sdk_pic_live_empty01_qm);
            return;
        }
        this.gZw.setText(a.h.sdk_prc_not_have_fans_hk);
        this.gZx.setImageResource(a.e.sdk_pic_live_empty01_qm);
    }
}
