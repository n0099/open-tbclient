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
import com.baidu.tbadk.core.data.n;
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
    private com.baidu.adp.lib.e.b<TbImageView> aeH;
    private com.baidu.adp.lib.e.b<TbImageView> bor;
    private RelateForumViewPager.a bow;
    public w box;
    private com.baidu.tieba.hottopic.view.a boo = null;
    private h bop = null;
    private a boq = null;
    private com.baidu.tieba.hottopic.data.b bos = null;
    private String bot = null;
    private String bou = null;
    private com.baidu.tieba.hottopic.data.f bov = null;
    private CustomMessageListener boy = new c(this, CmdConfigCustom.CMD_LIKE_FORUM);
    private CustomMessageListener boz = new d(this, CmdConfigCustom.CMD_UNLIKE_FORUM);
    private com.baidu.adp.base.g aLJ = new e(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        i(bundle);
        this.boo = new com.baidu.tieba.hottopic.view.a(getPageContext());
        this.bop = new h(this);
        this.bop.a(this);
        this.box = new w(getPageContext());
        this.box.setLoadDataCallBack(this.aLJ);
        this.boq = new a(this);
        this.boq.a(this);
        QN();
        QL();
    }

    private void QL() {
        showLoadingView(this.boo.Ra(), true);
        if (!com.baidu.adp.lib.util.i.iM()) {
            hideLoadingView(this.boo.Ra());
            showNetRefreshView(this.boo.Ra(), null);
            return;
        }
        QM();
    }

    private void i(Bundle bundle) {
        Intent intent = getIntent();
        if (intent != null) {
            this.bot = intent.getStringExtra(IntentConfig.TOPIC_ID);
            this.bou = intent.getStringExtra(IntentConfig.TOPIC_NAME);
        } else if (bundle != null) {
            this.bot = bundle.getString(IntentConfig.TOPIC_ID);
            this.bou = bundle.getString(IntentConfig.TOPIC_NAME);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        QO();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        hideNetRefreshView(this.boo.Ra());
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
        this.boo.onChangeSkinType(i);
        changeSkinType(i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public BdListView onGetPreLoadListView() {
        return this.boo.Rd();
    }

    @Override // com.baidu.tieba.hottopic.controller.h.a
    public void a(boolean z, com.baidu.tieba.hottopic.data.b bVar) {
        this.boo.Re();
        if (!z || bVar == null || this.boo == null) {
            hideLoadingView(this.boo.Ra());
            showNetRefreshView(this.boo.Ra(), null);
            return;
        }
        this.bos = bVar;
        a(bVar.QV());
        this.boo.b(bVar);
        this.boo.Rc();
    }

    private void a(n nVar) {
        if (nVar != null) {
            if (this.bov == null) {
                this.bov = new com.baidu.tieba.hottopic.data.f();
            }
            this.bov.bot = this.bot;
            this.bov.bou = this.bou;
            this.bov.bpc = nVar.rL() != 0;
            this.bov.bpd = 10;
            if (this.bov.bpc) {
                this.bov.bpb++;
                this.boo.Me();
                return;
            }
            this.boo.Mg();
            this.boo.Mf();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void QM() {
        if (!com.baidu.adp.lib.util.i.iM()) {
            this.boo.Re();
        } else if (this.bop != null) {
            this.bop.aC(this.bot, this.bou);
        }
    }

    private void QN() {
        this.boo.a(new f(this));
        this.boo.g(new g(this));
        registerListener(this.boy);
        registerListener(this.boz);
    }

    private void QO() {
        if (this.boo != null) {
            this.boo.Rg();
            this.boo.Rh();
        }
        if (this.bow != null) {
            this.bow.destory();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onNetRefreshButtonClicked() {
        hideNetRefreshView(this.boo.Ra());
        QL();
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.e.b<TbImageView> KD() {
        if (this.bor == null) {
            this.bor = FrsCommonImageLayout.n(getPageContext().getPageActivity(), 12);
        }
        return this.bor;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.e.b<TbImageView> vE() {
        if (this.aeH == null) {
            this.aeH = UserIconBox.g(getPageContext().getPageActivity(), 8);
        }
        return this.aeH;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public int vD() {
        return com.baidu.tieba.hottopic.b.a.QY();
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public ListView getListView() {
        if (this.boo != null) {
            return this.boo.Rd();
        }
        return null;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!com.baidu.adp.lib.util.i.iM()) {
            this.boo.Mg();
        } else if (this.boo == null || this.bos == null || this.bos.QT() == null || this.bov == null) {
            this.boo.Mf();
        } else {
            this.boo.Me();
            if (this.bov.bpc) {
                this.boq.b(this.bov);
            } else {
                this.boo.Mf();
            }
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (!StringUtils.isNull(this.bou) || !StringUtils.isNull(this.bot)) {
            bundle.putString(IntentConfig.TOPIC_ID, this.bot);
            bundle.putString(IntentConfig.TOPIC_NAME, this.bou);
        }
    }

    @Override // com.baidu.tieba.hottopic.controller.a.InterfaceC0056a
    public void a(boolean z, com.baidu.tieba.hottopic.data.a aVar) {
        this.boo.Mg();
        if (!z || aVar == null || this.bos == null) {
            this.boo.Mf();
            return;
        }
        this.bos.a(aVar);
        this.boo.Rc();
        a(aVar.boG);
    }

    public String QP() {
        return this.bot;
    }

    public void a(RelateForumViewPager.a aVar) {
        this.bow = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public RelateForumItemData ao(long j) {
        if (this.bos != null && this.bos.QT() != null && this.bos.QT().bpf != null) {
            for (RelateForumItemData relateForumItemData : this.bos.QT().bpf) {
                if (relateForumItemData != null && relateForumItemData.forumId == j) {
                    return relateForumItemData;
                }
            }
        }
        return null;
    }
}
