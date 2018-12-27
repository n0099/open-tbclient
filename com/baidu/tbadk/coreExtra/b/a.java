package com.baidu.tbadk.coreExtra.b;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.Disk.ops.d;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
/* loaded from: classes.dex */
public class a {
    private static volatile a aNd = null;
    private boolean aNc;
    private int aNe;

    private a() {
        this.aNc = false;
        this.aNe = 0;
        try {
            d dVar = new d("", "apk_ab_test.txt", DiskFileOperate.Action.READ);
            dVar.T(true);
            dVar.a(DiskFileOperate.OperateType.MUST_SUCCESS);
            if (dVar.hC()) {
                String content = dVar.getContent();
                if (content != null) {
                    this.aNe = Integer.parseInt(content);
                }
                if (this.aNe == 1 || this.aNe == 2) {
                    this.aNc = true;
                }
            }
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }

    public static a Gc() {
        if (aNd == null) {
            synchronized (a.class) {
                if (aNd == null) {
                    aNd = new a();
                }
            }
        }
        return aNd;
    }

    public boolean Gd() {
        return this.aNc;
    }

    public int Ge() {
        return this.aNe;
    }

    public String Gf() {
        return this.aNc ? "pub_env=" + this.aNe + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR : "";
    }
}
