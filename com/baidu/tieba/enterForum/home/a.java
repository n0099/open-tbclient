package com.baidu.tieba.enterForum.home;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.message.EnterForumInfoMessage;
import com.baidu.tieba.enterForum.model.EnterForumModel;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
class a implements EnterForumModel.b {
    @Override // com.baidu.tieba.enterForum.model.EnterForumModel.b
    public void a(EnterForumModel.a aVar) {
        com.baidu.tieba.enterForum.b.e Uf = aVar.byt.Uf();
        ArrayList arrayList = new ArrayList();
        Iterator<com.baidu.tieba.tbadkCore.u> it = Uf.Uk().iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getName());
        }
        MessageManager.getInstance().dispatchResponsedMessage(new EnterForumInfoMessage(CmdConfigCustom.CMD_ENTER_FORUM_INFO, arrayList));
    }
}
