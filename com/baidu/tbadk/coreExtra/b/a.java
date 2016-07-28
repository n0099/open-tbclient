package com.baidu.tbadk.coreExtra.b;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.Disk.ops.d;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
/* loaded from: classes.dex */
public class a {
    private static volatile a agJ = null;
    private boolean agI;
    private int agK;

    private a() {
        this.agI = false;
        this.agK = 0;
        try {
            d dVar = new d("", "apk_ab_test.txt", DiskFileOperate.Action.READ);
            dVar.r(true);
            dVar.a(DiskFileOperate.OperateType.MUST_SUCCESS);
            if (dVar.bH()) {
                String content = dVar.getContent();
                if (content != null) {
                    this.agK = Integer.parseInt(content);
                }
                if (this.agK == 1 || this.agK == 2) {
                    this.agI = true;
                }
            }
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }

    public static a wo() {
        if (agJ == null) {
            synchronized (a.class) {
                if (agJ == null) {
                    agJ = new a();
                }
            }
        }
        return agJ;
    }

    public boolean wp() {
        return this.agI;
    }

    public int wq() {
        return this.agK;
    }

    public String wr() {
        return this.agI ? "pub_env=" + this.agK + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR : "";
    }
}
