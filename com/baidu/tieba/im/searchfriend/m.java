package com.baidu.tieba.im.searchfriend;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements View.OnClickListener {
    final /* synthetic */ l bhU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar) {
        this.bhU = lVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        SearchFriendActivity searchFriendActivity;
        SearchFriendActivity searchFriendActivity2;
        if (view.getTag() instanceof com.baidu.tieba.im.searchfriend.a.c) {
            com.baidu.tieba.im.searchfriend.a.c cVar = (com.baidu.tieba.im.searchfriend.a.c) view.getTag();
            searchFriendActivity = this.bhU.bhT;
            com.baidu.tbadk.core.i.l(searchFriendActivity, cVar.RC());
            MessageManager messageManager = MessageManager.getInstance();
            searchFriendActivity2 = this.bhU.bhT;
            messageManager.sendMessage(new CustomMessage(2002001, new AddFriendActivityConfig(searchFriendActivity2, String.valueOf(cVar.getUserId()), cVar.getName(), cVar.ks(), null, false, cVar.RC(), cVar.kp())));
        }
    }
}
