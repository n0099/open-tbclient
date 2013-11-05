package com.baidu.tieba.a;

import com.baidu.tieba.data.AudioInfoData;
import com.baidu.tieba.util.DatabaseService;
import com.baidu.tieba.util.ag;
import com.baidu.tieba.util.bc;
import com.baidu.tieba.util.be;
import com.baidu.tieba.util.w;
import java.io.File;
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private ag f992a;
    private b b;
    private com.baidu.tieba.data.f c;
    private String d;
    private String e;

    public a(String str, String str2) {
        this.d = str;
        this.e = str2;
    }

    public com.baidu.tieba.data.f a(String str) {
        try {
            File file = new File(str);
            if (file == null || !file.exists()) {
                return null;
            }
            this.f992a = new ag(com.baidu.tieba.data.h.f1165a + this.d);
            return a(str, file);
        } catch (Exception e) {
            be.b(getClass().getName(), "upload", e.getMessage());
            return null;
        }
    }

    private com.baidu.tieba.data.f a(String str, File file) {
        String a2;
        String a3 = bc.a(w.a(file));
        com.baidu.tieba.data.e o = DatabaseService.o(a3);
        if (o == null) {
            o = new com.baidu.tieba.data.e();
            o.a(a3);
            o.a(0);
            o.a(file.length());
        }
        this.b = new b(this, str, o, com.baidu.tieba.data.h.f1165a + this.d, a3);
        this.c = this.b.a();
        if (this.c.b() && (a2 = a(a3, o)) != null && !a2.equals("")) {
            AudioInfoData audioInfoData = new AudioInfoData();
            audioInfoData.parserJson(a2);
            if (audioInfoData.getErrorCode() <= 0 && audioInfoData.getVoiceId() != null) {
                o.a(audioInfoData.getVoiceId());
                this.c.a(o);
            } else {
                this.c.a(audioInfoData.getErrorCode());
                this.c.a(audioInfoData.getErrorMsg());
                this.c.a(false);
            }
        }
        return this.c;
    }

    private String a(String str, com.baidu.tieba.data.e eVar) {
        this.f992a = new ag(com.baidu.tieba.data.h.f1165a + this.e);
        this.f992a.a("voice_md5", eVar.a());
        String j = this.f992a.j();
        if (j == null || !this.f992a.c()) {
            eVar.a((int) a(eVar.b()));
            DatabaseService.a(eVar);
            this.c.a(this.f992a.e());
            this.c.a(this.f992a.g());
            this.c.a(false);
            return null;
        }
        DatabaseService.n(str);
        return j;
    }

    private long a(long j) {
        return j % 30720 == 0 ? j / 30720 : (j / 30720) + 1;
    }
}
