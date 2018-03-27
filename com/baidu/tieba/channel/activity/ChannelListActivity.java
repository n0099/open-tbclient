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
    private ChannelListModel dbN;
    private j dbO;
    private String mUserId;
    private ChannelListModel.a dbP = new ChannelListModel.a() { // from class: com.baidu.tieba.channel.activity.ChannelListActivity.2
        @Override // com.baidu.tieba.channel.model.ChannelListModel.a
        public void a(int i, String str, boolean z, e eVar) {
            ChannelListActivity.this.closeLoadingDialog();
            ChannelListActivity.this.dbO.amw();
            if (i == 0) {
                ChannelListActivity.this.dbO.a(eVar);
                return;
            }
            ChannelListActivity.this.showToast(str);
            if (z) {
                ChannelListActivity.this.dbO.a(eVar);
            }
        }
    };
    private BdListView.e ckh = new BdListView.e() { // from class: com.baidu.tieba.channel.activity.ChannelListActivity.3
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (ChannelListActivity.this.dbN.isHasMore()) {
                ChannelListActivity.this.dbN.eT(true);
                ChannelListActivity.this.dbN.LoadData();
            }
        }
    };
    private NoNetworkView.a dbo = new NoNetworkView.a() { // from class: com.baidu.tieba.channel.activity.ChannelListActivity.4
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void bu(boolean z) {
            if (z) {
                ChannelListActivity.this.dbN.eT(false);
                ChannelListActivity.this.dbN.LoadData();
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
        this.dbN = new ChannelListModel(getPageContext(), this.mUserId);
        this.dbN.WM();
        this.dbN.a(this.dbP);
        this.dbN.eT(false);
    }

    private void initView() {
        this.dbO = new j(this);
        this.dbO.c(this.dbo);
        this.dbO.a(this.ckh);
        this.dbO.b(new j.b() { // from class: com.baidu.tieba.channel.activity.ChannelListActivity.1
            @Override // com.baidu.tbadk.core.view.j.b
            public void bw(boolean z) {
                if (l.pa()) {
                    ChannelListActivity.this.dbN.eT(false);
                    ChannelListActivity.this.dbN.LoadData();
                    return;
                }
                ChannelListActivity.this.dbO.amw();
            }
        });
        this.dbO.startPullRefresh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.dbO.onDestroy();
        this.dbN.removeListener();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.dbO.onChangeSkinType(i);
    }
}
