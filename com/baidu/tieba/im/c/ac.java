package com.baidu.tieba.im.c;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class ac {
    public String il(String str) {
        com.baidu.tbadk.coreExtra.data.b wh;
        if (str != null) {
            try {
                com.baidu.tbadk.coreExtra.data.c dI = new com.baidu.tbadk.core.voice.service.c(TbConfig.UPLOAD_CHUNK_AUDIO_ADDRESS, TbConfig.FINISH_UPLOAD_CHUNK_AUDIO_ADDRESS).dI(com.baidu.tbadk.core.util.n.q(str, 1));
                if (dI != null && dI.isSuccess() && (wh = dI.wh()) != null) {
                    String wf = wh.wf();
                    com.baidu.tbadk.core.voice.a.b.ah(str, wf);
                    return wf;
                }
            } catch (Exception e) {
            }
        }
        return null;
    }
}
