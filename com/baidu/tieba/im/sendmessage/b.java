package com.baidu.tieba.im.sendmessage;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.m;
import com.baidu.tbadk.coreExtra.data.k;
import com.baidu.tbadk.coreExtra.data.l;
/* loaded from: classes.dex */
public class b {
    public String zU(String str) {
        k amE;
        if (str != null) {
            try {
                com.baidu.tbadk.core.voice.service.b bVar = new com.baidu.tbadk.core.voice.service.b(TbConfig.UPLOAD_CHUNK_AUDIO_ADDRESS, TbConfig.FINISH_UPLOAD_CHUNK_AUDIO_ADDRESS);
                String O = m.O(str, 1);
                bVar.addPostParam("type", 2);
                l ph = bVar.ph(O);
                if (ph != null && ph.isSuccess() && (amE = ph.amE()) != null) {
                    String amC = amE.amC();
                    com.baidu.tbadk.core.voice.a.b.renameFile(str, amC);
                    return amC;
                }
            } catch (Exception e) {
            }
        }
        return null;
    }
}
