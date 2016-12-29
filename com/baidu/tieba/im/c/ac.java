package com.baidu.tieba.im.c;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class ac {
    public String kU(String str) {
        com.baidu.tbadk.coreExtra.data.g xE;
        if (str != null) {
            try {
                com.baidu.tbadk.core.voice.service.c cVar = new com.baidu.tbadk.core.voice.service.c(TbConfig.UPLOAD_CHUNK_AUDIO_ADDRESS, TbConfig.FINISH_UPLOAD_CHUNK_AUDIO_ADDRESS);
                String r = com.baidu.tbadk.core.util.m.r(str, 1);
                cVar.u("type", 2);
                com.baidu.tbadk.coreExtra.data.h ed = cVar.ed(r);
                if (ed != null && ed.isSuccess() && (xE = ed.xE()) != null) {
                    String md5 = xE.getMd5();
                    com.baidu.tbadk.core.voice.a.b.ah(str, md5);
                    return md5;
                }
            } catch (Exception e) {
            }
        }
        return null;
    }
}
