package com.baidu.tbadk.coreExtra.b;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.Disk.ops.d;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
/* loaded from: classes.dex */
public class a {
    private static volatile a ajr = null;
    private boolean ajq;
    private int ajs;

    private a() {
        this.ajq = false;
        this.ajs = 0;
        try {
            d dVar = new d("", "apk_ab_test.txt", DiskFileOperate.Action.READ);
            dVar.q(true);
            dVar.a(DiskFileOperate.OperateType.MUST_SUCCESS);
            if (dVar.fs()) {
                String content = dVar.getContent();
                if (content != null) {
                    this.ajs = Integer.parseInt(content);
                }
                if (this.ajs == 1 || this.ajs == 2) {
                    this.ajq = true;
                }
            }
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }

    public static a xQ() {
        if (ajr == null) {
            synchronized (a.class) {
                if (ajr == null) {
                    ajr = new a();
                }
            }
        }
        return ajr;
    }

    public boolean xR() {
        return this.ajq;
    }

    public int xS() {
        return this.ajs;
    }

    public String xT() {
        return this.ajq ? "pub_env=" + this.ajs + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR : "";
    }
}
