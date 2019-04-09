package com.baidu.tbadk.coreExtra.b;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.Disk.ops.d;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
/* loaded from: classes.dex */
public class a {
    private static volatile a bWj = null;
    private boolean bWi;
    private int bWk;

    private a() {
        this.bWi = false;
        this.bWk = 0;
        try {
            d dVar = new d("", "apk_ab_test.txt", DiskFileOperate.Action.READ);
            dVar.T(true);
            dVar.a(DiskFileOperate.OperateType.MUST_SUCCESS);
            if (dVar.hA()) {
                String content = dVar.getContent();
                if (content != null) {
                    this.bWk = Integer.parseInt(content);
                }
                if (this.bWk == 1 || this.bWk == 2) {
                    this.bWi = true;
                }
            }
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }

    public static a afG() {
        if (bWj == null) {
            synchronized (a.class) {
                if (bWj == null) {
                    bWj = new a();
                }
            }
        }
        return bWj;
    }

    public boolean afH() {
        return this.bWi;
    }

    public int afI() {
        return this.bWk;
    }

    public String afJ() {
        return this.bWi ? "pub_env=" + this.bWk + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR : "";
    }
}
