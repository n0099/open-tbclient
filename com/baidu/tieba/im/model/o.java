package com.baidu.tieba.im.model;
/* loaded from: classes.dex */
public class o {
    private static final String a = o.class.getName();

    public static String a(String str) {
        com.baidu.tbadk.coreExtra.data.b a2;
        if (str != null) {
            try {
                com.baidu.tbadk.coreExtra.data.c a3 = new com.baidu.tbadk.coreExtra.service.b("c/c/voice/chunkupload", "c/c/voice/voice_fin_chunk_upload").a(com.baidu.tbadk.core.util.w.a(str, 1));
                if (a3 != null && a3.b() && (a2 = a3.a()) != null) {
                    String a4 = a2.a();
                    com.baidu.tbadk.core.voice.a.e.a(str, a4);
                    return a4;
                }
            } catch (Exception e) {
                com.baidu.adp.lib.util.f.b(a, "submitVoiceBinary", "error: " + e.getMessage());
            }
        }
        return null;
    }
}
