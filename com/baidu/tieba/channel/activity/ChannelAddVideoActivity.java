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
/* loaded from: classes6.dex */
public class ChannelAddVideoActivity extends BaseActivity<ChannelAddVideoActivity> {
    private long channelId;
    private ChannelAddVideoModel emI;
    private a emJ;
    private ChannelAddVideoModel.b emK = new ChannelAddVideoModel.b() { // from class: com.baidu.tieba.channel.activity.ChannelAddVideoActivity.1
        @Override // com.baidu.tieba.channel.model.ChannelAddVideoModel.b
        public void a(int i, String str, boolean z, com.baidu.tieba.channel.data.a aVar) {
            ChannelAddVideoActivity.this.closeLoadingDialog();
            if (i == 0) {
                ChannelAddVideoActivity.this.emJ.a(aVar);
                return;
            }
            ChannelAddVideoActivity.this.showToast(str);
            if (z) {
                ChannelAddVideoActivity.this.emJ.a(aVar);
            }
        }
    };
    private ChannelAddVideoModel.a emL = new ChannelAddVideoModel.a() { // from class: com.baidu.tieba.channel.activity.ChannelAddVideoActivity.2
        @Override // com.baidu.tieba.channel.model.ChannelAddVideoModel.a
        public void ab(int i, String str) {
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
    private BdListView.e dlg = new BdListView.e() { // from class: com.baidu.tieba.channel.activity.ChannelAddVideoActivity.3
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (ChannelAddVideoActivity.this.emI.isHasMore()) {
                ChannelAddVideoActivity.this.emI.hW(true);
                ChannelAddVideoActivity.this.emI.aRB();
            }
        }
    };
    private NoNetworkView.a emM = new NoNetworkView.a() { // from class: com.baidu.tieba.channel.activity.ChannelAddVideoActivity.4
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void dP(boolean z) {
            if (z) {
                ChannelAddVideoActivity.this.emI.hW(false);
                ChannelAddVideoActivity.this.emI.LoadData();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.channelId = getIntent().getLongExtra("channel_id", 0L);
        fb();
        initView();
    }

    private void fb() {
        this.emI = new ChannelAddVideoModel(getPageContext());
        this.emI.aBa();
        this.emI.a(this.emK);
        this.emI.a(this.emL);
        this.emI.hW(false);
    }

    private void initView() {
        this.emJ = new a(this);
        this.emJ.c(this.emM);
        this.emJ.b(this.dlg);
        this.emI.hW(false);
        this.emI.aRB();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.emJ.onDestroy();
        this.emI.removeListener();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.emJ.onChangeSkinType(i);
    }

    public void bq(List<Long> list) {
        this.emI.a(this.channelId, list);
    }

    public long getChannelId() {
        return this.channelId;
    }
}
