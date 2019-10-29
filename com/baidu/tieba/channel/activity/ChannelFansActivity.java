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
    private ChannelFansListModel eRJ;
    private d eRK;
    private ChannelFansListModel.a eRL = new ChannelFansListModel.a() { // from class: com.baidu.tieba.channel.activity.ChannelFansActivity.2
        @Override // com.baidu.tieba.channel.model.ChannelFansListModel.a
        public void a(int i, String str, boolean z, c cVar) {
            ChannelFansActivity.this.closeLoadingDialog();
            ChannelFansActivity.this.eRK.bby();
            if (i == 0) {
                ChannelFansActivity.this.eRK.a(cVar);
                return;
            }
            ChannelFansActivity.this.showToast(str);
            if (z) {
                ChannelFansActivity.this.eRK.a(cVar);
            }
        }
    };
    private BdListView.e dJx = new BdListView.e() { // from class: com.baidu.tieba.channel.activity.ChannelFansActivity.3
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (ChannelFansActivity.this.eRJ.isHasMore()) {
                ChannelFansActivity.this.eRJ.iQ(true);
                ChannelFansActivity.this.eRJ.LoadData();
            }
        }
    };
    private NoNetworkView.a eRC = new NoNetworkView.a() { // from class: com.baidu.tieba.channel.activity.ChannelFansActivity.4
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            if (z) {
                ChannelFansActivity.this.eRJ.iQ(false);
                ChannelFansActivity.this.eRJ.LoadData();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.channelId = getIntent().getLongExtra("channel_id", 0L);
        dv();
        initView();
    }

    private void dv() {
        this.eRJ = new ChannelFansListModel(getPageContext(), this.channelId);
        this.eRJ.aIU();
        this.eRJ.a(this.eRL);
        this.eRJ.iQ(false);
    }

    private void initView() {
        this.eRK = new d(this);
        this.eRK.c(this.eRC);
        this.eRK.b(this.dJx);
        this.eRK.a(new h.c() { // from class: com.baidu.tieba.channel.activity.ChannelFansActivity.1
            @Override // com.baidu.tbadk.core.view.h.c
            public void onListPullRefresh(boolean z) {
                if (l.isNetOk()) {
                    ChannelFansActivity.this.eRJ.iQ(false);
                    ChannelFansActivity.this.eRJ.LoadData();
                    return;
                }
                ChannelFansActivity.this.eRK.bby();
            }
        });
        this.eRK.startPullRefresh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.eRK.onDestroy();
        this.eRJ.removeListener();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.eRK.onChangeSkinType(i);
    }
}
