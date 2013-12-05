package com.baidu.tieba.a;

import com.baidu.tieba.data.AudioInfoData;
import com.baidu.tieba.util.DatabaseService;
import com.baidu.tieba.util.am;
import com.baidu.tieba.util.bb;
import com.baidu.tieba.util.bd;
import com.baidu.tieba.util.x;
import java.io.File;
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private am f1018a;
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
            this.f1018a = new am(com.baidu.tieba.data.h.f1248a + this.d);
            return a(str, file);
        } catch (Exception e) {
            bd.b(getClass().getName(), "upload", e.getMessage());
            return null;
        }
    }

    private com.baidu.tieba.data.f a(String str, File file) {
        String a2;
        String a3 = bb.a(x.a(file));
        if (a3 != null && a3.length() > 0) {
            a3 = a3.toLowerCase();
        }
        com.baidu.tieba.data.e n = DatabaseService.n(a3);
        if (n == null) {
            n = new com.baidu.tieba.data.e();
            n.a(a3);
            n.a(0);
            n.a(file.length());
        }
        this.b = new b(this, str, n, com.baidu.tieba.data.h.f1248a + this.d, a3);
        this.c = this.b.a();
        if (this.c.b() && (a2 = a(a3, n)) != null && !a2.equals("")) {
            AudioInfoData audioInfoData = new AudioInfoData();
            audioInfoData.parserJson(a2);
            if (audioInfoData.getErrorCode() <= 0 && audioInfoData.getVoiceId() != null) {
                n.a(audioInfoData.getVoiceId());
                this.c.a(n);
            } else {
                this.c.a(audioInfoData.getErrorCode());
                this.c.a(audioInfoData.getErrorMsg());
                this.c.a(false);
            }
        }
        return this.c;
    }

    private String a(String str, com.baidu.tieba.data.e eVar) {
        this.f1018a = new am(com.baidu.tieba.data.h.f1248a + this.e);
        this.f1018a.a("voice_md5", eVar.a());
        String l = this.f1018a.l();
        if (l == null || !this.f1018a.c()) {
            eVar.a((int) a(eVar.b()));
            DatabaseService.a(eVar);
            this.c.a(this.f1018a.e());
            this.c.a(this.f1018a.i());
            this.c.a(false);
            return null;
        }
        DatabaseService.m(str);
        return l;
    }

    private long a(long j) {
        return j % 30720 == 0 ? j / 30720 : (j / 30720) + 1;
    }
}
