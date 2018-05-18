package com.baidu.tieba.channel.activity;

import android.os.Bundle;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.e;
import com.baidu.tieba.channel.data.e;
import com.baidu.tieba.channel.model.ChannelListModel;
import com.baidu.tieba.channel.view.j;
/* loaded from: classes3.dex */
public class ChannelListActivity extends BaseActivity<ChannelListActivity> {
    private ChannelListModel cuN;
    private j cuO;
    private String mUserId;
    private ChannelListModel.a cuP = new ChannelListModel.a() { // from class: com.baidu.tieba.channel.activity.ChannelListActivity.2
        @Override // com.baidu.tieba.channel.model.ChannelListModel.a
        public void a(int i, String str, boolean z, e eVar) {
            ChannelListActivity.this.closeLoadingDialog();
            ChannelListActivity.this.cuO.agw();
            if (i == 0) {
                ChannelListActivity.this.cuO.a(eVar);
                return;
            }
            ChannelListActivity.this.showToast(str);
            if (z) {
                ChannelListActivity.this.cuO.a(eVar);
            }
        }
    };
    private BdListView.e brM = new BdListView.e() { // from class: com.baidu.tieba.channel.activity.ChannelListActivity.3
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (ChannelListActivity.this.cuN.isHasMore()) {
                ChannelListActivity.this.cuN.ez(true);
                ChannelListActivity.this.cuN.LoadData();
            }
        }
    };
    private NoNetworkView.a cun = new NoNetworkView.a() { // from class: com.baidu.tieba.channel.activity.ChannelListActivity.4
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void aM(boolean z) {
            if (z) {
                ChannelListActivity.this.cuN.ez(false);
                ChannelListActivity.this.cuN.LoadData();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mUserId = getIntent().getStringExtra("user_id");
        aS();
        initView();
    }

    private void aS() {
        this.cuN = new ChannelListModel(getPageContext(), this.mUserId);
        this.cuN.Pj();
        this.cuN.a(this.cuP);
        this.cuN.ez(false);
    }

    private void initView() {
        this.cuO = new j(this);
        this.cuO.c(this.cun);
        this.cuO.a(this.brM);
        this.cuO.b(new e.b() { // from class: com.baidu.tieba.channel.activity.ChannelListActivity.1
            @Override // com.baidu.tbadk.core.view.e.b
            public void aO(boolean z) {
                if (l.hg()) {
                    ChannelListActivity.this.cuN.ez(false);
                    ChannelListActivity.this.cuN.LoadData();
                    return;
                }
                ChannelListActivity.this.cuO.agw();
            }
        });
        this.cuO.startPullRefresh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.cuO.onDestroy();
        this.cuN.removeListener();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.cuO.onChangeSkinType(i);
    }
}
