package com.baidu.tieba.im.sendmessage;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.m;
import com.baidu.tbadk.coreExtra.data.k;
import com.baidu.tbadk.coreExtra.data.l;
/* loaded from: classes.dex */
public class b {
    public String yJ(String str) {
        k all;
        if (str != null) {
            try {
                com.baidu.tbadk.core.voice.service.b bVar = new com.baidu.tbadk.core.voice.service.b(TbConfig.UPLOAD_CHUNK_AUDIO_ADDRESS, TbConfig.FINISH_UPLOAD_CHUNK_AUDIO_ADDRESS);
                String O = m.O(str, 1);
                bVar.addPostParam("type", 2);
                l oI = bVar.oI(O);
                if (oI != null && oI.isSuccess() && (all = oI.all()) != null) {
                    String alj = all.alj();
                    com.baidu.tbadk.core.voice.a.b.renameFile(str, alj);
                    return alj;
                }
            } catch (Exception e) {
            }
        }
        return null;
    }
}
