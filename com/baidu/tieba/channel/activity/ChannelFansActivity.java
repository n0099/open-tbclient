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
    private ChannelFansListModel emG;
    private d emH;
    private ChannelFansListModel.a emI = new ChannelFansListModel.a() { // from class: com.baidu.tieba.channel.activity.ChannelFansActivity.2
        @Override // com.baidu.tieba.channel.model.ChannelFansListModel.a
        public void a(int i, String str, boolean z, c cVar) {
            ChannelFansActivity.this.closeLoadingDialog();
            ChannelFansActivity.this.emH.aRC();
            if (i == 0) {
                ChannelFansActivity.this.emH.a(cVar);
                return;
            }
            ChannelFansActivity.this.showToast(str);
            if (z) {
                ChannelFansActivity.this.emH.a(cVar);
            }
        }
    };
    private BdListView.e dlk = new BdListView.e() { // from class: com.baidu.tieba.channel.activity.ChannelFansActivity.3
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (ChannelFansActivity.this.emG.isHasMore()) {
                ChannelFansActivity.this.emG.hW(true);
                ChannelFansActivity.this.emG.LoadData();
            }
        }
    };
    private NoNetworkView.a emz = new NoNetworkView.a() { // from class: com.baidu.tieba.channel.activity.ChannelFansActivity.4
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void dP(boolean z) {
            if (z) {
                ChannelFansActivity.this.emG.hW(false);
                ChannelFansActivity.this.emG.LoadData();
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
        this.emG = new ChannelFansListModel(getPageContext(), this.channelId);
        this.emG.aAX();
        this.emG.a(this.emI);
        this.emG.hW(false);
    }

    private void initView() {
        this.emH = new d(this);
        this.emH.c(this.emz);
        this.emH.b(this.dlk);
        this.emH.a(new h.c() { // from class: com.baidu.tieba.channel.activity.ChannelFansActivity.1
            @Override // com.baidu.tbadk.core.view.h.c
            public void dR(boolean z) {
                if (l.lo()) {
                    ChannelFansActivity.this.emG.hW(false);
                    ChannelFansActivity.this.emG.LoadData();
                    return;
                }
                ChannelFansActivity.this.emH.aRC();
            }
        });
        this.emH.startPullRefresh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.emH.onDestroy();
        this.emG.removeListener();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.emH.onChangeSkinType(i);
    }
}
