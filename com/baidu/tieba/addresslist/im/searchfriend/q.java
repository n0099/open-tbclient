package com.baidu.tieba.addresslist.im.searchfriend;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements View.OnClickListener {
    final /* synthetic */ n aAZ;
    private final /* synthetic */ com.baidu.tieba.addresslist.im.searchfriend.a.b aBa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(n nVar, com.baidu.tieba.addresslist.im.searchfriend.a.b bVar) {
        this.aAZ = nVar;
        this.aBa = bVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        SearchFriendActivity searchFriendActivity;
        SearchFriendActivity searchFriendActivity2;
        if (view.getTag() instanceof com.baidu.tieba.addresslist.im.searchfriend.a.c) {
            com.baidu.tieba.addresslist.im.searchfriend.a.c cVar = (com.baidu.tieba.addresslist.im.searchfriend.a.c) view.getTag();
            searchFriendActivity = this.aAZ.aAY;
            com.baidu.tbadk.core.k.A(searchFriendActivity.getPageContext().getPageActivity(), cVar.Gl());
            MessageManager messageManager = MessageManager.getInstance();
            searchFriendActivity2 = this.aAZ.aAY;
            messageManager.sendMessage(new CustomMessage(2002001, new AddFriendActivityConfig(searchFriendActivity2.getPageContext().getPageActivity(), String.valueOf(cVar.getUserId()), cVar.getName(), cVar.rc(), null, false, cVar.Gl(), this.aBa.Gj())));
        }
    }
}
