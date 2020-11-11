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
import com.baidu.tieba.im.chat.officialBar.i;
import java.util.List;
/* loaded from: classes26.dex */
public class SingleForumBroadcastFeedActivity extends BaseActivity {
    private String forumId;
    private i jZw;
    private OfficialBarFeedMsglistView jZx;
    private byte jZy;
    private i.a jZz = new i.a() { // from class: com.baidu.tieba.im.chat.officialBar.SingleForumBroadcastFeedActivity.1
        @Override // com.baidu.tieba.im.chat.officialBar.i.a
        public void ea(List<com.baidu.tieba.im.message.chat.b> list) {
            SingleForumBroadcastFeedActivity.this.jZx.z(list, null);
        }

        @Override // com.baidu.tieba.im.chat.officialBar.i.a
        public void onReadCountLoad(LongSparseArray<com.baidu.tieba.im.forum.broadcast.data.b> longSparseArray) {
            SingleForumBroadcastFeedActivity.this.jZx.a(longSparseArray);
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.jZw = new i(getPageContext());
        this.jZw.a(this.jZz);
        this.jZx = new OfficialBarFeedMsglistView(this, true);
        if (getIntent() != null) {
            this.forumId = getIntent().getStringExtra("key_uid");
            this.jZy = getIntent().getByteExtra(SingleForumBroadcastFeedActivityConfig.KEY_SOURCE, (byte) 3);
            this.jZw.hw(this.forumId);
            this.jZx.J(this.forumId, System.currentTimeMillis());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.jZx.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(this.forumId, 4)));
        aq aqVar = new aq("c13870");
        aqVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
        aqVar.dR("fid", this.forumId);
        aqVar.al("obj_source", this.jZy);
        TiebaStatic.log(aqVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.jZw != null) {
            this.jZw.destroy();
        }
    }
}
