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
    private ChannelFansListModel eHo;
    private d eHp;
    private ChannelFansListModel.a eHq = new ChannelFansListModel.a() { // from class: com.baidu.tieba.channel.activity.ChannelFansActivity.2
        @Override // com.baidu.tieba.channel.model.ChannelFansListModel.a
        public void a(int i, String str, boolean z, c cVar) {
            ChannelFansActivity.this.closeLoadingDialog();
            ChannelFansActivity.this.eHp.baN();
            if (i == 0) {
                ChannelFansActivity.this.eHp.a(cVar);
                return;
            }
            ChannelFansActivity.this.showToast(str);
            if (z) {
                ChannelFansActivity.this.eHp.a(cVar);
            }
        }
    };
    private BdListView.e dyR = new BdListView.e() { // from class: com.baidu.tieba.channel.activity.ChannelFansActivity.3
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (ChannelFansActivity.this.eHo.isHasMore()) {
                ChannelFansActivity.this.eHo.iK(true);
                ChannelFansActivity.this.eHo.LoadData();
            }
        }
    };
    private NoNetworkView.a eHh = new NoNetworkView.a() { // from class: com.baidu.tieba.channel.activity.ChannelFansActivity.4
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void ep(boolean z) {
            if (z) {
                ChannelFansActivity.this.eHo.iK(false);
                ChannelFansActivity.this.eHo.LoadData();
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
        this.eHo = new ChannelFansListModel(getPageContext(), this.channelId);
        this.eHo.aIO();
        this.eHo.a(this.eHq);
        this.eHo.iK(false);
    }

    private void initView() {
        this.eHp = new d(this);
        this.eHp.c(this.eHh);
        this.eHp.b(this.dyR);
        this.eHp.a(new h.c() { // from class: com.baidu.tieba.channel.activity.ChannelFansActivity.1
            @Override // com.baidu.tbadk.core.view.h.c
            public void er(boolean z) {
                if (l.kt()) {
                    ChannelFansActivity.this.eHo.iK(false);
                    ChannelFansActivity.this.eHo.LoadData();
                    return;
                }
                ChannelFansActivity.this.eHp.baN();
            }
        });
        this.eHp.startPullRefresh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.eHp.onDestroy();
        this.eHo.removeListener();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.eHp.onChangeSkinType(i);
    }
}
