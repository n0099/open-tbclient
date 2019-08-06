package com.baidu.tieba.im.sendmessage;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.m;
import com.baidu.tbadk.coreExtra.data.k;
import com.baidu.tbadk.coreExtra.data.l;
/* loaded from: classes.dex */
public class b {
    public String zv(String str) {
        k ams;
        if (str != null) {
            try {
                com.baidu.tbadk.core.voice.service.b bVar = new com.baidu.tbadk.core.voice.service.b(TbConfig.UPLOAD_CHUNK_AUDIO_ADDRESS, TbConfig.FINISH_UPLOAD_CHUNK_AUDIO_ADDRESS);
                String O = m.O(str, 1);
                bVar.addPostParam("type", 2);
                l oZ = bVar.oZ(O);
                if (oZ != null && oZ.isSuccess() && (ams = oZ.ams()) != null) {
                    String amq = ams.amq();
                    com.baidu.tbadk.core.voice.a.b.renameFile(str, amq);
                    return amq;
                }
            } catch (Exception e) {
            }
        }
        return null;
    }
}
