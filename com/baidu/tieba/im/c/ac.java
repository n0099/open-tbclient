package com.baidu.tieba.im.c;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class ac {
    public String lR(String str) {
        com.baidu.tbadk.coreExtra.data.g xH;
        if (str != null) {
            try {
                com.baidu.tbadk.core.voice.service.c cVar = new com.baidu.tbadk.core.voice.service.c(TbConfig.UPLOAD_CHUNK_AUDIO_ADDRESS, TbConfig.FINISH_UPLOAD_CHUNK_AUDIO_ADDRESS);
                String r = com.baidu.tbadk.core.util.m.r(str, 1);
                cVar.v("type", 2);
                com.baidu.tbadk.coreExtra.data.h eb = cVar.eb(r);
                if (eb != null && eb.isSuccess() && (xH = eb.xH()) != null) {
                    String md5 = xH.getMd5();
                    com.baidu.tbadk.core.voice.a.b.ag(str, md5);
                    return md5;
                }
            } catch (Exception e) {
            }
        }
        return null;
    }
}
