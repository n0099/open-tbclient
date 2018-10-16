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
    private ChannelListModel cRW;
    private j cRX;
    private String mUserId;
    private ChannelListModel.a cRY = new ChannelListModel.a() { // from class: com.baidu.tieba.channel.activity.ChannelListActivity.2
        @Override // com.baidu.tieba.channel.model.ChannelListModel.a
        public void a(int i, String str, boolean z, e eVar) {
            ChannelListActivity.this.closeLoadingDialog();
            ChannelListActivity.this.cRX.apm();
            if (i == 0) {
                ChannelListActivity.this.cRX.a(eVar);
                return;
            }
            ChannelListActivity.this.showToast(str);
            if (z) {
                ChannelListActivity.this.cRX.a(eVar);
            }
        }
    };
    private BdListView.e bQS = new BdListView.e() { // from class: com.baidu.tieba.channel.activity.ChannelListActivity.3
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (ChannelListActivity.this.cRW.isHasMore()) {
                ChannelListActivity.this.cRW.fn(true);
                ChannelListActivity.this.cRW.LoadData();
            }
        }
    };
    private NoNetworkView.a cRx = new NoNetworkView.a() { // from class: com.baidu.tieba.channel.activity.ChannelListActivity.4
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void bn(boolean z) {
            if (z) {
                ChannelListActivity.this.cRW.fn(false);
                ChannelListActivity.this.cRW.LoadData();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mUserId = getIntent().getStringExtra("user_id");
        fd();
        initView();
    }

    private void fd() {
        this.cRW = new ChannelListModel(getPageContext(), this.mUserId);
        this.cRW.YI();
        this.cRW.a(this.cRY);
        this.cRW.fn(false);
    }

    private void initView() {
        this.cRX = new j(this);
        this.cRX.c(this.cRx);
        this.cRX.a(this.bQS);
        this.cRX.b(new j.b() { // from class: com.baidu.tieba.channel.activity.ChannelListActivity.1
            @Override // com.baidu.tbadk.core.view.j.b
            public void bp(boolean z) {
                if (l.lo()) {
                    ChannelListActivity.this.cRW.fn(false);
                    ChannelListActivity.this.cRW.LoadData();
                    return;
                }
                ChannelListActivity.this.cRX.apm();
            }
        });
        this.cRX.startPullRefresh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.cRX.onDestroy();
        this.cRW.removeListener();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.cRX.onChangeSkinType(i);
    }
}
