package com.baidu.tbadk.coreExtra.b;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.Disk.ops.d;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
/* loaded from: classes.dex */
public class a {
    private static volatile a ajf = null;
    private boolean aje;
    private int ajg;

    private a() {
        this.aje = false;
        this.ajg = 0;
        try {
            d dVar = new d("", "apk_ab_test.txt", DiskFileOperate.Action.READ);
            dVar.t(true);
            dVar.a(DiskFileOperate.OperateType.MUST_SUCCESS);
            if (dVar.cC()) {
                String content = dVar.getContent();
                if (content != null) {
                    this.ajg = Integer.parseInt(content);
                }
                if (this.ajg == 1 || this.ajg == 2) {
                    this.aje = true;
                }
            }
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }

    public static a xu() {
        if (ajf == null) {
            synchronized (a.class) {
                if (ajf == null) {
                    ajf = new a();
                }
            }
        }
        return ajf;
    }

    public boolean xv() {
        return this.aje;
    }

    public int xw() {
        return this.ajg;
    }

    public String xx() {
        return this.aje ? "pub_env=" + this.ajg + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR : "";
    }
}
