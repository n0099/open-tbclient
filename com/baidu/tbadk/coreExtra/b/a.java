package com.baidu.tbadk.coreExtra.b;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.Disk.ops.d;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
/* loaded from: classes.dex */
public class a {
    private static volatile a aqn = null;
    private boolean aqm;
    private int aqo;

    private a() {
        this.aqm = false;
        this.aqo = 0;
        try {
            d dVar = new d("", "apk_ab_test.txt", DiskFileOperate.Action.READ);
            dVar.v(true);
            dVar.a(DiskFileOperate.OperateType.MUST_SUCCESS);
            if (dVar.dI()) {
                String content = dVar.getContent();
                if (content != null) {
                    this.aqo = Integer.parseInt(content);
                }
                if (this.aqo == 1 || this.aqo == 2) {
                    this.aqm = true;
                }
            }
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }

    public static a xr() {
        if (aqn == null) {
            synchronized (a.class) {
                if (aqn == null) {
                    aqn = new a();
                }
            }
        }
        return aqn;
    }

    public boolean xs() {
        return this.aqm;
    }

    public int xt() {
        return this.aqo;
    }

    public String xu() {
        return this.aqm ? "pub_env=" + this.aqo + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR : "";
    }
}
