package com.baidu.tieba.channel.activity;

import android.os.Bundle;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.h;
import com.baidu.tieba.channel.data.c;
import com.baidu.tieba.channel.model.ChannelFansListModel;
import com.baidu.tieba.channel.view.d;
/* loaded from: classes6.dex */
public class ChannelFansActivity extends BaseActivity<ChannelFansActivity> {
    private long channelId;
    private ChannelFansListModel eCs;
    private d eCt;
    private ChannelFansListModel.a eCu = new ChannelFansListModel.a() { // from class: com.baidu.tieba.channel.activity.ChannelFansActivity.2
        @Override // com.baidu.tieba.channel.model.ChannelFansListModel.a
        public void a(int i, String str, boolean z, c cVar) {
            ChannelFansActivity.this.closeLoadingDialog();
            ChannelFansActivity.this.eCt.aYO();
            if (i == 0) {
                ChannelFansActivity.this.eCt.a(cVar);
                return;
            }
            ChannelFansActivity.this.showToast(str);
            if (z) {
                ChannelFansActivity.this.eCt.a(cVar);
            }
        }
    };
    private BdListView.e dvS = new BdListView.e() { // from class: com.baidu.tieba.channel.activity.ChannelFansActivity.3
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (ChannelFansActivity.this.eCs.isHasMore()) {
                ChannelFansActivity.this.eCs.iB(true);
                ChannelFansActivity.this.eCs.LoadData();
            }
        }
    };
    private NoNetworkView.a eCl = new NoNetworkView.a() { // from class: com.baidu.tieba.channel.activity.ChannelFansActivity.4
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void el(boolean z) {
            if (z) {
                ChannelFansActivity.this.eCs.iB(false);
                ChannelFansActivity.this.eCs.LoadData();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.channelId = getIntent().getLongExtra("channel_id", 0L);
        dV();
        initView();
    }

    private void dV() {
        this.eCs = new ChannelFansListModel(getPageContext(), this.channelId);
        this.eCs.aHr();
        this.eCs.a(this.eCu);
        this.eCs.iB(false);
    }

    private void initView() {
        this.eCt = new d(this);
        this.eCt.c(this.eCl);
        this.eCt.b(this.dvS);
        this.eCt.a(new h.c() { // from class: com.baidu.tieba.channel.activity.ChannelFansActivity.1
            @Override // com.baidu.tbadk.core.view.h.c
            public void en(boolean z) {
                if (l.ki()) {
                    ChannelFansActivity.this.eCs.iB(false);
                    ChannelFansActivity.this.eCs.LoadData();
                    return;
                }
                ChannelFansActivity.this.eCt.aYO();
            }
        });
        this.eCt.startPullRefresh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.eCt.onDestroy();
        this.eCs.removeListener();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.eCt.onChangeSkinType(i);
    }
}
