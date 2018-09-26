package com.baidu.tbadk.coreExtra.b;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.Disk.ops.d;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
/* loaded from: classes.dex */
public class a {
    private static volatile a aEh = null;
    private boolean aEg;
    private int aEi;

    private a() {
        this.aEg = false;
        this.aEi = 0;
        try {
            d dVar = new d("", "apk_ab_test.txt", DiskFileOperate.Action.READ);
            dVar.F(true);
            dVar.a(DiskFileOperate.OperateType.MUST_SUCCESS);
            if (dVar.hm()) {
                String content = dVar.getContent();
                if (content != null) {
                    this.aEi = Integer.parseInt(content);
                }
                if (this.aEi == 1 || this.aEi == 2) {
                    this.aEg = true;
                }
            }
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }

    public static a CI() {
        if (aEh == null) {
            synchronized (a.class) {
                if (aEh == null) {
                    aEh = new a();
                }
            }
        }
        return aEh;
    }

    public boolean CJ() {
        return this.aEg;
    }

    public int CK() {
        return this.aEi;
    }

    public String CL() {
        return this.aEg ? "pub_env=" + this.aEi + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR : "";
    }
}
