package com.baidu.tieba.im.chat.officialBar;

import android.os.Bundle;
import android.util.LongSparseArray;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.SingleForumBroadcastFeedActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.live.message.MemoryClearUnreadCountMessage;
import com.baidu.tbadk.mutiprocess.event.TopToastEvent;
import com.baidu.tieba.im.chat.officialBar.h;
import java.util.List;
/* loaded from: classes8.dex */
public class SingleForumBroadcastFeedActivity extends BaseActivity {
    private String forumId;
    private h kEh;
    private OfficialBarFeedMsglistView kEi;
    private byte kEj;
    private com.baidu.tbadk.mutiprocess.h mTopToastEventListener = new com.baidu.tbadk.mutiprocess.h<TopToastEvent>() { // from class: com.baidu.tieba.im.chat.officialBar.SingleForumBroadcastFeedActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.mutiprocess.b
        public boolean a(TopToastEvent topToastEvent) {
            if (SingleForumBroadcastFeedActivity.this.kEi != null) {
                SingleForumBroadcastFeedActivity.this.kEi.showTipToast(topToastEvent.isSuccess(), topToastEvent.getContent());
                return false;
            }
            return false;
        }
    };
    private h.a kEk = new h.a() { // from class: com.baidu.tieba.im.chat.officialBar.SingleForumBroadcastFeedActivity.2
        @Override // com.baidu.tieba.im.chat.officialBar.h.a
        public void eq(List<com.baidu.tieba.im.message.chat.b> list) {
            SingleForumBroadcastFeedActivity.this.kEi.A(list, null);
        }

        @Override // com.baidu.tieba.im.chat.officialBar.h.a
        public void onReadCountLoad(LongSparseArray<com.baidu.tieba.im.forum.broadcast.data.b> longSparseArray) {
            SingleForumBroadcastFeedActivity.this.kEi.a(longSparseArray);
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.kEh = new h(getPageContext());
        this.kEh.a(this.kEk);
        this.kEi = new OfficialBarFeedMsglistView(this, true);
        if (getIntent() != null) {
            this.forumId = getIntent().getStringExtra("key_uid");
            this.kEj = getIntent().getByteExtra(SingleForumBroadcastFeedActivityConfig.KEY_SOURCE, (byte) 3);
            this.kEh.gL(this.forumId);
            this.kEi.J(this.forumId, System.currentTimeMillis());
        }
        registerResponsedEventListener(TopToastEvent.class, this.mTopToastEventListener);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.kEi.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(this.forumId, 4)));
        ar arVar = new ar("c13870");
        arVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
        arVar.dR("fid", this.forumId);
        arVar.ap("obj_source", this.kEj);
        TiebaStatic.log(arVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.kEh != null) {
            this.kEh.destroy();
        }
        unRegisterResponsedEventListener();
    }
}
