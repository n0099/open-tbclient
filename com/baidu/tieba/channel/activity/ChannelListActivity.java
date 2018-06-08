package com.baidu.tieba.channel.activity;

import android.os.Bundle;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.f;
import com.baidu.tieba.channel.data.e;
import com.baidu.tieba.channel.model.ChannelListModel;
import com.baidu.tieba.channel.view.j;
/* loaded from: classes3.dex */
public class ChannelListActivity extends BaseActivity<ChannelListActivity> {
    private ChannelListModel cDq;
    private j cDr;
    private String mUserId;
    private ChannelListModel.a cDs = new ChannelListModel.a() { // from class: com.baidu.tieba.channel.activity.ChannelListActivity.2
        @Override // com.baidu.tieba.channel.model.ChannelListModel.a
        public void a(int i, String str, boolean z, e eVar) {
            ChannelListActivity.this.closeLoadingDialog();
            ChannelListActivity.this.cDr.ake();
            if (i == 0) {
                ChannelListActivity.this.cDr.a(eVar);
                return;
            }
            ChannelListActivity.this.showToast(str);
            if (z) {
                ChannelListActivity.this.cDr.a(eVar);
            }
        }
    };
    private BdListView.e bzR = new BdListView.e() { // from class: com.baidu.tieba.channel.activity.ChannelListActivity.3
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (ChannelListActivity.this.cDq.isHasMore()) {
                ChannelListActivity.this.cDq.eD(true);
                ChannelListActivity.this.cDq.LoadData();
            }
        }
    };
    private NoNetworkView.a cCR = new NoNetworkView.a() { // from class: com.baidu.tieba.channel.activity.ChannelListActivity.4
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void aQ(boolean z) {
            if (z) {
                ChannelListActivity.this.cDq.eD(false);
                ChannelListActivity.this.cDq.LoadData();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mUserId = getIntent().getStringExtra("user_id");
        dG();
        initView();
    }

    private void dG() {
        this.cDq = new ChannelListModel(getPageContext(), this.mUserId);
        this.cDq.SH();
        this.cDq.a(this.cDs);
        this.cDq.eD(false);
    }

    private void initView() {
        this.cDr = new j(this);
        this.cDr.c(this.cCR);
        this.cDr.a(this.bzR);
        this.cDr.b(new f.b() { // from class: com.baidu.tieba.channel.activity.ChannelListActivity.1
            @Override // com.baidu.tbadk.core.view.f.b
            public void aS(boolean z) {
                if (l.jU()) {
                    ChannelListActivity.this.cDq.eD(false);
                    ChannelListActivity.this.cDq.LoadData();
                    return;
                }
                ChannelListActivity.this.cDr.ake();
            }
        });
        this.cDr.startPullRefresh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.cDr.onDestroy();
        this.cDq.removeListener();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.cDr.onChangeSkinType(i);
    }
}
