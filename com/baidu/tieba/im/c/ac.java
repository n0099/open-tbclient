package com.baidu.tieba.im.c;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class ac {
    public String iU(String str) {
        com.baidu.tbadk.coreExtra.data.c wM;
        if (str != null) {
            try {
                com.baidu.tbadk.coreExtra.data.d dT = new com.baidu.tbadk.core.voice.service.c(TbConfig.UPLOAD_CHUNK_AUDIO_ADDRESS, TbConfig.FINISH_UPLOAD_CHUNK_AUDIO_ADDRESS).dT(com.baidu.tbadk.core.util.n.q(str, 1));
                if (dT != null && dT.isSuccess() && (wM = dT.wM()) != null) {
                    String wK = wM.wK();
                    com.baidu.tbadk.core.voice.a.b.ad(str, wK);
                    return wK;
                }
            } catch (Exception e) {
            }
        }
        return null;
    }
}
