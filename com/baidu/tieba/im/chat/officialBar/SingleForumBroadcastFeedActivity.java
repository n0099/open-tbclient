package com.baidu.tieba.im.chat.officialBar;

import android.os.Bundle;
import android.util.LongSparseArray;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.SingleForumBroadcastFeedActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.live.message.MemoryClearUnreadCountMessage;
import com.baidu.tieba.im.chat.officialBar.i;
import java.util.List;
/* loaded from: classes20.dex */
public class SingleForumBroadcastFeedActivity extends BaseActivity {
    private String forumId;
    private i iUu;
    private OfficialBarFeedMsglistView iUv;
    private byte iUw;
    private i.a iUx = new i.a() { // from class: com.baidu.tieba.im.chat.officialBar.SingleForumBroadcastFeedActivity.1
        @Override // com.baidu.tieba.im.chat.officialBar.i.a
        public void dr(List<com.baidu.tieba.im.message.chat.b> list) {
            SingleForumBroadcastFeedActivity.this.iUv.r(list, null);
        }

        @Override // com.baidu.tieba.im.chat.officialBar.i.a
        public void onReadCountLoad(LongSparseArray<com.baidu.tieba.im.forum.broadcast.data.b> longSparseArray) {
            SingleForumBroadcastFeedActivity.this.iUv.a(longSparseArray);
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.iUu = new i(getPageContext());
        this.iUu.a(this.iUx);
        this.iUv = new OfficialBarFeedMsglistView(this, true);
        if (getIntent() != null) {
            this.forumId = getIntent().getStringExtra("key_uid");
            this.iUw = getIntent().getByteExtra(SingleForumBroadcastFeedActivityConfig.KEY_SOURCE, (byte) 3);
            this.iUu.GD(this.forumId);
            this.iUv.E(this.forumId, System.currentTimeMillis());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.iUv.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(this.forumId, 4)));
        ap apVar = new ap("c13870");
        if (com.baidu.tbadk.getUserInfo.b.bkd().bkf() != null) {
            apVar.dn("uid", com.baidu.tbadk.getUserInfo.b.bkd().bkf().getUserId());
        }
        apVar.dn("fid", this.forumId);
        apVar.ah("obj_source", this.iUw);
        TiebaStatic.log(apVar);
    }
}
