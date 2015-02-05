package com.baidu.tieba.friendfeed;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tieba.data.FriendFeedThreadData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements View.OnClickListener {
    final /* synthetic */ p aCc;
    private final /* synthetic */ FriendFeedThreadData aCd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(p pVar, FriendFeedThreadData friendFeedThreadData) {
        this.aCc = pVar;
        this.aCd = friendFeedThreadData;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        FriendFeedActivity friendFeedActivity;
        MessageManager messageManager = MessageManager.getInstance();
        friendFeedActivity = this.aCc.aBT;
        messageManager.sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(friendFeedActivity.getPageContext().getPageActivity(), this.aCd.getAuthor().getUserId(), this.aCd.getAuthor().getName_show(), "friend")));
    }
}
