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
    private ChannelListModel dbW;
    private j dbX;
    private String mUserId;
    private ChannelListModel.a dbY = new ChannelListModel.a() { // from class: com.baidu.tieba.channel.activity.ChannelListActivity.2
        @Override // com.baidu.tieba.channel.model.ChannelListModel.a
        public void a(int i, String str, boolean z, e eVar) {
            ChannelListActivity.this.closeLoadingDialog();
            ChannelListActivity.this.dbX.amw();
            if (i == 0) {
                ChannelListActivity.this.dbX.a(eVar);
                return;
            }
            ChannelListActivity.this.showToast(str);
            if (z) {
                ChannelListActivity.this.dbX.a(eVar);
            }
        }
    };
    private BdListView.e ckq = new BdListView.e() { // from class: com.baidu.tieba.channel.activity.ChannelListActivity.3
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (ChannelListActivity.this.dbW.isHasMore()) {
                ChannelListActivity.this.dbW.eT(true);
                ChannelListActivity.this.dbW.LoadData();
            }
        }
    };
    private NoNetworkView.a dbx = new NoNetworkView.a() { // from class: com.baidu.tieba.channel.activity.ChannelListActivity.4
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void bu(boolean z) {
            if (z) {
                ChannelListActivity.this.dbW.eT(false);
                ChannelListActivity.this.dbW.LoadData();
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
        this.dbW = new ChannelListModel(getPageContext(), this.mUserId);
        this.dbW.WM();
        this.dbW.a(this.dbY);
        this.dbW.eT(false);
    }

    private void initView() {
        this.dbX = new j(this);
        this.dbX.c(this.dbx);
        this.dbX.a(this.ckq);
        this.dbX.b(new j.b() { // from class: com.baidu.tieba.channel.activity.ChannelListActivity.1
            @Override // com.baidu.tbadk.core.view.j.b
            public void bw(boolean z) {
                if (l.pa()) {
                    ChannelListActivity.this.dbW.eT(false);
                    ChannelListActivity.this.dbW.LoadData();
                    return;
                }
                ChannelListActivity.this.dbX.amw();
            }
        });
        this.dbX.startPullRefresh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.dbX.onDestroy();
        this.dbW.removeListener();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.dbX.onChangeSkinType(i);
    }
}
