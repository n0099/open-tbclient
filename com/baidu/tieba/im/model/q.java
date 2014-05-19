package com.baidu.tieba.im.model;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class q {
    private static final String a = q.class.getName();

    public String a(String str) {
        com.baidu.tbadk.coreExtra.data.b a2;
        if (str != null) {
            try {
                com.baidu.tbadk.coreExtra.data.c a3 = new com.baidu.tbadk.coreExtra.service.b(TbConfig.UPLOAD_CHUNK_AUDIO_ADDRESS, TbConfig.FINISH_UPLOAD_CHUNK_AUDIO_ADDRESS).a(com.baidu.tbadk.core.util.x.a(str, 1));
                if (a3 != null && a3.b() && (a2 = a3.a()) != null) {
                    String a4 = a2.a();
                    com.baidu.tbadk.core.voice.a.e.a(str, a4);
                    return a4;
                }
            } catch (Exception e) {
                BdLog.e(a, "submitVoiceBinary", "error: " + e.getMessage());
            }
        }
        return null;
    }
}
