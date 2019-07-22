package com.baidu.tbadk.coreExtra.b;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.Disk.ops.d;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
/* loaded from: classes.dex */
public class a {
    private static volatile a cfi = null;
    private boolean cfh;
    private int cfj;

    private a() {
        this.cfh = false;
        this.cfj = 0;
        try {
            d dVar = new d("", "apk_ab_test.txt", DiskFileOperate.Action.READ);
            dVar.L(true);
            dVar.a(DiskFileOperate.OperateType.MUST_SUCCESS);
            if (dVar.gD()) {
                String content = dVar.getContent();
                if (content != null) {
                    this.cfj = Integer.parseInt(content);
                }
                if (this.cfj == 1 || this.cfj == 2) {
                    this.cfh = true;
                }
            }
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }

    public static a alK() {
        if (cfi == null) {
            synchronized (a.class) {
                if (cfi == null) {
                    cfi = new a();
                }
            }
        }
        return cfi;
    }

    public boolean alL() {
        return this.cfh;
    }

    public int alM() {
        return this.cfj;
    }

    public String alN() {
        return this.cfh ? "pub_env=" + this.cfj + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR : "";
    }
}
