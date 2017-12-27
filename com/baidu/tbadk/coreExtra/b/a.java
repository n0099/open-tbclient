package com.baidu.tbadk.coreExtra.b;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.Disk.ops.d;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
/* loaded from: classes.dex */
public class a {
    private static volatile a beK = null;
    private boolean beJ;
    private int beL;

    private a() {
        this.beJ = false;
        this.beL = 0;
        try {
            d dVar = new d("", "apk_ab_test.txt", DiskFileOperate.Action.READ);
            dVar.ab(true);
            dVar.a(DiskFileOperate.OperateType.MUST_SUCCESS);
            if (dVar.lm()) {
                String content = dVar.getContent();
                if (content != null) {
                    this.beL = Integer.parseInt(content);
                }
                if (this.beL == 1 || this.beL == 2) {
                    this.beJ = true;
                }
            }
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }

    public static a EQ() {
        if (beK == null) {
            synchronized (a.class) {
                if (beK == null) {
                    beK = new a();
                }
            }
        }
        return beK;
    }

    public boolean ER() {
        return this.beJ;
    }

    public int ES() {
        return this.beL;
    }

    public String ET() {
        return this.beJ ? "pub_env=" + this.beL + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR : "";
    }
}
