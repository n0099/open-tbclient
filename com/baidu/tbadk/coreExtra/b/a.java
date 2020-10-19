package com.baidu.tbadk.coreExtra.b;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.Disk.ops.d;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
/* loaded from: classes.dex */
public class a {
    private static volatile a eNQ = null;
    private boolean eNP;
    private int eNR;

    private a() {
        this.eNP = false;
        this.eNR = 0;
        try {
            d dVar = new d("", "apk_ab_test.txt", DiskFileOperate.Action.READ);
            dVar.setSdCard(true);
            dVar.a(DiskFileOperate.OperateType.MUST_SUCCESS);
            if (dVar.call()) {
                String content = dVar.getContent();
                if (content != null) {
                    this.eNR = Integer.parseInt(content);
                }
                if (this.eNR == 1 || this.eNR == 2) {
                    this.eNP = true;
                }
            }
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }

    public static a bpO() {
        if (eNQ == null) {
            synchronized (a.class) {
                if (eNQ == null) {
                    eNQ = new a();
                }
            }
        }
        return eNQ;
    }

    public boolean bpP() {
        return this.eNP;
    }

    public int bpQ() {
        return this.eNR;
    }

    public String bpR() {
        return this.eNP ? "pub_env=" + this.eNR + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR : "";
    }
}
