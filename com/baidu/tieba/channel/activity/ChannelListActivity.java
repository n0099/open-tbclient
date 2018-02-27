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
    private ChannelListModel dbK;
    private j dbL;
    private String mUserId;
    private ChannelListModel.a dbM = new ChannelListModel.a() { // from class: com.baidu.tieba.channel.activity.ChannelListActivity.2
        @Override // com.baidu.tieba.channel.model.ChannelListModel.a
        public void a(int i, String str, boolean z, e eVar) {
            ChannelListActivity.this.closeLoadingDialog();
            ChannelListActivity.this.dbL.amv();
            if (i == 0) {
                ChannelListActivity.this.dbL.a(eVar);
                return;
            }
            ChannelListActivity.this.showToast(str);
            if (z) {
                ChannelListActivity.this.dbL.a(eVar);
            }
        }
    };
    private BdListView.e cke = new BdListView.e() { // from class: com.baidu.tieba.channel.activity.ChannelListActivity.3
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (ChannelListActivity.this.dbK.isHasMore()) {
                ChannelListActivity.this.dbK.eT(true);
                ChannelListActivity.this.dbK.LoadData();
            }
        }
    };
    private NoNetworkView.a dbl = new NoNetworkView.a() { // from class: com.baidu.tieba.channel.activity.ChannelListActivity.4
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void bu(boolean z) {
            if (z) {
                ChannelListActivity.this.dbK.eT(false);
                ChannelListActivity.this.dbK.LoadData();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mUserId = getIntent().getStringExtra("user_id");
        iO();
        initView();
    }

    private void iO() {
        this.dbK = new ChannelListModel(getPageContext(), this.mUserId);
        this.dbK.WL();
        this.dbK.a(this.dbM);
        this.dbK.eT(false);
    }

    private void initView() {
        this.dbL = new j(this);
        this.dbL.c(this.dbl);
        this.dbL.a(this.cke);
        this.dbL.b(new j.b() { // from class: com.baidu.tieba.channel.activity.ChannelListActivity.1
            @Override // com.baidu.tbadk.core.view.j.b
            public void bw(boolean z) {
                if (l.pa()) {
                    ChannelListActivity.this.dbK.eT(false);
                    ChannelListActivity.this.dbK.LoadData();
                    return;
                }
                ChannelListActivity.this.dbL.amv();
            }
        });
        this.dbL.startPullRefresh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.dbL.onDestroy();
        this.dbK.removeListener();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.dbL.onChangeSkinType(i);
    }
}
