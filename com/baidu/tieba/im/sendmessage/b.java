package com.baidu.tieba.im.sendmessage;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.l;
import com.baidu.tbadk.coreExtra.data.k;
/* loaded from: classes.dex */
public class b {
    public String qP(String str) {
        k GW;
        if (str != null) {
            try {
                com.baidu.tbadk.core.voice.service.b bVar = new com.baidu.tbadk.core.voice.service.b(TbConfig.UPLOAD_CHUNK_AUDIO_ADDRESS, TbConfig.FINISH_UPLOAD_CHUNK_AUDIO_ADDRESS);
                String x = l.x(str, 1);
                bVar.addPostParam("type", 2);
                com.baidu.tbadk.coreExtra.data.l gM = bVar.gM(x);
                if (gM != null && gM.isSuccess() && (GW = gM.GW()) != null) {
                    String GU = GW.GU();
                    com.baidu.tbadk.core.voice.a.b.renameFile(str, GU);
                    return GU;
                }
            } catch (Exception e) {
            }
        }
        return null;
    }
}
