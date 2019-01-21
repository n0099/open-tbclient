package com.baidu.tbadk.coreExtra.b;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.Disk.ops.d;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
/* loaded from: classes.dex */
public class a {
    private static volatile a aNG = null;
    private boolean aNF;
    private int aNH;

    private a() {
        this.aNF = false;
        this.aNH = 0;
        try {
            d dVar = new d("", "apk_ab_test.txt", DiskFileOperate.Action.READ);
            dVar.T(true);
            dVar.a(DiskFileOperate.OperateType.MUST_SUCCESS);
            if (dVar.hC()) {
                String content = dVar.getContent();
                if (content != null) {
                    this.aNH = Integer.parseInt(content);
                }
                if (this.aNH == 1 || this.aNH == 2) {
                    this.aNF = true;
                }
            }
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }

    public static a Gp() {
        if (aNG == null) {
            synchronized (a.class) {
                if (aNG == null) {
                    aNG = new a();
                }
            }
        }
        return aNG;
    }

    public boolean Gq() {
        return this.aNF;
    }

    public int Gr() {
        return this.aNH;
    }

    public String Gs() {
        return this.aNF ? "pub_env=" + this.aNH + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR : "";
    }
}
