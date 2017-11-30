package com.baidu.tieba.im.sendmessage;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.k;
import com.baidu.tbadk.coreExtra.data.h;
import com.baidu.tbadk.coreExtra.data.i;
/* loaded from: classes.dex */
public class b {
    public String ni(String str) {
        h xW;
        if (str != null) {
            try {
                com.baidu.tbadk.core.voice.service.b bVar = new com.baidu.tbadk.core.voice.service.b(TbConfig.UPLOAD_CHUNK_AUDIO_ADDRESS, TbConfig.FINISH_UPLOAD_CHUNK_AUDIO_ADDRESS);
                String q = k.q(str, 1);
                bVar.x("type", 2);
                i eD = bVar.eD(q);
                if (eD != null && eD.isSuccess() && (xW = eD.xW()) != null) {
                    String xU = xW.xU();
                    com.baidu.tbadk.core.voice.a.b.renameFile(str, xU);
                    return xU;
                }
            } catch (Exception e) {
            }
        }
        return null;
    }
}
