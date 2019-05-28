package com.baidu.tieba.channel.activity;

import android.os.Bundle;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.h;
import com.baidu.tieba.channel.data.e;
import com.baidu.tieba.channel.model.ChannelListModel;
import com.baidu.tieba.channel.view.j;
/* loaded from: classes6.dex */
public class ChannelListActivity extends BaseActivity<ChannelListActivity> {
    private ChannelListModel eCK;
    private j eCL;
    private String mUserId;
    private ChannelListModel.a eCM = new ChannelListModel.a() { // from class: com.baidu.tieba.channel.activity.ChannelListActivity.2
        @Override // com.baidu.tieba.channel.model.ChannelListModel.a
        public void a(int i, String str, boolean z, e eVar) {
            ChannelListActivity.this.closeLoadingDialog();
            ChannelListActivity.this.eCL.aYO();
            if (i == 0) {
                ChannelListActivity.this.eCL.a(eVar);
                return;
            }
            ChannelListActivity.this.showToast(str);
            if (z) {
                ChannelListActivity.this.eCL.a(eVar);
            }
        }
    };
    private BdListView.e dvS = new BdListView.e() { // from class: com.baidu.tieba.channel.activity.ChannelListActivity.3
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (ChannelListActivity.this.eCK.isHasMore()) {
                ChannelListActivity.this.eCK.iB(true);
                ChannelListActivity.this.eCK.LoadData();
            }
        }
    };
    private NoNetworkView.a eCl = new NoNetworkView.a() { // from class: com.baidu.tieba.channel.activity.ChannelListActivity.4
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void el(boolean z) {
            if (z) {
                ChannelListActivity.this.eCK.iB(false);
                ChannelListActivity.this.eCK.LoadData();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mUserId = getIntent().getStringExtra("user_id");
        dV();
        initView();
    }

    private void dV() {
        this.eCK = new ChannelListModel(getPageContext(), this.mUserId);
        this.eCK.aHr();
        this.eCK.a(this.eCM);
        this.eCK.iB(false);
    }

    private void initView() {
        this.eCL = new j(this);
        this.eCL.c(this.eCl);
        this.eCL.b(this.dvS);
        this.eCL.a(new h.c() { // from class: com.baidu.tieba.channel.activity.ChannelListActivity.1
            @Override // com.baidu.tbadk.core.view.h.c
            public void en(boolean z) {
                if (l.ki()) {
                    ChannelListActivity.this.eCK.iB(false);
                    ChannelListActivity.this.eCK.LoadData();
                    return;
                }
                ChannelListActivity.this.eCL.aYO();
            }
        });
        this.eCL.startPullRefresh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.eCL.onDestroy();
        this.eCK.removeListener();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.eCL.onChangeSkinType(i);
    }
}
