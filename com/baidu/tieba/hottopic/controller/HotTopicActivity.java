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
    private com.baidu.adp.lib.f.b<TbImageView> afK;
    private k bDf;
    private a bDg;
    private com.baidu.adp.lib.f.b<TbImageView> bDh;
    private BdBaseViewPager.a bDl;
    public x bDm;
    private com.baidu.tieba.hottopic.view.a bDc = null;
    private i bDd = null;
    private b bDe = null;
    private com.baidu.tieba.hottopic.data.c bDi = null;
    private String bDj = null;
    private String bBb = null;
    private com.baidu.tieba.hottopic.data.h bDk = null;
    private CustomMessageListener aCo = new d(this, CmdConfigCustom.CMD_LIKE_FORUM);
    private CustomMessageListener aCn = new e(this, CmdConfigCustom.CMD_UNLIKE_FORUM);
    private com.baidu.adp.base.g aQL = new f(this);

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        i(bundle);
        this.bDc = new com.baidu.tieba.hottopic.view.a(getPageContext());
        this.bDd = new i(this);
        this.bDd.a(this);
        this.bDm = new x(getPageContext());
        this.bDm.setLoadDataCallBack(this.aQL);
        this.bDe = new b(this);
        this.bDe.a(this);
        this.bDf = new k(getPageContext());
        this.bDg = new a(this);
        TJ();
        Uf();
    }

    private void Uf() {
        showLoadingView(this.bDc.UC(), true);
        if (!com.baidu.adp.lib.util.i.iP()) {
            hideLoadingView(this.bDc.UC());
            showNetRefreshView(this.bDc.UC(), getResources().getString(n.i.neterror), true);
            this.bDc.hD(0);
            return;
        }
        Uh();
    }

    private void i(Bundle bundle) {
        Intent intent = getIntent();
        if (intent != null) {
            this.bDj = intent.getStringExtra(IntentConfig.TOPIC_ID);
            this.bBb = intent.getStringExtra(IntentConfig.TOPIC_NAME);
        } else if (bundle != null) {
            this.bDj = bundle.getString(IntentConfig.TOPIC_ID);
            this.bBb = bundle.getString(IntentConfig.TOPIC_NAME);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        Uk();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onResume() {
        onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
        if (this.bDl != null) {
            this.bDl.wp();
        }
        super.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onPause() {
        if (this.bDl != null) {
            this.bDl.wq();
        }
        super.onPause();
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 23003:
                    if (intent != null && this.bDi != null) {
                        this.bDf.a(Ug(), intent.getIntExtra("group_id", 0), intent.getStringExtra("group_name"), intent.getLongExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID, 0L), this.bDi);
                        return;
                    }
                    return;
                case 23007:
                    if (intent != null && this.bDi != null) {
                        this.bDf.a(Ug(), intent.getLongExtra("key_user_id", -1L), intent.getStringExtra("key_user_name"), intent.getStringExtra("key_user_portait"), this.bDi);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public ShareFromTopicMsgData Ug() {
        ShareFromTopicMsgData shareFromTopicMsgData = new ShareFromTopicMsgData();
        shareFromTopicMsgData.setContent(this.bDi.Us().bDQ);
        shareFromTopicMsgData.setImageUrl(this.bDi.Us().bDR);
        shareFromTopicMsgData.setTitle(this.bDi.Us().bBb);
        shareFromTopicMsgData.setHotTopicID(this.bDi.Us().bDj);
        shareFromTopicMsgData.setHotTopicName(this.bDi.Us().bBb);
        shareFromTopicMsgData.setLinkUrl(String.valueOf("http://tieba.baidu.com/mo/q/hotMessage?topic_id=") + this.bDi.Us().bDj);
        return shareFromTopicMsgData;
    }

    @Override // com.baidu.adp.base.BdBaseActivity, com.baidu.adp.base.k
    public BdUniqueId getUniqueId() {
        return super.getUniqueId();
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.bDc.onChangeSkinType(i);
        changeSkinType(i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public BdListView onGetPreLoadListView() {
        return this.bDc.UE();
    }

    @Override // com.baidu.tieba.hottopic.controller.i.a
    public void a(boolean z, com.baidu.tieba.hottopic.data.c cVar) {
        this.bDc.TT();
        hideLoadingView(this.bDc.UC());
        if (!z || cVar == null || this.bDc == null) {
            showNetRefreshView(this.bDc.UC(), null);
            return;
        }
        this.bDi = cVar;
        if (cVar.Uu() != null && cVar.Uv() != null) {
            this.bDc.a(8, true, 0L, 0);
        } else if (cVar.Uu() != null) {
            this.bDc.a(0, true, cVar.Uu().bDy, cVar.Uu().bDz);
        } else if (cVar.Uv() != null) {
            this.bDc.a(0, false, cVar.Uv().bDy, cVar.Uv().bDz);
        }
        a(cVar.Uy());
        this.bDc.c(cVar);
        this.bDc.UD();
    }

    private void a(com.baidu.tbadk.core.data.q qVar) {
        if (qVar != null) {
            if (this.bDk == null) {
                this.bDk = new com.baidu.tieba.hottopic.data.h();
                this.bDk.bEp = qVar.sd();
            }
            this.bDk.bDj = this.bDj;
            this.bDk.bBb = this.bBb;
            this.bDk.bEq = qVar.sf() != 0;
            this.bDk.bEr = 10;
            if (this.bDk.bEq) {
                this.bDk.bEp++;
                this.bDc.NR();
                return;
            }
            this.bDc.NT();
            this.bDc.NS();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Uh() {
        if (!com.baidu.adp.lib.util.i.iP()) {
            this.bDc.TT();
        } else if (this.bDd != null) {
            this.bDd.aG(this.bDj, this.bBb);
        }
    }

    public void Ui() {
        if (com.baidu.adp.lib.util.i.iP() && this.bDg != null) {
            com.baidu.tieba.hottopic.data.a Uu = this.bDi.Uu();
            com.baidu.tieba.hottopic.data.a Uv = this.bDi.Uv();
            if (Uu != null) {
                this.bDg.a(Uu.bDC, Long.parseLong(this.bDj), 1, 0, 1, Uu.bDD);
            } else if (Uv != null) {
                this.bDg.a(Uv.bDC, Long.parseLong(this.bDj), 1, 0, 1, Uv.bDD);
            }
        }
    }

    public void Uj() {
        com.baidu.tieba.hottopic.data.e Ut;
        if (com.baidu.adp.lib.util.i.iP() && this.bDg != null && (Ut = this.bDi.Ut()) != null) {
            this.bDg.a(Ut.bDC, Long.parseLong(this.bDj), Ut.bDz, 0, 0, Ut.bDD);
        }
    }

    private void TJ() {
        this.bDc.a(new g(this));
        this.bDc.f(new h(this));
        registerListener(this.aCo);
        registerListener(this.aCn);
    }

    private void Uk() {
        if (this.bDc != null) {
            this.bDc.UF();
            this.bDc.UG();
            this.bDc.clearAnimation();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onNetRefreshButtonClicked() {
        hideNetRefreshView(this.bDc.UC());
        Uf();
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.f.b<TbImageView> Mo() {
        if (this.bDh == null) {
            this.bDh = FrsCommonImageLayout.n(getPageContext().getPageActivity(), 12);
        }
        return this.bDh;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.f.b<TbImageView> wl() {
        if (this.afK == null) {
            this.afK = UserIconBox.g(getPageContext().getPageActivity(), 8);
        }
        return this.afK;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public int wk() {
        return com.baidu.tieba.hottopic.b.a.UB();
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public ListView getListView() {
        if (this.bDc != null) {
            return this.bDc.UE();
        }
        return null;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!com.baidu.adp.lib.util.i.iP()) {
            this.bDc.NT();
        } else if (this.bDc == null || this.bDi == null || this.bDi.Uw() == null || this.bDk == null) {
            this.bDc.NS();
        } else {
            this.bDc.NR();
            if (this.bDk.bEq) {
                this.bDe.b(this.bDk);
            } else {
                this.bDc.NS();
            }
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (!StringUtils.isNull(this.bBb) || !StringUtils.isNull(this.bDj)) {
            bundle.putString(IntentConfig.TOPIC_ID, this.bDj);
            bundle.putString(IntentConfig.TOPIC_NAME, this.bBb);
        }
    }

    @Override // com.baidu.tieba.hottopic.controller.b.a
    public void a(boolean z, com.baidu.tieba.hottopic.data.b bVar) {
        this.bDc.NT();
        if (!z || bVar == null || this.bDi == null) {
            this.bDc.NS();
            return;
        }
        this.bDi.a(bVar);
        this.bDc.UD();
        a(bVar.bDF);
    }

    public String Ul() {
        return this.bDj;
    }

    public void Um() {
        this.bDf.b(this.bDi);
    }

    public void a(BdBaseViewPager.a aVar) {
        this.bDl = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public RelateForumItemData aK(long j) {
        if (this.bDi != null && this.bDi.Uw() != null && this.bDi.Uw().bEw != null) {
            for (com.baidu.adp.widget.ListView.u uVar : this.bDi.Uw().bEw) {
                if (uVar != null && (uVar instanceof RelateForumItemData) && ((RelateForumItemData) uVar).forumId == j) {
                    return (RelateForumItemData) uVar;
                }
            }
        }
        return null;
    }
}
