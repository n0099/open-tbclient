package com.baidu.tieba.friendfeed;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tieba.data.FriendFeedThreadData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements View.OnClickListener {
    final /* synthetic */ q ayX;
    private final /* synthetic */ FriendFeedThreadData ayY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(q qVar, FriendFeedThreadData friendFeedThreadData) {
        this.ayX = qVar;
        this.ayY = friendFeedThreadData;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        MessageManager messageManager = MessageManager.getInstance();
        context = this.ayX.mContext;
        messageManager.sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(context, this.ayY.getAuthor().getUserId(), this.ayY.getAuthor().getName_show(), "friend")));
    }
}
