package com.baidu.tieba.im.c;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class ac {
    public String iW(String str) {
        com.baidu.tbadk.coreExtra.data.c xZ;
        if (str != null) {
            try {
                com.baidu.tbadk.core.voice.service.c cVar = new com.baidu.tbadk.core.voice.service.c(TbConfig.UPLOAD_CHUNK_AUDIO_ADDRESS, TbConfig.FINISH_UPLOAD_CHUNK_AUDIO_ADDRESS);
                String q = com.baidu.tbadk.core.util.m.q(str, 1);
                cVar.s("type", 2);
                com.baidu.tbadk.coreExtra.data.d dS = cVar.dS(q);
                if (dS != null && dS.isSuccess() && (xZ = dS.xZ()) != null) {
                    String md5 = xZ.getMd5();
                    com.baidu.tbadk.core.voice.a.b.ad(str, md5);
                    return md5;
                }
            } catch (Exception e) {
            }
        }
        return null;
    }
}
