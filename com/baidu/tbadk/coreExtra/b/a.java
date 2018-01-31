package com.baidu.tbadk.coreExtra.b;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.Disk.ops.d;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
/* loaded from: classes.dex */
public class a {
    private static volatile a beY = null;
    private boolean beX;
    private int beZ;

    private a() {
        this.beX = false;
        this.beZ = 0;
        try {
            d dVar = new d("", "apk_ab_test.txt", DiskFileOperate.Action.READ);
            dVar.ab(true);
            dVar.a(DiskFileOperate.OperateType.MUST_SUCCESS);
            if (dVar.lm()) {
                String content = dVar.getContent();
                if (content != null) {
                    this.beZ = Integer.parseInt(content);
                }
                if (this.beZ == 1 || this.beZ == 2) {
                    this.beX = true;
                }
            }
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }

    public static a EJ() {
        if (beY == null) {
            synchronized (a.class) {
                if (beY == null) {
                    beY = new a();
                }
            }
        }
        return beY;
    }

    public boolean EK() {
        return this.beX;
    }

    public int EL() {
        return this.beZ;
    }

    public String EM() {
        return this.beX ? "pub_env=" + this.beZ + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR : "";
    }
}
