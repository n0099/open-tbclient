package com.baidu.tbadk.coreExtra.b;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.Disk.ops.d;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
/* loaded from: classes.dex */
public class a {
    private static volatile a asn = null;
    private boolean asm;
    private int aso;

    private a() {
        this.asm = false;
        this.aso = 0;
        try {
            d dVar = new d("", "apk_ab_test.txt", DiskFileOperate.Action.READ);
            dVar.w(true);
            dVar.a(DiskFileOperate.OperateType.MUST_SUCCESS);
            if (dVar.dq()) {
                String content = dVar.getContent();
                if (content != null) {
                    this.aso = Integer.parseInt(content);
                }
                if (this.aso == 1 || this.aso == 2) {
                    this.asm = true;
                }
            }
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }

    public static a xQ() {
        if (asn == null) {
            synchronized (a.class) {
                if (asn == null) {
                    asn = new a();
                }
            }
        }
        return asn;
    }

    public boolean xR() {
        return this.asm;
    }

    public int xS() {
        return this.aso;
    }

    public String xT() {
        return this.asm ? "pub_env=" + this.aso + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR : "";
    }
}
