package com.baidu.tieba.channel.activity;

import android.os.Bundle;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.e;
import com.baidu.tieba.channel.data.c;
import com.baidu.tieba.channel.model.ChannelFansListModel;
import com.baidu.tieba.channel.view.d;
/* loaded from: classes3.dex */
public class ChannelFansActivity extends BaseActivity<ChannelFansActivity> {
    private long channelId;
    private ChannelFansListModel ctk;
    private d ctl;
    private ChannelFansListModel.a ctm = new ChannelFansListModel.a() { // from class: com.baidu.tieba.channel.activity.ChannelFansActivity.2
        @Override // com.baidu.tieba.channel.model.ChannelFansListModel.a
        public void a(int i, String str, boolean z, c cVar) {
            ChannelFansActivity.this.closeLoadingDialog();
            ChannelFansActivity.this.ctl.agw();
            if (i == 0) {
                ChannelFansActivity.this.ctl.a(cVar);
                return;
            }
            ChannelFansActivity.this.showToast(str);
            if (z) {
                ChannelFansActivity.this.ctl.a(cVar);
            }
        }
    };
    private BdListView.e brx = new BdListView.e() { // from class: com.baidu.tieba.channel.activity.ChannelFansActivity.3
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (ChannelFansActivity.this.ctk.isHasMore()) {
                ChannelFansActivity.this.ctk.ey(true);
                ChannelFansActivity.this.ctk.LoadData();
            }
        }
    };
    private NoNetworkView.a ctd = new NoNetworkView.a() { // from class: com.baidu.tieba.channel.activity.ChannelFansActivity.4
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void aM(boolean z) {
            if (z) {
                ChannelFansActivity.this.ctk.ey(false);
                ChannelFansActivity.this.ctk.LoadData();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.channelId = getIntent().getLongExtra("channel_id", 0L);
        aS();
        initView();
    }

    private void aS() {
        this.ctk = new ChannelFansListModel(getPageContext(), this.channelId);
        this.ctk.Pm();
        this.ctk.a(this.ctm);
        this.ctk.ey(false);
    }

    private void initView() {
        this.ctl = new d(this);
        this.ctl.c(this.ctd);
        this.ctl.a(this.brx);
        this.ctl.b(new e.b() { // from class: com.baidu.tieba.channel.activity.ChannelFansActivity.1
            @Override // com.baidu.tbadk.core.view.e.b
            public void aO(boolean z) {
                if (l.hg()) {
                    ChannelFansActivity.this.ctk.ey(false);
                    ChannelFansActivity.this.ctk.LoadData();
                    return;
                }
                ChannelFansActivity.this.ctl.agw();
            }
        });
        this.ctl.startPullRefresh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.ctl.onDestroy();
        this.ctk.removeListener();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.ctl.onChangeSkinType(i);
    }
}
