package com.baidu.tieba.im.sendmessage;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.k;
import com.baidu.tbadk.coreExtra.data.i;
import com.baidu.tbadk.coreExtra.data.j;
/* loaded from: classes.dex */
public class b {
    public String ni(String str) {
        i xX;
        if (str != null) {
            try {
                com.baidu.tbadk.core.voice.service.b bVar = new com.baidu.tbadk.core.voice.service.b(TbConfig.UPLOAD_CHUNK_AUDIO_ADDRESS, TbConfig.FINISH_UPLOAD_CHUNK_AUDIO_ADDRESS);
                String q = k.q(str, 1);
                bVar.x("type", 2);
                j eD = bVar.eD(q);
                if (eD != null && eD.isSuccess() && (xX = eD.xX()) != null) {
                    String xV = xX.xV();
                    com.baidu.tbadk.core.voice.a.b.renameFile(str, xV);
                    return xV;
                }
            } catch (Exception e) {
            }
        }
        return null;
    }
}
