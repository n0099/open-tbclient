package com.baidu.tbadk.coreExtra.b;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.Disk.ops.d;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
/* loaded from: classes.dex */
public class a {
    private static volatile a aqI = null;
    private boolean aqH;
    private int aqJ;

    private a() {
        this.aqH = false;
        this.aqJ = 0;
        try {
            d dVar = new d("", "apk_ab_test.txt", DiskFileOperate.Action.READ);
            dVar.v(true);
            dVar.a(DiskFileOperate.OperateType.MUST_SUCCESS);
            if (dVar.dI()) {
                String content = dVar.getContent();
                if (content != null) {
                    this.aqJ = Integer.parseInt(content);
                }
                if (this.aqJ == 1 || this.aqJ == 2) {
                    this.aqH = true;
                }
            }
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }

    public static a xr() {
        if (aqI == null) {
            synchronized (a.class) {
                if (aqI == null) {
                    aqI = new a();
                }
            }
        }
        return aqI;
    }

    public boolean xs() {
        return this.aqH;
    }

    public int xt() {
        return this.aqJ;
    }

    public String xu() {
        return this.aqH ? "pub_env=" + this.aqJ + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR : "";
    }
}
