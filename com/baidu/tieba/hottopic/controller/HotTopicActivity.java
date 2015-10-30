package com.baidu.tieba.hottopic.controller;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.o;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.hottopic.controller.a;
import com.baidu.tieba.hottopic.controller.h;
import com.baidu.tieba.hottopic.data.RelateForumItemData;
import com.baidu.tieba.hottopic.view.RelateForumViewPager;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.w;
/* loaded from: classes.dex */
public class HotTopicActivity extends BaseActivity<HotTopicActivity> implements BdListView.e, UserIconBox.b, a.InterfaceC0056a, h.a, FrsCommonImageLayout.c {
    private com.baidu.adp.lib.e.b<TbImageView> aeI;
    private com.baidu.adp.lib.e.b<TbImageView> boC;
    private RelateForumViewPager.a boH;
    public w boI;
    private com.baidu.tieba.hottopic.view.a boz = null;
    private h boA = null;
    private a boB = null;
    private com.baidu.tieba.hottopic.data.b boD = null;
    private String boE = null;
    private String boF = null;
    private com.baidu.tieba.hottopic.data.f boG = null;
    private CustomMessageListener boJ = new c(this, CmdConfigCustom.CMD_LIKE_FORUM);
    private CustomMessageListener boK = new d(this, CmdConfigCustom.CMD_UNLIKE_FORUM);
    private com.baidu.adp.base.g aLU = new e(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        i(bundle);
        this.boz = new com.baidu.tieba.hottopic.view.a(getPageContext());
        this.boA = new h(this);
        this.boA.a(this);
        this.boI = new w(getPageContext());
        this.boI.setLoadDataCallBack(this.aLU);
        this.boB = new a(this);
        this.boB.a(this);
        QJ();
        QH();
    }

    private void QH() {
        showLoadingView(this.boz.QW(), true);
        if (!com.baidu.adp.lib.util.i.iM()) {
            hideLoadingView(this.boz.QW());
            showNetRefreshView(this.boz.QW(), null);
            return;
        }
        QI();
    }

    private void i(Bundle bundle) {
        Intent intent = getIntent();
        if (intent != null) {
            this.boE = intent.getStringExtra(IntentConfig.TOPIC_ID);
            this.boF = intent.getStringExtra(IntentConfig.TOPIC_NAME);
        } else if (bundle != null) {
            this.boE = bundle.getString(IntentConfig.TOPIC_ID);
            this.boF = bundle.getString(IntentConfig.TOPIC_NAME);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        QK();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        hideNetRefreshView(this.boz.QW());
        onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
        super.onResume();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, com.baidu.adp.base.k
    public BdUniqueId getUniqueId() {
        return super.getUniqueId();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.boz.onChangeSkinType(i);
        changeSkinType(i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public BdListView onGetPreLoadListView() {
        return this.boz.QZ();
    }

    @Override // com.baidu.tieba.hottopic.controller.h.a
    public void a(boolean z, com.baidu.tieba.hottopic.data.b bVar) {
        this.boz.Ra();
        if (!z || bVar == null || this.boz == null) {
            hideLoadingView(this.boz.QW());
            showNetRefreshView(this.boz.QW(), null);
            return;
        }
        this.boD = bVar;
        a(bVar.QR());
        this.boz.b(bVar);
        this.boz.QY();
    }

    private void a(o oVar) {
        if (oVar != null) {
            if (this.boG == null) {
                this.boG = new com.baidu.tieba.hottopic.data.f();
            }
            this.boG.boE = this.boE;
            this.boG.boF = this.boF;
            this.boG.bpn = oVar.rI() != 0;
            this.boG.bpo = 10;
            if (this.boG.bpn) {
                this.boG.bpm++;
                this.boz.Ma();
                return;
            }
            this.boz.Mc();
            this.boz.Mb();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void QI() {
        if (!com.baidu.adp.lib.util.i.iM()) {
            this.boz.Ra();
        } else if (this.boA != null) {
            this.boA.aC(this.boE, this.boF);
        }
    }

    private void QJ() {
        this.boz.a(new f(this));
        this.boz.g(new g(this));
        registerListener(this.boJ);
        registerListener(this.boK);
    }

    private void QK() {
        if (this.boz != null) {
            this.boz.Rc();
            this.boz.Rd();
        }
        if (this.boH != null) {
            this.boH.destory();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onNetRefreshButtonClicked() {
        hideNetRefreshView(this.boz.QW());
        QH();
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.e.b<TbImageView> Kz() {
        if (this.boC == null) {
            this.boC = FrsCommonImageLayout.n(getPageContext().getPageActivity(), 12);
        }
        return this.boC;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.e.b<TbImageView> vB() {
        if (this.aeI == null) {
            this.aeI = UserIconBox.g(getPageContext().getPageActivity(), 8);
        }
        return this.aeI;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public int vA() {
        return com.baidu.tieba.hottopic.b.a.QU();
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public ListView getListView() {
        if (this.boz != null) {
            return this.boz.QZ();
        }
        return null;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!com.baidu.adp.lib.util.i.iM()) {
            this.boz.Mc();
        } else if (this.boz == null || this.boD == null || this.boD.QP() == null || this.boG == null) {
            this.boz.Mb();
        } else {
            this.boz.Ma();
            if (this.boG.bpn) {
                this.boB.b(this.boG);
            } else {
                this.boz.Mb();
            }
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (!StringUtils.isNull(this.boF) || !StringUtils.isNull(this.boE)) {
            bundle.putString(IntentConfig.TOPIC_ID, this.boE);
            bundle.putString(IntentConfig.TOPIC_NAME, this.boF);
        }
    }

    @Override // com.baidu.tieba.hottopic.controller.a.InterfaceC0056a
    public void a(boolean z, com.baidu.tieba.hottopic.data.a aVar) {
        this.boz.Mc();
        if (!z || aVar == null || this.boD == null) {
            this.boz.Mb();
            return;
        }
        this.boD.a(aVar);
        this.boz.QY();
        a(aVar.boR);
    }

    public String QL() {
        return this.boE;
    }

    public void a(RelateForumViewPager.a aVar) {
        this.boH = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public RelateForumItemData aw(long j) {
        if (this.boD != null && this.boD.QP() != null && this.boD.QP().bpq != null) {
            for (RelateForumItemData relateForumItemData : this.boD.QP().bpq) {
                if (relateForumItemData != null && relateForumItemData.forumId == j) {
                    return relateForumItemData;
                }
            }
        }
        return null;
    }
}
