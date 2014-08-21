package com.baidu.tieba.friendfeed;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.bh;
import com.baidu.tieba.data.FriendFeedThreadData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements View.OnClickListener {
    final /* synthetic */ l a;
    private final /* synthetic */ FriendFeedThreadData b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar, FriendFeedThreadData friendFeedThreadData) {
        this.a = lVar;
        this.b = friendFeedThreadData;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        MessageManager messageManager = MessageManager.getInstance();
        context = this.a.a;
        messageManager.sendMessage(new CustomMessage(2002003, new bh(context, this.b.getAuthor().getUserId(), this.b.getAuthor().getName_show(), "friend")));
    }
}
