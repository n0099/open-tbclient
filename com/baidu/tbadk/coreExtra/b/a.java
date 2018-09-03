package com.baidu.tbadk.coreExtra.b;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.Disk.ops.d;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
/* loaded from: classes.dex */
public class a {
    private static volatile a aBd = null;
    private boolean aBc;
    private int aBe;

    private a() {
        this.aBc = false;
        this.aBe = 0;
        try {
            d dVar = new d("", "apk_ab_test.txt", DiskFileOperate.Action.READ);
            dVar.w(true);
            dVar.a(DiskFileOperate.OperateType.MUST_SUCCESS);
            if (dVar.gf()) {
                String content = dVar.getContent();
                if (content != null) {
                    this.aBe = Integer.parseInt(content);
                }
                if (this.aBe == 1 || this.aBe == 2) {
                    this.aBc = true;
                }
            }
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }

    public static a Bw() {
        if (aBd == null) {
            synchronized (a.class) {
                if (aBd == null) {
                    aBd = new a();
                }
            }
        }
        return aBd;
    }

    public boolean Bx() {
        return this.aBc;
    }

    public int By() {
        return this.aBe;
    }

    public String Bz() {
        return this.aBc ? "pub_env=" + this.aBe + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR : "";
    }
}
