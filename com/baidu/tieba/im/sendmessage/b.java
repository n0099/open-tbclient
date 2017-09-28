package com.baidu.tieba.im.sendmessage;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.k;
import com.baidu.tbadk.coreExtra.data.g;
import com.baidu.tbadk.coreExtra.data.h;
/* loaded from: classes.dex */
public class b {
    public String mD(String str) {
        g xN;
        if (str != null) {
            try {
                com.baidu.tbadk.core.voice.service.b bVar = new com.baidu.tbadk.core.voice.service.b(TbConfig.UPLOAD_CHUNK_AUDIO_ADDRESS, TbConfig.FINISH_UPLOAD_CHUNK_AUDIO_ADDRESS);
                String q = k.q(str, 1);
                bVar.v("type", 2);
                h es = bVar.es(q);
                if (es != null && es.isSuccess() && (xN = es.xN()) != null) {
                    String xL = xN.xL();
                    com.baidu.tbadk.core.voice.a.b.ai(str, xL);
                    return xL;
                }
            } catch (Exception e) {
            }
        }
        return null;
    }
}
