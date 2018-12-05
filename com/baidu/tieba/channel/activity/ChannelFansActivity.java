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
    private ChannelFansListModel cZr;
    private d cZs;
    private long channelId;
    private ChannelFansListModel.a cZt = new ChannelFansListModel.a() { // from class: com.baidu.tieba.channel.activity.ChannelFansActivity.2
        @Override // com.baidu.tieba.channel.model.ChannelFansListModel.a
        public void a(int i, String str, boolean z, c cVar) {
            ChannelFansActivity.this.closeLoadingDialog();
            ChannelFansActivity.this.cZs.aqA();
            if (i == 0) {
                ChannelFansActivity.this.cZs.a(cVar);
                return;
            }
            ChannelFansActivity.this.showToast(str);
            if (z) {
                ChannelFansActivity.this.cZs.a(cVar);
            }
        }
    };
    private BdListView.e bVt = new BdListView.e() { // from class: com.baidu.tieba.channel.activity.ChannelFansActivity.3
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (ChannelFansActivity.this.cZr.isHasMore()) {
                ChannelFansActivity.this.cZr.fz(true);
                ChannelFansActivity.this.cZr.LoadData();
            }
        }
    };
    private NoNetworkView.a cZk = new NoNetworkView.a() { // from class: com.baidu.tieba.channel.activity.ChannelFansActivity.4
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void bF(boolean z) {
            if (z) {
                ChannelFansActivity.this.cZr.fz(false);
                ChannelFansActivity.this.cZr.LoadData();
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
        this.cZr = new ChannelFansListModel(getPageContext(), this.channelId);
        this.cZr.ZZ();
        this.cZr.a(this.cZt);
        this.cZr.fz(false);
    }

    private void initView() {
        this.cZs = new d(this);
        this.cZs.c(this.cZk);
        this.cZs.a(this.bVt);
        this.cZs.b(new j.b() { // from class: com.baidu.tieba.channel.activity.ChannelFansActivity.1
            @Override // com.baidu.tbadk.core.view.j.b
            public void bH(boolean z) {
                if (l.ll()) {
                    ChannelFansActivity.this.cZr.fz(false);
                    ChannelFansActivity.this.cZr.LoadData();
                    return;
                }
                ChannelFansActivity.this.cZs.aqA();
            }
        });
        this.cZs.startPullRefresh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.cZs.onDestroy();
        this.cZr.removeListener();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.cZs.onChangeSkinType(i);
    }
}
