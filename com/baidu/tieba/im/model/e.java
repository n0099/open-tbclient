package com.baidu.tieba.im.model;

import com.baidu.tieba.util.af;
/* loaded from: classes.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private static final String f1748a = e.class.getName();
    private String b = "";

    public String a(String str) {
        com.baidu.tieba.data.e a2;
        if (str != null) {
            try {
                com.baidu.tieba.data.f a3 = new com.baidu.tieba.a.a("c/c/voice/chunkupload", "c/c/voice/voice_fin_chunk_upload").a(af.a(str, 1));
                if (a3 != null && a3.b() && (a2 = a3.a()) != null) {
                    String a4 = a2.a();
                    com.baidu.tieba.voice.a.e.a(str, a4);
                    return a4;
                }
            } catch (Exception e) {
                com.baidu.adp.lib.h.d.b(f1748a, "submitVoiceBinary", "error: " + e.getMessage());
            }
        }
        return null;
    }
}
