package com.baidu.tbadk.coreExtra.b;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.Disk.ops.d;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
/* loaded from: classes.dex */
public class a {
    private static volatile a aBm = null;
    private boolean aBl;
    private int aBn;

    private a() {
        this.aBl = false;
        this.aBn = 0;
        try {
            d dVar = new d("", "apk_ab_test.txt", DiskFileOperate.Action.READ);
            dVar.y(true);
            dVar.a(DiskFileOperate.OperateType.MUST_SUCCESS);
            if (dVar.gg()) {
                String content = dVar.getContent();
                if (content != null) {
                    this.aBn = Integer.parseInt(content);
                }
                if (this.aBn == 1 || this.aBn == 2) {
                    this.aBl = true;
                }
            }
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }

    public static a BH() {
        if (aBm == null) {
            synchronized (a.class) {
                if (aBm == null) {
                    aBm = new a();
                }
            }
        }
        return aBm;
    }

    public boolean BI() {
        return this.aBl;
    }

    public int BJ() {
        return this.aBn;
    }

    public String BK() {
        return this.aBl ? "pub_env=" + this.aBn + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR : "";
    }
}
