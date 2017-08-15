package com.baidu.tbadk.coreExtra.b;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.Disk.ops.d;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
/* loaded from: classes.dex */
public class a {
    private static volatile a aru = null;
    private boolean art;
    private int arv;

    private a() {
        this.art = false;
        this.arv = 0;
        try {
            d dVar = new d("", "apk_ab_test.txt", DiskFileOperate.Action.READ);
            dVar.u(true);
            dVar.a(DiskFileOperate.OperateType.MUST_SUCCESS);
            if (dVar.dT()) {
                String content = dVar.getContent();
                if (content != null) {
                    this.arv = Integer.parseInt(content);
                }
                if (this.arv == 1 || this.arv == 2) {
                    this.art = true;
                }
            }
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }

    public static a xQ() {
        if (aru == null) {
            synchronized (a.class) {
                if (aru == null) {
                    aru = new a();
                }
            }
        }
        return aru;
    }

    public boolean xR() {
        return this.art;
    }

    public int xS() {
        return this.arv;
    }

    public String xT() {
        return this.art ? "pub_env=" + this.arv + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR : "";
    }
}
