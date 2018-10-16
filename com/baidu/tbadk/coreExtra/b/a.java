package com.baidu.tbadk.coreExtra.b;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.Disk.ops.d;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
/* loaded from: classes.dex */
public class a {
    private static volatile a aIL = null;
    private boolean aIK;
    private int aIM;

    private a() {
        this.aIK = false;
        this.aIM = 0;
        try {
            d dVar = new d("", "apk_ab_test.txt", DiskFileOperate.Action.READ);
            dVar.F(true);
            dVar.a(DiskFileOperate.OperateType.MUST_SUCCESS);
            if (dVar.hD()) {
                String content = dVar.getContent();
                if (content != null) {
                    this.aIM = Integer.parseInt(content);
                }
                if (this.aIM == 1 || this.aIM == 2) {
                    this.aIK = true;
                }
            }
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }

    public static a EM() {
        if (aIL == null) {
            synchronized (a.class) {
                if (aIL == null) {
                    aIL = new a();
                }
            }
        }
        return aIL;
    }

    public boolean EN() {
        return this.aIK;
    }

    public int EO() {
        return this.aIM;
    }

    public String EP() {
        return this.aIK ? "pub_env=" + this.aIM + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR : "";
    }
}
