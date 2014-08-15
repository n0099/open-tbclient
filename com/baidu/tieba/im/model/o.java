package com.baidu.tieba.im.model;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class o {
    public String a(String str) {
        com.baidu.tbadk.coreExtra.data.b a;
        if (str != null) {
            try {
                com.baidu.tbadk.coreExtra.data.c a2 = new com.baidu.tbadk.coreExtra.service.b(TbConfig.UPLOAD_CHUNK_AUDIO_ADDRESS, TbConfig.FINISH_UPLOAD_CHUNK_AUDIO_ADDRESS).a(com.baidu.tbadk.core.util.s.a(str, 1));
                if (a2 != null && a2.b() && (a = a2.a()) != null) {
                    String a3 = a.a();
                    com.baidu.tbadk.core.voice.a.b.a(str, a3);
                    return a3;
                }
            } catch (Exception e) {
            }
        }
        return null;
    }
}
