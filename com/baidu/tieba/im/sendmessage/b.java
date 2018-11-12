package com.baidu.tieba.im.sendmessage;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.l;
import com.baidu.tbadk.coreExtra.data.k;
/* loaded from: classes.dex */
public class b {
    public String pU(String str) {
        k FE;
        if (str != null) {
            try {
                com.baidu.tbadk.core.voice.service.b bVar = new com.baidu.tbadk.core.voice.service.b(TbConfig.UPLOAD_CHUNK_AUDIO_ADDRESS, TbConfig.FINISH_UPLOAD_CHUNK_AUDIO_ADDRESS);
                String w = l.w(str, 1);
                bVar.D("type", 2);
                com.baidu.tbadk.coreExtra.data.l gf = bVar.gf(w);
                if (gf != null && gf.isSuccess() && (FE = gf.FE()) != null) {
                    String FC = FE.FC();
                    com.baidu.tbadk.core.voice.a.b.renameFile(str, FC);
                    return FC;
                }
            } catch (Exception e) {
            }
        }
        return null;
    }
}
