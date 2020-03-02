package com.baidu.tbadk.coreExtra.b;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.Disk.ops.d;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
/* loaded from: classes.dex */
public class a {
    private static volatile a dlD = null;
    private boolean dlC;
    private int dlE;

    private a() {
        this.dlC = false;
        this.dlE = 0;
        try {
            d dVar = new d("", "apk_ab_test.txt", DiskFileOperate.Action.READ);
            dVar.setSdCard(true);
            dVar.a(DiskFileOperate.OperateType.MUST_SUCCESS);
            if (dVar.call()) {
                String content = dVar.getContent();
                if (content != null) {
                    this.dlE = Integer.parseInt(content);
                }
                if (this.dlE == 1 || this.dlE == 2) {
                    this.dlC = true;
                }
            }
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }

    public static a aIU() {
        if (dlD == null) {
            synchronized (a.class) {
                if (dlD == null) {
                    dlD = new a();
                }
            }
        }
        return dlD;
    }

    public boolean aIV() {
        return this.dlC;
    }

    public int aIW() {
        return this.dlE;
    }

    public String aIX() {
        return this.dlC ? "pub_env=" + this.dlE + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR : "";
    }
}
