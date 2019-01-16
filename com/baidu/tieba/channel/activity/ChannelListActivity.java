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
    private ChannelListModel ddo;
    private j ddp;
    private String mUserId;
    private ChannelListModel.a ddq = new ChannelListModel.a() { // from class: com.baidu.tieba.channel.activity.ChannelListActivity.2
        @Override // com.baidu.tieba.channel.model.ChannelListModel.a
        public void a(int i, String str, boolean z, e eVar) {
            ChannelListActivity.this.closeLoadingDialog();
            ChannelListActivity.this.ddp.arN();
            if (i == 0) {
                ChannelListActivity.this.ddp.a(eVar);
                return;
            }
            ChannelListActivity.this.showToast(str);
            if (z) {
                ChannelListActivity.this.ddp.a(eVar);
            }
        }
    };
    private BdListView.e bWh = new BdListView.e() { // from class: com.baidu.tieba.channel.activity.ChannelListActivity.3
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (ChannelListActivity.this.ddo.isHasMore()) {
                ChannelListActivity.this.ddo.fE(true);
                ChannelListActivity.this.ddo.LoadData();
            }
        }
    };
    private NoNetworkView.a dcP = new NoNetworkView.a() { // from class: com.baidu.tieba.channel.activity.ChannelListActivity.4
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void bG(boolean z) {
            if (z) {
                ChannelListActivity.this.ddo.fE(false);
                ChannelListActivity.this.ddo.LoadData();
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
        this.ddo = new ChannelListModel(getPageContext(), this.mUserId);
        this.ddo.aay();
        this.ddo.a(this.ddq);
        this.ddo.fE(false);
    }

    private void initView() {
        this.ddp = new j(this);
        this.ddp.c(this.dcP);
        this.ddp.a(this.bWh);
        this.ddp.b(new j.b() { // from class: com.baidu.tieba.channel.activity.ChannelListActivity.1
            @Override // com.baidu.tbadk.core.view.j.b
            public void bI(boolean z) {
                if (l.ll()) {
                    ChannelListActivity.this.ddo.fE(false);
                    ChannelListActivity.this.ddo.LoadData();
                    return;
                }
                ChannelListActivity.this.ddp.arN();
            }
        });
        this.ddp.startPullRefresh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.ddp.onDestroy();
        this.ddo.removeListener();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.ddp.onChangeSkinType(i);
    }
}
