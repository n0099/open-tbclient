package com.baidu.tieba.a;

import com.baidu.tieba.data.AudioInfoData;
import com.baidu.tieba.util.DatabaseService;
import com.baidu.tieba.util.at;
import com.baidu.tieba.util.av;
import com.baidu.tieba.util.p;
import com.baidu.tieba.util.z;
import java.io.File;
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private z f863a;
    private b b;
    private com.baidu.tieba.data.e c;
    private String d;
    private String e;

    public a(String str, String str2) {
        this.d = str;
        this.e = str2;
    }

    public com.baidu.tieba.data.e a(String str) {
        try {
            File file = new File(str);
            if (file == null || !file.exists()) {
                return null;
            }
            this.f863a = new z(String.valueOf(com.baidu.tieba.data.g.f1032a) + this.d);
            return a(str, file);
        } catch (Exception e) {
            av.b(getClass().getName(), "upload", e.getMessage());
            return null;
        }
    }

    private com.baidu.tieba.data.e a(String str, File file) {
        String a2;
        String a3 = at.a(p.a(file));
        if (a3 != null && a3.length() > 0) {
            a3 = a3.toLowerCase();
        }
        com.baidu.tieba.data.d o = DatabaseService.o(a3);
        if (o == null) {
            o = new com.baidu.tieba.data.d();
            o.a(a3);
            o.a(0);
            o.a(file.length());
        }
        this.b = new b(this, str, o, String.valueOf(com.baidu.tieba.data.g.f1032a) + this.d, a3);
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

    private String a(String str, com.baidu.tieba.data.d dVar) {
        this.f863a = new z(String.valueOf(com.baidu.tieba.data.g.f1032a) + this.e);
        this.f863a.a("voice_md5", dVar.a());
        String j = this.f863a.j();
        if (j == null || !this.f863a.c()) {
            dVar.a((int) a(dVar.b()));
            DatabaseService.a(dVar);
            this.c.a(this.f863a.e());
            this.c.a(this.f863a.g());
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
