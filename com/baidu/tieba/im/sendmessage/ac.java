package com.baidu.tieba.im.sendmessage;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class ac {
    public String lh(String str) {
        com.baidu.tbadk.coreExtra.data.g xA;
        if (str != null) {
            try {
                com.baidu.tbadk.core.voice.service.c cVar = new com.baidu.tbadk.core.voice.service.c(TbConfig.UPLOAD_CHUNK_AUDIO_ADDRESS, TbConfig.FINISH_UPLOAD_CHUNK_AUDIO_ADDRESS);
                String r = com.baidu.tbadk.core.util.l.r(str, 1);
                cVar.u("type", 2);
                com.baidu.tbadk.coreExtra.data.h eb = cVar.eb(r);
                if (eb != null && eb.isSuccess() && (xA = eb.xA()) != null) {
                    String md5 = xA.getMd5();
                    com.baidu.tbadk.core.voice.a.b.ah(str, md5);
                    return md5;
                }
            } catch (Exception e) {
            }
        }
        return null;
    }
}
