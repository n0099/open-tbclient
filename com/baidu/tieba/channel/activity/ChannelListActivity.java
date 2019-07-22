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
    private ChannelListModel eHG;
    private j eHH;
    private String mUserId;
    private ChannelListModel.a eHI = new ChannelListModel.a() { // from class: com.baidu.tieba.channel.activity.ChannelListActivity.2
        @Override // com.baidu.tieba.channel.model.ChannelListModel.a
        public void a(int i, String str, boolean z, e eVar) {
            ChannelListActivity.this.closeLoadingDialog();
            ChannelListActivity.this.eHH.baN();
            if (i == 0) {
                ChannelListActivity.this.eHH.a(eVar);
                return;
            }
            ChannelListActivity.this.showToast(str);
            if (z) {
                ChannelListActivity.this.eHH.a(eVar);
            }
        }
    };
    private BdListView.e dyR = new BdListView.e() { // from class: com.baidu.tieba.channel.activity.ChannelListActivity.3
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (ChannelListActivity.this.eHG.isHasMore()) {
                ChannelListActivity.this.eHG.iK(true);
                ChannelListActivity.this.eHG.LoadData();
            }
        }
    };
    private NoNetworkView.a eHh = new NoNetworkView.a() { // from class: com.baidu.tieba.channel.activity.ChannelListActivity.4
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void ep(boolean z) {
            if (z) {
                ChannelListActivity.this.eHG.iK(false);
                ChannelListActivity.this.eHG.LoadData();
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
        this.eHG = new ChannelListModel(getPageContext(), this.mUserId);
        this.eHG.aIO();
        this.eHG.a(this.eHI);
        this.eHG.iK(false);
    }

    private void initView() {
        this.eHH = new j(this);
        this.eHH.c(this.eHh);
        this.eHH.b(this.dyR);
        this.eHH.a(new h.c() { // from class: com.baidu.tieba.channel.activity.ChannelListActivity.1
            @Override // com.baidu.tbadk.core.view.h.c
            public void er(boolean z) {
                if (l.kt()) {
                    ChannelListActivity.this.eHG.iK(false);
                    ChannelListActivity.this.eHG.LoadData();
                    return;
                }
                ChannelListActivity.this.eHH.baN();
            }
        });
        this.eHH.startPullRefresh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.eHH.onDestroy();
        this.eHG.removeListener();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.eHH.onChangeSkinType(i);
    }
}
