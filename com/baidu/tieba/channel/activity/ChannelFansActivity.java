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
    private ChannelFansListModel eJe;
    private d eJf;
    private ChannelFansListModel.a eJg = new ChannelFansListModel.a() { // from class: com.baidu.tieba.channel.activity.ChannelFansActivity.2
        @Override // com.baidu.tieba.channel.model.ChannelFansListModel.a
        public void a(int i, String str, boolean z, c cVar) {
            ChannelFansActivity.this.closeLoadingDialog();
            ChannelFansActivity.this.eJf.bbt();
            if (i == 0) {
                ChannelFansActivity.this.eJf.a(cVar);
                return;
            }
            ChannelFansActivity.this.showToast(str);
            if (z) {
                ChannelFansActivity.this.eJf.a(cVar);
            }
        }
    };
    private BdListView.e dAJ = new BdListView.e() { // from class: com.baidu.tieba.channel.activity.ChannelFansActivity.3
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (ChannelFansActivity.this.eJe.isHasMore()) {
                ChannelFansActivity.this.eJe.iN(true);
                ChannelFansActivity.this.eJe.LoadData();
            }
        }
    };
    private NoNetworkView.a eIX = new NoNetworkView.a() { // from class: com.baidu.tieba.channel.activity.ChannelFansActivity.4
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void es(boolean z) {
            if (z) {
                ChannelFansActivity.this.eJe.iN(false);
                ChannelFansActivity.this.eJe.LoadData();
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
        this.eJe = new ChannelFansListModel(getPageContext(), this.channelId);
        this.eJe.aJu();
        this.eJe.a(this.eJg);
        this.eJe.iN(false);
    }

    private void initView() {
        this.eJf = new d(this);
        this.eJf.c(this.eIX);
        this.eJf.b(this.dAJ);
        this.eJf.a(new h.c() { // from class: com.baidu.tieba.channel.activity.ChannelFansActivity.1
            @Override // com.baidu.tbadk.core.view.h.c
            public void eu(boolean z) {
                if (l.kt()) {
                    ChannelFansActivity.this.eJe.iN(false);
                    ChannelFansActivity.this.eJe.LoadData();
                    return;
                }
                ChannelFansActivity.this.eJf.bbt();
            }
        });
        this.eJf.startPullRefresh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.eJf.onDestroy();
        this.eJe.removeListener();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.eJf.onChangeSkinType(i);
    }
}
