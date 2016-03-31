package com.baidu.tieba.im.c;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class ac {
    public String jF(String str) {
        com.baidu.tbadk.coreExtra.data.c yA;
        if (str != null) {
            try {
                com.baidu.tbadk.core.voice.service.c cVar = new com.baidu.tbadk.core.voice.service.c(TbConfig.UPLOAD_CHUNK_AUDIO_ADDRESS, TbConfig.FINISH_UPLOAD_CHUNK_AUDIO_ADDRESS);
                String q = com.baidu.tbadk.core.util.m.q(str, 1);
                cVar.t("type", 2);
                com.baidu.tbadk.coreExtra.data.d dZ = cVar.dZ(q);
                if (dZ != null && dZ.isSuccess() && (yA = dZ.yA()) != null) {
                    String md5 = yA.getMd5();
                    com.baidu.tbadk.core.voice.a.b.ah(str, md5);
                    return md5;
                }
            } catch (Exception e) {
            }
        }
        return null;
    }
}
