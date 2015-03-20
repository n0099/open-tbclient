package com.baidu.tieba.im.c;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class ac {
    public String gP(String str) {
        com.baidu.tbadk.coreExtra.data.b uz;
        if (str != null) {
            try {
                com.baidu.tbadk.coreExtra.data.c df = new com.baidu.tbadk.core.voice.service.c(TbConfig.UPLOAD_CHUNK_AUDIO_ADDRESS, TbConfig.FINISH_UPLOAD_CHUNK_AUDIO_ADDRESS).df(com.baidu.tbadk.core.util.o.o(str, 1));
                if (df != null && df.isSuccess() && (uz = df.uz()) != null) {
                    String ux = uz.ux();
                    com.baidu.tbadk.core.voice.a.b.ad(str, ux);
                    return ux;
                }
            } catch (Exception e) {
            }
        }
        return null;
    }
}
