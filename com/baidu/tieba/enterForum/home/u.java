package com.baidu.tieba.enterForum.home;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.data.HotTopicBussinessData;
import com.baidu.tbadk.core.data.ai;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.enterForum.model.EnterForumModel;
import java.util.ArrayList;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements CustomMessageTask.CustomRunnable<ai> {
    final /* synthetic */ i bGZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(i iVar) {
        this.bGZ = iVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.CustomMessage] */
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<ai> run(CustomMessage<ai> customMessage) {
        EnterForumModel enterForumModel;
        EnterForumModel enterForumModel2;
        EnterForumModel enterForumModel3;
        EnterForumModel enterForumModel4;
        EnterForumModel enterForumModel5;
        ai aiVar = new ai();
        ArrayList arrayList = new ArrayList();
        enterForumModel = this.bGZ.bGO;
        if (enterForumModel != null) {
            enterForumModel2 = this.bGZ.bGO;
            if (enterForumModel2.WB() != null) {
                enterForumModel3 = this.bGZ.bGO;
                if (enterForumModel3.WB().VT() != null) {
                    enterForumModel4 = this.bGZ.bGO;
                    if (x.q(enterForumModel4.WB().VT().VZ()) > 0) {
                        enterForumModel5 = this.bGZ.bGO;
                        Iterator<com.baidu.tieba.enterForum.b.g> it = enterForumModel5.WB().VT().VZ().iterator();
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
                        aiVar.m(arrayList);
                    }
                }
            }
        }
        return new CustomResponsedMessage<>(CmdConfigCustom.CMD_GET_LIKE_FORUM_LIST, aiVar);
    }
}
