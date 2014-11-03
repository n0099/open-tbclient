package com.baidu.tieba.im.searchfriend;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements View.OnClickListener {
    final /* synthetic */ l bik;
    private final /* synthetic */ com.baidu.tieba.im.searchfriend.a.b bil;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(l lVar, com.baidu.tieba.im.searchfriend.a.b bVar) {
        this.bik = lVar;
        this.bil = bVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        SearchFriendActivity searchFriendActivity;
        SearchFriendActivity searchFriendActivity2;
        if (view.getTag() instanceof com.baidu.tieba.im.searchfriend.a.c) {
            com.baidu.tieba.im.searchfriend.a.c cVar = (com.baidu.tieba.im.searchfriend.a.c) view.getTag();
            searchFriendActivity = this.bik.bij;
            com.baidu.tbadk.core.j.l(searchFriendActivity, cVar.RF());
            MessageManager messageManager = MessageManager.getInstance();
            searchFriendActivity2 = this.bik.bij;
            messageManager.sendMessage(new CustomMessage(2002001, new AddFriendActivityConfig(searchFriendActivity2, String.valueOf(cVar.getUserId()), cVar.getName(), cVar.ks(), null, false, cVar.RF(), this.bil.RD())));
        }
    }
}
