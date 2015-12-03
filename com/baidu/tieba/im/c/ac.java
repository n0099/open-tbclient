package com.baidu.tieba.im.c;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class ac {
    public String iH(String str) {
        com.baidu.tbadk.coreExtra.data.c xd;
        if (str != null) {
            try {
                com.baidu.tbadk.coreExtra.data.d dQ = new com.baidu.tbadk.core.voice.service.c(TbConfig.UPLOAD_CHUNK_AUDIO_ADDRESS, TbConfig.FINISH_UPLOAD_CHUNK_AUDIO_ADDRESS).dQ(com.baidu.tbadk.core.util.n.q(str, 1));
                if (dQ != null && dQ.isSuccess() && (xd = dQ.xd()) != null) {
                    String xb = xd.xb();
                    com.baidu.tbadk.core.voice.a.b.ae(str, xb);
                    return xb;
                }
            } catch (Exception e) {
            }
        }
        return null;
    }
}
