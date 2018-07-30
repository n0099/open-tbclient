package com.baidu.tbadk.coreExtra.b;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.Disk.ops.d;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
/* loaded from: classes.dex */
public class a {
    private static volatile a aBg = null;
    private boolean aBf;
    private int aBh;

    private a() {
        this.aBf = false;
        this.aBh = 0;
        try {
            d dVar = new d("", "apk_ab_test.txt", DiskFileOperate.Action.READ);
            dVar.w(true);
            dVar.a(DiskFileOperate.OperateType.MUST_SUCCESS);
            if (dVar.gf()) {
                String content = dVar.getContent();
                if (content != null) {
                    this.aBh = Integer.parseInt(content);
                }
                if (this.aBh == 1 || this.aBh == 2) {
                    this.aBf = true;
                }
            }
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }

    public static a Bz() {
        if (aBg == null) {
            synchronized (a.class) {
                if (aBg == null) {
                    aBg = new a();
                }
            }
        }
        return aBg;
    }

    public boolean BA() {
        return this.aBf;
    }

    public int BB() {
        return this.aBh;
    }

    public String BC() {
        return this.aBf ? "pub_env=" + this.aBh + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR : "";
    }
}
