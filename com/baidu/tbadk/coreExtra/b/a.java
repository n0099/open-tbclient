package com.baidu.tbadk.coreExtra.b;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.Disk.ops.d;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
/* loaded from: classes.dex */
public class a {
    private static volatile a ejd = null;
    private boolean ejc;
    private int eje;

    private a() {
        this.ejc = false;
        this.eje = 0;
        try {
            d dVar = new d("", "apk_ab_test.txt", DiskFileOperate.Action.READ);
            dVar.setSdCard(true);
            dVar.a(DiskFileOperate.OperateType.MUST_SUCCESS);
            if (dVar.call()) {
                String content = dVar.getContent();
                if (content != null) {
                    this.eje = Integer.parseInt(content);
                }
                if (this.eje == 1 || this.eje == 2) {
                    this.ejc = true;
                }
            }
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }

    public static a aZH() {
        if (ejd == null) {
            synchronized (a.class) {
                if (ejd == null) {
                    ejd = new a();
                }
            }
        }
        return ejd;
    }

    public boolean aZI() {
        return this.ejc;
    }

    public int aZJ() {
        return this.eje;
    }

    public String aZK() {
        return this.ejc ? "pub_env=" + this.eje + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR : "";
    }
}
