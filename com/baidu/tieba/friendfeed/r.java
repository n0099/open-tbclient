package com.baidu.tieba.friendfeed;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tieba.data.FriendFeedThreadData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements View.OnClickListener {
    final /* synthetic */ q aBe;
    private final /* synthetic */ FriendFeedThreadData aBf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(q qVar, FriendFeedThreadData friendFeedThreadData) {
        this.aBe = qVar;
        this.aBf = friendFeedThreadData;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        FriendFeedActivity friendFeedActivity;
        MessageManager messageManager = MessageManager.getInstance();
        friendFeedActivity = this.aBe.aAV;
        messageManager.sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(friendFeedActivity.getPageContext().getPageActivity(), this.aBf.getAuthor().getUserId(), this.aBf.getAuthor().getName_show(), "friend")));
    }
}
