package com.baidu.tbadk.coreExtra.b;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.Disk.ops.d;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
/* loaded from: classes.dex */
public class a {
    private static volatile a art = null;
    private boolean ars;
    private int aru;

    private a() {
        this.ars = false;
        this.aru = 0;
        try {
            d dVar = new d("", "apk_ab_test.txt", DiskFileOperate.Action.READ);
            dVar.u(true);
            dVar.a(DiskFileOperate.OperateType.MUST_SUCCESS);
            if (dVar.dT()) {
                String content = dVar.getContent();
                if (content != null) {
                    this.aru = Integer.parseInt(content);
                }
                if (this.aru == 1 || this.aru == 2) {
                    this.ars = true;
                }
            }
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }

    public static a xQ() {
        if (art == null) {
            synchronized (a.class) {
                if (art == null) {
                    art = new a();
                }
            }
        }
        return art;
    }

    public boolean xR() {
        return this.ars;
    }

    public int xS() {
        return this.aru;
    }

    public String xT() {
        return this.ars ? "pub_env=" + this.aru + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR : "";
    }
}
