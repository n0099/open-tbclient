package com.baidu.tbadk.coreExtra.b;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.Disk.ops.d;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
/* loaded from: classes.dex */
public class a {
    private static volatile a afU = null;
    private boolean afT;
    private int afV;

    private a() {
        this.afT = false;
        this.afV = 0;
        try {
            d dVar = new d("", "apk_ab_test.txt", DiskFileOperate.Action.READ);
            dVar.p(true);
            dVar.a(DiskFileOperate.OperateType.MUST_SUCCESS);
            if (dVar.bI()) {
                String content = dVar.getContent();
                if (content != null) {
                    this.afV = Integer.parseInt(content);
                }
                if (this.afV == 1 || this.afV == 2) {
                    this.afT = true;
                }
            }
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }

    public static a wo() {
        if (afU == null) {
            synchronized (a.class) {
                if (afU == null) {
                    afU = new a();
                }
            }
        }
        return afU;
    }

    public boolean wp() {
        return this.afT;
    }

    public int wq() {
        return this.afV;
    }

    public String wr() {
        return this.afT ? "pub_env=" + this.afV + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR : "";
    }
}
