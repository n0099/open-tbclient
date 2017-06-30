package com.baidu.tieba.im.sendmessage;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class ac {
    public String mc(String str) {
        com.baidu.tbadk.coreExtra.data.g xS;
        if (str != null) {
            try {
                com.baidu.tbadk.core.voice.service.c cVar = new com.baidu.tbadk.core.voice.service.c(TbConfig.UPLOAD_CHUNK_AUDIO_ADDRESS, TbConfig.FINISH_UPLOAD_CHUNK_AUDIO_ADDRESS);
                String q = com.baidu.tbadk.core.util.n.q(str, 1);
                cVar.u("type", 2);
                com.baidu.tbadk.coreExtra.data.h es = cVar.es(q);
                if (es != null && es.isSuccess() && (xS = es.xS()) != null) {
                    String md5 = xS.getMd5();
                    com.baidu.tbadk.core.voice.a.b.af(str, md5);
                    return md5;
                }
            } catch (Exception e) {
            }
        }
        return null;
    }
}
