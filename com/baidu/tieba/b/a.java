package com.baidu.tieba.b;

import com.baidu.tieba.data.AudioInfoData;
import com.baidu.tieba.util.DatabaseService;
import com.baidu.tieba.util.af;
import com.baidu.tieba.util.ba;
import com.baidu.tieba.util.bs;
import java.io.File;
/* loaded from: classes.dex */
public final class a {
    private ba a;
    private b b;
    private com.baidu.tieba.data.g c;
    private String d;
    private String e;

    public a(String str, String str2) {
        this.d = str;
        this.e = str2;
    }

    public final com.baidu.tieba.data.g a(String str) {
        try {
            File file = new File(str);
            if (file.exists()) {
                this.a = new ba(String.valueOf(com.baidu.tieba.data.i.a) + this.d);
                String a = bs.a(af.a(file));
                if (a != null && a.length() > 0) {
                    a = a.toLowerCase();
                }
                com.baidu.tieba.data.f k = DatabaseService.k(a);
                if (k == null) {
                    k = new com.baidu.tieba.data.f();
                    k.a(a);
                    k.a(0);
                    k.a(file.length());
                }
                this.b = new b(this, str, k, String.valueOf(com.baidu.tieba.data.i.a) + this.d, a);
                this.c = this.b.a();
                if (this.c.b()) {
                    this.a = new ba(String.valueOf(com.baidu.tieba.data.i.a) + this.e);
                    this.a.a("voice_md5", k.a());
                    String l = this.a.l();
                    if (l == null || !this.a.c()) {
                        long b = k.b();
                        k.a((int) (b % 30720 == 0 ? b / 30720 : (b / 30720) + 1));
                        DatabaseService.a(k);
                        this.c.a(this.a.e());
                        this.c.a(this.a.i());
                        this.c.a(false);
                        l = null;
                    } else {
                        DatabaseService.j(a);
                    }
                    if (l != null && !l.equals("")) {
                        AudioInfoData audioInfoData = new AudioInfoData();
                        audioInfoData.parserJson(l);
                        if (audioInfoData.getErrorCode() > 0 || audioInfoData.getVoiceId() == null) {
                            this.c.a(audioInfoData.getErrorCode());
                            this.c.a(audioInfoData.getErrorMsg());
                            this.c.a(false);
                        } else {
                            k.a(audioInfoData.getVoiceId());
                            this.c.a(k);
                        }
                    }
                }
                return this.c;
            }
            return null;
        } catch (Exception e) {
            com.baidu.adp.lib.util.e.b(getClass().getName(), "upload", e.getMessage());
            return null;
        }
    }
}
