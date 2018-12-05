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
import com.baidu.tieba.e;
import java.util.List;
/* loaded from: classes3.dex */
public class ChannelAddVideoActivity extends BaseActivity<ChannelAddVideoActivity> {
    private ChannelAddVideoModel cZg;
    private a cZh;
    private long channelId;
    private ChannelAddVideoModel.b cZi = new ChannelAddVideoModel.b() { // from class: com.baidu.tieba.channel.activity.ChannelAddVideoActivity.1
        @Override // com.baidu.tieba.channel.model.ChannelAddVideoModel.b
        public void a(int i, String str, boolean z, com.baidu.tieba.channel.data.a aVar) {
            ChannelAddVideoActivity.this.closeLoadingDialog();
            if (i == 0) {
                ChannelAddVideoActivity.this.cZh.a(aVar);
                return;
            }
            ChannelAddVideoActivity.this.showToast(str);
            if (z) {
                ChannelAddVideoActivity.this.cZh.a(aVar);
            }
        }
    };
    private ChannelAddVideoModel.a cZj = new ChannelAddVideoModel.a() { // from class: com.baidu.tieba.channel.activity.ChannelAddVideoActivity.2
        @Override // com.baidu.tieba.channel.model.ChannelAddVideoModel.a
        public void I(int i, String str) {
            if (i != 0) {
                ChannelAddVideoActivity channelAddVideoActivity = ChannelAddVideoActivity.this;
                if (TextUtils.isEmpty(str)) {
                    str = ChannelAddVideoActivity.this.getResources().getString(e.j.neterror);
                }
                channelAddVideoActivity.showToast(str);
                return;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016511));
            ChannelAddVideoActivity.this.finish();
        }
    };
    private BdListView.e bVt = new BdListView.e() { // from class: com.baidu.tieba.channel.activity.ChannelAddVideoActivity.3
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (ChannelAddVideoActivity.this.cZg.isHasMore()) {
                ChannelAddVideoActivity.this.cZg.fz(true);
                ChannelAddVideoActivity.this.cZg.aqx();
            }
        }
    };
    private NoNetworkView.a cZk = new NoNetworkView.a() { // from class: com.baidu.tieba.channel.activity.ChannelAddVideoActivity.4
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void bF(boolean z) {
            if (z) {
                ChannelAddVideoActivity.this.cZg.fz(false);
                ChannelAddVideoActivity.this.cZg.LoadData();
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
        this.cZg = new ChannelAddVideoModel(getPageContext());
        this.cZg.ZZ();
        this.cZg.a(this.cZi);
        this.cZg.a(this.cZj);
        this.cZg.fz(false);
    }

    private void initView() {
        this.cZh = new a(this);
        this.cZh.c(this.cZk);
        this.cZh.a(this.bVt);
        this.cZg.fz(false);
        this.cZg.aqx();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.cZh.onDestroy();
        this.cZg.removeListener();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.cZh.onChangeSkinType(i);
    }

    public void ba(List<Long> list) {
        this.cZg.a(this.channelId, list);
    }

    public long getChannelId() {
        return this.channelId;
    }
}
