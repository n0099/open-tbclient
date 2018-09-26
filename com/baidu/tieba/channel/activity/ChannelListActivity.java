package com.baidu.tieba.channel.activity;

import android.os.Bundle;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.j;
import com.baidu.tieba.channel.data.e;
import com.baidu.tieba.channel.model.ChannelListModel;
import com.baidu.tieba.channel.view.j;
/* loaded from: classes3.dex */
public class ChannelListActivity extends BaseActivity<ChannelListActivity> {
    private ChannelListModel cJD;
    private j cJE;
    private String mUserId;
    private ChannelListModel.a cJF = new ChannelListModel.a() { // from class: com.baidu.tieba.channel.activity.ChannelListActivity.2
        @Override // com.baidu.tieba.channel.model.ChannelListModel.a
        public void a(int i, String str, boolean z, e eVar) {
            ChannelListActivity.this.closeLoadingDialog();
            ChannelListActivity.this.cJE.alJ();
            if (i == 0) {
                ChannelListActivity.this.cJE.a(eVar);
                return;
            }
            ChannelListActivity.this.showToast(str);
            if (z) {
                ChannelListActivity.this.cJE.a(eVar);
            }
        }
    };
    private BdListView.e bIp = new BdListView.e() { // from class: com.baidu.tieba.channel.activity.ChannelListActivity.3
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (ChannelListActivity.this.cJD.isHasMore()) {
                ChannelListActivity.this.cJD.eV(true);
                ChannelListActivity.this.cJD.LoadData();
            }
        }
    };
    private NoNetworkView.a cJe = new NoNetworkView.a() { // from class: com.baidu.tieba.channel.activity.ChannelListActivity.4
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void bd(boolean z) {
            if (z) {
                ChannelListActivity.this.cJD.eV(false);
                ChannelListActivity.this.cJD.LoadData();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mUserId = getIntent().getStringExtra("user_id");
        eL();
        initView();
    }

    private void eL() {
        this.cJD = new ChannelListModel(getPageContext(), this.mUserId);
        this.cJD.Vb();
        this.cJD.a(this.cJF);
        this.cJD.eV(false);
    }

    private void initView() {
        this.cJE = new j(this);
        this.cJE.c(this.cJe);
        this.cJE.a(this.bIp);
        this.cJE.b(new j.b() { // from class: com.baidu.tieba.channel.activity.ChannelListActivity.1
            @Override // com.baidu.tbadk.core.view.j.b
            public void bf(boolean z) {
                if (l.lb()) {
                    ChannelListActivity.this.cJD.eV(false);
                    ChannelListActivity.this.cJD.LoadData();
                    return;
                }
                ChannelListActivity.this.cJE.alJ();
            }
        });
        this.cJE.startPullRefresh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.cJE.onDestroy();
        this.cJD.removeListener();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.cJE.onChangeSkinType(i);
    }
}
