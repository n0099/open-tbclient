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
/* loaded from: classes3.dex */
public class PersonListActivity extends BaseActivity<PersonListActivity> {
    private TextView bjy;
    private c fQc;
    private LinearLayout fQd;
    private TextView fQe;
    private ImageView fQf;
    private f fQg;
    private BdListView mListView;
    private NavigationBar mNavigationBar;
    private int fQh = 0;
    private f.a fQi = new f.a() { // from class: com.baidu.tieba.ala.live.personcenter.fans.PersonListActivity.1
        @Override // com.baidu.tieba.ala.live.personcenter.fans.f.a
        public void at(String str, boolean z) {
            if (!StringUtils.isNull(str)) {
                PersonListActivity.this.showToast(str);
            }
            PersonListActivity.this.byV();
        }

        @Override // com.baidu.tieba.ala.live.personcenter.fans.f.a
        public e a(e eVar, boolean z) {
            if (eVar == null || ListUtils.isEmpty(eVar.aRi())) {
                PersonListActivity.this.byV();
                return null;
            }
            PersonListActivity.this.mListView.setVisibility(0);
            PersonListActivity.this.fQd.setVisibility(8);
            PersonListActivity.this.fQc.a(eVar);
            return null;
        }
    };
    private View.OnClickListener fAx = new View.OnClickListener() { // from class: com.baidu.tieba.ala.live.personcenter.fans.PersonListActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a aVar;
            if (view != null && (view.getTag() instanceof Integer)) {
                int intValue = ((Integer) view.getTag()).intValue();
                if (PersonListActivity.this.fQc != null && ViewHelper.checkUpIsLogin(PersonListActivity.this.getPageContext().getPageActivity()) && (aVar = (a) PersonListActivity.this.fQc.getItem(intValue)) != null && aVar.userId != null) {
                    boolean z = aVar.fPV != 0;
                    aVar.fPV = z ? 0 : 1;
                    PersonListActivity.this.fQc.notifyDataSetChanged();
                    com.baidu.live.data.d dVar = new com.baidu.live.data.d();
                    dVar.setUserId(aVar.userId);
                    dVar.setPortrait(aVar.portrait);
                    dVar.setPageId(PersonListActivity.this.getUniqueId());
                    dVar.setIsAttention(z ? false : true);
                    dVar.setFrom("source_person_card");
                    com.baidu.live.view.a.Ky().a(aVar.userId, dVar);
                }
            }
        }
    };
    private CustomMessageListener fzf = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.live.personcenter.fans.PersonListActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage;
            if ((customResponsedMessage instanceof UpdateAttentionMessage) && (updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage) != null && updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid)) {
                if (!updateAttentionMessage.getData().isSucc) {
                    if (PersonListActivity.this.fQc != null) {
                        PersonListActivity.this.fQc.ar(updateAttentionMessage.getData().toUid, !updateAttentionMessage.getData().isAttention);
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
            registerListener(this.fzf);
        }
    }

    private void initData(Bundle bundle) {
        this.fQg = new f(this, this.fQi);
        if (bundle != null) {
            this.fQg.kt(bundle.getBoolean("follow", false));
            this.fQg.setId(bundle.getString("user_id"));
            this.fQh = bundle.getInt("user_sex");
            this.fQg.setSex(this.fQh);
            return;
        }
        Intent intent = getIntent();
        this.fQg.kt(intent.getBooleanExtra("follow", false));
        this.fQg.setId(intent.getStringExtra("user_id"));
        this.fQh = intent.getIntExtra("user_sex", 0);
        this.fQg.setSex(this.fQh);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("follow", this.fQg.byW());
        bundle.putString("user_id", this.fQg.getId());
        bundle.putInt("user_sex", this.fQh);
    }

    private void initUI() {
        this.mNavigationBar = (NavigationBar) findViewById(a.g.view_navigation_bar);
        this.bjy = this.mNavigationBar.setCenterTextTitle("");
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.mNavigationBar.onChangeSkinType(getPageContext(), 0);
        this.mListView = (BdListView) findViewById(a.g.list);
        this.fQc = new c(getPageContext(), true, this.fQh);
        this.fQc.t(this.fAx);
        this.mListView.setAdapter((ListAdapter) this.fQc);
        this.fQd = (LinearLayout) findViewById(a.g.empty_layout);
        this.fQe = (TextView) findViewById(a.g.ala_empty_view_text);
        this.fQf = (ImageView) findViewById(a.g.ala_empty_view_img);
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String id = this.fQg.getId();
        if (currentAccount != null && currentAccount.equals(id)) {
            this.bjy.setText(a.i.sdk_prc_fans);
        } else if (this.fQh == 2) {
            this.bjy.setText(a.i.sdk_prc_attention_to_her);
        } else {
            this.bjy.setText(a.i.sdk_prc_attention_to_him);
        }
    }

    private void loadData() {
        this.fQg.byX();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void byV() {
        this.fQd.setVisibility(0);
        this.mListView.setVisibility(8);
        if (this.fQg.getId() != null && this.fQg.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
            this.fQe.setText(a.i.sdk_prc_not_have_fans_hk);
            this.fQf.setImageResource(a.f.sdk_pic_live_empty01_qm);
            return;
        }
        this.fQe.setText(a.i.sdk_prc_not_have_fans_hk);
        this.fQf.setImageResource(a.f.sdk_pic_live_empty01_qm);
    }
}
