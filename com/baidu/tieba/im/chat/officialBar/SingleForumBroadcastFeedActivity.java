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
/* loaded from: classes8.dex */
public class SingleForumBroadcastFeedActivity extends BaseActivity {
    private String forumId;
    private h kAs;
    private OfficialBarFeedMsglistView kAt;
    private byte kAu;
    private com.baidu.tbadk.mutiprocess.h mTopToastEventListener = new com.baidu.tbadk.mutiprocess.h<TopToastEvent>() { // from class: com.baidu.tieba.im.chat.officialBar.SingleForumBroadcastFeedActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.mutiprocess.b
        public boolean a(TopToastEvent topToastEvent) {
            if (SingleForumBroadcastFeedActivity.this.kAt != null) {
                SingleForumBroadcastFeedActivity.this.kAt.showTipToast(topToastEvent.isSuccess(), topToastEvent.getContent());
                return false;
            }
            return false;
        }
    };
    private h.a kAv = new h.a() { // from class: com.baidu.tieba.im.chat.officialBar.SingleForumBroadcastFeedActivity.2
        @Override // com.baidu.tieba.im.chat.officialBar.h.a
        public void es(List<com.baidu.tieba.im.message.chat.b> list) {
            SingleForumBroadcastFeedActivity.this.kAt.B(list, null);
        }

        @Override // com.baidu.tieba.im.chat.officialBar.h.a
        public void onReadCountLoad(LongSparseArray<com.baidu.tieba.im.forum.broadcast.data.b> longSparseArray) {
            SingleForumBroadcastFeedActivity.this.kAt.a(longSparseArray);
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.kAs = new h(getPageContext());
        this.kAs.a(this.kAv);
        this.kAt = new OfficialBarFeedMsglistView(this, true);
        if (getIntent() != null) {
            this.forumId = getIntent().getStringExtra("key_uid");
            this.kAu = getIntent().getByteExtra(SingleForumBroadcastFeedActivityConfig.KEY_SOURCE, (byte) 3);
            this.kAs.hz(this.forumId);
            this.kAt.K(this.forumId, System.currentTimeMillis());
        }
        registerResponsedEventListener(TopToastEvent.class, this.mTopToastEventListener);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.kAt.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(this.forumId, 4)));
        aq aqVar = new aq("c13870");
        aqVar.dX("uid", TbadkCoreApplication.getCurrentAccount());
        aqVar.dX("fid", this.forumId);
        aqVar.an("obj_source", this.kAu);
        TiebaStatic.log(aqVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.kAs != null) {
            this.kAs.destroy();
        }
        unRegisterResponsedEventListener();
    }
}
