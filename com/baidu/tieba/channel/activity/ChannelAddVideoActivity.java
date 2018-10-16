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
    private ChannelAddVideoModel cRt;
    private a cRu;
    private long channelId;
    private ChannelAddVideoModel.b cRv = new ChannelAddVideoModel.b() { // from class: com.baidu.tieba.channel.activity.ChannelAddVideoActivity.1
        @Override // com.baidu.tieba.channel.model.ChannelAddVideoModel.b
        public void a(int i, String str, boolean z, com.baidu.tieba.channel.data.a aVar) {
            ChannelAddVideoActivity.this.closeLoadingDialog();
            if (i == 0) {
                ChannelAddVideoActivity.this.cRu.a(aVar);
                return;
            }
            ChannelAddVideoActivity.this.showToast(str);
            if (z) {
                ChannelAddVideoActivity.this.cRu.a(aVar);
            }
        }
    };
    private ChannelAddVideoModel.a cRw = new ChannelAddVideoModel.a() { // from class: com.baidu.tieba.channel.activity.ChannelAddVideoActivity.2
        @Override // com.baidu.tieba.channel.model.ChannelAddVideoModel.a
        public void M(int i, String str) {
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
    private BdListView.e bQS = new BdListView.e() { // from class: com.baidu.tieba.channel.activity.ChannelAddVideoActivity.3
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (ChannelAddVideoActivity.this.cRt.isHasMore()) {
                ChannelAddVideoActivity.this.cRt.fn(true);
                ChannelAddVideoActivity.this.cRt.apj();
            }
        }
    };
    private NoNetworkView.a cRx = new NoNetworkView.a() { // from class: com.baidu.tieba.channel.activity.ChannelAddVideoActivity.4
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void bn(boolean z) {
            if (z) {
                ChannelAddVideoActivity.this.cRt.fn(false);
                ChannelAddVideoActivity.this.cRt.LoadData();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.channelId = getIntent().getLongExtra("channel_id", 0L);
        fd();
        initView();
    }

    private void fd() {
        this.cRt = new ChannelAddVideoModel(getPageContext());
        this.cRt.YI();
        this.cRt.a(this.cRv);
        this.cRt.a(this.cRw);
        this.cRt.fn(false);
    }

    private void initView() {
        this.cRu = new a(this);
        this.cRu.c(this.cRx);
        this.cRu.a(this.bQS);
        this.cRt.fn(false);
        this.cRt.apj();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.cRu.onDestroy();
        this.cRt.removeListener();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.cRu.onChangeSkinType(i);
    }

    public void ba(List<Long> list) {
        this.cRt.a(this.channelId, list);
    }

    public long getChannelId() {
        return this.channelId;
    }
}
