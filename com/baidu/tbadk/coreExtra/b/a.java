package com.baidu.tbadk.coreExtra.b;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.Disk.ops.d;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
/* loaded from: classes.dex */
public class a {
    private static volatile a api = null;
    private boolean aph;
    private int apj;

    private a() {
        this.aph = false;
        this.apj = 0;
        try {
            d dVar = new d("", "apk_ab_test.txt", DiskFileOperate.Action.READ);
            dVar.u(true);
            dVar.a(DiskFileOperate.OperateType.MUST_SUCCESS);
            if (dVar.dJ()) {
                String content = dVar.getContent();
                if (content != null) {
                    this.apj = Integer.parseInt(content);
                }
                if (this.apj == 1 || this.apj == 2) {
                    this.aph = true;
                }
            }
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }

    public static a xx() {
        if (api == null) {
            synchronized (a.class) {
                if (api == null) {
                    api = new a();
                }
            }
        }
        return api;
    }

    public boolean xy() {
        return this.aph;
    }

    public int xz() {
        return this.apj;
    }

    public String xA() {
        return this.aph ? "pub_env=" + this.apj + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR : "";
    }
}
