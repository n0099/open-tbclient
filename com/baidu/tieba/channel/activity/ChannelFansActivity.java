package com.baidu.tieba.channel.activity;

import android.os.Bundle;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.j;
import com.baidu.tieba.channel.data.c;
import com.baidu.tieba.channel.model.ChannelFansListModel;
import com.baidu.tieba.channel.view.d;
/* loaded from: classes3.dex */
public class ChannelFansActivity extends BaseActivity<ChannelFansActivity> {
    private long channelId;
    private ChannelFansListModel dcj;
    private d dck;
    private ChannelFansListModel.a dcl = new ChannelFansListModel.a() { // from class: com.baidu.tieba.channel.activity.ChannelFansActivity.2
        @Override // com.baidu.tieba.channel.model.ChannelFansListModel.a
        public void a(int i, String str, boolean z, c cVar) {
            ChannelFansActivity.this.closeLoadingDialog();
            ChannelFansActivity.this.dck.arp();
            if (i == 0) {
                ChannelFansActivity.this.dck.a(cVar);
                return;
            }
            ChannelFansActivity.this.showToast(str);
            if (z) {
                ChannelFansActivity.this.dck.a(cVar);
            }
        }
    };
    private BdListView.e bVw = new BdListView.e() { // from class: com.baidu.tieba.channel.activity.ChannelFansActivity.3
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (ChannelFansActivity.this.dcj.isHasMore()) {
                ChannelFansActivity.this.dcj.fB(true);
                ChannelFansActivity.this.dcj.LoadData();
            }
        }
    };
    private NoNetworkView.a dcc = new NoNetworkView.a() { // from class: com.baidu.tieba.channel.activity.ChannelFansActivity.4
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void bF(boolean z) {
            if (z) {
                ChannelFansActivity.this.dcj.fB(false);
                ChannelFansActivity.this.dcj.LoadData();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.channelId = getIntent().getLongExtra("channel_id", 0L);
        fc();
        initView();
    }

    private void fc() {
        this.dcj = new ChannelFansListModel(getPageContext(), this.channelId);
        this.dcj.aab();
        this.dcj.a(this.dcl);
        this.dcj.fB(false);
    }

    private void initView() {
        this.dck = new d(this);
        this.dck.c(this.dcc);
        this.dck.a(this.bVw);
        this.dck.b(new j.b() { // from class: com.baidu.tieba.channel.activity.ChannelFansActivity.1
            @Override // com.baidu.tbadk.core.view.j.b
            public void bH(boolean z) {
                if (l.ll()) {
                    ChannelFansActivity.this.dcj.fB(false);
                    ChannelFansActivity.this.dcj.LoadData();
                    return;
                }
                ChannelFansActivity.this.dck.arp();
            }
        });
        this.dck.startPullRefresh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.dck.onDestroy();
        this.dcj.removeListener();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.dck.onChangeSkinType(i);
    }
}
