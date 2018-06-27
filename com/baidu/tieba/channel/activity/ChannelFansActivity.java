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
    private ChannelFansListModel cAS;
    private d cAT;
    private long channelId;
    private ChannelFansListModel.a cAU = new ChannelFansListModel.a() { // from class: com.baidu.tieba.channel.activity.ChannelFansActivity.2
        @Override // com.baidu.tieba.channel.model.ChannelFansListModel.a
        public void a(int i, String str, boolean z, c cVar) {
            ChannelFansActivity.this.closeLoadingDialog();
            ChannelFansActivity.this.cAT.ajy();
            if (i == 0) {
                ChannelFansActivity.this.cAT.a(cVar);
                return;
            }
            ChannelFansActivity.this.showToast(str);
            if (z) {
                ChannelFansActivity.this.cAT.a(cVar);
            }
        }
    };
    private BdListView.e bBR = new BdListView.e() { // from class: com.baidu.tieba.channel.activity.ChannelFansActivity.3
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (ChannelFansActivity.this.cAS.isHasMore()) {
                ChannelFansActivity.this.cAS.eD(true);
                ChannelFansActivity.this.cAS.LoadData();
            }
        }
    };
    private NoNetworkView.a cAL = new NoNetworkView.a() { // from class: com.baidu.tieba.channel.activity.ChannelFansActivity.4
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void aS(boolean z) {
            if (z) {
                ChannelFansActivity.this.cAS.eD(false);
                ChannelFansActivity.this.cAS.LoadData();
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
        this.cAS = new ChannelFansListModel(getPageContext(), this.channelId);
        this.cAS.Td();
        this.cAS.a(this.cAU);
        this.cAS.eD(false);
    }

    private void initView() {
        this.cAT = new d(this);
        this.cAT.c(this.cAL);
        this.cAT.a(this.bBR);
        this.cAT.b(new g.b() { // from class: com.baidu.tieba.channel.activity.ChannelFansActivity.1
            @Override // com.baidu.tbadk.core.view.g.b
            public void aU(boolean z) {
                if (l.jU()) {
                    ChannelFansActivity.this.cAS.eD(false);
                    ChannelFansActivity.this.cAS.LoadData();
                    return;
                }
                ChannelFansActivity.this.cAT.ajy();
            }
        });
        this.cAT.startPullRefresh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.cAT.onDestroy();
        this.cAS.removeListener();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.cAT.onChangeSkinType(i);
    }
}
