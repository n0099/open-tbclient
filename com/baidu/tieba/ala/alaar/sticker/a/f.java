package com.baidu.tieba.ala.alaar.sticker.a;

import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
/* loaded from: classes3.dex */
public class f {
    public static void bkx() {
        com.baidu.tieba.ala.alaar.messages.b bVar = new com.baidu.tieba.ala.alaar.messages.b("");
        bVar.setParams();
        MessageManager.getInstance().sendMessage(bVar);
    }

    public static void cZ(String str, String str2) {
        com.baidu.tieba.ala.alaar.messages.a aVar = new com.baidu.tieba.ala.alaar.messages.a();
        aVar.setParams();
        aVar.addParam("user_id", TbadkCoreApplication.getCurrentAccountId());
        aVar.addParam("nickname", TbadkCoreApplication.getCurrentAccountInfo().getAccountNameShow());
        aVar.addParam("content", str);
        aVar.addParam("title", str2);
        MessageManager.getInstance().sendMessage(aVar);
    }
}
