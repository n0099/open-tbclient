package com.baidu.tbadk.coreExtra.b;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.Disk.ops.d;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
/* loaded from: classes.dex */
public class a {
    private static volatile a dLY = null;
    private boolean dLX;
    private int dLZ;

    private a() {
        this.dLX = false;
        this.dLZ = 0;
        try {
            d dVar = new d("", "apk_ab_test.txt", DiskFileOperate.Action.READ);
            dVar.setSdCard(true);
            dVar.a(DiskFileOperate.OperateType.MUST_SUCCESS);
            if (dVar.call()) {
                String content = dVar.getContent();
                if (content != null) {
                    this.dLZ = Integer.parseInt(content);
                }
                if (this.dLZ == 1 || this.dLZ == 2) {
                    this.dLX = true;
                }
            }
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }

    public static a aRw() {
        if (dLY == null) {
            synchronized (a.class) {
                if (dLY == null) {
                    dLY = new a();
                }
            }
        }
        return dLY;
    }

    public boolean aRx() {
        return this.dLX;
    }

    public int aRy() {
        return this.dLZ;
    }

    public String aRz() {
        return this.dLX ? "pub_env=" + this.dLZ + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR : "";
    }
}
