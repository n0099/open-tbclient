package com.baidu.tieba.enterForum.home;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.data.HotTopicBussinessData;
import com.baidu.tbadk.core.data.aj;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.z;
import com.baidu.tieba.enterForum.model.EnterForumModel;
import java.util.ArrayList;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements CustomMessageTask.CustomRunnable<aj> {
    final /* synthetic */ i bTq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(i iVar) {
        this.bTq = iVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.CustomMessage] */
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<aj> run(CustomMessage<aj> customMessage) {
        EnterForumModel enterForumModel;
        EnterForumModel enterForumModel2;
        EnterForumModel enterForumModel3;
        EnterForumModel enterForumModel4;
        EnterForumModel enterForumModel5;
        aj ajVar = new aj();
        ArrayList arrayList = new ArrayList();
        enterForumModel = this.bTq.bTd;
        if (enterForumModel != null) {
            enterForumModel2 = this.bTq.bTd;
            if (enterForumModel2.abc() != null) {
                enterForumModel3 = this.bTq.bTd;
                if (enterForumModel3.abc().aas() != null) {
                    enterForumModel4 = this.bTq.bTd;
                    if (z.s(enterForumModel4.abc().aas().aaz()) > 0) {
                        enterForumModel5 = this.bTq.bTd;
                        Iterator<com.baidu.tieba.enterForum.b.g> it = enterForumModel5.abc().aas().aaz().iterator();
                        while (it.hasNext()) {
                            com.baidu.tieba.enterForum.b.g next = it.next();
                            if (next != null) {
                                HotTopicBussinessData hotTopicBussinessData = new HotTopicBussinessData();
                                hotTopicBussinessData.setForumId(com.baidu.adp.lib.g.b.c(next.getId(), 0L));
                                hotTopicBussinessData.setForumName(next.getName());
                                hotTopicBussinessData.setForumAvatar(next.getAvatar());
                                arrayList.add(hotTopicBussinessData);
                            }
                        }
                        ajVar.o(arrayList);
                    }
                }
            }
        }
        return new CustomResponsedMessage<>(CmdConfigCustom.CMD_GET_LIKE_FORUM_LIST, ajVar);
    }
}
