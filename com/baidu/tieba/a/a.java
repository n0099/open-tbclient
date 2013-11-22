package com.baidu.tieba.a;

import com.baidu.tieba.data.AudioInfoData;
import com.baidu.tieba.util.DatabaseService;
import com.baidu.tieba.util.af;
import com.baidu.tieba.util.ap;
import com.baidu.tieba.util.be;
import com.baidu.tieba.util.bg;
import java.io.File;
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private ap f1008a;
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
            this.f1008a = new ap(com.baidu.tieba.data.h.f1201a + this.d);
            return a(str, file);
        } catch (Exception e) {
            bg.b(getClass().getName(), "upload", e.getMessage());
            return null;
        }
    }

    private com.baidu.tieba.data.f a(String str, File file) {
        String a2;
        String a3 = be.a(af.a(file));
        if (a3 != null && a3.length() > 0) {
            a3 = a3.toLowerCase();
        }
        com.baidu.tieba.data.e p = DatabaseService.p(a3);
        if (p == null) {
            p = new com.baidu.tieba.data.e();
            p.a(a3);
            p.a(0);
            p.a(file.length());
        }
        this.b = new b(this, str, p, com.baidu.tieba.data.h.f1201a + this.d, a3);
        this.c = this.b.a();
        if (this.c.b() && (a2 = a(a3, p)) != null && !a2.equals("")) {
            AudioInfoData audioInfoData = new AudioInfoData();
            audioInfoData.parserJson(a2);
            if (audioInfoData.getErrorCode() <= 0 && audioInfoData.getVoiceId() != null) {
                p.a(audioInfoData.getVoiceId());
                this.c.a(p);
            } else {
                this.c.a(audioInfoData.getErrorCode());
                this.c.a(audioInfoData.getErrorMsg());
                this.c.a(false);
            }
        }
        return this.c;
    }

    private String a(String str, com.baidu.tieba.data.e eVar) {
        this.f1008a = new ap(com.baidu.tieba.data.h.f1201a + this.e);
        this.f1008a.a("voice_md5", eVar.a());
        String l = this.f1008a.l();
        if (l == null || !this.f1008a.c()) {
            eVar.a((int) a(eVar.b()));
            DatabaseService.a(eVar);
            this.c.a(this.f1008a.e());
            this.c.a(this.f1008a.i());
            this.c.a(false);
            return null;
        }
        DatabaseService.o(str);
        return l;
    }

    private long a(long j) {
        return j % 30720 == 0 ? j / 30720 : (j / 30720) + 1;
    }
}
