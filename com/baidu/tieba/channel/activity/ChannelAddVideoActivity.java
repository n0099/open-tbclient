package com.baidu.tieba.channel.activity;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.channel.model.ChannelAddVideoModel;
import com.baidu.tieba.channel.view.a;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes3.dex */
public class ChannelAddVideoActivity extends BaseActivity<ChannelAddVideoActivity> {
    private long channelId;
    private ChannelAddVideoModel dbk;
    private a dbl;
    private ChannelAddVideoModel.b dbm = new ChannelAddVideoModel.b() { // from class: com.baidu.tieba.channel.activity.ChannelAddVideoActivity.1
        @Override // com.baidu.tieba.channel.model.ChannelAddVideoModel.b
        public void a(int i, String str, boolean z, com.baidu.tieba.channel.data.a aVar) {
            ChannelAddVideoActivity.this.closeLoadingDialog();
            if (i == 0) {
                ChannelAddVideoActivity.this.dbl.a(aVar);
                return;
            }
            ChannelAddVideoActivity.this.showToast(str);
            if (z) {
                ChannelAddVideoActivity.this.dbl.a(aVar);
            }
        }
    };
    private ChannelAddVideoModel.a dbn = new ChannelAddVideoModel.a() { // from class: com.baidu.tieba.channel.activity.ChannelAddVideoActivity.2
        @Override // com.baidu.tieba.channel.model.ChannelAddVideoModel.a
        public void E(int i, String str) {
            if (i != 0) {
                ChannelAddVideoActivity channelAddVideoActivity = ChannelAddVideoActivity.this;
                if (TextUtils.isEmpty(str)) {
                    str = ChannelAddVideoActivity.this.getResources().getString(d.j.neterror);
                }
                channelAddVideoActivity.showToast(str);
                return;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016511));
            ChannelAddVideoActivity.this.finish();
        }
    };
    private BdListView.e ckh = new BdListView.e() { // from class: com.baidu.tieba.channel.activity.ChannelAddVideoActivity.3
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (ChannelAddVideoActivity.this.dbk.isHasMore()) {
                ChannelAddVideoActivity.this.dbk.eT(true);
                ChannelAddVideoActivity.this.dbk.ams();
            }
        }
    };
    private NoNetworkView.a dbo = new NoNetworkView.a() { // from class: com.baidu.tieba.channel.activity.ChannelAddVideoActivity.4
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void bu(boolean z) {
            if (z) {
                ChannelAddVideoActivity.this.dbk.eT(false);
                ChannelAddVideoActivity.this.dbk.LoadData();
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
        this.dbk = new ChannelAddVideoModel(getPageContext());
        this.dbk.WM();
        this.dbk.a(this.dbm);
        this.dbk.a(this.dbn);
        this.dbk.eT(false);
    }

    private void initView() {
        this.dbl = new a(this);
        this.dbl.c(this.dbo);
        this.dbl.a(this.ckh);
        this.dbk.eT(false);
        this.dbk.ams();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.dbl.onDestroy();
        this.dbk.removeListener();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.dbl.onChangeSkinType(i);
    }

    public void aI(List<Long> list) {
        this.dbk.a(this.channelId, list);
    }

    public long getChannelId() {
        return this.channelId;
    }
}
