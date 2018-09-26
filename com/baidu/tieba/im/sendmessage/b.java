package com.baidu.tieba.im.sendmessage;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.l;
import com.baidu.tbadk.coreExtra.data.j;
import com.baidu.tbadk.coreExtra.data.k;
/* loaded from: classes.dex */
public class b {
    public String pr(String str) {
        j Dr;
        if (str != null) {
            try {
                com.baidu.tbadk.core.voice.service.b bVar = new com.baidu.tbadk.core.voice.service.b(TbConfig.UPLOAD_CHUNK_AUDIO_ADDRESS, TbConfig.FINISH_UPLOAD_CHUNK_AUDIO_ADDRESS);
                String v = l.v(str, 1);
                bVar.C("type", 2);
                k fQ = bVar.fQ(v);
                if (fQ != null && fQ.isSuccess() && (Dr = fQ.Dr()) != null) {
                    String Dp = Dr.Dp();
                    com.baidu.tbadk.core.voice.a.b.renameFile(str, Dp);
                    return Dp;
                }
            } catch (Exception e) {
            }
        }
        return null;
    }
}
