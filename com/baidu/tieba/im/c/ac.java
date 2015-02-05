package com.baidu.tieba.im.c;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class ac {
    public String hk(String str) {
        com.baidu.tbadk.coreExtra.data.b rC;
        if (str != null) {
            try {
                com.baidu.tbadk.coreExtra.data.c cW = new com.baidu.tbadk.core.voice.service.c(TbConfig.UPLOAD_CHUNK_AUDIO_ADDRESS, TbConfig.FINISH_UPLOAD_CHUNK_AUDIO_ADDRESS).cW(com.baidu.tbadk.core.util.s.n(str, 1));
                if (cW != null && cW.isSuccess() && (rC = cW.rC()) != null) {
                    String rA = rC.rA();
                    com.baidu.tbadk.core.voice.a.b.ad(str, rA);
                    return rA;
                }
            } catch (Exception e) {
            }
        }
        return null;
    }
}
