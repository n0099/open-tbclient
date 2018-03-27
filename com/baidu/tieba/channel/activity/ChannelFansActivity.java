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
    private long channelId;
    private ChannelFansListModel dbv;
    private d dbw;
    private ChannelFansListModel.a dbx = new ChannelFansListModel.a() { // from class: com.baidu.tieba.channel.activity.ChannelFansActivity.2
        @Override // com.baidu.tieba.channel.model.ChannelFansListModel.a
        public void a(int i, String str, boolean z, c cVar) {
            ChannelFansActivity.this.closeLoadingDialog();
            ChannelFansActivity.this.dbw.amw();
            if (i == 0) {
                ChannelFansActivity.this.dbw.a(cVar);
                return;
            }
            ChannelFansActivity.this.showToast(str);
            if (z) {
                ChannelFansActivity.this.dbw.a(cVar);
            }
        }
    };
    private BdListView.e ckh = new BdListView.e() { // from class: com.baidu.tieba.channel.activity.ChannelFansActivity.3
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (ChannelFansActivity.this.dbv.isHasMore()) {
                ChannelFansActivity.this.dbv.eT(true);
                ChannelFansActivity.this.dbv.LoadData();
            }
        }
    };
    private NoNetworkView.a dbo = new NoNetworkView.a() { // from class: com.baidu.tieba.channel.activity.ChannelFansActivity.4
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void bu(boolean z) {
            if (z) {
                ChannelFansActivity.this.dbv.eT(false);
                ChannelFansActivity.this.dbv.LoadData();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.channelId = getIntent().getLongExtra("channel_id", 0L);
        iO();
        initView();
    }

    private void iO() {
        this.dbv = new ChannelFansListModel(getPageContext(), this.channelId);
        this.dbv.WM();
        this.dbv.a(this.dbx);
        this.dbv.eT(false);
    }

    private void initView() {
        this.dbw = new d(this);
        this.dbw.c(this.dbo);
        this.dbw.a(this.ckh);
        this.dbw.b(new j.b() { // from class: com.baidu.tieba.channel.activity.ChannelFansActivity.1
            @Override // com.baidu.tbadk.core.view.j.b
            public void bw(boolean z) {
                if (l.pa()) {
                    ChannelFansActivity.this.dbv.eT(false);
                    ChannelFansActivity.this.dbv.LoadData();
                    return;
                }
                ChannelFansActivity.this.dbw.amw();
            }
        });
        this.dbw.startPullRefresh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.dbw.onDestroy();
        this.dbv.removeListener();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.dbw.onChangeSkinType(i);
    }
}
