package com.baidu.tieba.im.c;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class ac {
    public String mr(String str) {
        com.baidu.tbadk.coreExtra.data.g xQ;
        if (str != null) {
            try {
                com.baidu.tbadk.core.voice.service.c cVar = new com.baidu.tbadk.core.voice.service.c(TbConfig.UPLOAD_CHUNK_AUDIO_ADDRESS, TbConfig.FINISH_UPLOAD_CHUNK_AUDIO_ADDRESS);
                String r = com.baidu.tbadk.core.util.m.r(str, 1);
                cVar.u("type", 2);
                com.baidu.tbadk.coreExtra.data.h eg = cVar.eg(r);
                if (eg != null && eg.isSuccess() && (xQ = eg.xQ()) != null) {
                    String md5 = xQ.getMd5();
                    com.baidu.tbadk.core.voice.a.b.ah(str, md5);
                    return md5;
                }
            } catch (Exception e) {
            }
        }
        return null;
    }
}
