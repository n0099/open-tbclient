package com.baidu.tieba.channel.activity;

import android.os.Bundle;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.g;
import com.baidu.tieba.channel.data.e;
import com.baidu.tieba.channel.model.ChannelListModel;
import com.baidu.tieba.channel.view.j;
/* loaded from: classes3.dex */
public class ChannelListActivity extends BaseActivity<ChannelListActivity> {
    private ChannelListModel cDM;
    private j cDN;
    private String mUserId;
    private ChannelListModel.a cDO = new ChannelListModel.a() { // from class: com.baidu.tieba.channel.activity.ChannelListActivity.2
        @Override // com.baidu.tieba.channel.model.ChannelListModel.a
        public void a(int i, String str, boolean z, e eVar) {
            ChannelListActivity.this.closeLoadingDialog();
            ChannelListActivity.this.cDN.ajY();
            if (i == 0) {
                ChannelListActivity.this.cDN.a(eVar);
                return;
            }
            ChannelListActivity.this.showToast(str);
            if (z) {
                ChannelListActivity.this.cDN.a(eVar);
            }
        }
    };
    private BdListView.e bCA = new BdListView.e() { // from class: com.baidu.tieba.channel.activity.ChannelListActivity.3
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (ChannelListActivity.this.cDM.isHasMore()) {
                ChannelListActivity.this.cDM.eE(true);
                ChannelListActivity.this.cDM.LoadData();
            }
        }
    };
    private NoNetworkView.a cDn = new NoNetworkView.a() { // from class: com.baidu.tieba.channel.activity.ChannelListActivity.4
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void aR(boolean z) {
            if (z) {
                ChannelListActivity.this.cDM.eE(false);
                ChannelListActivity.this.cDM.LoadData();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mUserId = getIntent().getStringExtra("user_id");
        dE();
        initView();
    }

    private void dE() {
        this.cDM = new ChannelListModel(getPageContext(), this.mUserId);
        this.cDM.To();
        this.cDM.a(this.cDO);
        this.cDM.eE(false);
    }

    private void initView() {
        this.cDN = new j(this);
        this.cDN.c(this.cDn);
        this.cDN.a(this.bCA);
        this.cDN.b(new g.b() { // from class: com.baidu.tieba.channel.activity.ChannelListActivity.1
            @Override // com.baidu.tbadk.core.view.g.b
            public void aT(boolean z) {
                if (l.jV()) {
                    ChannelListActivity.this.cDM.eE(false);
                    ChannelListActivity.this.cDM.LoadData();
                    return;
                }
                ChannelListActivity.this.cDN.ajY();
            }
        });
        this.cDN.startPullRefresh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.cDN.onDestroy();
        this.cDM.removeListener();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.cDN.onChangeSkinType(i);
    }
}
