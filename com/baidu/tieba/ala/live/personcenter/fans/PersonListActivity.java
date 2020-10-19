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
    private TextView bwx;
    private c gza;
    private LinearLayout gzb;
    private TextView gzc;
    private ImageView gzd;
    private f gze;
    private BdListView mListView;
    private NavigationBar mNavigationBar;
    private int gzf = 0;
    private f.a gzg = new f.a() { // from class: com.baidu.tieba.ala.live.personcenter.fans.PersonListActivity.1
        @Override // com.baidu.tieba.ala.live.personcenter.fans.f.a
        public void az(String str, boolean z) {
            if (!StringUtils.isNull(str)) {
                PersonListActivity.this.showToast(str);
            }
            PersonListActivity.this.bQf();
        }

        @Override // com.baidu.tieba.ala.live.personcenter.fans.f.a
        public e a(e eVar, boolean z) {
            if (eVar == null || ListUtils.isEmpty(eVar.bha())) {
                PersonListActivity.this.bQf();
                return null;
            }
            PersonListActivity.this.mListView.setVisibility(0);
            PersonListActivity.this.gzb.setVisibility(8);
            PersonListActivity.this.gza.a(eVar);
            return null;
        }
    };
    private View.OnClickListener ggG = new View.OnClickListener() { // from class: com.baidu.tieba.ala.live.personcenter.fans.PersonListActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a aVar;
            if (view != null && (view.getTag() instanceof Integer)) {
                int intValue = ((Integer) view.getTag()).intValue();
                if (PersonListActivity.this.gza != null && ViewHelper.checkUpIsLogin(PersonListActivity.this.getPageContext().getPageActivity()) && (aVar = (a) PersonListActivity.this.gza.getItem(intValue)) != null && aVar.userId != null) {
                    boolean z = aVar.aNe != 0;
                    aVar.aNe = z ? 0 : 1;
                    PersonListActivity.this.gza.notifyDataSetChanged();
                    com.baidu.live.data.e eVar = new com.baidu.live.data.e();
                    eVar.setUserId(aVar.userId);
                    eVar.setPortrait(aVar.portrait);
                    eVar.setPageId(PersonListActivity.this.getUniqueId());
                    eVar.setIsAttention(z ? false : true);
                    eVar.setFrom("source_person_card");
                    com.baidu.live.view.a.SY().a(aVar.userId, eVar);
                }
            }
        }
    };
    private CustomMessageListener gfl = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.live.personcenter.fans.PersonListActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage;
            if ((customResponsedMessage instanceof UpdateAttentionMessage) && (updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage) != null && updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid)) {
                if (!updateAttentionMessage.getData().isSucc) {
                    if (PersonListActivity.this.gza != null) {
                        PersonListActivity.this.gza.ax(updateAttentionMessage.getData().toUid, !updateAttentionMessage.getData().isAttention);
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
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!isFinishing()) {
            setContentView(a.h.sdk_prc_person_list_activity);
            initData(bundle);
            initUI();
            loadData();
            registerListener(this.gfl);
        }
    }

    private void initData(Bundle bundle) {
        this.gze = new f(this, this.gzg);
        if (bundle != null) {
            this.gze.md(bundle.getBoolean("follow", false));
            this.gze.setId(bundle.getString("user_id"));
            this.gzf = bundle.getInt("user_sex");
            this.gze.setSex(this.gzf);
            return;
        }
        Intent intent = getIntent();
        this.gze.md(intent.getBooleanExtra("follow", false));
        this.gze.setId(intent.getStringExtra("user_id"));
        this.gzf = intent.getIntExtra("user_sex", 0);
        this.gze.setSex(this.gzf);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("follow", this.gze.bQg());
        bundle.putString("user_id", this.gze.getId());
        bundle.putInt("user_sex", this.gzf);
    }

    private void initUI() {
        this.mNavigationBar = (NavigationBar) findViewById(a.g.view_navigation_bar);
        this.bwx = this.mNavigationBar.setCenterTextTitle("");
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.mNavigationBar.onChangeSkinType(getPageContext(), 0);
        this.mListView = (BdListView) findViewById(a.g.list);
        this.gza = new c(getPageContext(), true, this.gzf);
        this.gza.t(this.ggG);
        this.mListView.setAdapter((ListAdapter) this.gza);
        this.gzb = (LinearLayout) findViewById(a.g.empty_layout);
        this.gzc = (TextView) findViewById(a.g.ala_empty_view_text);
        this.gzd = (ImageView) findViewById(a.g.ala_empty_view_img);
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String id = this.gze.getId();
        if (currentAccount != null && currentAccount.equals(id)) {
            this.bwx.setText(a.i.sdk_prc_fans);
        } else if (this.gzf == 2) {
            this.bwx.setText(a.i.sdk_prc_attention_to_her);
        } else {
            this.bwx.setText(a.i.sdk_prc_attention_to_him);
        }
    }

    private void loadData() {
        this.gze.bQh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bQf() {
        this.gzb.setVisibility(0);
        this.mListView.setVisibility(8);
        if (this.gze.getId() != null && this.gze.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
            this.gzc.setText(a.i.sdk_prc_not_have_fans_hk);
            this.gzd.setImageResource(a.f.sdk_pic_live_empty01_qm);
            return;
        }
        this.gzc.setText(a.i.sdk_prc_not_have_fans_hk);
        this.gzd.setImageResource(a.f.sdk_pic_live_empty01_qm);
    }
}
