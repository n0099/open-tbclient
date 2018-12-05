package com.baidu.tbadk.coreExtra.b;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.Disk.ops.d;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
/* loaded from: classes.dex */
public class a {
    private static volatile a aNb = null;
    private boolean aNa;
    private int aNc;

    private a() {
        this.aNa = false;
        this.aNc = 0;
        try {
            d dVar = new d("", "apk_ab_test.txt", DiskFileOperate.Action.READ);
            dVar.T(true);
            dVar.a(DiskFileOperate.OperateType.MUST_SUCCESS);
            if (dVar.hC()) {
                String content = dVar.getContent();
                if (content != null) {
                    this.aNc = Integer.parseInt(content);
                }
                if (this.aNc == 1 || this.aNc == 2) {
                    this.aNa = true;
                }
            }
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }

    public static a Gb() {
        if (aNb == null) {
            synchronized (a.class) {
                if (aNb == null) {
                    aNb = new a();
                }
            }
        }
        return aNb;
    }

    public boolean Gc() {
        return this.aNa;
    }

    public int Gd() {
        return this.aNc;
    }

    public String Ge() {
        return this.aNa ? "pub_env=" + this.aNc + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR : "";
    }
}
