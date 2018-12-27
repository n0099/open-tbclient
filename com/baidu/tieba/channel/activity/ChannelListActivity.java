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
    private ChannelListModel dcC;
    private j dcD;
    private String mUserId;
    private ChannelListModel.a dcE = new ChannelListModel.a() { // from class: com.baidu.tieba.channel.activity.ChannelListActivity.2
        @Override // com.baidu.tieba.channel.model.ChannelListModel.a
        public void a(int i, String str, boolean z, e eVar) {
            ChannelListActivity.this.closeLoadingDialog();
            ChannelListActivity.this.dcD.arp();
            if (i == 0) {
                ChannelListActivity.this.dcD.a(eVar);
                return;
            }
            ChannelListActivity.this.showToast(str);
            if (z) {
                ChannelListActivity.this.dcD.a(eVar);
            }
        }
    };
    private BdListView.e bVw = new BdListView.e() { // from class: com.baidu.tieba.channel.activity.ChannelListActivity.3
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (ChannelListActivity.this.dcC.isHasMore()) {
                ChannelListActivity.this.dcC.fB(true);
                ChannelListActivity.this.dcC.LoadData();
            }
        }
    };
    private NoNetworkView.a dcc = new NoNetworkView.a() { // from class: com.baidu.tieba.channel.activity.ChannelListActivity.4
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void bF(boolean z) {
            if (z) {
                ChannelListActivity.this.dcC.fB(false);
                ChannelListActivity.this.dcC.LoadData();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mUserId = getIntent().getStringExtra("user_id");
        fc();
        initView();
    }

    private void fc() {
        this.dcC = new ChannelListModel(getPageContext(), this.mUserId);
        this.dcC.aab();
        this.dcC.a(this.dcE);
        this.dcC.fB(false);
    }

    private void initView() {
        this.dcD = new j(this);
        this.dcD.c(this.dcc);
        this.dcD.a(this.bVw);
        this.dcD.b(new j.b() { // from class: com.baidu.tieba.channel.activity.ChannelListActivity.1
            @Override // com.baidu.tbadk.core.view.j.b
            public void bH(boolean z) {
                if (l.ll()) {
                    ChannelListActivity.this.dcC.fB(false);
                    ChannelListActivity.this.dcC.LoadData();
                    return;
                }
                ChannelListActivity.this.dcD.arp();
            }
        });
        this.dcD.startPullRefresh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.dcD.onDestroy();
        this.dcC.removeListener();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.dcD.onChangeSkinType(i);
    }
}
