package com.baidu.tieba.im.sendmessage;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.l;
import com.baidu.tbadk.coreExtra.data.j;
import com.baidu.tbadk.coreExtra.data.k;
/* loaded from: classes.dex */
public class b {
    public String pT(String str) {
        j Fs;
        if (str != null) {
            try {
                com.baidu.tbadk.core.voice.service.b bVar = new com.baidu.tbadk.core.voice.service.b(TbConfig.UPLOAD_CHUNK_AUDIO_ADDRESS, TbConfig.FINISH_UPLOAD_CHUNK_AUDIO_ADDRESS);
                String w = l.w(str, 1);
                bVar.D("type", 2);
                k ge = bVar.ge(w);
                if (ge != null && ge.isSuccess() && (Fs = ge.Fs()) != null) {
                    String Fq = Fs.Fq();
                    com.baidu.tbadk.core.voice.a.b.renameFile(str, Fq);
                    return Fq;
                }
            } catch (Exception e) {
            }
        }
        return null;
    }
}
