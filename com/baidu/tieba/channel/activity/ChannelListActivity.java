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
    private ChannelListModel eHN;
    private j eHO;
    private String mUserId;
    private ChannelListModel.a eHP = new ChannelListModel.a() { // from class: com.baidu.tieba.channel.activity.ChannelListActivity.2
        @Override // com.baidu.tieba.channel.model.ChannelListModel.a
        public void a(int i, String str, boolean z, e eVar) {
            ChannelListActivity.this.closeLoadingDialog();
            ChannelListActivity.this.eHO.baP();
            if (i == 0) {
                ChannelListActivity.this.eHO.a(eVar);
                return;
            }
            ChannelListActivity.this.showToast(str);
            if (z) {
                ChannelListActivity.this.eHO.a(eVar);
            }
        }
    };
    private BdListView.e dyY = new BdListView.e() { // from class: com.baidu.tieba.channel.activity.ChannelListActivity.3
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (ChannelListActivity.this.eHN.isHasMore()) {
                ChannelListActivity.this.eHN.iK(true);
                ChannelListActivity.this.eHN.LoadData();
            }
        }
    };
    private NoNetworkView.a eHo = new NoNetworkView.a() { // from class: com.baidu.tieba.channel.activity.ChannelListActivity.4
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void ep(boolean z) {
            if (z) {
                ChannelListActivity.this.eHN.iK(false);
                ChannelListActivity.this.eHN.LoadData();
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
        this.eHN = new ChannelListModel(getPageContext(), this.mUserId);
        this.eHN.aIQ();
        this.eHN.a(this.eHP);
        this.eHN.iK(false);
    }

    private void initView() {
        this.eHO = new j(this);
        this.eHO.c(this.eHo);
        this.eHO.b(this.dyY);
        this.eHO.a(new h.c() { // from class: com.baidu.tieba.channel.activity.ChannelListActivity.1
            @Override // com.baidu.tbadk.core.view.h.c
            public void er(boolean z) {
                if (l.kt()) {
                    ChannelListActivity.this.eHN.iK(false);
                    ChannelListActivity.this.eHN.LoadData();
                    return;
                }
                ChannelListActivity.this.eHO.baP();
            }
        });
        this.eHO.startPullRefresh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.eHO.onDestroy();
        this.eHN.removeListener();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.eHO.onChangeSkinType(i);
    }
}
