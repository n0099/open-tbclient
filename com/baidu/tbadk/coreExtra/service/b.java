package com.baidu.tbadk.coreExtra.service;

import com.baidu.adp.lib.util.f;
import com.baidu.tbadk.core.data.n;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.k;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.coreExtra.data.AudioInfoData;
import java.io.File;
/* loaded from: classes.dex */
public final class b {
    private ak a;
    private c b;
    private com.baidu.tbadk.coreExtra.data.c c;
    private String d;
    private String e;

    public b(String str, String str2) {
        this.d = str;
        this.e = str2;
    }

    public final com.baidu.tbadk.coreExtra.data.c a(String str) {
        try {
            File file = new File(str);
            if (file.exists()) {
                this.a = new ak(String.valueOf(n.a) + this.d);
                String a = bc.a(w.a(file));
                if (a != null && a.length() > 0) {
                    a = a.toLowerCase();
                }
                com.baidu.tbadk.coreExtra.data.b b = k.b(a);
                if (b == null) {
                    b = new com.baidu.tbadk.coreExtra.data.b();
                    b.a(a);
                    b.a(0);
                    b.a(file.length());
                }
                this.b = new c(this, str, b, String.valueOf(n.a) + this.d, a);
                this.c = this.b.a();
                if (this.c.b()) {
                    this.a = new ak(String.valueOf(n.a) + this.e);
                    this.a.a("voice_md5", b.a());
                    String i = this.a.i();
                    if (i == null || !this.a.a().b().b()) {
                        long b2 = b.b();
                        b.a((int) (b2 % 30720 == 0 ? b2 / 30720 : (b2 / 30720) + 1));
                        k.a(b);
                        this.c.a(this.a.d());
                        this.c.a(this.a.f());
                        this.c.a(false);
                        i = null;
                    } else {
                        k.a(a);
                    }
                    if (i != null && !i.equals("")) {
                        AudioInfoData audioInfoData = new AudioInfoData();
                        audioInfoData.parserJson(i);
                        if (audioInfoData.getErrorCode() > 0 || audioInfoData.getVoiceId() == null) {
                            this.c.a(audioInfoData.getErrorCode());
                            this.c.a(audioInfoData.getErrorMsg());
                            this.c.a(false);
                        } else {
                            b.a(audioInfoData.getVoiceId());
                            this.c.a(b);
                        }
                    }
                }
                return this.c;
            }
            return null;
        } catch (Exception e) {
            f.b(getClass().getName(), "upload", e.getMessage());
            return null;
        }
    }
}
