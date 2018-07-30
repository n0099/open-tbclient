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
    private ChannelListModel cDP;
    private j cDQ;
    private String mUserId;
    private ChannelListModel.a cDR = new ChannelListModel.a() { // from class: com.baidu.tieba.channel.activity.ChannelListActivity.2
        @Override // com.baidu.tieba.channel.model.ChannelListModel.a
        public void a(int i, String str, boolean z, e eVar) {
            ChannelListActivity.this.closeLoadingDialog();
            ChannelListActivity.this.cDQ.ajW();
            if (i == 0) {
                ChannelListActivity.this.cDQ.a(eVar);
                return;
            }
            ChannelListActivity.this.showToast(str);
            if (z) {
                ChannelListActivity.this.cDQ.a(eVar);
            }
        }
    };
    private BdListView.e bCy = new BdListView.e() { // from class: com.baidu.tieba.channel.activity.ChannelListActivity.3
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (ChannelListActivity.this.cDP.isHasMore()) {
                ChannelListActivity.this.cDP.eE(true);
                ChannelListActivity.this.cDP.LoadData();
            }
        }
    };
    private NoNetworkView.a cDq = new NoNetworkView.a() { // from class: com.baidu.tieba.channel.activity.ChannelListActivity.4
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void aQ(boolean z) {
            if (z) {
                ChannelListActivity.this.cDP.eE(false);
                ChannelListActivity.this.cDP.LoadData();
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
        this.cDP = new ChannelListModel(getPageContext(), this.mUserId);
        this.cDP.Tl();
        this.cDP.a(this.cDR);
        this.cDP.eE(false);
    }

    private void initView() {
        this.cDQ = new j(this);
        this.cDQ.c(this.cDq);
        this.cDQ.a(this.bCy);
        this.cDQ.b(new g.b() { // from class: com.baidu.tieba.channel.activity.ChannelListActivity.1
            @Override // com.baidu.tbadk.core.view.g.b
            public void aS(boolean z) {
                if (l.jV()) {
                    ChannelListActivity.this.cDP.eE(false);
                    ChannelListActivity.this.cDP.LoadData();
                    return;
                }
                ChannelListActivity.this.cDQ.ajW();
            }
        });
        this.cDQ.startPullRefresh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.cDQ.onDestroy();
        this.cDP.removeListener();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.cDQ.onChangeSkinType(i);
    }
}
