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
    private ChannelFansListModel dbE;
    private d dbF;
    private ChannelFansListModel.a dbG = new ChannelFansListModel.a() { // from class: com.baidu.tieba.channel.activity.ChannelFansActivity.2
        @Override // com.baidu.tieba.channel.model.ChannelFansListModel.a
        public void a(int i, String str, boolean z, c cVar) {
            ChannelFansActivity.this.closeLoadingDialog();
            ChannelFansActivity.this.dbF.amw();
            if (i == 0) {
                ChannelFansActivity.this.dbF.a(cVar);
                return;
            }
            ChannelFansActivity.this.showToast(str);
            if (z) {
                ChannelFansActivity.this.dbF.a(cVar);
            }
        }
    };
    private BdListView.e ckq = new BdListView.e() { // from class: com.baidu.tieba.channel.activity.ChannelFansActivity.3
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (ChannelFansActivity.this.dbE.isHasMore()) {
                ChannelFansActivity.this.dbE.eT(true);
                ChannelFansActivity.this.dbE.LoadData();
            }
        }
    };
    private NoNetworkView.a dbx = new NoNetworkView.a() { // from class: com.baidu.tieba.channel.activity.ChannelFansActivity.4
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void bu(boolean z) {
            if (z) {
                ChannelFansActivity.this.dbE.eT(false);
                ChannelFansActivity.this.dbE.LoadData();
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
        this.dbE = new ChannelFansListModel(getPageContext(), this.channelId);
        this.dbE.WM();
        this.dbE.a(this.dbG);
        this.dbE.eT(false);
    }

    private void initView() {
        this.dbF = new d(this);
        this.dbF.c(this.dbx);
        this.dbF.a(this.ckq);
        this.dbF.b(new j.b() { // from class: com.baidu.tieba.channel.activity.ChannelFansActivity.1
            @Override // com.baidu.tbadk.core.view.j.b
            public void bw(boolean z) {
                if (l.pa()) {
                    ChannelFansActivity.this.dbE.eT(false);
                    ChannelFansActivity.this.dbE.LoadData();
                    return;
                }
                ChannelFansActivity.this.dbF.amw();
            }
        });
        this.dbF.startPullRefresh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.dbF.onDestroy();
        this.dbE.removeListener();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.dbF.onChangeSkinType(i);
    }
}
