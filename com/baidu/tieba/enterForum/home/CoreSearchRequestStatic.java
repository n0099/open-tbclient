package com.baidu.tieba.enterForum.home;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.message.EnterForumInfoMessage;
import com.baidu.tbadk.core.message.RequestEnterForumDataMessage;
import com.baidu.tieba.enterForum.data.f;
import com.baidu.tieba.enterForum.data.g;
import com.baidu.tieba.enterForum.model.EnterForumModel;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes2.dex */
public class CoreSearchRequestStatic {
    private static EnterForumModel cPE;

    static {
        aoc();
        aod();
    }

    private static void aoc() {
        com.baidu.tieba.tbadkCore.d.c.bxX();
        if (cPE == null) {
            cPE = new EnterForumModel(null);
            cPE.a(new EnterForumModel.b() { // from class: com.baidu.tieba.enterForum.home.CoreSearchRequestStatic.1
                @Override // com.baidu.tieba.enterForum.model.EnterForumModel.b
                public void a(EnterForumModel.a aVar) {
                    g anT = aVar.cQR.anT();
                    ArrayList arrayList = new ArrayList();
                    Iterator<f> it = anT.anZ().iterator();
                    while (it.hasNext()) {
                        arrayList.add(it.next().getName());
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new EnterForumInfoMessage(2001329, arrayList));
                }
            });
        }
        MessageManager.getInstance().registerListener(new com.baidu.adp.framework.listener.a(CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, 303011) { // from class: com.baidu.tieba.enterForum.home.CoreSearchRequestStatic.2
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                if (((responsedMessage instanceof forumRecommendSocketResponseMessage) || (responsedMessage instanceof forumRecommendHttpResponseMessage)) && CoreSearchRequestStatic.cPE.getUniqueId() == responsedMessage.getOrginalMessage().getTag() && !responsedMessage.hasError()) {
                    if (responsedMessage instanceof forumRecommendSocketResponseMessage) {
                        CoreSearchRequestStatic.cPE.a((forumRecommendSocketResponseMessage) responsedMessage);
                    }
                    if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                        CoreSearchRequestStatic.cPE.a((forumRecommendHttpResponseMessage) responsedMessage);
                    }
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2001323) { // from class: com.baidu.tieba.enterForum.home.CoreSearchRequestStatic.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (TbadkCoreApplication.isLogin() && (customResponsedMessage instanceof RequestEnterForumDataMessage)) {
                    if (((RequestEnterForumDataMessage) customResponsedMessage).isCache()) {
                        CoreSearchRequestStatic.cPE.fh(true);
                    } else {
                        CoreSearchRequestStatic.cPE.fg(true);
                    }
                }
            }
        });
    }

    public static void aod() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2016562, new CustomMessageTask.CustomRunnable<Object>() { // from class: com.baidu.tieba.enterForum.home.CoreSearchRequestStatic.4
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<com.baidu.tieba.c.a> run(CustomMessage<Object> customMessage) {
                return new CustomResponsedMessage<>(2016562, new b());
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }
}
