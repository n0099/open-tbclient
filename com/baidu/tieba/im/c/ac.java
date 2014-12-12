package com.baidu.tieba.im.c;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class ac {
    public String hi(String str) {
        com.baidu.tbadk.coreExtra.data.b rw;
        if (str != null) {
            try {
                com.baidu.tbadk.coreExtra.data.c da = new com.baidu.tbadk.core.voice.service.c(TbConfig.UPLOAD_CHUNK_AUDIO_ADDRESS, TbConfig.FINISH_UPLOAD_CHUNK_AUDIO_ADDRESS).da(com.baidu.tbadk.core.util.s.n(str, 1));
                if (da != null && da.isSuccess() && (rw = da.rw()) != null) {
                    String ru = rw.ru();
                    com.baidu.tbadk.core.voice.a.b.aa(str, ru);
                    return ru;
                }
            } catch (Exception e) {
            }
        }
        return null;
    }
}
