package com.baidu.tbadk.coreExtra.service;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.ae;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.i;
import com.baidu.tbadk.core.util.s;
import com.baidu.tbadk.coreExtra.data.AudioInfoData;
import java.io.File;
/* loaded from: classes.dex */
public class b {
    private ae a;
    private c b;
    private com.baidu.tbadk.coreExtra.data.c c;
    private String d;
    private String e;

    public b(String str, String str2) {
        this.d = str;
        this.e = str2;
    }

    public com.baidu.tbadk.coreExtra.data.c a(String str) {
        try {
            File file = new File(str);
            if (file == null || !file.exists()) {
                return null;
            }
            this.a = new ae(String.valueOf(TbConfig.SERVER_ADDRESS) + this.d);
            return a(str, file);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }

    private com.baidu.tbadk.coreExtra.data.c a(String str, File file) {
        String a;
        String a2 = ba.a(s.a(file));
        if (a2 != null && a2.length() > 0) {
            a2 = a2.toLowerCase();
        }
        com.baidu.tbadk.coreExtra.data.b b = i.b(a2);
        if (b == null) {
            b = new com.baidu.tbadk.coreExtra.data.b();
            b.a(a2);
            b.a(0);
            b.a(file.length());
        }
        this.b = new c(this, str, b, String.valueOf(TbConfig.SERVER_ADDRESS) + this.d, a2);
        this.c = this.b.a();
        if (this.c.b() && (a = a(a2, b)) != null && !a.equals("")) {
            AudioInfoData audioInfoData = new AudioInfoData();
            audioInfoData.parserJson(a);
            if (audioInfoData.getErrorCode() <= 0 && audioInfoData.getVoiceId() != null) {
                b.a(audioInfoData.getVoiceId());
                this.c.a(b);
            } else {
                this.c.a(audioInfoData.getErrorCode());
                this.c.a(audioInfoData.getErrorMsg());
                this.c.a(false);
            }
        }
        return this.c;
    }

    private String a(String str, com.baidu.tbadk.coreExtra.data.b bVar) {
        this.a = new ae(String.valueOf(TbConfig.SERVER_ADDRESS) + this.e);
        this.a.a("voice_md5", bVar.a());
        String h = this.a.h();
        if (h == null || !this.a.a().b().b()) {
            bVar.a((int) a(bVar.b()));
            i.a(bVar);
            this.c.a(this.a.c());
            this.c.a(this.a.e());
            this.c.a(false);
            return null;
        }
        i.a(str);
        return h;
    }

    private long a(long j) {
        return j % 30720 == 0 ? j / 30720 : (j / 30720) + 1;
    }
}
