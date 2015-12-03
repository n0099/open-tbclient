package com.baidu.tieba.addresslist.im.searchfriend;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements View.OnClickListener {
    final /* synthetic */ m aJD;
    private final /* synthetic */ com.baidu.tieba.addresslist.im.searchfriend.a.b aJE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(m mVar, com.baidu.tieba.addresslist.im.searchfriend.a.b bVar) {
        this.aJD = mVar;
        this.aJE = bVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        SearchFriendActivity searchFriendActivity;
        if (view.getTag() instanceof com.baidu.tieba.addresslist.im.searchfriend.a.c) {
            com.baidu.tieba.addresslist.im.searchfriend.a.c cVar = (com.baidu.tieba.addresslist.im.searchfriend.a.c) view.getTag();
            TiebaStatic.log(cVar.HH());
            MessageManager messageManager = MessageManager.getInstance();
            searchFriendActivity = this.aJD.aJC;
            messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AddFriendActivityConfig(searchFriendActivity.getPageContext().getPageActivity(), String.valueOf(cVar.getUserId()), cVar.getName(), cVar.su(), null, false, cVar.HH(), this.aJE.HF())));
        }
    }
}
