package com.baidu.tbadk.coreExtra.b;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.Disk.ops.d;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
/* loaded from: classes.dex */
public class a {
    private static volatile a aot = null;
    private boolean aos;
    private int aou;

    private a() {
        this.aos = false;
        this.aou = 0;
        try {
            d dVar = new d("", "apk_ab_test.txt", DiskFileOperate.Action.READ);
            dVar.u(true);
            dVar.a(DiskFileOperate.OperateType.MUST_SUCCESS);
            if (dVar.dI()) {
                String content = dVar.getContent();
                if (content != null) {
                    this.aou = Integer.parseInt(content);
                }
                if (this.aou == 1 || this.aou == 2) {
                    this.aos = true;
                }
            }
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }

    public static a xY() {
        if (aot == null) {
            synchronized (a.class) {
                if (aot == null) {
                    aot = new a();
                }
            }
        }
        return aot;
    }

    public boolean xZ() {
        return this.aos;
    }

    public int ya() {
        return this.aou;
    }

    public String yb() {
        return this.aos ? "pub_env=" + this.aou + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR : "";
    }
}
