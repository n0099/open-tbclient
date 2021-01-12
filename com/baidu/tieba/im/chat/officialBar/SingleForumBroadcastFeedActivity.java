package com.baidu.tieba.im.chat.officialBar;

import android.os.Bundle;
import android.util.LongSparseArray;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.SingleForumBroadcastFeedActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.live.message.MemoryClearUnreadCountMessage;
import com.baidu.tbadk.mutiprocess.event.TopToastEvent;
import com.baidu.tieba.im.chat.officialBar.h;
import java.util.List;
/* loaded from: classes7.dex */
public class SingleForumBroadcastFeedActivity extends BaseActivity {
    private String forumId;
    private h kvN;
    private OfficialBarFeedMsglistView kvO;
    private byte kvP;
    private com.baidu.tbadk.mutiprocess.h mTopToastEventListener = new com.baidu.tbadk.mutiprocess.h<TopToastEvent>() { // from class: com.baidu.tieba.im.chat.officialBar.SingleForumBroadcastFeedActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.mutiprocess.b
        public boolean a(TopToastEvent topToastEvent) {
            if (SingleForumBroadcastFeedActivity.this.kvO != null) {
                SingleForumBroadcastFeedActivity.this.kvO.showTipToast(topToastEvent.isSuccess(), topToastEvent.getContent());
                return false;
            }
            return false;
        }
    };
    private h.a kvQ = new h.a() { // from class: com.baidu.tieba.im.chat.officialBar.SingleForumBroadcastFeedActivity.2
        @Override // com.baidu.tieba.im.chat.officialBar.h.a
        public void es(List<com.baidu.tieba.im.message.chat.b> list) {
            SingleForumBroadcastFeedActivity.this.kvO.B(list, null);
        }

        @Override // com.baidu.tieba.im.chat.officialBar.h.a
        public void onReadCountLoad(LongSparseArray<com.baidu.tieba.im.forum.broadcast.data.b> longSparseArray) {
            SingleForumBroadcastFeedActivity.this.kvO.a(longSparseArray);
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.kvN = new h(getPageContext());
        this.kvN.a(this.kvQ);
        this.kvO = new OfficialBarFeedMsglistView(this, true);
        if (getIntent() != null) {
            this.forumId = getIntent().getStringExtra("key_uid");
            this.kvP = getIntent().getByteExtra(SingleForumBroadcastFeedActivityConfig.KEY_SOURCE, (byte) 3);
            this.kvN.gn(this.forumId);
            this.kvO.K(this.forumId, System.currentTimeMillis());
        }
        registerResponsedEventListener(TopToastEvent.class, this.mTopToastEventListener);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.kvO.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(this.forumId, 4)));
        aq aqVar = new aq("c13870");
        aqVar.dW("uid", TbadkCoreApplication.getCurrentAccount());
        aqVar.dW("fid", this.forumId);
        aqVar.an("obj_source", this.kvP);
        TiebaStatic.log(aqVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.kvN != null) {
            this.kvN.destroy();
        }
        unRegisterResponsedEventListener();
    }
}
