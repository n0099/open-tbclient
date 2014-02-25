package com.baidu.tieba.b;

import com.baidu.tieba.data.AudioInfoData;
import com.baidu.tieba.util.DatabaseService;
import com.baidu.tieba.util.af;
import com.baidu.tieba.util.ba;
import com.baidu.tieba.util.bs;
import java.io.File;
/* loaded from: classes.dex */
public class a {
    private ba a;
    private b b;
    private com.baidu.tieba.data.g c;
    private String d;
    private String e;

    public a(String str, String str2) {
        this.d = str;
        this.e = str2;
    }

    public com.baidu.tieba.data.g a(String str) {
        try {
            File file = new File(str);
            if (file == null || !file.exists()) {
                return null;
            }
            this.a = new ba(String.valueOf(com.baidu.tieba.data.i.a) + this.d);
            return a(str, file);
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b(getClass().getName(), "upload", e.getMessage());
            return null;
        }
    }

    private com.baidu.tieba.data.g a(String str, File file) {
        String a;
        String a2 = bs.a(af.a(file));
        if (a2 != null && a2.length() > 0) {
            a2 = a2.toLowerCase();
        }
        com.baidu.tieba.data.f m = DatabaseService.m(a2);
        if (m == null) {
            m = new com.baidu.tieba.data.f();
            m.a(a2);
            m.a(0);
            m.a(file.length());
        }
        this.b = new b(this, str, m, String.valueOf(com.baidu.tieba.data.i.a) + this.d, a2);
        this.c = this.b.a();
        if (this.c.b() && (a = a(a2, m)) != null && !a.equals("")) {
            AudioInfoData audioInfoData = new AudioInfoData();
            audioInfoData.parserJson(a);
            if (audioInfoData.getErrorCode() <= 0 && audioInfoData.getVoiceId() != null) {
                m.a(audioInfoData.getVoiceId());
                this.c.a(m);
            } else {
                this.c.a(audioInfoData.getErrorCode());
                this.c.a(audioInfoData.getErrorMsg());
                this.c.a(false);
            }
        }
        return this.c;
    }

    private String a(String str, com.baidu.tieba.data.f fVar) {
        this.a = new ba(String.valueOf(com.baidu.tieba.data.i.a) + this.e);
        this.a.a("voice_md5", fVar.a());
        String m = this.a.m();
        if (m == null || !this.a.d()) {
            fVar.a((int) a(fVar.b()));
            DatabaseService.a(fVar);
            this.c.a(this.a.f());
            this.c.a(this.a.j());
            this.c.a(false);
            return null;
        }
        DatabaseService.l(str);
        return m;
    }

    private long a(long j) {
        return j % 30720 == 0 ? j / 30720 : (j / 30720) + 1;
    }
}
