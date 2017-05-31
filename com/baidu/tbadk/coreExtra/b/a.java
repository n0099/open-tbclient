package com.baidu.tbadk.coreExtra.b;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.Disk.ops.d;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
/* loaded from: classes.dex */
public class a {
    private static volatile a aoi = null;
    private boolean aoh;
    private int aoj;

    private a() {
        this.aoh = false;
        this.aoj = 0;
        try {
            d dVar = new d("", "apk_ab_test.txt", DiskFileOperate.Action.READ);
            dVar.u(true);
            dVar.a(DiskFileOperate.OperateType.MUST_SUCCESS);
            if (dVar.dJ()) {
                String content = dVar.getContent();
                if (content != null) {
                    this.aoj = Integer.parseInt(content);
                }
                if (this.aoj == 1 || this.aoj == 2) {
                    this.aoh = true;
                }
            }
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }

    public static a xf() {
        if (aoi == null) {
            synchronized (a.class) {
                if (aoi == null) {
                    aoi = new a();
                }
            }
        }
        return aoi;
    }

    public boolean xg() {
        return this.aoh;
    }

    public int xh() {
        return this.aoj;
    }

    public String xi() {
        return this.aoh ? "pub_env=" + this.aoj + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR : "";
    }
}
