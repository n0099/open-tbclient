package com.baidu.tbadk.coreExtra.b;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.Disk.ops.d;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
/* loaded from: classes.dex */
public class a {
    private static volatile a bWi = null;
    private boolean bWh;
    private int bWj;

    private a() {
        this.bWh = false;
        this.bWj = 0;
        try {
            d dVar = new d("", "apk_ab_test.txt", DiskFileOperate.Action.READ);
            dVar.T(true);
            dVar.a(DiskFileOperate.OperateType.MUST_SUCCESS);
            if (dVar.hA()) {
                String content = dVar.getContent();
                if (content != null) {
                    this.bWj = Integer.parseInt(content);
                }
                if (this.bWj == 1 || this.bWj == 2) {
                    this.bWh = true;
                }
            }
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }

    public static a afG() {
        if (bWi == null) {
            synchronized (a.class) {
                if (bWi == null) {
                    bWi = new a();
                }
            }
        }
        return bWi;
    }

    public boolean afH() {
        return this.bWh;
    }

    public int afI() {
        return this.bWj;
    }

    public String afJ() {
        return this.bWh ? "pub_env=" + this.bWj + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR : "";
    }
}
