package com.baidu.tbadk.coreExtra.b;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.Disk.ops.d;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
/* loaded from: classes.dex */
public class a {
    private static volatile a epp = null;
    private boolean epo;
    private int epq;

    private a() {
        this.epo = false;
        this.epq = 0;
        try {
            d dVar = new d("", "apk_ab_test.txt", DiskFileOperate.Action.READ);
            dVar.setSdCard(true);
            dVar.a(DiskFileOperate.OperateType.MUST_SUCCESS);
            if (dVar.call()) {
                String content = dVar.getContent();
                if (content != null) {
                    this.epq = Integer.parseInt(content);
                }
                if (this.epq == 1 || this.epq == 2) {
                    this.epo = true;
                }
            }
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }

    public static a bdE() {
        if (epp == null) {
            synchronized (a.class) {
                if (epp == null) {
                    epp = new a();
                }
            }
        }
        return epp;
    }

    public boolean bdF() {
        return this.epo;
    }

    public int bdG() {
        return this.epq;
    }

    public String bdH() {
        return this.epo ? "pub_env=" + this.epq + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR : "";
    }
}
