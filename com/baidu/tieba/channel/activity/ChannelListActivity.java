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
    private ChannelListModel ddp;
    private j ddq;
    private String mUserId;
    private ChannelListModel.a ddr = new ChannelListModel.a() { // from class: com.baidu.tieba.channel.activity.ChannelListActivity.2
        @Override // com.baidu.tieba.channel.model.ChannelListModel.a
        public void a(int i, String str, boolean z, e eVar) {
            ChannelListActivity.this.closeLoadingDialog();
            ChannelListActivity.this.ddq.arN();
            if (i == 0) {
                ChannelListActivity.this.ddq.a(eVar);
                return;
            }
            ChannelListActivity.this.showToast(str);
            if (z) {
                ChannelListActivity.this.ddq.a(eVar);
            }
        }
    };
    private BdListView.e bWi = new BdListView.e() { // from class: com.baidu.tieba.channel.activity.ChannelListActivity.3
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (ChannelListActivity.this.ddp.isHasMore()) {
                ChannelListActivity.this.ddp.fE(true);
                ChannelListActivity.this.ddp.LoadData();
            }
        }
    };
    private NoNetworkView.a dcQ = new NoNetworkView.a() { // from class: com.baidu.tieba.channel.activity.ChannelListActivity.4
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void bG(boolean z) {
            if (z) {
                ChannelListActivity.this.ddp.fE(false);
                ChannelListActivity.this.ddp.LoadData();
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
        this.ddp = new ChannelListModel(getPageContext(), this.mUserId);
        this.ddp.aay();
        this.ddp.a(this.ddr);
        this.ddp.fE(false);
    }

    private void initView() {
        this.ddq = new j(this);
        this.ddq.c(this.dcQ);
        this.ddq.a(this.bWi);
        this.ddq.b(new j.b() { // from class: com.baidu.tieba.channel.activity.ChannelListActivity.1
            @Override // com.baidu.tbadk.core.view.j.b
            public void bI(boolean z) {
                if (l.ll()) {
                    ChannelListActivity.this.ddp.fE(false);
                    ChannelListActivity.this.ddp.LoadData();
                    return;
                }
                ChannelListActivity.this.ddq.arN();
            }
        });
        this.ddq.startPullRefresh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.ddq.onDestroy();
        this.ddp.removeListener();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.ddq.onChangeSkinType(i);
    }
}
