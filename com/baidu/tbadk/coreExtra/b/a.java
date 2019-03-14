package com.baidu.tbadk.coreExtra.b;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.Disk.ops.d;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
/* loaded from: classes.dex */
public class a {
    private static volatile a bWg = null;
    private boolean bWf;
    private int bWh;

    private a() {
        this.bWf = false;
        this.bWh = 0;
        try {
            d dVar = new d("", "apk_ab_test.txt", DiskFileOperate.Action.READ);
            dVar.T(true);
            dVar.a(DiskFileOperate.OperateType.MUST_SUCCESS);
            if (dVar.hA()) {
                String content = dVar.getContent();
                if (content != null) {
                    this.bWh = Integer.parseInt(content);
                }
                if (this.bWh == 1 || this.bWh == 2) {
                    this.bWf = true;
                }
            }
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }

    public static a afJ() {
        if (bWg == null) {
            synchronized (a.class) {
                if (bWg == null) {
                    bWg = new a();
                }
            }
        }
        return bWg;
    }

    public boolean afK() {
        return this.bWf;
    }

    public int afL() {
        return this.bWh;
    }

    public String afM() {
        return this.bWf ? "pub_env=" + this.bWh + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR : "";
    }
}
