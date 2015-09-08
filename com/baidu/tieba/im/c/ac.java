package com.baidu.tieba.im.c;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class ac {
    public String ih(String str) {
        com.baidu.tbadk.coreExtra.data.b ww;
        if (str != null) {
            try {
                com.baidu.tbadk.coreExtra.data.c dE = new com.baidu.tbadk.core.voice.service.c(TbConfig.UPLOAD_CHUNK_AUDIO_ADDRESS, TbConfig.FINISH_UPLOAD_CHUNK_AUDIO_ADDRESS).dE(com.baidu.tbadk.core.util.n.q(str, 1));
                if (dE != null && dE.isSuccess() && (ww = dE.ww()) != null) {
                    String wu = ww.wu();
                    com.baidu.tbadk.core.voice.a.b.ai(str, wu);
                    return wu;
                }
            } catch (Exception e) {
            }
        }
        return null;
    }
}
