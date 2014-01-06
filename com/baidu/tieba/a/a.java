package com.baidu.tieba.a;

import com.baidu.tieba.data.AudioInfoData;
import com.baidu.tieba.util.DatabaseService;
import com.baidu.tieba.util.aa;
import com.baidu.tieba.util.at;
import com.baidu.tieba.util.bm;
import com.baidu.tieba.util.bo;
import java.io.File;
/* loaded from: classes.dex */
public class a {
    private at a;
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
            this.a = new at(com.baidu.tieba.data.h.a + this.d);
            return a(str, file);
        } catch (Exception e) {
            bo.b(getClass().getName(), "upload", e.getMessage());
            return null;
        }
    }

    private com.baidu.tieba.data.f a(String str, File file) {
        String a;
        String a2 = bm.a(aa.a(file));
        if (a2 != null && a2.length() > 0) {
            a2 = a2.toLowerCase();
        }
        com.baidu.tieba.data.e p = DatabaseService.p(a2);
        if (p == null) {
            p = new com.baidu.tieba.data.e();
            p.a(a2);
            p.a(0);
            p.a(file.length());
        }
        this.b = new b(this, str, p, com.baidu.tieba.data.h.a + this.d, a2);
        this.c = this.b.a();
        if (this.c.b() && (a = a(a2, p)) != null && !a.equals("")) {
            AudioInfoData audioInfoData = new AudioInfoData();
            audioInfoData.parserJson(a);
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
        this.a = new at(com.baidu.tieba.data.h.a + this.e);
        this.a.a("voice_md5", eVar.a());
        String l = this.a.l();
        if (l == null || !this.a.c()) {
            eVar.a((int) a(eVar.b()));
            DatabaseService.a(eVar);
            this.c.a(this.a.e());
            this.c.a(this.a.i());
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
