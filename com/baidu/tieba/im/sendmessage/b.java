package com.baidu.tieba.im.sendmessage;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.m;
import com.baidu.tbadk.coreExtra.data.k;
import com.baidu.tbadk.coreExtra.data.l;
/* loaded from: classes.dex */
public class b {
    public String xs(String str) {
        k agm;
        if (str != null) {
            try {
                com.baidu.tbadk.core.voice.service.b bVar = new com.baidu.tbadk.core.voice.service.b(TbConfig.UPLOAD_CHUNK_AUDIO_ADDRESS, TbConfig.FINISH_UPLOAD_CHUNK_AUDIO_ADDRESS);
                String S = m.S(str, 1);
                bVar.addPostParam("type", 2);
                l nz = bVar.nz(S);
                if (nz != null && nz.isSuccess() && (agm = nz.agm()) != null) {
                    String agk = agm.agk();
                    com.baidu.tbadk.core.voice.a.b.renameFile(str, agk);
                    return agk;
                }
            } catch (Exception e) {
            }
        }
        return null;
    }
}
