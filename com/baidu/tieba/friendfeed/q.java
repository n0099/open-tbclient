package com.baidu.tieba.friendfeed;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tieba.data.FriendFeedThreadData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements View.OnClickListener {
    final /* synthetic */ p aCf;
    private final /* synthetic */ FriendFeedThreadData aCg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(p pVar, FriendFeedThreadData friendFeedThreadData) {
        this.aCf = pVar;
        this.aCg = friendFeedThreadData;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        FriendFeedActivity friendFeedActivity;
        MessageManager messageManager = MessageManager.getInstance();
        friendFeedActivity = this.aCf.aBW;
        messageManager.sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(friendFeedActivity.getPageContext().getPageActivity(), this.aCg.getAuthor().getUserId(), this.aCg.getAuthor().getName_show(), "friend")));
    }
}
