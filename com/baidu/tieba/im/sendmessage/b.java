package com.baidu.tieba.im.sendmessage;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.k;
import com.baidu.tbadk.coreExtra.data.i;
import com.baidu.tbadk.coreExtra.data.j;
/* loaded from: classes.dex */
public class b {
    public String nM(String str) {
        i FK;
        if (str != null) {
            try {
                com.baidu.tbadk.core.voice.service.b bVar = new com.baidu.tbadk.core.voice.service.b(TbConfig.UPLOAD_CHUNK_AUDIO_ADDRESS, TbConfig.FINISH_UPLOAD_CHUNK_AUDIO_ADDRESS);
                String r = k.r(str, 1);
                bVar.x("type", 2);
                j fd = bVar.fd(r);
                if (fd != null && fd.isSuccess() && (FK = fd.FK()) != null) {
                    String FI = FK.FI();
                    com.baidu.tbadk.core.voice.a.b.renameFile(str, FI);
                    return FI;
                }
            } catch (Exception e) {
            }
        }
        return null;
    }
}
