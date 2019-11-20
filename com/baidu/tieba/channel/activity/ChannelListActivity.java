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
    private ChannelListModel eRk;
    private j eRl;
    private String mUserId;
    private ChannelListModel.a eRm = new ChannelListModel.a() { // from class: com.baidu.tieba.channel.activity.ChannelListActivity.2
        @Override // com.baidu.tieba.channel.model.ChannelListModel.a
        public void a(int i, String str, boolean z, e eVar) {
            ChannelListActivity.this.closeLoadingDialog();
            ChannelListActivity.this.eRl.bbw();
            if (i == 0) {
                ChannelListActivity.this.eRl.a(eVar);
                return;
            }
            ChannelListActivity.this.showToast(str);
            if (z) {
                ChannelListActivity.this.eRl.a(eVar);
            }
        }
    };
    private BdListView.e dIG = new BdListView.e() { // from class: com.baidu.tieba.channel.activity.ChannelListActivity.3
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (ChannelListActivity.this.eRk.isHasMore()) {
                ChannelListActivity.this.eRk.iQ(true);
                ChannelListActivity.this.eRk.LoadData();
            }
        }
    };
    private NoNetworkView.a eQL = new NoNetworkView.a() { // from class: com.baidu.tieba.channel.activity.ChannelListActivity.4
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            if (z) {
                ChannelListActivity.this.eRk.iQ(false);
                ChannelListActivity.this.eRk.LoadData();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mUserId = getIntent().getStringExtra("user_id");
        dv();
        initView();
    }

    private void dv() {
        this.eRk = new ChannelListModel(getPageContext(), this.mUserId);
        this.eRk.aIS();
        this.eRk.a(this.eRm);
        this.eRk.iQ(false);
    }

    private void initView() {
        this.eRl = new j(this);
        this.eRl.c(this.eQL);
        this.eRl.b(this.dIG);
        this.eRl.a(new h.c() { // from class: com.baidu.tieba.channel.activity.ChannelListActivity.1
            @Override // com.baidu.tbadk.core.view.h.c
            public void onListPullRefresh(boolean z) {
                if (l.isNetOk()) {
                    ChannelListActivity.this.eRk.iQ(false);
                    ChannelListActivity.this.eRk.LoadData();
                    return;
                }
                ChannelListActivity.this.eRl.bbw();
            }
        });
        this.eRl.startPullRefresh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.eRl.onDestroy();
        this.eRk.removeListener();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.eRl.onChangeSkinType(i);
    }
}
