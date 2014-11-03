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
    final /* synthetic */ q azg;
    private final /* synthetic */ FriendFeedThreadData azh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(q qVar, FriendFeedThreadData friendFeedThreadData) {
        this.azg = qVar;
        this.azh = friendFeedThreadData;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        MessageManager messageManager = MessageManager.getInstance();
        context = this.azg.mContext;
        messageManager.sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(context, this.azh.getAuthor().getUserId(), this.azh.getAuthor().getName_show(), "friend")));
    }
}
