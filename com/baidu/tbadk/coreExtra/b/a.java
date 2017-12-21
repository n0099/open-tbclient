package com.baidu.tbadk.coreExtra.b;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.Disk.ops.d;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
/* loaded from: classes.dex */
public class a {
    private static volatile a aqL = null;
    private boolean aqK;
    private int aqM;

    private a() {
        this.aqK = false;
        this.aqM = 0;
        try {
            d dVar = new d("", "apk_ab_test.txt", DiskFileOperate.Action.READ);
            dVar.v(true);
            dVar.a(DiskFileOperate.OperateType.MUST_SUCCESS);
            if (dVar.dI()) {
                String content = dVar.getContent();
                if (content != null) {
                    this.aqM = Integer.parseInt(content);
                }
                if (this.aqM == 1 || this.aqM == 2) {
                    this.aqK = true;
                }
            }
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }

    public static a xr() {
        if (aqL == null) {
            synchronized (a.class) {
                if (aqL == null) {
                    aqL = new a();
                }
            }
        }
        return aqL;
    }

    public boolean xs() {
        return this.aqK;
    }

    public int xt() {
        return this.aqM;
    }

    public String xu() {
        return this.aqK ? "pub_env=" + this.aqM + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR : "";
    }
}
