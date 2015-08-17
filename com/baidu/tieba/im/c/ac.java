package com.baidu.tieba.im.c;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class ac {
    public String hX(String str) {
        com.baidu.tbadk.coreExtra.data.b wq;
        if (str != null) {
            try {
                com.baidu.tbadk.coreExtra.data.c dx = new com.baidu.tbadk.core.voice.service.c(TbConfig.UPLOAD_CHUNK_AUDIO_ADDRESS, TbConfig.FINISH_UPLOAD_CHUNK_AUDIO_ADDRESS).dx(com.baidu.tbadk.core.util.n.q(str, 1));
                if (dx != null && dx.isSuccess() && (wq = dx.wq()) != null) {
                    String wo = wq.wo();
                    com.baidu.tbadk.core.voice.a.b.ai(str, wo);
                    return wo;
                }
            } catch (Exception e) {
            }
        }
        return null;
    }
}
