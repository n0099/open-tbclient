package com.baidu.tieba.friendFeed;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tieba.friendFeed.data.FriendFeedThreadData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements View.OnClickListener {
    final /* synthetic */ p aHY;
    private final /* synthetic */ FriendFeedThreadData aHZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(p pVar, FriendFeedThreadData friendFeedThreadData) {
        this.aHY = pVar;
        this.aHZ = friendFeedThreadData;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        FriendFeedActivity friendFeedActivity;
        MessageManager messageManager = MessageManager.getInstance();
        friendFeedActivity = this.aHY.aHN;
        messageManager.sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(friendFeedActivity.getPageContext().getPageActivity(), this.aHZ.getAuthor().getUserId(), this.aHZ.getAuthor().getName_show(), "friend")));
    }
}
