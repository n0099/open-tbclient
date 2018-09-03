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
    private ChannelFansListModel cDu;
    private d cDv;
    private long channelId;
    private ChannelFansListModel.a cDw = new ChannelFansListModel.a() { // from class: com.baidu.tieba.channel.activity.ChannelFansActivity.2
        @Override // com.baidu.tieba.channel.model.ChannelFansListModel.a
        public void a(int i, String str, boolean z, c cVar) {
            ChannelFansActivity.this.closeLoadingDialog();
            ChannelFansActivity.this.cDv.ajY();
            if (i == 0) {
                ChannelFansActivity.this.cDv.a(cVar);
                return;
            }
            ChannelFansActivity.this.showToast(str);
            if (z) {
                ChannelFansActivity.this.cDv.a(cVar);
            }
        }
    };
    private BdListView.e bCA = new BdListView.e() { // from class: com.baidu.tieba.channel.activity.ChannelFansActivity.3
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (ChannelFansActivity.this.cDu.isHasMore()) {
                ChannelFansActivity.this.cDu.eE(true);
                ChannelFansActivity.this.cDu.LoadData();
            }
        }
    };
    private NoNetworkView.a cDn = new NoNetworkView.a() { // from class: com.baidu.tieba.channel.activity.ChannelFansActivity.4
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void aR(boolean z) {
            if (z) {
                ChannelFansActivity.this.cDu.eE(false);
                ChannelFansActivity.this.cDu.LoadData();
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
        this.cDu = new ChannelFansListModel(getPageContext(), this.channelId);
        this.cDu.To();
        this.cDu.a(this.cDw);
        this.cDu.eE(false);
    }

    private void initView() {
        this.cDv = new d(this);
        this.cDv.c(this.cDn);
        this.cDv.a(this.bCA);
        this.cDv.b(new g.b() { // from class: com.baidu.tieba.channel.activity.ChannelFansActivity.1
            @Override // com.baidu.tbadk.core.view.g.b
            public void aT(boolean z) {
                if (l.jV()) {
                    ChannelFansActivity.this.cDu.eE(false);
                    ChannelFansActivity.this.cDu.LoadData();
                    return;
                }
                ChannelFansActivity.this.cDv.ajY();
            }
        });
        this.cDv.startPullRefresh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.cDv.onDestroy();
        this.cDu.removeListener();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.cDv.onChangeSkinType(i);
    }
}
