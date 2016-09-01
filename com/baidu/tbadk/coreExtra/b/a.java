package com.baidu.tbadk.coreExtra.b;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.Disk.ops.d;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
/* loaded from: classes.dex */
public class a {
    private static volatile a ajD = null;
    private boolean ajC;
    private int ajE;

    private a() {
        this.ajC = false;
        this.ajE = 0;
        try {
            d dVar = new d("", "apk_ab_test.txt", DiskFileOperate.Action.READ);
            dVar.t(true);
            dVar.a(DiskFileOperate.OperateType.MUST_SUCCESS);
            if (dVar.cC()) {
                String content = dVar.getContent();
                if (content != null) {
                    this.ajE = Integer.parseInt(content);
                }
                if (this.ajE == 1 || this.ajE == 2) {
                    this.ajC = true;
                }
            }
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }

    public static a xs() {
        if (ajD == null) {
            synchronized (a.class) {
                if (ajD == null) {
                    ajD = new a();
                }
            }
        }
        return ajD;
    }

    public boolean xt() {
        return this.ajC;
    }

    public int xu() {
        return this.ajE;
    }

    public String xv() {
        return this.ajC ? "pub_env=" + this.ajE + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR : "";
    }
}
