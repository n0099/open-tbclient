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
    private ChannelFansListModel cJl;
    private d cJm;
    private long channelId;
    private ChannelFansListModel.a cJn = new ChannelFansListModel.a() { // from class: com.baidu.tieba.channel.activity.ChannelFansActivity.2
        @Override // com.baidu.tieba.channel.model.ChannelFansListModel.a
        public void a(int i, String str, boolean z, c cVar) {
            ChannelFansActivity.this.closeLoadingDialog();
            ChannelFansActivity.this.cJm.alJ();
            if (i == 0) {
                ChannelFansActivity.this.cJm.a(cVar);
                return;
            }
            ChannelFansActivity.this.showToast(str);
            if (z) {
                ChannelFansActivity.this.cJm.a(cVar);
            }
        }
    };
    private BdListView.e bIp = new BdListView.e() { // from class: com.baidu.tieba.channel.activity.ChannelFansActivity.3
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (ChannelFansActivity.this.cJl.isHasMore()) {
                ChannelFansActivity.this.cJl.eV(true);
                ChannelFansActivity.this.cJl.LoadData();
            }
        }
    };
    private NoNetworkView.a cJe = new NoNetworkView.a() { // from class: com.baidu.tieba.channel.activity.ChannelFansActivity.4
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void bd(boolean z) {
            if (z) {
                ChannelFansActivity.this.cJl.eV(false);
                ChannelFansActivity.this.cJl.LoadData();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.channelId = getIntent().getLongExtra("channel_id", 0L);
        eL();
        initView();
    }

    private void eL() {
        this.cJl = new ChannelFansListModel(getPageContext(), this.channelId);
        this.cJl.Vb();
        this.cJl.a(this.cJn);
        this.cJl.eV(false);
    }

    private void initView() {
        this.cJm = new d(this);
        this.cJm.c(this.cJe);
        this.cJm.a(this.bIp);
        this.cJm.b(new j.b() { // from class: com.baidu.tieba.channel.activity.ChannelFansActivity.1
            @Override // com.baidu.tbadk.core.view.j.b
            public void bf(boolean z) {
                if (l.lb()) {
                    ChannelFansActivity.this.cJl.eV(false);
                    ChannelFansActivity.this.cJl.LoadData();
                    return;
                }
                ChannelFansActivity.this.cJm.alJ();
            }
        });
        this.cJm.startPullRefresh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.cJm.onDestroy();
        this.cJl.removeListener();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.cJm.onChangeSkinType(i);
    }
}
