package com.baidu.tieba.channel.activity;

import android.os.Bundle;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.f;
import com.baidu.tieba.channel.data.c;
import com.baidu.tieba.channel.model.ChannelFansListModel;
import com.baidu.tieba.channel.view.d;
/* loaded from: classes3.dex */
public class ChannelFansActivity extends BaseActivity<ChannelFansActivity> {
    private ChannelFansListModel cCY;
    private d cCZ;
    private long channelId;
    private ChannelFansListModel.a cDa = new ChannelFansListModel.a() { // from class: com.baidu.tieba.channel.activity.ChannelFansActivity.2
        @Override // com.baidu.tieba.channel.model.ChannelFansListModel.a
        public void a(int i, String str, boolean z, c cVar) {
            ChannelFansActivity.this.closeLoadingDialog();
            ChannelFansActivity.this.cCZ.ake();
            if (i == 0) {
                ChannelFansActivity.this.cCZ.a(cVar);
                return;
            }
            ChannelFansActivity.this.showToast(str);
            if (z) {
                ChannelFansActivity.this.cCZ.a(cVar);
            }
        }
    };
    private BdListView.e bzR = new BdListView.e() { // from class: com.baidu.tieba.channel.activity.ChannelFansActivity.3
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (ChannelFansActivity.this.cCY.isHasMore()) {
                ChannelFansActivity.this.cCY.eD(true);
                ChannelFansActivity.this.cCY.LoadData();
            }
        }
    };
    private NoNetworkView.a cCR = new NoNetworkView.a() { // from class: com.baidu.tieba.channel.activity.ChannelFansActivity.4
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void aQ(boolean z) {
            if (z) {
                ChannelFansActivity.this.cCY.eD(false);
                ChannelFansActivity.this.cCY.LoadData();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.channelId = getIntent().getLongExtra("channel_id", 0L);
        dG();
        initView();
    }

    private void dG() {
        this.cCY = new ChannelFansListModel(getPageContext(), this.channelId);
        this.cCY.SH();
        this.cCY.a(this.cDa);
        this.cCY.eD(false);
    }

    private void initView() {
        this.cCZ = new d(this);
        this.cCZ.c(this.cCR);
        this.cCZ.a(this.bzR);
        this.cCZ.b(new f.b() { // from class: com.baidu.tieba.channel.activity.ChannelFansActivity.1
            @Override // com.baidu.tbadk.core.view.f.b
            public void aS(boolean z) {
                if (l.jU()) {
                    ChannelFansActivity.this.cCY.eD(false);
                    ChannelFansActivity.this.cCY.LoadData();
                    return;
                }
                ChannelFansActivity.this.cCZ.ake();
            }
        });
        this.cCZ.startPullRefresh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.cCZ.onDestroy();
        this.cCY.removeListener();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.cCZ.onChangeSkinType(i);
    }
}
