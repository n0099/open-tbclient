package com.baidu.tbadk.coreExtra.b;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.Disk.ops.d;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
/* loaded from: classes.dex */
public class a {
    private static volatile a dhk = null;
    private boolean dhj;
    private int dhl;

    private a() {
        this.dhj = false;
        this.dhl = 0;
        try {
            d dVar = new d("", "apk_ab_test.txt", DiskFileOperate.Action.READ);
            dVar.setSdCard(true);
            dVar.a(DiskFileOperate.OperateType.MUST_SUCCESS);
            if (dVar.call()) {
                String content = dVar.getContent();
                if (content != null) {
                    this.dhl = Integer.parseInt(content);
                }
                if (this.dhl == 1 || this.dhl == 2) {
                    this.dhj = true;
                }
            }
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }

    public static a aGl() {
        if (dhk == null) {
            synchronized (a.class) {
                if (dhk == null) {
                    dhk = new a();
                }
            }
        }
        return dhk;
    }

    public boolean aGm() {
        return this.dhj;
    }

    public int aGn() {
        return this.dhl;
    }

    public String aGo() {
        return this.dhj ? "pub_env=" + this.dhl + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR : "";
    }
}
