package com.baidu.tbadk.coreExtra.b;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.Disk.ops.d;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
/* loaded from: classes.dex */
public class a {
    private static volatile a dlC = null;
    private boolean dlB;
    private int dlD;

    private a() {
        this.dlB = false;
        this.dlD = 0;
        try {
            d dVar = new d("", "apk_ab_test.txt", DiskFileOperate.Action.READ);
            dVar.setSdCard(true);
            dVar.a(DiskFileOperate.OperateType.MUST_SUCCESS);
            if (dVar.call()) {
                String content = dVar.getContent();
                if (content != null) {
                    this.dlD = Integer.parseInt(content);
                }
                if (this.dlD == 1 || this.dlD == 2) {
                    this.dlB = true;
                }
            }
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }

    public static a aIS() {
        if (dlC == null) {
            synchronized (a.class) {
                if (dlC == null) {
                    dlC = new a();
                }
            }
        }
        return dlC;
    }

    public boolean aIT() {
        return this.dlB;
    }

    public int aIU() {
        return this.dlD;
    }

    public String aIV() {
        return this.dlB ? "pub_env=" + this.dlD + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR : "";
    }
}
