package com.baidu.tieba.channel.activity;

import android.os.Bundle;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.g;
import com.baidu.tieba.channel.data.e;
import com.baidu.tieba.channel.model.ChannelListModel;
import com.baidu.tieba.channel.view.j;
/* loaded from: classes3.dex */
public class ChannelListActivity extends BaseActivity<ChannelListActivity> {
    private ChannelListModel cBk;
    private j cBl;
    private String mUserId;
    private ChannelListModel.a cBm = new ChannelListModel.a() { // from class: com.baidu.tieba.channel.activity.ChannelListActivity.2
        @Override // com.baidu.tieba.channel.model.ChannelListModel.a
        public void a(int i, String str, boolean z, e eVar) {
            ChannelListActivity.this.closeLoadingDialog();
            ChannelListActivity.this.cBl.ajy();
            if (i == 0) {
                ChannelListActivity.this.cBl.a(eVar);
                return;
            }
            ChannelListActivity.this.showToast(str);
            if (z) {
                ChannelListActivity.this.cBl.a(eVar);
            }
        }
    };
    private BdListView.e bBR = new BdListView.e() { // from class: com.baidu.tieba.channel.activity.ChannelListActivity.3
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (ChannelListActivity.this.cBk.isHasMore()) {
                ChannelListActivity.this.cBk.eD(true);
                ChannelListActivity.this.cBk.LoadData();
            }
        }
    };
    private NoNetworkView.a cAL = new NoNetworkView.a() { // from class: com.baidu.tieba.channel.activity.ChannelListActivity.4
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void aS(boolean z) {
            if (z) {
                ChannelListActivity.this.cBk.eD(false);
                ChannelListActivity.this.cBk.LoadData();
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
        this.cBk = new ChannelListModel(getPageContext(), this.mUserId);
        this.cBk.Td();
        this.cBk.a(this.cBm);
        this.cBk.eD(false);
    }

    private void initView() {
        this.cBl = new j(this);
        this.cBl.c(this.cAL);
        this.cBl.a(this.bBR);
        this.cBl.b(new g.b() { // from class: com.baidu.tieba.channel.activity.ChannelListActivity.1
            @Override // com.baidu.tbadk.core.view.g.b
            public void aU(boolean z) {
                if (l.jU()) {
                    ChannelListActivity.this.cBk.eD(false);
                    ChannelListActivity.this.cBk.LoadData();
                    return;
                }
                ChannelListActivity.this.cBl.ajy();
            }
        });
        this.cBl.startPullRefresh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.cBl.onDestroy();
        this.cBk.removeListener();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.cBl.onChangeSkinType(i);
    }
}
