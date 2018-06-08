package com.baidu.tbadk.coreExtra.b;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.Disk.ops.d;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
/* loaded from: classes.dex */
public class a {
    private static volatile a aAu = null;
    private boolean aAt;
    private int aAv;

    private a() {
        this.aAt = false;
        this.aAv = 0;
        try {
            d dVar = new d("", "apk_ab_test.txt", DiskFileOperate.Action.READ);
            dVar.y(true);
            dVar.a(DiskFileOperate.OperateType.MUST_SUCCESS);
            if (dVar.gg()) {
                String content = dVar.getContent();
                if (content != null) {
                    this.aAv = Integer.parseInt(content);
                }
                if (this.aAv == 1 || this.aAv == 2) {
                    this.aAt = true;
                }
            }
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }

    public static a Bq() {
        if (aAu == null) {
            synchronized (a.class) {
                if (aAu == null) {
                    aAu = new a();
                }
            }
        }
        return aAu;
    }

    public boolean Br() {
        return this.aAt;
    }

    public int Bs() {
        return this.aAv;
    }

    public String Bt() {
        return this.aAt ? "pub_env=" + this.aAv + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR : "";
    }
}
