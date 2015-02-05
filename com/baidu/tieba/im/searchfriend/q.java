package com.baidu.tieba.im.searchfriend;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements View.OnClickListener {
    final /* synthetic */ n boh;
    private final /* synthetic */ com.baidu.tieba.im.searchfriend.a.b boi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(n nVar, com.baidu.tieba.im.searchfriend.a.b bVar) {
        this.boh = nVar;
        this.boi = bVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        SearchFriendActivity searchFriendActivity;
        SearchFriendActivity searchFriendActivity2;
        if (view.getTag() instanceof com.baidu.tieba.im.searchfriend.a.c) {
            com.baidu.tieba.im.searchfriend.a.c cVar = (com.baidu.tieba.im.searchfriend.a.c) view.getTag();
            searchFriendActivity = this.boh.bog;
            com.baidu.tbadk.core.i.A(searchFriendActivity.getPageContext().getPageActivity(), cVar.Ti());
            MessageManager messageManager = MessageManager.getInstance();
            searchFriendActivity2 = this.boh.bog;
            messageManager.sendMessage(new CustomMessage(2002001, new AddFriendActivityConfig(searchFriendActivity2.getPageContext().getPageActivity(), String.valueOf(cVar.getUserId()), cVar.getName(), cVar.ng(), null, false, cVar.Ti(), this.boi.Tg())));
        }
    }
}
