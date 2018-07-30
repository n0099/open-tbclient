package com.baidu.tieba.channel.activity;

import android.os.Bundle;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.g;
import com.baidu.tieba.channel.data.c;
import com.baidu.tieba.channel.model.ChannelFansListModel;
import com.baidu.tieba.channel.view.d;
/* loaded from: classes3.dex */
public class ChannelFansActivity extends BaseActivity<ChannelFansActivity> {
    private ChannelFansListModel cDx;
    private d cDy;
    private long channelId;
    private ChannelFansListModel.a cDz = new ChannelFansListModel.a() { // from class: com.baidu.tieba.channel.activity.ChannelFansActivity.2
        @Override // com.baidu.tieba.channel.model.ChannelFansListModel.a
        public void a(int i, String str, boolean z, c cVar) {
            ChannelFansActivity.this.closeLoadingDialog();
            ChannelFansActivity.this.cDy.ajW();
            if (i == 0) {
                ChannelFansActivity.this.cDy.a(cVar);
                return;
            }
            ChannelFansActivity.this.showToast(str);
            if (z) {
                ChannelFansActivity.this.cDy.a(cVar);
            }
        }
    };
    private BdListView.e bCy = new BdListView.e() { // from class: com.baidu.tieba.channel.activity.ChannelFansActivity.3
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (ChannelFansActivity.this.cDx.isHasMore()) {
                ChannelFansActivity.this.cDx.eE(true);
                ChannelFansActivity.this.cDx.LoadData();
            }
        }
    };
    private NoNetworkView.a cDq = new NoNetworkView.a() { // from class: com.baidu.tieba.channel.activity.ChannelFansActivity.4
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void aQ(boolean z) {
            if (z) {
                ChannelFansActivity.this.cDx.eE(false);
                ChannelFansActivity.this.cDx.LoadData();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.channelId = getIntent().getLongExtra("channel_id", 0L);
        dE();
        initView();
    }

    private void dE() {
        this.cDx = new ChannelFansListModel(getPageContext(), this.channelId);
        this.cDx.Tl();
        this.cDx.a(this.cDz);
        this.cDx.eE(false);
    }

    private void initView() {
        this.cDy = new d(this);
        this.cDy.c(this.cDq);
        this.cDy.a(this.bCy);
        this.cDy.b(new g.b() { // from class: com.baidu.tieba.channel.activity.ChannelFansActivity.1
            @Override // com.baidu.tbadk.core.view.g.b
            public void aS(boolean z) {
                if (l.jV()) {
                    ChannelFansActivity.this.cDx.eE(false);
                    ChannelFansActivity.this.cDx.LoadData();
                    return;
                }
                ChannelFansActivity.this.cDy.ajW();
            }
        });
        this.cDy.startPullRefresh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.cDy.onDestroy();
        this.cDx.removeListener();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.cDy.onChangeSkinType(i);
    }
}
