package com.baidu.tbadk.coreExtra.service;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.u;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.ac;
import com.baidu.tbadk.core.util.i;
import com.baidu.tbadk.core.util.s;
import com.baidu.tbadk.coreExtra.data.AudioInfoData;
import java.io.File;
/* loaded from: classes.dex */
public class b {
    private c MA;
    private com.baidu.tbadk.coreExtra.data.c MB;
    private String MC;
    private String MD;
    private ac yV;

    public b(String str, String str2) {
        this.MC = str;
        this.MD = str2;
    }

    public com.baidu.tbadk.coreExtra.data.c cI(String str) {
        try {
            File file = new File(str);
            if (file == null || !file.exists()) {
                return null;
            }
            this.yV = new ac(String.valueOf(TbConfig.SERVER_ADDRESS) + this.MC);
            return a(str, file);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }

    private com.baidu.tbadk.coreExtra.data.c a(String str, File file) {
        String a;
        String b = u.b(s.k(file));
        if (b != null && b.length() > 0) {
            b = b.toLowerCase();
        }
        com.baidu.tbadk.coreExtra.data.b bn = i.bn(b);
        if (bn == null) {
            bn = new com.baidu.tbadk.coreExtra.data.b();
            bn.cn(b);
            bn.bV(0);
            bn.l(file.length());
        }
        this.MA = new c(this, str, bn, String.valueOf(TbConfig.SERVER_ADDRESS) + this.MC, b);
        this.MB = this.MA.pH();
        if (this.MB.isSuccess() && (a = a(b, bn)) != null && !a.equals("")) {
            AudioInfoData audioInfoData = new AudioInfoData();
            audioInfoData.parserJson(a);
            if (audioInfoData.getErrorCode() <= 0 && audioInfoData.getVoiceId() != null) {
                bn.cn(audioInfoData.getVoiceId());
                this.MB.b(bn);
            } else {
                this.MB.setErrorCode(audioInfoData.getErrorCode());
                this.MB.setErrorString(audioInfoData.getErrorMsg());
                this.MB.ab(false);
            }
        }
        return this.MB;
    }

    private String a(String str, com.baidu.tbadk.coreExtra.data.b bVar) {
        this.yV = new ac(String.valueOf(TbConfig.SERVER_ADDRESS) + this.MD);
        this.yV.k("voice_md5", bVar.ou());
        String lA = this.yV.lA();
        if (lA == null || !this.yV.mc().nb().jq()) {
            bVar.bV((int) n(bVar.ov()));
            i.a(bVar);
            this.MB.setErrorCode(this.yV.mg());
            this.MB.setErrorString(this.yV.getErrorString());
            this.MB.ab(false);
            return null;
        }
        i.bm(str);
        return lA;
    }

    private long n(long j) {
        return j % 30720 == 0 ? j / 30720 : (j / 30720) + 1;
    }
}
