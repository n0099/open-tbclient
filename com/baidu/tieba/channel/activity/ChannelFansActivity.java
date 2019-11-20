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
    private ChannelFansListModel eQS;
    private d eQT;
    private ChannelFansListModel.a eQU = new ChannelFansListModel.a() { // from class: com.baidu.tieba.channel.activity.ChannelFansActivity.2
        @Override // com.baidu.tieba.channel.model.ChannelFansListModel.a
        public void a(int i, String str, boolean z, c cVar) {
            ChannelFansActivity.this.closeLoadingDialog();
            ChannelFansActivity.this.eQT.bbw();
            if (i == 0) {
                ChannelFansActivity.this.eQT.a(cVar);
                return;
            }
            ChannelFansActivity.this.showToast(str);
            if (z) {
                ChannelFansActivity.this.eQT.a(cVar);
            }
        }
    };
    private BdListView.e dIG = new BdListView.e() { // from class: com.baidu.tieba.channel.activity.ChannelFansActivity.3
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (ChannelFansActivity.this.eQS.isHasMore()) {
                ChannelFansActivity.this.eQS.iQ(true);
                ChannelFansActivity.this.eQS.LoadData();
            }
        }
    };
    private NoNetworkView.a eQL = new NoNetworkView.a() { // from class: com.baidu.tieba.channel.activity.ChannelFansActivity.4
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            if (z) {
                ChannelFansActivity.this.eQS.iQ(false);
                ChannelFansActivity.this.eQS.LoadData();
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
        this.eQS = new ChannelFansListModel(getPageContext(), this.channelId);
        this.eQS.aIS();
        this.eQS.a(this.eQU);
        this.eQS.iQ(false);
    }

    private void initView() {
        this.eQT = new d(this);
        this.eQT.c(this.eQL);
        this.eQT.b(this.dIG);
        this.eQT.a(new h.c() { // from class: com.baidu.tieba.channel.activity.ChannelFansActivity.1
            @Override // com.baidu.tbadk.core.view.h.c
            public void onListPullRefresh(boolean z) {
                if (l.isNetOk()) {
                    ChannelFansActivity.this.eQS.iQ(false);
                    ChannelFansActivity.this.eQS.LoadData();
                    return;
                }
                ChannelFansActivity.this.eQT.bbw();
            }
        });
        this.eQT.startPullRefresh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.eQT.onDestroy();
        this.eQS.removeListener();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.eQT.onChangeSkinType(i);
    }
}
