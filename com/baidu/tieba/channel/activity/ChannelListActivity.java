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
    private ChannelListModel eSb;
    private j eSc;
    private String mUserId;
    private ChannelListModel.a eSd = new ChannelListModel.a() { // from class: com.baidu.tieba.channel.activity.ChannelListActivity.2
        @Override // com.baidu.tieba.channel.model.ChannelListModel.a
        public void a(int i, String str, boolean z, e eVar) {
            ChannelListActivity.this.closeLoadingDialog();
            ChannelListActivity.this.eSc.bby();
            if (i == 0) {
                ChannelListActivity.this.eSc.a(eVar);
                return;
            }
            ChannelListActivity.this.showToast(str);
            if (z) {
                ChannelListActivity.this.eSc.a(eVar);
            }
        }
    };
    private BdListView.e dJx = new BdListView.e() { // from class: com.baidu.tieba.channel.activity.ChannelListActivity.3
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (ChannelListActivity.this.eSb.isHasMore()) {
                ChannelListActivity.this.eSb.iQ(true);
                ChannelListActivity.this.eSb.LoadData();
            }
        }
    };
    private NoNetworkView.a eRC = new NoNetworkView.a() { // from class: com.baidu.tieba.channel.activity.ChannelListActivity.4
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            if (z) {
                ChannelListActivity.this.eSb.iQ(false);
                ChannelListActivity.this.eSb.LoadData();
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
        this.eSb = new ChannelListModel(getPageContext(), this.mUserId);
        this.eSb.aIU();
        this.eSb.a(this.eSd);
        this.eSb.iQ(false);
    }

    private void initView() {
        this.eSc = new j(this);
        this.eSc.c(this.eRC);
        this.eSc.b(this.dJx);
        this.eSc.a(new h.c() { // from class: com.baidu.tieba.channel.activity.ChannelListActivity.1
            @Override // com.baidu.tbadk.core.view.h.c
            public void onListPullRefresh(boolean z) {
                if (l.isNetOk()) {
                    ChannelListActivity.this.eSb.iQ(false);
                    ChannelListActivity.this.eSb.LoadData();
                    return;
                }
                ChannelListActivity.this.eSc.bby();
            }
        });
        this.eSc.startPullRefresh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.eSc.onDestroy();
        this.eSb.removeListener();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.eSc.onChangeSkinType(i);
    }
}
