package com.baidu.tieba.ala.alaar.sticker.a;

import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.data.AlaLiveStickerInfo;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
/* loaded from: classes3.dex */
public class f {
    private static int fhL = 0;
    private static volatile boolean fhM = false;

    public static void a(BdUniqueId bdUniqueId, String str, int i, int i2) {
        com.baidu.tieba.ala.alaar.messages.c cVar = new com.baidu.tieba.ala.alaar.messages.c(bdUniqueId, str, i, i2);
        cVar.setParams();
        MessageManager.getInstance().sendMessage(cVar);
    }

    public static void Hx() {
        com.baidu.tieba.ala.alaar.messages.b bVar = new com.baidu.tieba.ala.alaar.messages.b("");
        bVar.setParams();
        MessageManager.getInstance().sendMessage(bVar);
    }

    public static void dB(String str, String str2) {
        com.baidu.tieba.ala.alaar.messages.a aVar = new com.baidu.tieba.ala.alaar.messages.a();
        aVar.setParams();
        aVar.addParam("user_id", TbadkCoreApplication.getCurrentAccountId());
        aVar.addParam("nickname", TbadkCoreApplication.getCurrentAccountInfo().getAccountNameShow());
        aVar.addParam("content", str);
        aVar.addParam("title", str2);
        MessageManager.getInstance().sendMessage(aVar);
    }

    public static void a(long j, int i, AlaLiveStickerInfo alaLiveStickerInfo) {
        fhL = i;
        fhM = true;
        com.baidu.tieba.ala.alaar.messages.d dVar = new com.baidu.tieba.ala.alaar.messages.d(j, i, alaLiveStickerInfo);
        dVar.setParams();
        MessageManager.getInstance().sendMessage(dVar);
    }

    public static void bsA() {
        fhM = false;
    }

    public static boolean bsB() {
        return fhM;
    }
}
