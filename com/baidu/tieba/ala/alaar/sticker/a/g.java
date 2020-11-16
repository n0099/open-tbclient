package com.baidu.tieba.ala.alaar.sticker.a;

import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.data.AlaLiveStickerInfo;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
/* loaded from: classes4.dex */
public class g {
    private static int gcx = 0;
    private static volatile boolean gcy = false;

    public static void a(BdUniqueId bdUniqueId, String str, int i, int i2) {
        com.baidu.tieba.ala.alaar.messages.c cVar = new com.baidu.tieba.ala.alaar.messages.c(bdUniqueId, str, i, i2);
        cVar.setParams();
        MessageManager.getInstance().sendMessage(cVar);
    }

    public static void PB() {
        com.baidu.tieba.ala.alaar.messages.b bVar = new com.baidu.tieba.ala.alaar.messages.b("");
        bVar.setParams();
        MessageManager.getInstance().sendMessage(bVar);
    }

    public static void eh(String str, String str2) {
        com.baidu.tieba.ala.alaar.messages.a aVar = new com.baidu.tieba.ala.alaar.messages.a();
        aVar.setParams();
        aVar.addParam("user_id", TbadkCoreApplication.getCurrentAccountId());
        aVar.addParam("nickname", TbadkCoreApplication.getCurrentAccountInfo().getAccountNameShow());
        aVar.addParam("content", str);
        aVar.addParam("title", str2);
        MessageManager.getInstance().sendMessage(aVar);
    }

    public static void a(long j, int i, AlaLiveStickerInfo alaLiveStickerInfo) {
        gcx = i;
        gcy = true;
        com.baidu.tieba.ala.alaar.messages.d dVar = new com.baidu.tieba.ala.alaar.messages.d(j, i, alaLiveStickerInfo);
        dVar.setParams();
        MessageManager.getInstance().sendMessage(dVar);
    }

    public static void bNa() {
        gcy = false;
    }

    public static boolean bNb() {
        return gcy;
    }
}
