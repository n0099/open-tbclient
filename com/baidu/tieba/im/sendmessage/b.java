package com.baidu.tieba.im.sendmessage;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.k;
import com.baidu.tbadk.coreExtra.data.i;
import com.baidu.tbadk.coreExtra.data.j;
/* loaded from: classes.dex */
public class b {
    public String nQ(String str) {
        i yy;
        if (str != null) {
            try {
                com.baidu.tbadk.core.voice.service.b bVar = new com.baidu.tbadk.core.voice.service.b(TbConfig.UPLOAD_CHUNK_AUDIO_ADDRESS, TbConfig.FINISH_UPLOAD_CHUNK_AUDIO_ADDRESS);
                String q = k.q(str, 1);
                bVar.x("type", 2);
                j eV = bVar.eV(q);
                if (eV != null && eV.isSuccess() && (yy = eV.yy()) != null) {
                    String yw = yy.yw();
                    com.baidu.tbadk.core.voice.a.b.renameFile(str, yw);
                    return yw;
                }
            } catch (Exception e) {
            }
        }
        return null;
    }
}
