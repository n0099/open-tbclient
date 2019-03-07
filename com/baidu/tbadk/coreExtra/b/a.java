package com.baidu.tbadk.coreExtra.b;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.Disk.ops.d;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
/* loaded from: classes.dex */
public class a {
    private static volatile a bWf = null;
    private boolean bWe;
    private int bWg;

    private a() {
        this.bWe = false;
        this.bWg = 0;
        try {
            d dVar = new d("", "apk_ab_test.txt", DiskFileOperate.Action.READ);
            dVar.T(true);
            dVar.a(DiskFileOperate.OperateType.MUST_SUCCESS);
            if (dVar.hA()) {
                String content = dVar.getContent();
                if (content != null) {
                    this.bWg = Integer.parseInt(content);
                }
                if (this.bWg == 1 || this.bWg == 2) {
                    this.bWe = true;
                }
            }
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }

    public static a afJ() {
        if (bWf == null) {
            synchronized (a.class) {
                if (bWf == null) {
                    bWf = new a();
                }
            }
        }
        return bWf;
    }

    public boolean afK() {
        return this.bWe;
    }

    public int afL() {
        return this.bWg;
    }

    public String afM() {
        return this.bWe ? "pub_env=" + this.bWg + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR : "";
    }
}
