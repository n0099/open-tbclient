package com.baidu.tbadk.coreExtra.b;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.Disk.ops.d;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
/* loaded from: classes.dex */
public class a {
    private static volatile a eBJ = null;
    private boolean eBI;
    private int eBK;

    private a() {
        this.eBI = false;
        this.eBK = 0;
        try {
            d dVar = new d("", "apk_ab_test.txt", DiskFileOperate.Action.READ);
            dVar.setSdCard(true);
            dVar.a(DiskFileOperate.OperateType.MUST_SUCCESS);
            if (dVar.call()) {
                String content = dVar.getContent();
                if (content != null) {
                    this.eBK = Integer.parseInt(content);
                }
                if (this.eBK == 1 || this.eBK == 2) {
                    this.eBI = true;
                }
            }
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }

    public static a bne() {
        if (eBJ == null) {
            synchronized (a.class) {
                if (eBJ == null) {
                    eBJ = new a();
                }
            }
        }
        return eBJ;
    }

    public boolean bnf() {
        return this.eBI;
    }

    public int bng() {
        return this.eBK;
    }

    public String bnh() {
        return this.eBI ? "pub_env=" + this.eBK + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR : "";
    }
}
