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
    private ChannelFansListModel eCr;
    private d eCs;
    private ChannelFansListModel.a eCt = new ChannelFansListModel.a() { // from class: com.baidu.tieba.channel.activity.ChannelFansActivity.2
        @Override // com.baidu.tieba.channel.model.ChannelFansListModel.a
        public void a(int i, String str, boolean z, c cVar) {
            ChannelFansActivity.this.closeLoadingDialog();
            ChannelFansActivity.this.eCs.aYL();
            if (i == 0) {
                ChannelFansActivity.this.eCs.a(cVar);
                return;
            }
            ChannelFansActivity.this.showToast(str);
            if (z) {
                ChannelFansActivity.this.eCs.a(cVar);
            }
        }
    };
    private BdListView.e dvR = new BdListView.e() { // from class: com.baidu.tieba.channel.activity.ChannelFansActivity.3
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (ChannelFansActivity.this.eCr.isHasMore()) {
                ChannelFansActivity.this.eCr.iB(true);
                ChannelFansActivity.this.eCr.LoadData();
            }
        }
    };
    private NoNetworkView.a eCk = new NoNetworkView.a() { // from class: com.baidu.tieba.channel.activity.ChannelFansActivity.4
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void el(boolean z) {
            if (z) {
                ChannelFansActivity.this.eCr.iB(false);
                ChannelFansActivity.this.eCr.LoadData();
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
        this.eCr = new ChannelFansListModel(getPageContext(), this.channelId);
        this.eCr.aHo();
        this.eCr.a(this.eCt);
        this.eCr.iB(false);
    }

    private void initView() {
        this.eCs = new d(this);
        this.eCs.c(this.eCk);
        this.eCs.b(this.dvR);
        this.eCs.a(new h.c() { // from class: com.baidu.tieba.channel.activity.ChannelFansActivity.1
            @Override // com.baidu.tbadk.core.view.h.c
            public void en(boolean z) {
                if (l.ki()) {
                    ChannelFansActivity.this.eCr.iB(false);
                    ChannelFansActivity.this.eCr.LoadData();
                    return;
                }
                ChannelFansActivity.this.eCs.aYL();
            }
        });
        this.eCs.startPullRefresh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.eCs.onDestroy();
        this.eCr.removeListener();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.eCs.onChangeSkinType(i);
    }
}
