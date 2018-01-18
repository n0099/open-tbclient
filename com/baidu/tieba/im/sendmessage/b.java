package com.baidu.tieba.im.sendmessage;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.k;
import com.baidu.tbadk.coreExtra.data.i;
import com.baidu.tbadk.coreExtra.data.j;
/* loaded from: classes.dex */
public class b {
    public String nu(String str) {
        i Fn;
        if (str != null) {
            try {
                com.baidu.tbadk.core.voice.service.b bVar = new com.baidu.tbadk.core.voice.service.b(TbConfig.UPLOAD_CHUNK_AUDIO_ADDRESS, TbConfig.FINISH_UPLOAD_CHUNK_AUDIO_ADDRESS);
                String r = k.r(str, 1);
                bVar.x("type", 2);
                j eK = bVar.eK(r);
                if (eK != null && eK.isSuccess() && (Fn = eK.Fn()) != null) {
                    String Fl = Fn.Fl();
                    com.baidu.tbadk.core.voice.a.b.renameFile(str, Fl);
                    return Fl;
                }
            } catch (Exception e) {
            }
        }
        return null;
    }
}
