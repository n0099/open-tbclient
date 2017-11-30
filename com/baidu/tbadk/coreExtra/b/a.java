package com.baidu.tbadk.coreExtra.b;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.Disk.ops.d;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
/* loaded from: classes.dex */
public class a {
    private static volatile a aqF = null;
    private boolean aqE;
    private int aqG;

    private a() {
        this.aqE = false;
        this.aqG = 0;
        try {
            d dVar = new d("", "apk_ab_test.txt", DiskFileOperate.Action.READ);
            dVar.v(true);
            dVar.a(DiskFileOperate.OperateType.MUST_SUCCESS);
            if (dVar.dI()) {
                String content = dVar.getContent();
                if (content != null) {
                    this.aqG = Integer.parseInt(content);
                }
                if (this.aqG == 1 || this.aqG == 2) {
                    this.aqE = true;
                }
            }
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }

    public static a xs() {
        if (aqF == null) {
            synchronized (a.class) {
                if (aqF == null) {
                    aqF = new a();
                }
            }
        }
        return aqF;
    }

    public boolean xt() {
        return this.aqE;
    }

    public int xu() {
        return this.aqG;
    }

    public String xv() {
        return this.aqE ? "pub_env=" + this.aqG + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR : "";
    }
}
