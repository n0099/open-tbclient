package com.baidu.tieba.game;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.task.CustomMessageTask;
/* loaded from: classes.dex */
public class GameCenterManagerStatic {
    static {
        com.baidu.tbadk.task.a aVar = new com.baidu.tbadk.task.a(2001224, new af());
        aVar.a(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        MessageManager.getInstance().registerTask(aVar);
        com.baidu.tbadk.task.b bVar = new com.baidu.tbadk.task.b(303008);
        bVar.a(ResponseGameCenterMessage.class);
        bVar.b(false);
        bVar.setParallel(com.baidu.tbadk.k.b());
        MessageManager.getInstance().registerTask(bVar);
    }
}
