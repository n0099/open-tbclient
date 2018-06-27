package com.baidu.tieba.im.sendmessage;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.l;
import com.baidu.tbadk.coreExtra.data.i;
import com.baidu.tbadk.coreExtra.data.j;
/* loaded from: classes.dex */
public class b {
    public String oI(String str) {
        i Cp;
        if (str != null) {
            try {
                com.baidu.tbadk.core.voice.service.b bVar = new com.baidu.tbadk.core.voice.service.b(TbConfig.UPLOAD_CHUNK_AUDIO_ADDRESS, TbConfig.FINISH_UPLOAD_CHUNK_AUDIO_ADDRESS);
                String q = l.q(str, 1);
                bVar.x("type", 2);
                j fx = bVar.fx(q);
                if (fx != null && fx.isSuccess() && (Cp = fx.Cp()) != null) {
                    String Cn = Cp.Cn();
                    com.baidu.tbadk.core.voice.a.b.renameFile(str, Cn);
                    return Cn;
                }
            } catch (Exception e) {
            }
        }
        return null;
    }
}
