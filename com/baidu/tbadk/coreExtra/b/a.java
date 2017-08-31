package com.baidu.tbadk.coreExtra.b;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.Disk.ops.d;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
/* loaded from: classes.dex */
public class a {
    private static volatile a ara = null;
    private boolean aqZ;
    private int arb;

    private a() {
        this.aqZ = false;
        this.arb = 0;
        try {
            d dVar = new d("", "apk_ab_test.txt", DiskFileOperate.Action.READ);
            dVar.v(true);
            dVar.a(DiskFileOperate.OperateType.MUST_SUCCESS);
            if (dVar.dJ()) {
                String content = dVar.getContent();
                if (content != null) {
                    this.arb = Integer.parseInt(content);
                }
                if (this.arb == 1 || this.arb == 2) {
                    this.aqZ = true;
                }
            }
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }

    public static a xS() {
        if (ara == null) {
            synchronized (a.class) {
                if (ara == null) {
                    ara = new a();
                }
            }
        }
        return ara;
    }

    public boolean xT() {
        return this.aqZ;
    }

    public int xU() {
        return this.arb;
    }

    public String xV() {
        return this.aqZ ? "pub_env=" + this.arb + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR : "";
    }
}
