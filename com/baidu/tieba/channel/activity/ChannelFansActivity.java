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
    private ChannelFansListModel eHv;
    private d eHw;
    private ChannelFansListModel.a eHx = new ChannelFansListModel.a() { // from class: com.baidu.tieba.channel.activity.ChannelFansActivity.2
        @Override // com.baidu.tieba.channel.model.ChannelFansListModel.a
        public void a(int i, String str, boolean z, c cVar) {
            ChannelFansActivity.this.closeLoadingDialog();
            ChannelFansActivity.this.eHw.baP();
            if (i == 0) {
                ChannelFansActivity.this.eHw.a(cVar);
                return;
            }
            ChannelFansActivity.this.showToast(str);
            if (z) {
                ChannelFansActivity.this.eHw.a(cVar);
            }
        }
    };
    private BdListView.e dyY = new BdListView.e() { // from class: com.baidu.tieba.channel.activity.ChannelFansActivity.3
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (ChannelFansActivity.this.eHv.isHasMore()) {
                ChannelFansActivity.this.eHv.iK(true);
                ChannelFansActivity.this.eHv.LoadData();
            }
        }
    };
    private NoNetworkView.a eHo = new NoNetworkView.a() { // from class: com.baidu.tieba.channel.activity.ChannelFansActivity.4
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void ep(boolean z) {
            if (z) {
                ChannelFansActivity.this.eHv.iK(false);
                ChannelFansActivity.this.eHv.LoadData();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.channelId = getIntent().getLongExtra("channel_id", 0L);
        ec();
        initView();
    }

    private void ec() {
        this.eHv = new ChannelFansListModel(getPageContext(), this.channelId);
        this.eHv.aIQ();
        this.eHv.a(this.eHx);
        this.eHv.iK(false);
    }

    private void initView() {
        this.eHw = new d(this);
        this.eHw.c(this.eHo);
        this.eHw.b(this.dyY);
        this.eHw.a(new h.c() { // from class: com.baidu.tieba.channel.activity.ChannelFansActivity.1
            @Override // com.baidu.tbadk.core.view.h.c
            public void er(boolean z) {
                if (l.kt()) {
                    ChannelFansActivity.this.eHv.iK(false);
                    ChannelFansActivity.this.eHv.LoadData();
                    return;
                }
                ChannelFansActivity.this.eHw.baP();
            }
        });
        this.eHw.startPullRefresh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.eHw.onDestroy();
        this.eHv.removeListener();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.eHw.onChangeSkinType(i);
    }
}
