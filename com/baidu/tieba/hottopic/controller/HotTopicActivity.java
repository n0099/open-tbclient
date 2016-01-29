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
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.hottopic.controller.f;
import com.baidu.tieba.hottopic.controller.m;
import com.baidu.tieba.hottopic.data.RelateForumItemData;
import com.baidu.tieba.hottopic.data.ShareFromTopicMsgData;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
/* loaded from: classes.dex */
public class HotTopicActivity extends BaseActivity<HotTopicActivity> implements BdListView.e, UserIconBox.b, f.a, m.a, FrsCommonImageLayout.c {
    private com.baidu.adp.lib.f.b<TbImageView> ahx;
    private o bKi;
    private a bKj;
    private com.baidu.adp.lib.f.b<TbImageView> bKk;
    private BdBaseViewPager.a bKo;
    public com.baidu.tieba.tbadkCore.w bKp;
    private com.baidu.tieba.hottopic.view.c bKf = null;
    private m bKg = null;
    private f bKh = null;
    private com.baidu.tieba.hottopic.data.e bKl = null;
    private String bKm = null;
    private String Wm = null;
    private com.baidu.tieba.hottopic.data.k bKn = null;
    private long bKq = 0;
    private CustomMessageListener aEM = new h(this, CmdConfigCustom.CMD_LIKE_FORUM);
    private CustomMessageListener aEL = new i(this, CmdConfigCustom.CMD_UNLIKE_FORUM);
    private com.baidu.adp.base.g aWL = new j(this);

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        g(bundle);
        this.bKf = new com.baidu.tieba.hottopic.view.c(getPageContext());
        this.bKg = new m(this);
        this.bKg.a(this);
        this.bKp = new com.baidu.tieba.tbadkCore.w(getPageContext());
        this.bKp.setLoadDataCallBack(this.aWL);
        this.bKh = new f(this);
        this.bKh.a(this);
        this.bKi = new o(getPageContext());
        this.bKj = new a(this);
        Xr();
        Xw();
    }

    private void Xw() {
        showLoadingView(this.bKf.Yb(), true);
        if (!com.baidu.adp.lib.util.i.iZ()) {
            hideLoadingView(this.bKf.Yb());
            showNetRefreshView(this.bKf.Yb(), getResources().getString(t.j.neterror), true);
            this.bKf.iA(0);
            return;
        }
        Xy();
    }

    private void g(Bundle bundle) {
        Intent intent = getIntent();
        if (intent != null) {
            this.bKm = intent.getStringExtra(IntentConfig.TOPIC_ID);
            this.Wm = intent.getStringExtra(IntentConfig.TOPIC_NAME);
        } else if (bundle != null) {
            this.bKm = bundle.getString(IntentConfig.TOPIC_ID);
            this.Wm = bundle.getString(IntentConfig.TOPIC_NAME);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        Xu();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onResume() {
        this.bKq = System.currentTimeMillis();
        onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
        if (this.bKo != null) {
            this.bKo.xo();
        }
        super.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onPause() {
        TiebaStatic.log(new au("c10817").aa("obj_duration", String.valueOf(System.currentTimeMillis() - this.bKq)));
        if (this.bKo != null) {
            this.bKo.xp();
        }
        super.onPause();
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 23003:
                    if (intent != null && this.bKl != null) {
                        this.bKi.a(Xx(), intent.getIntExtra("group_id", 0), intent.getStringExtra("group_name"), intent.getLongExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID, 0L), this.bKl);
                        return;
                    }
                    return;
                case 23007:
                    if (intent != null && this.bKl != null) {
                        this.bKi.a(Xx(), intent.getLongExtra("key_user_id", -1L), intent.getStringExtra("key_user_name"), intent.getStringExtra("key_user_portait"), this.bKl);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public ShareFromTopicMsgData Xx() {
        ShareFromTopicMsgData shareFromTopicMsgData = new ShareFromTopicMsgData();
        shareFromTopicMsgData.setContent(this.bKl.XO().bLf);
        shareFromTopicMsgData.setImageUrl(this.bKl.XO().bLg);
        shareFromTopicMsgData.setTitle(this.bKl.XO().Wm);
        shareFromTopicMsgData.setHotTopicID(this.bKl.XO().bKm);
        shareFromTopicMsgData.setHotTopicName(this.bKl.XO().Wm);
        shareFromTopicMsgData.setLinkUrl(String.valueOf("http://tieba.baidu.com/mo/q/hotMessage?topic_id=") + this.bKl.XO().bKm);
        return shareFromTopicMsgData;
    }

    @Override // com.baidu.adp.base.BdBaseActivity, com.baidu.adp.base.k
    public BdUniqueId getUniqueId() {
        return super.getUniqueId();
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.bKf.onChangeSkinType(i);
        changeSkinType(i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public BdListView onGetPreLoadListView() {
        return this.bKf.Yg();
    }

    @Override // com.baidu.tieba.hottopic.controller.m.a
    public void a(boolean z, com.baidu.tieba.hottopic.data.e eVar) {
        this.bKf.Ya();
        hideLoadingView(this.bKf.Yb());
        if (!z || eVar == null || this.bKf == null) {
            showNetRefreshView(this.bKf.Yb(), null, true);
            return;
        }
        this.bKl = eVar;
        if (eVar.XQ() != null && eVar.XR() != null) {
            this.bKf.a(8, true, 0L, 0);
        } else if (eVar.XQ() != null) {
            this.bKf.a(0, true, eVar.XQ().bKC, eVar.XQ().bKD);
        } else if (eVar.XR() != null) {
            this.bKf.a(0, false, eVar.XR().bKC, eVar.XR().bKD);
        }
        a(eVar.XU());
        this.bKf.c(eVar);
        this.bKf.Yc();
    }

    private void a(com.baidu.tbadk.core.data.u uVar) {
        if (uVar != null) {
            if (this.bKn == null) {
                this.bKn = new com.baidu.tieba.hottopic.data.k();
                this.bKn.bLv = uVar.st();
            }
            this.bKn.bKm = this.bKm;
            this.bKn.Wm = this.Wm;
            this.bKn.bLw = uVar.sv() != 0;
            this.bKn.bLx = 10;
            if (this.bKn.bLw) {
                this.bKn.bLv++;
                this.bKf.Qn();
                return;
            }
            this.bKf.Qp();
            this.bKf.Qo();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Xy() {
        if (!com.baidu.adp.lib.util.i.iZ()) {
            this.bKf.Ya();
        } else if (this.bKg != null) {
            this.bKg.aF(this.bKm, this.Wm);
        }
    }

    public void Xz() {
        if (com.baidu.adp.lib.util.i.iZ() && this.bKj != null) {
            com.baidu.tieba.hottopic.data.a XQ = this.bKl.XQ();
            com.baidu.tieba.hottopic.data.a XR = this.bKl.XR();
            if (XQ != null) {
                this.bKj.a(XQ.bKG, Long.parseLong(this.bKm), 1, 0, 1, XQ.bKH);
            } else if (XR != null) {
                this.bKj.a(XR.bKG, Long.parseLong(this.bKm), 1, 0, 1, XR.bKH);
            }
        }
    }

    public void XA() {
        com.baidu.tieba.hottopic.data.h XP;
        if (com.baidu.adp.lib.util.i.iZ() && this.bKj != null && (XP = this.bKl.XP()) != null) {
            this.bKj.a(XP.bKG, Long.parseLong(this.bKm), XP.bKD, 0, 0, XP.bKH);
        }
    }

    private void Xr() {
        this.bKf.a(new k(this));
        this.bKf.f(new l(this));
        registerListener(this.aEM);
        registerListener(this.aEL);
    }

    private void Xu() {
        if (this.bKf != null) {
            this.bKf.Yd();
            this.bKf.Ye();
            this.bKf.clearAnimation();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onNetRefreshButtonClicked() {
        hideNetRefreshView(this.bKf.Yb());
        Xw();
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.f.b<TbImageView> OC() {
        if (this.bKk == null) {
            this.bKk = FrsCommonImageLayout.l(getPageContext().getPageActivity(), 12);
        }
        return this.bKk;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.f.b<TbImageView> xj() {
        if (this.ahx == null) {
            this.ahx = UserIconBox.e(getPageContext().getPageActivity(), 8);
        }
        return this.ahx;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public int xi() {
        return com.baidu.tieba.hottopic.b.c.XY();
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public ListView getListView() {
        if (this.bKf != null) {
            return this.bKf.Yg();
        }
        return null;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void nv() {
        if (!com.baidu.adp.lib.util.i.iZ()) {
            this.bKf.Qp();
        } else if (this.bKf == null || this.bKl == null || this.bKl.XS() == null || this.bKn == null) {
            this.bKf.Qo();
        } else {
            this.bKf.Qn();
            if (this.bKn.bLw) {
                this.bKh.b(this.bKn);
            } else {
                this.bKf.Qo();
            }
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (!StringUtils.isNull(this.Wm) || !StringUtils.isNull(this.bKm)) {
            bundle.putString(IntentConfig.TOPIC_ID, this.bKm);
            bundle.putString(IntentConfig.TOPIC_NAME, this.Wm);
        }
    }

    @Override // com.baidu.tieba.hottopic.controller.f.a
    public void a(boolean z, com.baidu.tieba.hottopic.data.d dVar) {
        this.bKf.Qp();
        if (!z || dVar == null || this.bKl == null) {
            this.bKf.Qo();
            return;
        }
        this.bKl.a(dVar);
        this.bKf.Yc();
        a(dVar.bKQ);
    }

    public String XB() {
        return this.bKm;
    }

    public String getTopicName() {
        return this.Wm;
    }

    public void XC() {
        this.bKi.b(this.bKl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public RelateForumItemData aM(long j) {
        if (this.bKl != null && this.bKl.XS() != null && this.bKl.XS().bLE != null) {
            for (com.baidu.adp.widget.ListView.u uVar : this.bKl.XS().bLE) {
                if (uVar != null && (uVar instanceof RelateForumItemData) && ((RelateForumItemData) uVar).forumId == j) {
                    return (RelateForumItemData) uVar;
                }
            }
        }
        return null;
    }
}
