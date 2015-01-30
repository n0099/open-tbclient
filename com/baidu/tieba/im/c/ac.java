package com.baidu.tieba.im.c;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class ac {
    public String hn(String str) {
        com.baidu.tbadk.coreExtra.data.b rI;
        if (str != null) {
            try {
                com.baidu.tbadk.coreExtra.data.c cZ = new com.baidu.tbadk.core.voice.service.c(TbConfig.UPLOAD_CHUNK_AUDIO_ADDRESS, TbConfig.FINISH_UPLOAD_CHUNK_AUDIO_ADDRESS).cZ(com.baidu.tbadk.core.util.s.n(str, 1));
                if (cZ != null && cZ.isSuccess() && (rI = cZ.rI()) != null) {
                    String rG = rI.rG();
                    com.baidu.tbadk.core.voice.a.b.ad(str, rG);
                    return rG;
                }
            } catch (Exception e) {
            }
        }
        return null;
    }
}
