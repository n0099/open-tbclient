package com.baidu.tieba.enterForum.home;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.message.EnterForumInfoMessage;
import com.baidu.tieba.enterForum.c.c;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
class a implements c.b {
    @Override // com.baidu.tieba.enterForum.c.c.b
    public void a(c.a aVar) {
        com.baidu.tieba.enterForum.b.d Nx = aVar.bbY.Nx();
        ArrayList arrayList = new ArrayList();
        Iterator<com.baidu.tieba.tbadkCore.v> it = Nx.NB().iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getName());
        }
        MessageManager.getInstance().dispatchResponsedMessage(new EnterForumInfoMessage(CmdConfigCustom.CMD_ENTER_FORUM_INFO, arrayList));
    }
}
