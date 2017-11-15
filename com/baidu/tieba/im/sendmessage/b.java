package com.baidu.tieba.im.sendmessage;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.k;
import com.baidu.tbadk.coreExtra.data.h;
import com.baidu.tbadk.coreExtra.data.i;
/* loaded from: classes.dex */
public class b {
    public String mZ(String str) {
        h xV;
        if (str != null) {
            try {
                com.baidu.tbadk.core.voice.service.b bVar = new com.baidu.tbadk.core.voice.service.b(TbConfig.UPLOAD_CHUNK_AUDIO_ADDRESS, TbConfig.FINISH_UPLOAD_CHUNK_AUDIO_ADDRESS);
                String q = k.q(str, 1);
                bVar.x("type", 2);
                i ey = bVar.ey(q);
                if (ey != null && ey.isSuccess() && (xV = ey.xV()) != null) {
                    String xT = xV.xT();
                    com.baidu.tbadk.core.voice.a.b.renameFile(str, xT);
                    return xT;
                }
            } catch (Exception e) {
            }
        }
        return null;
    }
}
