package com.baidu.tbadk.coreExtra.b;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.Disk.ops.d;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
/* loaded from: classes.dex */
public class a {
    private static volatile a aof = null;
    private boolean aoe;
    private int aog;

    private a() {
        this.aoe = false;
        this.aog = 0;
        try {
            d dVar = new d("", "apk_ab_test.txt", DiskFileOperate.Action.READ);
            dVar.u(true);
            dVar.a(DiskFileOperate.OperateType.MUST_SUCCESS);
            if (dVar.dJ()) {
                String content = dVar.getContent();
                if (content != null) {
                    this.aog = Integer.parseInt(content);
                }
                if (this.aog == 1 || this.aog == 2) {
                    this.aoe = true;
                }
            }
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }

    public static a xC() {
        if (aof == null) {
            synchronized (a.class) {
                if (aof == null) {
                    aof = new a();
                }
            }
        }
        return aof;
    }

    public boolean xD() {
        return this.aoe;
    }

    public int xE() {
        return this.aog;
    }

    public String xF() {
        return this.aoe ? "pub_env=" + this.aog + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR : "";
    }
}
