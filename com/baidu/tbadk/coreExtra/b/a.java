package com.baidu.tbadk.coreExtra.b;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.Disk.ops.d;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
/* loaded from: classes.dex */
public class a {
    private static volatile a aiE = null;
    private boolean aiD;
    private int aiF;

    private a() {
        this.aiD = false;
        this.aiF = 0;
        try {
            d dVar = new d("", "apk_ab_test.txt", DiskFileOperate.Action.READ);
            dVar.q(true);
            dVar.a(DiskFileOperate.OperateType.MUST_SUCCESS);
            if (dVar.fk()) {
                String content = dVar.getContent();
                if (content != null) {
                    this.aiF = Integer.parseInt(content);
                }
                if (this.aiF == 1 || this.aiF == 2) {
                    this.aiD = true;
                }
            }
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }

    public static a wC() {
        if (aiE == null) {
            synchronized (a.class) {
                if (aiE == null) {
                    aiE = new a();
                }
            }
        }
        return aiE;
    }

    public boolean wD() {
        return this.aiD;
    }

    public int wE() {
        return this.aiF;
    }

    public String wF() {
        return this.aiD ? "pub_env=" + this.aiF + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR : "";
    }
}
