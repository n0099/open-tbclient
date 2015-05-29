package com.baidu.tieba.im.c;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class ac {
    public String hv(String str) {
        com.baidu.tbadk.coreExtra.data.b vi;
        if (str != null) {
            try {
                com.baidu.tbadk.coreExtra.data.c dw = new com.baidu.tbadk.core.voice.service.c(TbConfig.UPLOAD_CHUNK_AUDIO_ADDRESS, TbConfig.FINISH_UPLOAD_CHUNK_AUDIO_ADDRESS).dw(com.baidu.tbadk.core.util.o.o(str, 1));
                if (dw != null && dw.isSuccess() && (vi = dw.vi()) != null) {
                    String vg = vi.vg();
                    com.baidu.tbadk.core.voice.a.b.ai(str, vg);
                    return vg;
                }
            } catch (Exception e) {
            }
        }
        return null;
    }
}
