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
    private ChannelListModel emX;
    private j emY;
    private String mUserId;
    private ChannelListModel.a emZ = new ChannelListModel.a() { // from class: com.baidu.tieba.channel.activity.ChannelListActivity.2
        @Override // com.baidu.tieba.channel.model.ChannelListModel.a
        public void a(int i, String str, boolean z, e eVar) {
            ChannelListActivity.this.closeLoadingDialog();
            ChannelListActivity.this.emY.aRC();
            if (i == 0) {
                ChannelListActivity.this.emY.a(eVar);
                return;
            }
            ChannelListActivity.this.showToast(str);
            if (z) {
                ChannelListActivity.this.emY.a(eVar);
            }
        }
    };
    private BdListView.e dlj = new BdListView.e() { // from class: com.baidu.tieba.channel.activity.ChannelListActivity.3
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (ChannelListActivity.this.emX.isHasMore()) {
                ChannelListActivity.this.emX.hW(true);
                ChannelListActivity.this.emX.LoadData();
            }
        }
    };
    private NoNetworkView.a emy = new NoNetworkView.a() { // from class: com.baidu.tieba.channel.activity.ChannelListActivity.4
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void dP(boolean z) {
            if (z) {
                ChannelListActivity.this.emX.hW(false);
                ChannelListActivity.this.emX.LoadData();
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
        this.emX = new ChannelListModel(getPageContext(), this.mUserId);
        this.emX.aAX();
        this.emX.a(this.emZ);
        this.emX.hW(false);
    }

    private void initView() {
        this.emY = new j(this);
        this.emY.c(this.emy);
        this.emY.b(this.dlj);
        this.emY.a(new h.c() { // from class: com.baidu.tieba.channel.activity.ChannelListActivity.1
            @Override // com.baidu.tbadk.core.view.h.c
            public void dR(boolean z) {
                if (l.lo()) {
                    ChannelListActivity.this.emX.hW(false);
                    ChannelListActivity.this.emX.LoadData();
                    return;
                }
                ChannelListActivity.this.emY.aRC();
            }
        });
        this.emY.startPullRefresh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.emY.onDestroy();
        this.emX.removeListener();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.emY.onChangeSkinType(i);
    }
}
