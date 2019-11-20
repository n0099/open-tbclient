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
import com.baidu.live.k.a;
import com.baidu.live.tbadk.BaseActivity;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.ViewHelper;
import com.baidu.live.tbadk.core.view.NavigationBar;
import com.baidu.live.tbadk.coreextra.message.UpdateAttentionMessage;
import com.baidu.tieba.ala.live.personcenter.fans.g;
/* loaded from: classes6.dex */
public class PersonListActivity extends BaseActivity<PersonListActivity> {
    private TextView aqd;
    private c dQW;
    private LinearLayout dQX;
    private TextView dQY;
    private ImageView dQZ;
    private g dRa;
    private BdListView mListView;
    private NavigationBar mNavigationBar;
    private int dRb = 0;
    private g.a dRc = new g.a() { // from class: com.baidu.tieba.ala.live.personcenter.fans.PersonListActivity.1
        @Override // com.baidu.tieba.ala.live.personcenter.fans.g.a
        public void U(String str, boolean z) {
            if (!StringUtils.isNull(str)) {
                PersonListActivity.this.showToast(str);
            }
            PersonListActivity.this.aMy();
        }

        @Override // com.baidu.tieba.ala.live.personcenter.fans.g.a
        public f a(f fVar, boolean z) {
            if (fVar == null || ListUtils.isEmpty(fVar.ahB())) {
                PersonListActivity.this.aMy();
                return null;
            }
            PersonListActivity.this.mListView.setVisibility(0);
            PersonListActivity.this.dQX.setVisibility(8);
            PersonListActivity.this.dQW.a(fVar);
            return null;
        }
    };
    private View.OnClickListener dFg = new View.OnClickListener() { // from class: com.baidu.tieba.ala.live.personcenter.fans.PersonListActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a aVar;
            if (view != null && (view.getTag() instanceof Integer)) {
                int intValue = ((Integer) view.getTag()).intValue();
                if (PersonListActivity.this.dQW != null && ViewHelper.checkUpIsLogin(PersonListActivity.this.getPageContext().getPageActivity()) && (aVar = (a) PersonListActivity.this.dQW.getItem(intValue)) != null && aVar.userId != null) {
                    boolean z = aVar.dQP != 0;
                    aVar.dQP = z ? 0 : 1;
                    PersonListActivity.this.dQW.notifyDataSetChanged();
                    com.baidu.live.data.b bVar = new com.baidu.live.data.b();
                    bVar.setUserId(aVar.userId);
                    bVar.setPortrait(aVar.portrait);
                    bVar.setPageId(PersonListActivity.this.getUniqueId());
                    bVar.setIsAttention(z ? false : true);
                    com.baidu.live.view.a.wy().a(aVar.userId, bVar);
                }
            }
        }
    };
    private CustomMessageListener dEn = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.live.personcenter.fans.PersonListActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage;
            if ((customResponsedMessage instanceof UpdateAttentionMessage) && (updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage) != null && updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid)) {
                if (!updateAttentionMessage.getData().isSucc) {
                    if (PersonListActivity.this.dQW != null) {
                        PersonListActivity.this.dQW.T(updateAttentionMessage.getData().toUid, !updateAttentionMessage.getData().isAttention);
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
        registerListener(this.dEn);
    }

    private void initData(Bundle bundle) {
        this.dRa = new g(this, this.dRc);
        if (bundle != null) {
            this.dRa.hi(bundle.getBoolean("follow", false));
            this.dRa.setId(bundle.getString("user_id"));
            this.dRb = bundle.getInt("user_sex");
            this.dRa.setSex(this.dRb);
            return;
        }
        Intent intent = getIntent();
        this.dRa.hi(intent.getBooleanExtra("follow", false));
        this.dRa.setId(intent.getStringExtra("user_id"));
        this.dRb = intent.getIntExtra("user_sex", 0);
        this.dRa.setSex(this.dRb);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("follow", this.dRa.aMz());
        bundle.putString("user_id", this.dRa.getId());
        bundle.putInt("user_sex", this.dRb);
    }

    private void initUI() {
        this.mNavigationBar = (NavigationBar) findViewById(a.g.view_navigation_bar);
        this.aqd = this.mNavigationBar.setCenterTextTitle("");
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.mNavigationBar.onChangeSkinType(getPageContext(), 0);
        this.mListView = (BdListView) findViewById(a.g.list);
        this.dQW = new c(getPageContext(), true, this.dRb);
        this.dQW.r(this.dFg);
        this.mListView.setAdapter((ListAdapter) this.dQW);
        this.dQX = (LinearLayout) findViewById(a.g.empty_layout);
        this.dQY = (TextView) findViewById(a.g.ala_empty_view_text);
        this.dQZ = (ImageView) findViewById(a.g.ala_empty_view_img);
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String id = this.dRa.getId();
        if (currentAccount != null && currentAccount.equals(id)) {
            this.aqd.setText(a.i.sdk_prc_fans);
        } else if (this.dRb == 2) {
            this.aqd.setText(a.i.sdk_prc_attention_to_her);
        } else {
            this.aqd.setText(a.i.sdk_prc_attention_to_him);
        }
    }

    private void loadData() {
        this.dRa.aMA();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aMy() {
        this.dQX.setVisibility(0);
        this.mListView.setVisibility(8);
        if (this.dRa.getId() != null && this.dRa.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
            this.dQY.setText(a.i.sdk_prc_not_have_fans_hk);
            this.dQZ.setImageResource(a.f.sdk_pic_live_empty01_qm);
            return;
        }
        this.dQY.setText(a.i.sdk_prc_not_have_fans_hk);
        this.dQZ.setImageResource(a.f.sdk_pic_live_empty01_qm);
    }
}
