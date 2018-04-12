package com.baidu.tieba.channel.activity;

import android.os.Bundle;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.e;
import com.baidu.tieba.channel.data.e;
import com.baidu.tieba.channel.model.ChannelListModel;
import com.baidu.tieba.channel.view.j;
/* loaded from: classes3.dex */
public class ChannelListActivity extends BaseActivity<ChannelListActivity> {
    private ChannelListModel ctG;
    private j ctH;
    private String mUserId;
    private ChannelListModel.a ctI = new ChannelListModel.a() { // from class: com.baidu.tieba.channel.activity.ChannelListActivity.2
        @Override // com.baidu.tieba.channel.model.ChannelListModel.a
        public void a(int i, String str, boolean z, e eVar) {
            ChannelListActivity.this.closeLoadingDialog();
            ChannelListActivity.this.ctH.agw();
            if (i == 0) {
                ChannelListActivity.this.ctH.a(eVar);
                return;
            }
            ChannelListActivity.this.showToast(str);
            if (z) {
                ChannelListActivity.this.ctH.a(eVar);
            }
        }
    };
    private BdListView.e brx = new BdListView.e() { // from class: com.baidu.tieba.channel.activity.ChannelListActivity.3
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (ChannelListActivity.this.ctG.isHasMore()) {
                ChannelListActivity.this.ctG.ey(true);
                ChannelListActivity.this.ctG.LoadData();
            }
        }
    };
    private NoNetworkView.a ctg = new NoNetworkView.a() { // from class: com.baidu.tieba.channel.activity.ChannelListActivity.4
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void aM(boolean z) {
            if (z) {
                ChannelListActivity.this.ctG.ey(false);
                ChannelListActivity.this.ctG.LoadData();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mUserId = getIntent().getStringExtra("user_id");
        aS();
        initView();
    }

    private void aS() {
        this.ctG = new ChannelListModel(getPageContext(), this.mUserId);
        this.ctG.Pm();
        this.ctG.a(this.ctI);
        this.ctG.ey(false);
    }

    private void initView() {
        this.ctH = new j(this);
        this.ctH.c(this.ctg);
        this.ctH.a(this.brx);
        this.ctH.b(new e.b() { // from class: com.baidu.tieba.channel.activity.ChannelListActivity.1
            @Override // com.baidu.tbadk.core.view.e.b
            public void aO(boolean z) {
                if (l.hg()) {
                    ChannelListActivity.this.ctG.ey(false);
                    ChannelListActivity.this.ctG.LoadData();
                    return;
                }
                ChannelListActivity.this.ctH.agw();
            }
        });
        this.ctH.startPullRefresh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.ctH.onDestroy();
        this.ctG.removeListener();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.ctH.onChangeSkinType(i);
    }
}
