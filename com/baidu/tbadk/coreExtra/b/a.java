package com.baidu.tbadk.coreExtra.b;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.Disk.ops.d;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
/* loaded from: classes.dex */
public class a {
    private static volatile a aqo = null;
    private boolean aqn;
    private int aqp;

    private a() {
        this.aqn = false;
        this.aqp = 0;
        try {
            d dVar = new d("", "apk_ab_test.txt", DiskFileOperate.Action.READ);
            dVar.v(true);
            dVar.a(DiskFileOperate.OperateType.MUST_SUCCESS);
            if (dVar.dI()) {
                String content = dVar.getContent();
                if (content != null) {
                    this.aqp = Integer.parseInt(content);
                }
                if (this.aqp == 1 || this.aqp == 2) {
                    this.aqn = true;
                }
            }
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }

    public static a xr() {
        if (aqo == null) {
            synchronized (a.class) {
                if (aqo == null) {
                    aqo = new a();
                }
            }
        }
        return aqo;
    }

    public boolean xs() {
        return this.aqn;
    }

    public int xt() {
        return this.aqp;
    }

    public String xu() {
        return this.aqn ? "pub_env=" + this.aqp + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR : "";
    }
}
