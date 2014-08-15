package com.baidu.tieba.im.searchfriend;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements View.OnClickListener {
    final /* synthetic */ l a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(l lVar) {
        this.a = lVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        SearchFriendActivity searchFriendActivity;
        SearchFriendActivity searchFriendActivity2;
        searchFriendActivity = this.a.b;
        com.baidu.tbadk.core.f.a(searchFriendActivity, "cluster_btn_addFd");
        if (view.getTag() instanceof com.baidu.tieba.im.searchfriend.a.c) {
            com.baidu.tieba.im.searchfriend.a.c cVar = (com.baidu.tieba.im.searchfriend.a.c) view.getTag();
            MessageManager messageManager = MessageManager.getInstance();
            searchFriendActivity2 = this.a.b;
            messageManager.sendMessage(new CustomMessage(2002001, new com.baidu.tbadk.core.atomData.a(searchFriendActivity2, String.valueOf(cVar.c()), cVar.e(), cVar.d(), null, false, "search")));
        }
    }
}
