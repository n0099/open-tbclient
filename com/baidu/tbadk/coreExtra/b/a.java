package com.baidu.tbadk.coreExtra.b;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.Disk.ops.d;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
/* loaded from: classes.dex */
public class a {
    private static volatile a aNF = null;
    private boolean aNE;
    private int aNG;

    private a() {
        this.aNE = false;
        this.aNG = 0;
        try {
            d dVar = new d("", "apk_ab_test.txt", DiskFileOperate.Action.READ);
            dVar.T(true);
            dVar.a(DiskFileOperate.OperateType.MUST_SUCCESS);
            if (dVar.hC()) {
                String content = dVar.getContent();
                if (content != null) {
                    this.aNG = Integer.parseInt(content);
                }
                if (this.aNG == 1 || this.aNG == 2) {
                    this.aNE = true;
                }
            }
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }

    public static a Gp() {
        if (aNF == null) {
            synchronized (a.class) {
                if (aNF == null) {
                    aNF = new a();
                }
            }
        }
        return aNF;
    }

    public boolean Gq() {
        return this.aNE;
    }

    public int Gr() {
        return this.aNG;
    }

    public String Gs() {
        return this.aNE ? "pub_env=" + this.aNG + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR : "";
    }
}
