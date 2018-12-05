package com.baidu.tieba.im.sendmessage;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.l;
import com.baidu.tbadk.coreExtra.data.k;
/* loaded from: classes.dex */
public class b {
    public String qw(String str) {
        k GI;
        if (str != null) {
            try {
                com.baidu.tbadk.core.voice.service.b bVar = new com.baidu.tbadk.core.voice.service.b(TbConfig.UPLOAD_CHUNK_AUDIO_ADDRESS, TbConfig.FINISH_UPLOAD_CHUNK_AUDIO_ADDRESS);
                String w = l.w(str, 1);
                bVar.D("type", 2);
                com.baidu.tbadk.coreExtra.data.l gy = bVar.gy(w);
                if (gy != null && gy.isSuccess() && (GI = gy.GI()) != null) {
                    String GG = GI.GG();
                    com.baidu.tbadk.core.voice.a.b.renameFile(str, GG);
                    return GG;
                }
            } catch (Exception e) {
            }
        }
        return null;
    }
}
