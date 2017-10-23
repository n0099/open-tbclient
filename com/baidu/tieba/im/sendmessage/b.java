package com.baidu.tieba.im.sendmessage;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.k;
import com.baidu.tbadk.coreExtra.data.g;
import com.baidu.tbadk.coreExtra.data.h;
/* loaded from: classes.dex */
public class b {
    public String mC(String str) {
        g xG;
        if (str != null) {
            try {
                com.baidu.tbadk.core.voice.service.b bVar = new com.baidu.tbadk.core.voice.service.b(TbConfig.UPLOAD_CHUNK_AUDIO_ADDRESS, TbConfig.FINISH_UPLOAD_CHUNK_AUDIO_ADDRESS);
                String q = k.q(str, 1);
                bVar.v("type", 2);
                h er = bVar.er(q);
                if (er != null && er.isSuccess() && (xG = er.xG()) != null) {
                    String xE = xG.xE();
                    com.baidu.tbadk.core.voice.a.b.ah(str, xE);
                    return xE;
                }
            } catch (Exception e) {
            }
        }
        return null;
    }
}
