package com.baidu.tieba.im.sendmessage;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class ac {
    public String kT(String str) {
        com.baidu.tbadk.coreExtra.data.g xI;
        if (str != null) {
            try {
                com.baidu.tbadk.core.voice.service.c cVar = new com.baidu.tbadk.core.voice.service.c(TbConfig.UPLOAD_CHUNK_AUDIO_ADDRESS, TbConfig.FINISH_UPLOAD_CHUNK_AUDIO_ADDRESS);
                String r = com.baidu.tbadk.core.util.l.r(str, 1);
                cVar.v("type", 2);
                com.baidu.tbadk.coreExtra.data.h ea = cVar.ea(r);
                if (ea != null && ea.isSuccess() && (xI = ea.xI()) != null) {
                    String md5 = xI.getMd5();
                    com.baidu.tbadk.core.voice.a.b.ag(str, md5);
                    return md5;
                }
            } catch (Exception e) {
            }
        }
        return null;
    }
}
