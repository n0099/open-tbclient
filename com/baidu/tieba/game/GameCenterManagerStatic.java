package com.baidu.tieba.game;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.TiebaIMConfig;
/* loaded from: classes.dex */
public class GameCenterManagerStatic {
    static {
        com.baidu.tbadk.task.a aVar = new com.baidu.tbadk.task.a(2001224, new am());
        aVar.a(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        MessageManager.getInstance().registerTask(aVar);
        com.baidu.tbadk.task.b bVar = new com.baidu.tbadk.task.b(303008);
        bVar.setResponsedClass(ResponseGameCenterMessage.class);
        bVar.f(false);
        bVar.setParallel(TiebaIMConfig.getParallel());
        MessageManager.getInstance().registerTask(bVar);
        MessageManager.getInstance().registerListener(new m(205005));
        MessageManager.getInstance().registerListener(new n(2001236));
        com.baidu.tbadk.core.util.bg.mR().a(new o());
    }
}
