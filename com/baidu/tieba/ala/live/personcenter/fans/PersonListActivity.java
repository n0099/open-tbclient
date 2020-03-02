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
    private TextView aCT;
    private c eLI;
    private LinearLayout eLJ;
    private TextView eLK;
    private ImageView eLL;
    private f eLM;
    private BdListView mListView;
    private NavigationBar mNavigationBar;
    private int eLN = 0;
    private f.a eLO = new f.a() { // from class: com.baidu.tieba.ala.live.personcenter.fans.PersonListActivity.1
        @Override // com.baidu.tieba.ala.live.personcenter.fans.f.a
        public void Y(String str, boolean z) {
            if (!StringUtils.isNull(str)) {
                PersonListActivity.this.showToast(str);
            }
            PersonListActivity.this.bgK();
        }

        @Override // com.baidu.tieba.ala.live.personcenter.fans.f.a
        public e a(e eVar, boolean z) {
            if (eVar == null || ListUtils.isEmpty(eVar.aBn())) {
                PersonListActivity.this.bgK();
                return null;
            }
            PersonListActivity.this.mListView.setVisibility(0);
            PersonListActivity.this.eLJ.setVisibility(8);
            PersonListActivity.this.eLI.a(eVar);
            return null;
        }
    };
    private View.OnClickListener ewG = new View.OnClickListener() { // from class: com.baidu.tieba.ala.live.personcenter.fans.PersonListActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a aVar;
            if (view != null && (view.getTag() instanceof Integer)) {
                int intValue = ((Integer) view.getTag()).intValue();
                if (PersonListActivity.this.eLI != null && ViewHelper.checkUpIsLogin(PersonListActivity.this.getPageContext().getPageActivity()) && (aVar = (a) PersonListActivity.this.eLI.getItem(intValue)) != null && aVar.userId != null) {
                    boolean z = aVar.eLB != 0;
                    aVar.eLB = z ? 0 : 1;
                    PersonListActivity.this.eLI.notifyDataSetChanged();
                    com.baidu.live.data.b bVar = new com.baidu.live.data.b();
                    bVar.setUserId(aVar.userId);
                    bVar.setPortrait(aVar.portrait);
                    bVar.setPageId(PersonListActivity.this.getUniqueId());
                    bVar.setIsAttention(z ? false : true);
                    com.baidu.live.view.a.Bj().a(aVar.userId, bVar);
                }
            }
        }
    };
    private CustomMessageListener evz = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.live.personcenter.fans.PersonListActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage;
            if ((customResponsedMessage instanceof UpdateAttentionMessage) && (updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage) != null && updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid)) {
                if (!updateAttentionMessage.getData().isSucc) {
                    if (PersonListActivity.this.eLI != null) {
                        PersonListActivity.this.eLI.X(updateAttentionMessage.getData().toUid, !updateAttentionMessage.getData().isAttention);
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
        registerListener(this.evz);
    }

    private void initData(Bundle bundle) {
        this.eLM = new f(this, this.eLO);
        if (bundle != null) {
            this.eLM.iJ(bundle.getBoolean("follow", false));
            this.eLM.setId(bundle.getString("user_id"));
            this.eLN = bundle.getInt("user_sex");
            this.eLM.setSex(this.eLN);
            return;
        }
        Intent intent = getIntent();
        this.eLM.iJ(intent.getBooleanExtra("follow", false));
        this.eLM.setId(intent.getStringExtra("user_id"));
        this.eLN = intent.getIntExtra("user_sex", 0);
        this.eLM.setSex(this.eLN);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("follow", this.eLM.bgL());
        bundle.putString("user_id", this.eLM.getId());
        bundle.putInt("user_sex", this.eLN);
    }

    private void initUI() {
        this.mNavigationBar = (NavigationBar) findViewById(a.g.view_navigation_bar);
        this.aCT = this.mNavigationBar.setCenterTextTitle("");
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.mNavigationBar.onChangeSkinType(getPageContext(), 0);
        this.mListView = (BdListView) findViewById(a.g.list);
        this.eLI = new c(getPageContext(), true, this.eLN);
        this.eLI.t(this.ewG);
        this.mListView.setAdapter((ListAdapter) this.eLI);
        this.eLJ = (LinearLayout) findViewById(a.g.empty_layout);
        this.eLK = (TextView) findViewById(a.g.ala_empty_view_text);
        this.eLL = (ImageView) findViewById(a.g.ala_empty_view_img);
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String id = this.eLM.getId();
        if (currentAccount != null && currentAccount.equals(id)) {
            this.aCT.setText(a.i.sdk_prc_fans);
        } else if (this.eLN == 2) {
            this.aCT.setText(a.i.sdk_prc_attention_to_her);
        } else {
            this.aCT.setText(a.i.sdk_prc_attention_to_him);
        }
    }

    private void loadData() {
        this.eLM.bgM();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bgK() {
        this.eLJ.setVisibility(0);
        this.mListView.setVisibility(8);
        if (this.eLM.getId() != null && this.eLM.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
            this.eLK.setText(a.i.sdk_prc_not_have_fans_hk);
            this.eLL.setImageResource(a.f.sdk_pic_live_empty01_qm);
            return;
        }
        this.eLK.setText(a.i.sdk_prc_not_have_fans_hk);
        this.eLL.setImageResource(a.f.sdk_pic_live_empty01_qm);
    }
}
