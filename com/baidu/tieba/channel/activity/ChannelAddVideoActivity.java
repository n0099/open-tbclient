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
    private ChannelAddVideoModel cCN;
    private a cCO;
    private long channelId;
    private ChannelAddVideoModel.b cCP = new ChannelAddVideoModel.b() { // from class: com.baidu.tieba.channel.activity.ChannelAddVideoActivity.1
        @Override // com.baidu.tieba.channel.model.ChannelAddVideoModel.b
        public void a(int i, String str, boolean z, com.baidu.tieba.channel.data.a aVar) {
            ChannelAddVideoActivity.this.closeLoadingDialog();
            if (i == 0) {
                ChannelAddVideoActivity.this.cCO.a(aVar);
                return;
            }
            ChannelAddVideoActivity.this.showToast(str);
            if (z) {
                ChannelAddVideoActivity.this.cCO.a(aVar);
            }
        }
    };
    private ChannelAddVideoModel.a cCQ = new ChannelAddVideoModel.a() { // from class: com.baidu.tieba.channel.activity.ChannelAddVideoActivity.2
        @Override // com.baidu.tieba.channel.model.ChannelAddVideoModel.a
        public void N(int i, String str) {
            if (i != 0) {
                ChannelAddVideoActivity channelAddVideoActivity = ChannelAddVideoActivity.this;
                if (TextUtils.isEmpty(str)) {
                    str = ChannelAddVideoActivity.this.getResources().getString(d.k.neterror);
                }
                channelAddVideoActivity.showToast(str);
                return;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016511));
            ChannelAddVideoActivity.this.finish();
        }
    };
    private BdListView.e bzR = new BdListView.e() { // from class: com.baidu.tieba.channel.activity.ChannelAddVideoActivity.3
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (ChannelAddVideoActivity.this.cCN.isHasMore()) {
                ChannelAddVideoActivity.this.cCN.eD(true);
                ChannelAddVideoActivity.this.cCN.aka();
            }
        }
    };
    private NoNetworkView.a cCR = new NoNetworkView.a() { // from class: com.baidu.tieba.channel.activity.ChannelAddVideoActivity.4
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void aQ(boolean z) {
            if (z) {
                ChannelAddVideoActivity.this.cCN.eD(false);
                ChannelAddVideoActivity.this.cCN.LoadData();
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
        this.cCN = new ChannelAddVideoModel(getPageContext());
        this.cCN.SH();
        this.cCN.a(this.cCP);
        this.cCN.a(this.cCQ);
        this.cCN.eD(false);
    }

    private void initView() {
        this.cCO = new a(this);
        this.cCO.c(this.cCR);
        this.cCO.a(this.bzR);
        this.cCN.eD(false);
        this.cCN.aka();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.cCO.onDestroy();
        this.cCN.removeListener();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.cCO.onChangeSkinType(i);
    }

    public void aJ(List<Long> list) {
        this.cCN.a(this.channelId, list);
    }

    public long getChannelId() {
        return this.channelId;
    }
}
