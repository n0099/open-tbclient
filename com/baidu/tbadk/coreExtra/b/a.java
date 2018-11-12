package com.baidu.tbadk.coreExtra.b;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.Disk.ops.d;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
/* loaded from: classes.dex */
public class a {
    private static volatile a aJB = null;
    private boolean aJA;
    private int aJC;

    private a() {
        this.aJA = false;
        this.aJC = 0;
        try {
            d dVar = new d("", "apk_ab_test.txt", DiskFileOperate.Action.READ);
            dVar.T(true);
            dVar.a(DiskFileOperate.OperateType.MUST_SUCCESS);
            if (dVar.hC()) {
                String content = dVar.getContent();
                if (content != null) {
                    this.aJC = Integer.parseInt(content);
                }
                if (this.aJC == 1 || this.aJC == 2) {
                    this.aJA = true;
                }
            }
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }

    public static a EX() {
        if (aJB == null) {
            synchronized (a.class) {
                if (aJB == null) {
                    aJB = new a();
                }
            }
        }
        return aJB;
    }

    public boolean EY() {
        return this.aJA;
    }

    public int EZ() {
        return this.aJC;
    }

    public String Fa() {
        return this.aJA ? "pub_env=" + this.aJC + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR : "";
    }
}
