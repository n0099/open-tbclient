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
    private ChannelFansListModel emF;
    private d emG;
    private ChannelFansListModel.a emH = new ChannelFansListModel.a() { // from class: com.baidu.tieba.channel.activity.ChannelFansActivity.2
        @Override // com.baidu.tieba.channel.model.ChannelFansListModel.a
        public void a(int i, String str, boolean z, c cVar) {
            ChannelFansActivity.this.closeLoadingDialog();
            ChannelFansActivity.this.emG.aRC();
            if (i == 0) {
                ChannelFansActivity.this.emG.a(cVar);
                return;
            }
            ChannelFansActivity.this.showToast(str);
            if (z) {
                ChannelFansActivity.this.emG.a(cVar);
            }
        }
    };
    private BdListView.e dlj = new BdListView.e() { // from class: com.baidu.tieba.channel.activity.ChannelFansActivity.3
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (ChannelFansActivity.this.emF.isHasMore()) {
                ChannelFansActivity.this.emF.hW(true);
                ChannelFansActivity.this.emF.LoadData();
            }
        }
    };
    private NoNetworkView.a emy = new NoNetworkView.a() { // from class: com.baidu.tieba.channel.activity.ChannelFansActivity.4
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void dP(boolean z) {
            if (z) {
                ChannelFansActivity.this.emF.hW(false);
                ChannelFansActivity.this.emF.LoadData();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.channelId = getIntent().getLongExtra("channel_id", 0L);
        fb();
        initView();
    }

    private void fb() {
        this.emF = new ChannelFansListModel(getPageContext(), this.channelId);
        this.emF.aAX();
        this.emF.a(this.emH);
        this.emF.hW(false);
    }

    private void initView() {
        this.emG = new d(this);
        this.emG.c(this.emy);
        this.emG.b(this.dlj);
        this.emG.a(new h.c() { // from class: com.baidu.tieba.channel.activity.ChannelFansActivity.1
            @Override // com.baidu.tbadk.core.view.h.c
            public void dR(boolean z) {
                if (l.lo()) {
                    ChannelFansActivity.this.emF.hW(false);
                    ChannelFansActivity.this.emF.LoadData();
                    return;
                }
                ChannelFansActivity.this.emG.aRC();
            }
        });
        this.emG.startPullRefresh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.emG.onDestroy();
        this.emF.removeListener();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.emG.onChangeSkinType(i);
    }
}
