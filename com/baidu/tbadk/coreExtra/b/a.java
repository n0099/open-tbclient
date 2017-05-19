package com.baidu.tbadk.coreExtra.b;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.Disk.ops.d;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
/* loaded from: classes.dex */
public class a {
    private static volatile a aoy = null;
    private boolean aox;
    private int aoz;

    private a() {
        this.aox = false;
        this.aoz = 0;
        try {
            d dVar = new d("", "apk_ab_test.txt", DiskFileOperate.Action.READ);
            dVar.u(true);
            dVar.a(DiskFileOperate.OperateType.MUST_SUCCESS);
            if (dVar.dJ()) {
                String content = dVar.getContent();
                if (content != null) {
                    this.aoz = Integer.parseInt(content);
                }
                if (this.aoz == 1 || this.aoz == 2) {
                    this.aox = true;
                }
            }
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }

    public static a xm() {
        if (aoy == null) {
            synchronized (a.class) {
                if (aoy == null) {
                    aoy = new a();
                }
            }
        }
        return aoy;
    }

    public boolean xn() {
        return this.aox;
    }

    public int xo() {
        return this.aoz;
    }

    public String xp() {
        return this.aox ? "pub_env=" + this.aoz + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR : "";
    }
}
