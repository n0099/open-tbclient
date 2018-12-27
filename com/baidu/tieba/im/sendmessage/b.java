package com.baidu.tieba.im.sendmessage;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.l;
import com.baidu.tbadk.coreExtra.data.k;
/* loaded from: classes.dex */
public class b {
    public String qz(String str) {
        k GJ;
        if (str != null) {
            try {
                com.baidu.tbadk.core.voice.service.b bVar = new com.baidu.tbadk.core.voice.service.b(TbConfig.UPLOAD_CHUNK_AUDIO_ADDRESS, TbConfig.FINISH_UPLOAD_CHUNK_AUDIO_ADDRESS);
                String w = l.w(str, 1);
                bVar.E("type", 2);
                com.baidu.tbadk.coreExtra.data.l gz = bVar.gz(w);
                if (gz != null && gz.isSuccess() && (GJ = gz.GJ()) != null) {
                    String GH = GJ.GH();
                    com.baidu.tbadk.core.voice.a.b.renameFile(str, GH);
                    return GH;
                }
            } catch (Exception e) {
            }
        }
        return null;
    }
}
