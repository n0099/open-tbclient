package com.baidu.tieba.im.sendmessage;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.l;
import com.baidu.tbadk.coreExtra.data.i;
import com.baidu.tbadk.coreExtra.data.j;
/* loaded from: classes.dex */
public class b {
    public String oM(String str) {
        i Ce;
        if (str != null) {
            try {
                com.baidu.tbadk.core.voice.service.b bVar = new com.baidu.tbadk.core.voice.service.b(TbConfig.UPLOAD_CHUNK_AUDIO_ADDRESS, TbConfig.FINISH_UPLOAD_CHUNK_AUDIO_ADDRESS);
                String q = l.q(str, 1);
                bVar.x("type", 2);
                j fv = bVar.fv(q);
                if (fv != null && fv.isSuccess() && (Ce = fv.Ce()) != null) {
                    String Cc = Ce.Cc();
                    com.baidu.tbadk.core.voice.a.b.renameFile(str, Cc);
                    return Cc;
                }
            } catch (Exception e) {
            }
        }
        return null;
    }
}
