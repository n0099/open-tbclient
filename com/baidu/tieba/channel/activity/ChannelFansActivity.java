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
    private ChannelFansListModel ctn;
    private d cto;
    private ChannelFansListModel.a ctp = new ChannelFansListModel.a() { // from class: com.baidu.tieba.channel.activity.ChannelFansActivity.2
        @Override // com.baidu.tieba.channel.model.ChannelFansListModel.a
        public void a(int i, String str, boolean z, c cVar) {
            ChannelFansActivity.this.closeLoadingDialog();
            ChannelFansActivity.this.cto.agw();
            if (i == 0) {
                ChannelFansActivity.this.cto.a(cVar);
                return;
            }
            ChannelFansActivity.this.showToast(str);
            if (z) {
                ChannelFansActivity.this.cto.a(cVar);
            }
        }
    };
    private BdListView.e brx = new BdListView.e() { // from class: com.baidu.tieba.channel.activity.ChannelFansActivity.3
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (ChannelFansActivity.this.ctn.isHasMore()) {
                ChannelFansActivity.this.ctn.ey(true);
                ChannelFansActivity.this.ctn.LoadData();
            }
        }
    };
    private NoNetworkView.a ctg = new NoNetworkView.a() { // from class: com.baidu.tieba.channel.activity.ChannelFansActivity.4
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void aM(boolean z) {
            if (z) {
                ChannelFansActivity.this.ctn.ey(false);
                ChannelFansActivity.this.ctn.LoadData();
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
        this.ctn = new ChannelFansListModel(getPageContext(), this.channelId);
        this.ctn.Pm();
        this.ctn.a(this.ctp);
        this.ctn.ey(false);
    }

    private void initView() {
        this.cto = new d(this);
        this.cto.c(this.ctg);
        this.cto.a(this.brx);
        this.cto.b(new e.b() { // from class: com.baidu.tieba.channel.activity.ChannelFansActivity.1
            @Override // com.baidu.tbadk.core.view.e.b
            public void aO(boolean z) {
                if (l.hg()) {
                    ChannelFansActivity.this.ctn.ey(false);
                    ChannelFansActivity.this.ctn.LoadData();
                    return;
                }
                ChannelFansActivity.this.cto.agw();
            }
        });
        this.cto.startPullRefresh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.cto.onDestroy();
        this.ctn.removeListener();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.cto.onChangeSkinType(i);
    }
}
