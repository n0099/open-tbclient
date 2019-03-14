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
    private ChannelListModel enm;
    private j enn;
    private String mUserId;
    private ChannelListModel.a eno = new ChannelListModel.a() { // from class: com.baidu.tieba.channel.activity.ChannelListActivity.2
        @Override // com.baidu.tieba.channel.model.ChannelListModel.a
        public void a(int i, String str, boolean z, e eVar) {
            ChannelListActivity.this.closeLoadingDialog();
            ChannelListActivity.this.enn.aRE();
            if (i == 0) {
                ChannelListActivity.this.enn.a(eVar);
                return;
            }
            ChannelListActivity.this.showToast(str);
            if (z) {
                ChannelListActivity.this.enn.a(eVar);
            }
        }
    };
    private BdListView.e dlg = new BdListView.e() { // from class: com.baidu.tieba.channel.activity.ChannelListActivity.3
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (ChannelListActivity.this.enm.isHasMore()) {
                ChannelListActivity.this.enm.hW(true);
                ChannelListActivity.this.enm.LoadData();
            }
        }
    };
    private NoNetworkView.a emM = new NoNetworkView.a() { // from class: com.baidu.tieba.channel.activity.ChannelListActivity.4
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void dP(boolean z) {
            if (z) {
                ChannelListActivity.this.enm.hW(false);
                ChannelListActivity.this.enm.LoadData();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mUserId = getIntent().getStringExtra("user_id");
        fb();
        initView();
    }

    private void fb() {
        this.enm = new ChannelListModel(getPageContext(), this.mUserId);
        this.enm.aBa();
        this.enm.a(this.eno);
        this.enm.hW(false);
    }

    private void initView() {
        this.enn = new j(this);
        this.enn.c(this.emM);
        this.enn.b(this.dlg);
        this.enn.a(new h.c() { // from class: com.baidu.tieba.channel.activity.ChannelListActivity.1
            @Override // com.baidu.tbadk.core.view.h.c
            public void dR(boolean z) {
                if (l.lo()) {
                    ChannelListActivity.this.enm.hW(false);
                    ChannelListActivity.this.enm.LoadData();
                    return;
                }
                ChannelListActivity.this.enn.aRE();
            }
        });
        this.enn.startPullRefresh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.enn.onDestroy();
        this.enm.removeListener();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.enn.onChangeSkinType(i);
    }
}
