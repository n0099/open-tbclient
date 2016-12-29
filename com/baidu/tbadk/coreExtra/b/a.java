package com.baidu.tbadk.coreExtra.b;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.Disk.ops.d;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
/* loaded from: classes.dex */
public class a {
    private static volatile a ajy = null;
    private boolean ajx;
    private int ajz;

    private a() {
        this.ajx = false;
        this.ajz = 0;
        try {
            d dVar = new d("", "apk_ab_test.txt", DiskFileOperate.Action.READ);
            dVar.t(true);
            dVar.a(DiskFileOperate.OperateType.MUST_SUCCESS);
            if (dVar.cC()) {
                String content = dVar.getContent();
                if (content != null) {
                    this.ajz = Integer.parseInt(content);
                }
                if (this.ajz == 1 || this.ajz == 2) {
                    this.ajx = true;
                }
            }
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }

    public static a xm() {
        if (ajy == null) {
            synchronized (a.class) {
                if (ajy == null) {
                    ajy = new a();
                }
            }
        }
        return ajy;
    }

    public boolean xn() {
        return this.ajx;
    }

    public int xo() {
        return this.ajz;
    }

    public String xp() {
        return this.ajx ? "pub_env=" + this.ajz + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR : "";
    }
}
