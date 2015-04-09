package com.baidu.tieba.friendFeed;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tieba.friendFeed.data.FriendFeedThreadData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements View.OnClickListener {
    final /* synthetic */ p aIg;
    private final /* synthetic */ FriendFeedThreadData aIh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(p pVar, FriendFeedThreadData friendFeedThreadData) {
        this.aIg = pVar;
        this.aIh = friendFeedThreadData;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        FriendFeedActivity friendFeedActivity;
        MessageManager messageManager = MessageManager.getInstance();
        friendFeedActivity = this.aIg.aHV;
        messageManager.sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(friendFeedActivity.getPageContext().getPageActivity(), this.aIh.getAuthor().getUserId(), this.aIh.getAuthor().getName_show(), "friend")));
    }
}
