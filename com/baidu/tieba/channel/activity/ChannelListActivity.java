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
    private ChannelListModel eJw;
    private j eJx;
    private String mUserId;
    private ChannelListModel.a eJy = new ChannelListModel.a() { // from class: com.baidu.tieba.channel.activity.ChannelListActivity.2
        @Override // com.baidu.tieba.channel.model.ChannelListModel.a
        public void a(int i, String str, boolean z, e eVar) {
            ChannelListActivity.this.closeLoadingDialog();
            ChannelListActivity.this.eJx.bbt();
            if (i == 0) {
                ChannelListActivity.this.eJx.a(eVar);
                return;
            }
            ChannelListActivity.this.showToast(str);
            if (z) {
                ChannelListActivity.this.eJx.a(eVar);
            }
        }
    };
    private BdListView.e dAJ = new BdListView.e() { // from class: com.baidu.tieba.channel.activity.ChannelListActivity.3
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (ChannelListActivity.this.eJw.isHasMore()) {
                ChannelListActivity.this.eJw.iN(true);
                ChannelListActivity.this.eJw.LoadData();
            }
        }
    };
    private NoNetworkView.a eIX = new NoNetworkView.a() { // from class: com.baidu.tieba.channel.activity.ChannelListActivity.4
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void es(boolean z) {
            if (z) {
                ChannelListActivity.this.eJw.iN(false);
                ChannelListActivity.this.eJw.LoadData();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mUserId = getIntent().getStringExtra("user_id");
        ec();
        initView();
    }

    private void ec() {
        this.eJw = new ChannelListModel(getPageContext(), this.mUserId);
        this.eJw.aJu();
        this.eJw.a(this.eJy);
        this.eJw.iN(false);
    }

    private void initView() {
        this.eJx = new j(this);
        this.eJx.c(this.eIX);
        this.eJx.b(this.dAJ);
        this.eJx.a(new h.c() { // from class: com.baidu.tieba.channel.activity.ChannelListActivity.1
            @Override // com.baidu.tbadk.core.view.h.c
            public void eu(boolean z) {
                if (l.kt()) {
                    ChannelListActivity.this.eJw.iN(false);
                    ChannelListActivity.this.eJw.LoadData();
                    return;
                }
                ChannelListActivity.this.eJx.bbt();
            }
        });
        this.eJx.startPullRefresh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.eJx.onDestroy();
        this.eJw.removeListener();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.eJx.onChangeSkinType(i);
    }
}
