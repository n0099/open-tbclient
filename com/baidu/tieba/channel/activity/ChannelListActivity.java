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
    private ChannelListModel eCJ;
    private j eCK;
    private String mUserId;
    private ChannelListModel.a eCL = new ChannelListModel.a() { // from class: com.baidu.tieba.channel.activity.ChannelListActivity.2
        @Override // com.baidu.tieba.channel.model.ChannelListModel.a
        public void a(int i, String str, boolean z, e eVar) {
            ChannelListActivity.this.closeLoadingDialog();
            ChannelListActivity.this.eCK.aYL();
            if (i == 0) {
                ChannelListActivity.this.eCK.a(eVar);
                return;
            }
            ChannelListActivity.this.showToast(str);
            if (z) {
                ChannelListActivity.this.eCK.a(eVar);
            }
        }
    };
    private BdListView.e dvR = new BdListView.e() { // from class: com.baidu.tieba.channel.activity.ChannelListActivity.3
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (ChannelListActivity.this.eCJ.isHasMore()) {
                ChannelListActivity.this.eCJ.iB(true);
                ChannelListActivity.this.eCJ.LoadData();
            }
        }
    };
    private NoNetworkView.a eCk = new NoNetworkView.a() { // from class: com.baidu.tieba.channel.activity.ChannelListActivity.4
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void el(boolean z) {
            if (z) {
                ChannelListActivity.this.eCJ.iB(false);
                ChannelListActivity.this.eCJ.LoadData();
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
        this.eCJ = new ChannelListModel(getPageContext(), this.mUserId);
        this.eCJ.aHo();
        this.eCJ.a(this.eCL);
        this.eCJ.iB(false);
    }

    private void initView() {
        this.eCK = new j(this);
        this.eCK.c(this.eCk);
        this.eCK.b(this.dvR);
        this.eCK.a(new h.c() { // from class: com.baidu.tieba.channel.activity.ChannelListActivity.1
            @Override // com.baidu.tbadk.core.view.h.c
            public void en(boolean z) {
                if (l.ki()) {
                    ChannelListActivity.this.eCJ.iB(false);
                    ChannelListActivity.this.eCJ.LoadData();
                    return;
                }
                ChannelListActivity.this.eCK.aYL();
            }
        });
        this.eCK.startPullRefresh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.eCK.onDestroy();
        this.eCJ.removeListener();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.eCK.onChangeSkinType(i);
    }
}
