package com.baidu.tieba.addresslist.im.searchfriend;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements View.OnClickListener {
    final /* synthetic */ n aAY;
    private final /* synthetic */ com.baidu.tieba.addresslist.im.searchfriend.a.b aAZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(n nVar, com.baidu.tieba.addresslist.im.searchfriend.a.b bVar) {
        this.aAY = nVar;
        this.aAZ = bVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        SearchFriendActivity searchFriendActivity;
        SearchFriendActivity searchFriendActivity2;
        if (view.getTag() instanceof com.baidu.tieba.addresslist.im.searchfriend.a.c) {
            com.baidu.tieba.addresslist.im.searchfriend.a.c cVar = (com.baidu.tieba.addresslist.im.searchfriend.a.c) view.getTag();
            searchFriendActivity = this.aAY.aAX;
            com.baidu.tbadk.core.k.A(searchFriendActivity.getPageContext().getPageActivity(), cVar.Gk());
            MessageManager messageManager = MessageManager.getInstance();
            searchFriendActivity2 = this.aAY.aAX;
            messageManager.sendMessage(new CustomMessage(2002001, new AddFriendActivityConfig(searchFriendActivity2.getPageContext().getPageActivity(), String.valueOf(cVar.getUserId()), cVar.getName(), cVar.rc(), null, false, cVar.Gk(), this.aAZ.Gi())));
        }
    }
}
