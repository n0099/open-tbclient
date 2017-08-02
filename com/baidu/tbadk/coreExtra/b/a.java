package com.baidu.tbadk.coreExtra.b;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.Disk.ops.d;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
/* loaded from: classes.dex */
public class a {
    private static volatile a aqa = null;
    private boolean apZ;
    private int aqb;

    private a() {
        this.apZ = false;
        this.aqb = 0;
        try {
            d dVar = new d("", "apk_ab_test.txt", DiskFileOperate.Action.READ);
            dVar.u(true);
            dVar.a(DiskFileOperate.OperateType.MUST_SUCCESS);
            if (dVar.dI()) {
                String content = dVar.getContent();
                if (content != null) {
                    this.aqb = Integer.parseInt(content);
                }
                if (this.aqb == 1 || this.aqb == 2) {
                    this.apZ = true;
                }
            }
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }

    public static a xI() {
        if (aqa == null) {
            synchronized (a.class) {
                if (aqa == null) {
                    aqa = new a();
                }
            }
        }
        return aqa;
    }

    public boolean xJ() {
        return this.apZ;
    }

    public int xK() {
        return this.aqb;
    }

    public String xL() {
        return this.apZ ? "pub_env=" + this.aqb + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR : "";
    }
}
