package com.baidu.tbadk.coreExtra.b;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.Disk.ops.d;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
/* loaded from: classes.dex */
public class a {
    private static volatile a aqf = null;
    private boolean aqe;
    private int aqg;

    private a() {
        this.aqe = false;
        this.aqg = 0;
        try {
            d dVar = new d("", "apk_ab_test.txt", DiskFileOperate.Action.READ);
            dVar.v(true);
            dVar.a(DiskFileOperate.OperateType.MUST_SUCCESS);
            if (dVar.dI()) {
                String content = dVar.getContent();
                if (content != null) {
                    this.aqg = Integer.parseInt(content);
                }
                if (this.aqg == 1 || this.aqg == 2) {
                    this.aqe = true;
                }
            }
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }

    public static a xr() {
        if (aqf == null) {
            synchronized (a.class) {
                if (aqf == null) {
                    aqf = new a();
                }
            }
        }
        return aqf;
    }

    public boolean xs() {
        return this.aqe;
    }

    public int xt() {
        return this.aqg;
    }

    public String xu() {
        return this.aqe ? "pub_env=" + this.aqg + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR : "";
    }
}
