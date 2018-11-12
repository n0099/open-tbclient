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
    private ChannelListModel cTc;
    private j cTd;
    private String mUserId;
    private ChannelListModel.a cTe = new ChannelListModel.a() { // from class: com.baidu.tieba.channel.activity.ChannelListActivity.2
        @Override // com.baidu.tieba.channel.model.ChannelListModel.a
        public void a(int i, String str, boolean z, e eVar) {
            ChannelListActivity.this.closeLoadingDialog();
            ChannelListActivity.this.cTd.aoN();
            if (i == 0) {
                ChannelListActivity.this.cTd.a(eVar);
                return;
            }
            ChannelListActivity.this.showToast(str);
            if (z) {
                ChannelListActivity.this.cTd.a(eVar);
            }
        }
    };
    private BdListView.e bRC = new BdListView.e() { // from class: com.baidu.tieba.channel.activity.ChannelListActivity.3
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (ChannelListActivity.this.cTc.isHasMore()) {
                ChannelListActivity.this.cTc.fy(true);
                ChannelListActivity.this.cTc.LoadData();
            }
        }
    };
    private NoNetworkView.a cSD = new NoNetworkView.a() { // from class: com.baidu.tieba.channel.activity.ChannelListActivity.4
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void bE(boolean z) {
            if (z) {
                ChannelListActivity.this.cTc.fy(false);
                ChannelListActivity.this.cTc.LoadData();
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
        this.cTc = new ChannelListModel(getPageContext(), this.mUserId);
        this.cTc.YT();
        this.cTc.a(this.cTe);
        this.cTc.fy(false);
    }

    private void initView() {
        this.cTd = new j(this);
        this.cTd.c(this.cSD);
        this.cTd.a(this.bRC);
        this.cTd.b(new j.b() { // from class: com.baidu.tieba.channel.activity.ChannelListActivity.1
            @Override // com.baidu.tbadk.core.view.j.b
            public void bG(boolean z) {
                if (l.lm()) {
                    ChannelListActivity.this.cTc.fy(false);
                    ChannelListActivity.this.cTc.LoadData();
                    return;
                }
                ChannelListActivity.this.cTd.aoN();
            }
        });
        this.cTd.startPullRefresh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.cTd.onDestroy();
        this.cTc.removeListener();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.cTd.onChangeSkinType(i);
    }
}
