package com.baidu.tbadk.coreExtra.b;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.Disk.ops.d;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
/* loaded from: classes.dex */
public class a {
    private static volatile a cfp = null;
    private boolean cfo;
    private int cfq;

    private a() {
        this.cfo = false;
        this.cfq = 0;
        try {
            d dVar = new d("", "apk_ab_test.txt", DiskFileOperate.Action.READ);
            dVar.L(true);
            dVar.a(DiskFileOperate.OperateType.MUST_SUCCESS);
            if (dVar.gD()) {
                String content = dVar.getContent();
                if (content != null) {
                    this.cfq = Integer.parseInt(content);
                }
                if (this.cfq == 1 || this.cfq == 2) {
                    this.cfo = true;
                }
            }
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }

    public static a alM() {
        if (cfp == null) {
            synchronized (a.class) {
                if (cfp == null) {
                    cfp = new a();
                }
            }
        }
        return cfp;
    }

    public boolean alN() {
        return this.cfo;
    }

    public int alO() {
        return this.cfq;
    }

    public String alP() {
        return this.cfo ? "pub_env=" + this.cfq + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR : "";
    }
}
