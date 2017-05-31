package com.baidu.tieba.im.sendmessage;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class ac {
    public String ld(String str) {
        com.baidu.tbadk.coreExtra.data.g xB;
        if (str != null) {
            try {
                com.baidu.tbadk.core.voice.service.c cVar = new com.baidu.tbadk.core.voice.service.c(TbConfig.UPLOAD_CHUNK_AUDIO_ADDRESS, TbConfig.FINISH_UPLOAD_CHUNK_AUDIO_ADDRESS);
                String q = com.baidu.tbadk.core.util.l.q(str, 1);
                cVar.u("type", 2);
                com.baidu.tbadk.coreExtra.data.h dY = cVar.dY(q);
                if (dY != null && dY.isSuccess() && (xB = dY.xB()) != null) {
                    String md5 = xB.getMd5();
                    com.baidu.tbadk.core.voice.a.b.af(str, md5);
                    return md5;
                }
            } catch (Exception e) {
            }
        }
        return null;
    }
}
