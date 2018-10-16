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
    private ChannelFansListModel cRE;
    private d cRF;
    private long channelId;
    private ChannelFansListModel.a cRG = new ChannelFansListModel.a() { // from class: com.baidu.tieba.channel.activity.ChannelFansActivity.2
        @Override // com.baidu.tieba.channel.model.ChannelFansListModel.a
        public void a(int i, String str, boolean z, c cVar) {
            ChannelFansActivity.this.closeLoadingDialog();
            ChannelFansActivity.this.cRF.apm();
            if (i == 0) {
                ChannelFansActivity.this.cRF.a(cVar);
                return;
            }
            ChannelFansActivity.this.showToast(str);
            if (z) {
                ChannelFansActivity.this.cRF.a(cVar);
            }
        }
    };
    private BdListView.e bQS = new BdListView.e() { // from class: com.baidu.tieba.channel.activity.ChannelFansActivity.3
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (ChannelFansActivity.this.cRE.isHasMore()) {
                ChannelFansActivity.this.cRE.fn(true);
                ChannelFansActivity.this.cRE.LoadData();
            }
        }
    };
    private NoNetworkView.a cRx = new NoNetworkView.a() { // from class: com.baidu.tieba.channel.activity.ChannelFansActivity.4
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void bn(boolean z) {
            if (z) {
                ChannelFansActivity.this.cRE.fn(false);
                ChannelFansActivity.this.cRE.LoadData();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.channelId = getIntent().getLongExtra("channel_id", 0L);
        fd();
        initView();
    }

    private void fd() {
        this.cRE = new ChannelFansListModel(getPageContext(), this.channelId);
        this.cRE.YI();
        this.cRE.a(this.cRG);
        this.cRE.fn(false);
    }

    private void initView() {
        this.cRF = new d(this);
        this.cRF.c(this.cRx);
        this.cRF.a(this.bQS);
        this.cRF.b(new j.b() { // from class: com.baidu.tieba.channel.activity.ChannelFansActivity.1
            @Override // com.baidu.tbadk.core.view.j.b
            public void bp(boolean z) {
                if (l.lo()) {
                    ChannelFansActivity.this.cRE.fn(false);
                    ChannelFansActivity.this.cRE.LoadData();
                    return;
                }
                ChannelFansActivity.this.cRF.apm();
            }
        });
        this.cRF.startPullRefresh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.cRF.onDestroy();
        this.cRE.removeListener();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.cRF.onChangeSkinType(i);
    }
}
