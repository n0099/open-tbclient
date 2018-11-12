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
    private ChannelFansListModel cSK;
    private d cSL;
    private long channelId;
    private ChannelFansListModel.a cSM = new ChannelFansListModel.a() { // from class: com.baidu.tieba.channel.activity.ChannelFansActivity.2
        @Override // com.baidu.tieba.channel.model.ChannelFansListModel.a
        public void a(int i, String str, boolean z, c cVar) {
            ChannelFansActivity.this.closeLoadingDialog();
            ChannelFansActivity.this.cSL.aoN();
            if (i == 0) {
                ChannelFansActivity.this.cSL.a(cVar);
                return;
            }
            ChannelFansActivity.this.showToast(str);
            if (z) {
                ChannelFansActivity.this.cSL.a(cVar);
            }
        }
    };
    private BdListView.e bRC = new BdListView.e() { // from class: com.baidu.tieba.channel.activity.ChannelFansActivity.3
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (ChannelFansActivity.this.cSK.isHasMore()) {
                ChannelFansActivity.this.cSK.fy(true);
                ChannelFansActivity.this.cSK.LoadData();
            }
        }
    };
    private NoNetworkView.a cSD = new NoNetworkView.a() { // from class: com.baidu.tieba.channel.activity.ChannelFansActivity.4
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void bE(boolean z) {
            if (z) {
                ChannelFansActivity.this.cSK.fy(false);
                ChannelFansActivity.this.cSK.LoadData();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.channelId = getIntent().getLongExtra("channel_id", 0L);
        fc();
        initView();
    }

    private void fc() {
        this.cSK = new ChannelFansListModel(getPageContext(), this.channelId);
        this.cSK.YT();
        this.cSK.a(this.cSM);
        this.cSK.fy(false);
    }

    private void initView() {
        this.cSL = new d(this);
        this.cSL.c(this.cSD);
        this.cSL.a(this.bRC);
        this.cSL.b(new j.b() { // from class: com.baidu.tieba.channel.activity.ChannelFansActivity.1
            @Override // com.baidu.tbadk.core.view.j.b
            public void bG(boolean z) {
                if (l.lm()) {
                    ChannelFansActivity.this.cSK.fy(false);
                    ChannelFansActivity.this.cSK.LoadData();
                    return;
                }
                ChannelFansActivity.this.cSL.aoN();
            }
        });
        this.cSL.startPullRefresh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.cSL.onDestroy();
        this.cSK.removeListener();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.cSL.onChangeSkinType(i);
    }
}
