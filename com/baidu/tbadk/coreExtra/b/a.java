package com.baidu.tbadk.coreExtra.b;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.Disk.ops.d;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
/* loaded from: classes.dex */
public class a {
    private static volatile a dmd = null;
    private boolean dmc;
    private int dme;

    private a() {
        this.dmc = false;
        this.dme = 0;
        try {
            d dVar = new d("", "apk_ab_test.txt", DiskFileOperate.Action.READ);
            dVar.setSdCard(true);
            dVar.a(DiskFileOperate.OperateType.MUST_SUCCESS);
            if (dVar.call()) {
                String content = dVar.getContent();
                if (content != null) {
                    this.dme = Integer.parseInt(content);
                }
                if (this.dme == 1 || this.dme == 2) {
                    this.dmc = true;
                }
            }
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }

    public static a aIZ() {
        if (dmd == null) {
            synchronized (a.class) {
                if (dmd == null) {
                    dmd = new a();
                }
            }
        }
        return dmd;
    }

    public boolean aJa() {
        return this.dmc;
    }

    public int aJb() {
        return this.dme;
    }

    public String aJc() {
        return this.dmc ? "pub_env=" + this.dme + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR : "";
    }
}
