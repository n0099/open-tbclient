package com.baidu.tieba.gift.myGiftList;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.TiebaIMConfig;
/* loaded from: classes.dex */
public class MyGiftListStatic {
    static {
        com.baidu.tbadk.task.b bVar = new com.baidu.tbadk.task.b(308002);
        bVar.setResponsedClass(ResponseMyGiftListMessage.class);
        bVar.j(false);
        bVar.setParallel(TiebaIMConfig.getParallel());
        MessageManager.getInstance().registerTask(bVar);
    }
}
