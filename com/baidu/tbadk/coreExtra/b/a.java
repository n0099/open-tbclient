package com.baidu.tbadk.coreExtra.b;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.Disk.ops.d;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
/* loaded from: classes.dex */
public class a {
    private static volatile a cgi = null;
    private boolean cgh;
    private int cgj;

    private a() {
        this.cgh = false;
        this.cgj = 0;
        try {
            d dVar = new d("", "apk_ab_test.txt", DiskFileOperate.Action.READ);
            dVar.L(true);
            dVar.a(DiskFileOperate.OperateType.MUST_SUCCESS);
            if (dVar.gD()) {
                String content = dVar.getContent();
                if (content != null) {
                    this.cgj = Integer.parseInt(content);
                }
                if (this.cgj == 1 || this.cgj == 2) {
                    this.cgh = true;
                }
            }
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }

    public static a alY() {
        if (cgi == null) {
            synchronized (a.class) {
                if (cgi == null) {
                    cgi = new a();
                }
            }
        }
        return cgi;
    }

    public boolean alZ() {
        return this.cgh;
    }

    public int ama() {
        return this.cgj;
    }

    public String amb() {
        return this.cgh ? "pub_env=" + this.cgj + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR : "";
    }
}
