package com.baidu.tbadk.coreExtra.b;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.Disk.ops.d;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
/* loaded from: classes.dex */
public class a {
    private static volatile a beQ = null;
    private boolean beP;
    private int beR;

    private a() {
        this.beP = false;
        this.beR = 0;
        try {
            d dVar = new d("", "apk_ab_test.txt", DiskFileOperate.Action.READ);
            dVar.ab(true);
            dVar.a(DiskFileOperate.OperateType.MUST_SUCCESS);
            if (dVar.lm()) {
                String content = dVar.getContent();
                if (content != null) {
                    this.beR = Integer.parseInt(content);
                }
                if (this.beR == 1 || this.beR == 2) {
                    this.beP = true;
                }
            }
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }

    public static a EH() {
        if (beQ == null) {
            synchronized (a.class) {
                if (beQ == null) {
                    beQ = new a();
                }
            }
        }
        return beQ;
    }

    public boolean EI() {
        return this.beP;
    }

    public int EJ() {
        return this.beR;
    }

    public String EK() {
        return this.beP ? "pub_env=" + this.beR + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR : "";
    }
}
