package com.baidu.tbadk.coreExtra.b;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.Disk.ops.d;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
/* loaded from: classes.dex */
public class a {
    private static volatile a eWm = null;
    private boolean eWl;
    private int eWn;

    private a() {
        this.eWl = false;
        this.eWn = 0;
        try {
            d dVar = new d("", "apk_ab_test.txt", DiskFileOperate.Action.READ);
            dVar.setSdCard(true);
            dVar.a(DiskFileOperate.OperateType.MUST_SUCCESS);
            if (dVar.call()) {
                String content = dVar.getContent();
                if (content != null) {
                    this.eWn = Integer.parseInt(content);
                }
                if (this.eWn == 1 || this.eWn == 2) {
                    this.eWl = true;
                }
            }
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }

    public static a brH() {
        if (eWm == null) {
            synchronized (a.class) {
                if (eWm == null) {
                    eWm = new a();
                }
            }
        }
        return eWm;
    }

    public boolean brI() {
        return this.eWl;
    }

    public int brJ() {
        return this.eWn;
    }

    public String brK() {
        return this.eWl ? "pub_env=" + this.eWn + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR : "";
    }
}
