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
    private com.baidu.adp.lib.e.b<TbImageView> aeN;
    private com.baidu.adp.lib.e.b<TbImageView> bpg;
    private RelateForumViewPager.a bpl;
    public w bpm;
    private com.baidu.tieba.hottopic.view.a bpd = null;
    private h bpe = null;
    private a bpf = null;
    private com.baidu.tieba.hottopic.data.b bph = null;
    private String bpi = null;
    private String bpj = null;
    private com.baidu.tieba.hottopic.data.f bpk = null;
    private CustomMessageListener bpn = new c(this, CmdConfigCustom.CMD_LIKE_FORUM);
    private CustomMessageListener bpo = new d(this, CmdConfigCustom.CMD_UNLIKE_FORUM);
    private com.baidu.adp.base.g aMc = new e(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        i(bundle);
        this.bpd = new com.baidu.tieba.hottopic.view.a(getPageContext());
        this.bpe = new h(this);
        this.bpe.a(this);
        this.bpm = new w(getPageContext());
        this.bpm.setLoadDataCallBack(this.aMc);
        this.bpf = new a(this);
        this.bpf.a(this);
        Rf();
        Rd();
    }

    private void Rd() {
        showLoadingView(this.bpd.Rs(), true);
        if (!com.baidu.adp.lib.util.i.iN()) {
            hideLoadingView(this.bpd.Rs());
            showNetRefreshView(this.bpd.Rs(), null);
            return;
        }
        Re();
    }

    private void i(Bundle bundle) {
        Intent intent = getIntent();
        if (intent != null) {
            this.bpi = intent.getStringExtra(IntentConfig.TOPIC_ID);
            this.bpj = intent.getStringExtra(IntentConfig.TOPIC_NAME);
        } else if (bundle != null) {
            this.bpi = bundle.getString(IntentConfig.TOPIC_ID);
            this.bpj = bundle.getString(IntentConfig.TOPIC_NAME);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        Rg();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        hideNetRefreshView(this.bpd.Rs());
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
        this.bpd.onChangeSkinType(i);
        changeSkinType(i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public BdListView onGetPreLoadListView() {
        return this.bpd.Rv();
    }

    @Override // com.baidu.tieba.hottopic.controller.h.a
    public void a(boolean z, com.baidu.tieba.hottopic.data.b bVar) {
        this.bpd.Rw();
        if (!z || bVar == null || this.bpd == null) {
            hideLoadingView(this.bpd.Rs());
            showNetRefreshView(this.bpd.Rs(), null);
            return;
        }
        this.bph = bVar;
        a(bVar.Rn());
        this.bpd.b(bVar);
        this.bpd.Ru();
    }

    private void a(o oVar) {
        if (oVar != null) {
            if (this.bpk == null) {
                this.bpk = new com.baidu.tieba.hottopic.data.f();
            }
            this.bpk.bpi = this.bpi;
            this.bpk.bpj = this.bpj;
            this.bpk.bpR = oVar.rK() != 0;
            this.bpk.bpS = 10;
            if (this.bpk.bpR) {
                this.bpk.bpQ++;
                this.bpd.Mq();
                return;
            }
            this.bpd.Ms();
            this.bpd.Mr();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Re() {
        if (!com.baidu.adp.lib.util.i.iN()) {
            this.bpd.Rw();
        } else if (this.bpe != null) {
            this.bpe.aB(this.bpi, this.bpj);
        }
    }

    private void Rf() {
        this.bpd.a(new f(this));
        this.bpd.g(new g(this));
        registerListener(this.bpn);
        registerListener(this.bpo);
    }

    private void Rg() {
        if (this.bpd != null) {
            this.bpd.Ry();
            this.bpd.Rz();
        }
        if (this.bpl != null) {
            this.bpl.destory();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onNetRefreshButtonClicked() {
        hideNetRefreshView(this.bpd.Rs());
        Rd();
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.e.b<TbImageView> KP() {
        if (this.bpg == null) {
            this.bpg = FrsCommonImageLayout.n(getPageContext().getPageActivity(), 12);
        }
        return this.bpg;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.e.b<TbImageView> vF() {
        if (this.aeN == null) {
            this.aeN = UserIconBox.g(getPageContext().getPageActivity(), 8);
        }
        return this.aeN;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public int vE() {
        return com.baidu.tieba.hottopic.b.a.Rq();
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public ListView getListView() {
        if (this.bpd != null) {
            return this.bpd.Rv();
        }
        return null;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!com.baidu.adp.lib.util.i.iN()) {
            this.bpd.Ms();
        } else if (this.bpd == null || this.bph == null || this.bph.Rl() == null || this.bpk == null) {
            this.bpd.Mr();
        } else {
            this.bpd.Mq();
            if (this.bpk.bpR) {
                this.bpf.b(this.bpk);
            } else {
                this.bpd.Mr();
            }
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (!StringUtils.isNull(this.bpj) || !StringUtils.isNull(this.bpi)) {
            bundle.putString(IntentConfig.TOPIC_ID, this.bpi);
            bundle.putString(IntentConfig.TOPIC_NAME, this.bpj);
        }
    }

    @Override // com.baidu.tieba.hottopic.controller.a.InterfaceC0056a
    public void a(boolean z, com.baidu.tieba.hottopic.data.a aVar) {
        this.bpd.Ms();
        if (!z || aVar == null || this.bph == null) {
            this.bpd.Mr();
            return;
        }
        this.bph.a(aVar);
        this.bpd.Ru();
        a(aVar.bpv);
    }

    public String Rh() {
        return this.bpi;
    }

    public void a(RelateForumViewPager.a aVar) {
        this.bpl = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public RelateForumItemData aw(long j) {
        if (this.bph != null && this.bph.Rl() != null && this.bph.Rl().bpU != null) {
            for (RelateForumItemData relateForumItemData : this.bph.Rl().bpU) {
                if (relateForumItemData != null && relateForumItemData.forumId == j) {
                    return relateForumItemData;
                }
            }
        }
        return null;
    }
}
