package com.baidu.tieba.channel.activity;

import android.os.Bundle;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.j;
import com.baidu.tieba.channel.data.e;
import com.baidu.tieba.channel.model.ChannelListModel;
import com.baidu.tieba.channel.view.j;
/* loaded from: classes3.dex */
public class ChannelListActivity extends BaseActivity<ChannelListActivity> {
    private ChannelListModel cZJ;
    private j cZK;
    private String mUserId;
    private ChannelListModel.a cZL = new ChannelListModel.a() { // from class: com.baidu.tieba.channel.activity.ChannelListActivity.2
        @Override // com.baidu.tieba.channel.model.ChannelListModel.a
        public void a(int i, String str, boolean z, e eVar) {
            ChannelListActivity.this.closeLoadingDialog();
            ChannelListActivity.this.cZK.aqA();
            if (i == 0) {
                ChannelListActivity.this.cZK.a(eVar);
                return;
            }
            ChannelListActivity.this.showToast(str);
            if (z) {
                ChannelListActivity.this.cZK.a(eVar);
            }
        }
    };
    private BdListView.e bVt = new BdListView.e() { // from class: com.baidu.tieba.channel.activity.ChannelListActivity.3
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (ChannelListActivity.this.cZJ.isHasMore()) {
                ChannelListActivity.this.cZJ.fz(true);
                ChannelListActivity.this.cZJ.LoadData();
            }
        }
    };
    private NoNetworkView.a cZk = new NoNetworkView.a() { // from class: com.baidu.tieba.channel.activity.ChannelListActivity.4
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void bF(boolean z) {
            if (z) {
                ChannelListActivity.this.cZJ.fz(false);
                ChannelListActivity.this.cZJ.LoadData();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mUserId = getIntent().getStringExtra("user_id");
        fc();
        initView();
    }

    private void fc() {
        this.cZJ = new ChannelListModel(getPageContext(), this.mUserId);
        this.cZJ.ZZ();
        this.cZJ.a(this.cZL);
        this.cZJ.fz(false);
    }

    private void initView() {
        this.cZK = new j(this);
        this.cZK.c(this.cZk);
        this.cZK.a(this.bVt);
        this.cZK.b(new j.b() { // from class: com.baidu.tieba.channel.activity.ChannelListActivity.1
            @Override // com.baidu.tbadk.core.view.j.b
            public void bH(boolean z) {
                if (l.ll()) {
                    ChannelListActivity.this.cZJ.fz(false);
                    ChannelListActivity.this.cZJ.LoadData();
                    return;
                }
                ChannelListActivity.this.cZK.aqA();
            }
        });
        this.cZK.startPullRefresh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.cZK.onDestroy();
        this.cZJ.removeListener();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.cZK.onChangeSkinType(i);
    }
}
