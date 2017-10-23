package com.baidu.tbadk.coreExtra.b;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.Disk.ops.d;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
/* loaded from: classes.dex */
public class a {
    private static volatile a apT = null;
    private boolean apS;
    private int apU;

    private a() {
        this.apS = false;
        this.apU = 0;
        try {
            d dVar = new d("", "apk_ab_test.txt", DiskFileOperate.Action.READ);
            dVar.v(true);
            dVar.a(DiskFileOperate.OperateType.MUST_SUCCESS);
            if (dVar.dI()) {
                String content = dVar.getContent();
                if (content != null) {
                    this.apU = Integer.parseInt(content);
                }
                if (this.apU == 1 || this.apU == 2) {
                    this.apS = true;
                }
            }
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }

    public static a xk() {
        if (apT == null) {
            synchronized (a.class) {
                if (apT == null) {
                    apT = new a();
                }
            }
        }
        return apT;
    }

    public boolean xl() {
        return this.apS;
    }

    public int xm() {
        return this.apU;
    }

    public String xn() {
        return this.apS ? "pub_env=" + this.apU + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR : "";
    }
}
