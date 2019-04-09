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
    private ChannelListModel emY;
    private j emZ;
    private String mUserId;
    private ChannelListModel.a ena = new ChannelListModel.a() { // from class: com.baidu.tieba.channel.activity.ChannelListActivity.2
        @Override // com.baidu.tieba.channel.model.ChannelListModel.a
        public void a(int i, String str, boolean z, e eVar) {
            ChannelListActivity.this.closeLoadingDialog();
            ChannelListActivity.this.emZ.aRC();
            if (i == 0) {
                ChannelListActivity.this.emZ.a(eVar);
                return;
            }
            ChannelListActivity.this.showToast(str);
            if (z) {
                ChannelListActivity.this.emZ.a(eVar);
            }
        }
    };
    private BdListView.e dlk = new BdListView.e() { // from class: com.baidu.tieba.channel.activity.ChannelListActivity.3
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (ChannelListActivity.this.emY.isHasMore()) {
                ChannelListActivity.this.emY.hW(true);
                ChannelListActivity.this.emY.LoadData();
            }
        }
    };
    private NoNetworkView.a emz = new NoNetworkView.a() { // from class: com.baidu.tieba.channel.activity.ChannelListActivity.4
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void dP(boolean z) {
            if (z) {
                ChannelListActivity.this.emY.hW(false);
                ChannelListActivity.this.emY.LoadData();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mUserId = getIntent().getStringExtra("user_id");
        fb();
        initView();
    }

    private void fb() {
        this.emY = new ChannelListModel(getPageContext(), this.mUserId);
        this.emY.aAX();
        this.emY.a(this.ena);
        this.emY.hW(false);
    }

    private void initView() {
        this.emZ = new j(this);
        this.emZ.c(this.emz);
        this.emZ.b(this.dlk);
        this.emZ.a(new h.c() { // from class: com.baidu.tieba.channel.activity.ChannelListActivity.1
            @Override // com.baidu.tbadk.core.view.h.c
            public void dR(boolean z) {
                if (l.lo()) {
                    ChannelListActivity.this.emY.hW(false);
                    ChannelListActivity.this.emY.LoadData();
                    return;
                }
                ChannelListActivity.this.emZ.aRC();
            }
        });
        this.emZ.startPullRefresh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.emZ.onDestroy();
        this.emY.removeListener();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.emZ.onChangeSkinType(i);
    }
}
