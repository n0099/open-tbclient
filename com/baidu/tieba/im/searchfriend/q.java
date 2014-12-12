package com.baidu.tieba.im.searchfriend;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements View.OnClickListener {
    final /* synthetic */ n bmL;
    private final /* synthetic */ com.baidu.tieba.im.searchfriend.a.b bmM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(n nVar, com.baidu.tieba.im.searchfriend.a.b bVar) {
        this.bmL = nVar;
        this.bmM = bVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        SearchFriendActivity searchFriendActivity;
        SearchFriendActivity searchFriendActivity2;
        if (view.getTag() instanceof com.baidu.tieba.im.searchfriend.a.c) {
            com.baidu.tieba.im.searchfriend.a.c cVar = (com.baidu.tieba.im.searchfriend.a.c) view.getTag();
            searchFriendActivity = this.bmL.bmK;
            com.baidu.tbadk.core.i.B(searchFriendActivity.getPageContext().getPageActivity(), cVar.SR());
            MessageManager messageManager = MessageManager.getInstance();
            searchFriendActivity2 = this.bmL.bmK;
            messageManager.sendMessage(new CustomMessage(2002001, new AddFriendActivityConfig(searchFriendActivity2.getPageContext().getPageActivity(), String.valueOf(cVar.getUserId()), cVar.getName(), cVar.nl(), null, false, cVar.SR(), this.bmM.SP())));
        }
    }
}
