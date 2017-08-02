package com.baidu.tieba.im.sendmessage;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.k;
import com.baidu.tbadk.coreExtra.data.g;
import com.baidu.tbadk.coreExtra.data.h;
/* loaded from: classes.dex */
public class b {
    public String ms(String str) {
        g yd;
        if (str != null) {
            try {
                com.baidu.tbadk.core.voice.service.b bVar = new com.baidu.tbadk.core.voice.service.b(TbConfig.UPLOAD_CHUNK_AUDIO_ADDRESS, TbConfig.FINISH_UPLOAD_CHUNK_AUDIO_ADDRESS);
                String q = k.q(str, 1);
                bVar.v("type", 2);
                h ev = bVar.ev(q);
                if (ev != null && ev.isSuccess() && (yd = ev.yd()) != null) {
                    String md5 = yd.getMd5();
                    com.baidu.tbadk.core.voice.a.b.af(str, md5);
                    return md5;
                }
            } catch (Exception e) {
            }
        }
        return null;
    }
}
