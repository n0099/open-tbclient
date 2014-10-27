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
    private String MA;
    private c Mx;
    private com.baidu.tbadk.coreExtra.data.c My;
    private String Mz;
    private ac yV;

    public b(String str, String str2) {
        this.Mz = str;
        this.MA = str2;
    }

    public com.baidu.tbadk.coreExtra.data.c cH(String str) {
        try {
            File file = new File(str);
            if (file == null || !file.exists()) {
                return null;
            }
            this.yV = new ac(String.valueOf(TbConfig.SERVER_ADDRESS) + this.Mz);
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
        this.Mx = new c(this, str, bn, String.valueOf(TbConfig.SERVER_ADDRESS) + this.Mz, b);
        this.My = this.Mx.pF();
        if (this.My.isSuccess() && (a = a(b, bn)) != null && !a.equals("")) {
            AudioInfoData audioInfoData = new AudioInfoData();
            audioInfoData.parserJson(a);
            if (audioInfoData.getErrorCode() <= 0 && audioInfoData.getVoiceId() != null) {
                bn.cn(audioInfoData.getVoiceId());
                this.My.b(bn);
            } else {
                this.My.setErrorCode(audioInfoData.getErrorCode());
                this.My.setErrorString(audioInfoData.getErrorMsg());
                this.My.ab(false);
            }
        }
        return this.My;
    }

    private String a(String str, com.baidu.tbadk.coreExtra.data.b bVar) {
        this.yV = new ac(String.valueOf(TbConfig.SERVER_ADDRESS) + this.MA);
        this.yV.k("voice_md5", bVar.ou());
        String lA = this.yV.lA();
        if (lA == null || !this.yV.mc().nb().jq()) {
            bVar.bV((int) n(bVar.ov()));
            i.a(bVar);
            this.My.setErrorCode(this.yV.mg());
            this.My.setErrorString(this.yV.getErrorString());
            this.My.ab(false);
            return null;
        }
        i.bm(str);
        return lA;
    }

    private long n(long j) {
        return j % 30720 == 0 ? j / 30720 : (j / 30720) + 1;
    }
}
