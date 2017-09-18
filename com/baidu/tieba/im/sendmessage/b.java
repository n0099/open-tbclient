package com.baidu.tieba.im.sendmessage;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.k;
import com.baidu.tbadk.coreExtra.data.g;
import com.baidu.tbadk.coreExtra.data.h;
/* loaded from: classes.dex */
public class b {
    public String mZ(String str) {
        g yo;
        if (str != null) {
            try {
                com.baidu.tbadk.core.voice.service.b bVar = new com.baidu.tbadk.core.voice.service.b(TbConfig.UPLOAD_CHUNK_AUDIO_ADDRESS, TbConfig.FINISH_UPLOAD_CHUNK_AUDIO_ADDRESS);
                String q = k.q(str, 1);
                bVar.v("type", 2);
                h ey = bVar.ey(q);
                if (ey != null && ey.isSuccess() && (yo = ey.yo()) != null) {
                    String ym = yo.ym();
                    com.baidu.tbadk.core.voice.a.b.ai(str, ym);
                    return ym;
                }
            } catch (Exception e) {
            }
        }
        return null;
    }
}
