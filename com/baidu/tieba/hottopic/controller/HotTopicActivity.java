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
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.hottopic.controller.b;
import com.baidu.tieba.hottopic.controller.i;
import com.baidu.tieba.hottopic.data.RelateForumItemData;
import com.baidu.tieba.hottopic.data.ShareFromTopicMsgData;
import com.baidu.tieba.n;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.x;
/* loaded from: classes.dex */
public class HotTopicActivity extends BaseActivity<HotTopicActivity> implements BdListView.e, UserIconBox.b, b.a, i.a, FrsCommonImageLayout.c {
    private com.baidu.adp.lib.f.b<TbImageView> agI;
    private k bGJ;
    private a bGK;
    private com.baidu.adp.lib.f.b<TbImageView> bGL;
    private BdBaseViewPager.a bGP;
    public x bGQ;
    private com.baidu.tieba.hottopic.view.a bGG = null;
    private i bGH = null;
    private b bGI = null;
    private com.baidu.tieba.hottopic.data.c bGM = null;
    private String bGN = null;
    private String aQB = null;
    private com.baidu.tieba.hottopic.data.h bGO = null;
    private CustomMessageListener aDW = new d(this, CmdConfigCustom.CMD_LIKE_FORUM);
    private CustomMessageListener aDV = new e(this, CmdConfigCustom.CMD_UNLIKE_FORUM);
    private com.baidu.adp.base.g aUC = new f(this);

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        e(bundle);
        this.bGG = new com.baidu.tieba.hottopic.view.a(getPageContext());
        this.bGH = new i(this);
        this.bGH.a(this);
        this.bGQ = new x(getPageContext());
        this.bGQ.setLoadDataCallBack(this.aUC);
        this.bGI = new b(this);
        this.bGI.a(this);
        this.bGJ = new k(getPageContext());
        this.bGK = new a(this);
        Vm();
        Vh();
    }

    private void Vh() {
        showLoadingView(this.bGG.VF(), true);
        if (!com.baidu.adp.lib.util.i.iQ()) {
            hideLoadingView(this.bGG.VF());
            showNetRefreshView(this.bGG.VF(), getResources().getString(n.j.neterror), true);
            this.bGG.ic(0);
            return;
        }
        Vj();
    }

    private void e(Bundle bundle) {
        Intent intent = getIntent();
        if (intent != null) {
            this.bGN = intent.getStringExtra(IntentConfig.TOPIC_ID);
            this.aQB = intent.getStringExtra(IntentConfig.TOPIC_NAME);
        } else if (bundle != null) {
            this.bGN = bundle.getString(IntentConfig.TOPIC_ID);
            this.aQB = bundle.getString(IntentConfig.TOPIC_NAME);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        Vn();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onResume() {
        onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
        if (this.bGP != null) {
            this.bGP.wa();
        }
        super.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onPause() {
        if (this.bGP != null) {
            this.bGP.wb();
        }
        super.onPause();
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 23003:
                    if (intent != null && this.bGM != null) {
                        this.bGJ.a(Vi(), intent.getIntExtra("group_id", 0), intent.getStringExtra("group_name"), intent.getLongExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID, 0L), this.bGM);
                        return;
                    }
                    return;
                case 23007:
                    if (intent != null && this.bGM != null) {
                        this.bGJ.a(Vi(), intent.getLongExtra("key_user_id", -1L), intent.getStringExtra("key_user_name"), intent.getStringExtra("key_user_portait"), this.bGM);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public ShareFromTopicMsgData Vi() {
        ShareFromTopicMsgData shareFromTopicMsgData = new ShareFromTopicMsgData();
        shareFromTopicMsgData.setContent(this.bGM.Vv().bHt);
        shareFromTopicMsgData.setImageUrl(this.bGM.Vv().bHu);
        shareFromTopicMsgData.setTitle(this.bGM.Vv().aQB);
        shareFromTopicMsgData.setHotTopicID(this.bGM.Vv().bGN);
        shareFromTopicMsgData.setHotTopicName(this.bGM.Vv().aQB);
        shareFromTopicMsgData.setLinkUrl(String.valueOf("http://tieba.baidu.com/mo/q/hotMessage?topic_id=") + this.bGM.Vv().bGN);
        return shareFromTopicMsgData;
    }

    @Override // com.baidu.adp.base.BdBaseActivity, com.baidu.adp.base.k
    public BdUniqueId getUniqueId() {
        return super.getUniqueId();
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.bGG.onChangeSkinType(i);
        changeSkinType(i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public BdListView onGetPreLoadListView() {
        return this.bGG.VI();
    }

    @Override // com.baidu.tieba.hottopic.controller.i.a
    public void a(boolean z, com.baidu.tieba.hottopic.data.c cVar) {
        this.bGG.VJ();
        hideLoadingView(this.bGG.VF());
        if (!z || cVar == null || this.bGG == null) {
            showNetRefreshView(this.bGG.VF(), null);
            return;
        }
        this.bGM = cVar;
        if (cVar.Vx() != null && cVar.Vy() != null) {
            this.bGG.a(8, true, 0L, 0);
        } else if (cVar.Vx() != null) {
            this.bGG.a(0, true, cVar.Vx().bHc, cVar.Vx().bHd);
        } else if (cVar.Vy() != null) {
            this.bGG.a(0, false, cVar.Vy().bHc, cVar.Vy().bHd);
        }
        a(cVar.VB());
        this.bGG.c(cVar);
        this.bGG.VH();
    }

    private void a(com.baidu.tbadk.core.data.q qVar) {
        if (qVar != null) {
            if (this.bGO == null) {
                this.bGO = new com.baidu.tieba.hottopic.data.h();
                this.bGO.bHS = qVar.rM();
            }
            this.bGO.bGN = this.bGN;
            this.bGO.aQB = this.aQB;
            this.bGO.bHT = qVar.rO() != 0;
            this.bGO.bHU = 10;
            if (this.bGO.bHT) {
                this.bGO.bHS++;
                this.bGG.Ok();
                return;
            }
            this.bGG.Om();
            this.bGG.Ol();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Vj() {
        if (!com.baidu.adp.lib.util.i.iQ()) {
            this.bGG.VJ();
        } else if (this.bGH != null) {
            this.bGH.aA(this.bGN, this.aQB);
        }
    }

    public void Vk() {
        if (com.baidu.adp.lib.util.i.iQ() && this.bGK != null) {
            com.baidu.tieba.hottopic.data.a Vx = this.bGM.Vx();
            com.baidu.tieba.hottopic.data.a Vy = this.bGM.Vy();
            if (Vx != null) {
                this.bGK.a(Vx.bHg, Long.parseLong(this.bGN), 1, 0, 1, Vx.bHh);
            } else if (Vy != null) {
                this.bGK.a(Vy.bHg, Long.parseLong(this.bGN), 1, 0, 1, Vy.bHh);
            }
        }
    }

    public void Vl() {
        com.baidu.tieba.hottopic.data.e Vw;
        if (com.baidu.adp.lib.util.i.iQ() && this.bGK != null && (Vw = this.bGM.Vw()) != null) {
            this.bGK.a(Vw.bHg, Long.parseLong(this.bGN), Vw.bHd, 0, 0, Vw.bHh);
        }
    }

    private void Vm() {
        this.bGG.a(new g(this));
        this.bGG.f(new h(this));
        registerListener(this.aDW);
        registerListener(this.aDV);
    }

    private void Vn() {
        if (this.bGG != null) {
            this.bGG.VL();
            this.bGG.VM();
            this.bGG.clearAnimation();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onNetRefreshButtonClicked() {
        hideNetRefreshView(this.bGG.VF());
        Vh();
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.f.b<TbImageView> MH() {
        if (this.bGL == null) {
            this.bGL = FrsCommonImageLayout.n(getPageContext().getPageActivity(), 12);
        }
        return this.bGL;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.f.b<TbImageView> vV() {
        if (this.agI == null) {
            this.agI = UserIconBox.g(getPageContext().getPageActivity(), 8);
        }
        return this.agI;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public int vU() {
        return com.baidu.tieba.hottopic.b.a.VE();
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public ListView getListView() {
        if (this.bGG != null) {
            return this.bGG.VI();
        }
        return null;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!com.baidu.adp.lib.util.i.iQ()) {
            this.bGG.Om();
        } else if (this.bGG == null || this.bGM == null || this.bGM.Vz() == null || this.bGO == null) {
            this.bGG.Ol();
        } else {
            this.bGG.Ok();
            if (this.bGO.bHT) {
                this.bGI.b(this.bGO);
            } else {
                this.bGG.Ol();
            }
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (!StringUtils.isNull(this.aQB) || !StringUtils.isNull(this.bGN)) {
            bundle.putString(IntentConfig.TOPIC_ID, this.bGN);
            bundle.putString(IntentConfig.TOPIC_NAME, this.aQB);
        }
    }

    @Override // com.baidu.tieba.hottopic.controller.b.a
    public void a(boolean z, com.baidu.tieba.hottopic.data.b bVar) {
        this.bGG.Om();
        if (!z || bVar == null || this.bGM == null) {
            this.bGG.Ol();
            return;
        }
        this.bGM.a(bVar);
        this.bGG.VH();
        a(bVar.bHj);
    }

    public String Vo() {
        return this.bGN;
    }

    public void Vp() {
        this.bGJ.b(this.bGM);
    }

    public void a(BdBaseViewPager.a aVar) {
        this.bGP = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public RelateForumItemData aL(long j) {
        if (this.bGM != null && this.bGM.Vz() != null && this.bGM.Vz().bIa != null) {
            for (com.baidu.adp.widget.ListView.u uVar : this.bGM.Vz().bIa) {
                if (uVar != null && (uVar instanceof RelateForumItemData) && ((RelateForumItemData) uVar).forumId == j) {
                    return (RelateForumItemData) uVar;
                }
            }
        }
        return null;
    }
}
