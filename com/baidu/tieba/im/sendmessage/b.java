package com.baidu.tieba.im.sendmessage;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.m;
import com.baidu.tbadk.coreExtra.data.k;
import com.baidu.tbadk.coreExtra.data.l;
/* loaded from: classes.dex */
public class b {
    public String xt(String str) {
        k agp;
        if (str != null) {
            try {
                com.baidu.tbadk.core.voice.service.b bVar = new com.baidu.tbadk.core.voice.service.b(TbConfig.UPLOAD_CHUNK_AUDIO_ADDRESS, TbConfig.FINISH_UPLOAD_CHUNK_AUDIO_ADDRESS);
                String S = m.S(str, 1);
                bVar.addPostParam("type", 2);
                l ny = bVar.ny(S);
                if (ny != null && ny.isSuccess() && (agp = ny.agp()) != null) {
                    String agn = agp.agn();
                    com.baidu.tbadk.core.voice.a.b.renameFile(str, agn);
                    return agn;
                }
            } catch (Exception e) {
            }
        }
        return null;
    }
}
