package com.baidu.tieba.im.model;
/* loaded from: classes.dex */
public class g {
    private static final String a = g.class.getName();
    private String b = "";

    public String a(String str) {
        com.baidu.tieba.data.f a2;
        if (str != null) {
            try {
                com.baidu.tieba.data.g a3 = new com.baidu.tieba.b.a("c/c/voice/chunkupload", "c/c/voice/voice_fin_chunk_upload").a(com.baidu.tieba.util.af.a(str, 1));
                if (a3 != null && a3.b() && (a2 = a3.a()) != null) {
                    String a4 = a2.a();
                    com.baidu.tieba.voice.a.e.a(str, a4);
                    return a4;
                }
            } catch (Exception e) {
                com.baidu.adp.lib.util.f.b(a, "submitVoiceBinary", "error: " + e.getMessage());
            }
        }
        return null;
    }
}
