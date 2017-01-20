package com.baidu.tbadk.coreExtra.b;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.Disk.ops.d;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
/* loaded from: classes.dex */
public class a {
    private static volatile a aiJ = null;
    private boolean aiI;
    private int aiK;

    private a() {
        this.aiI = false;
        this.aiK = 0;
        try {
            d dVar = new d("", "apk_ab_test.txt", DiskFileOperate.Action.READ);
            dVar.t(true);
            dVar.a(DiskFileOperate.OperateType.MUST_SUCCESS);
            if (dVar.cA()) {
                String content = dVar.getContent();
                if (content != null) {
                    this.aiK = Integer.parseInt(content);
                }
                if (this.aiK == 1 || this.aiK == 2) {
                    this.aiI = true;
                }
            }
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }

    public static a xg() {
        if (aiJ == null) {
            synchronized (a.class) {
                if (aiJ == null) {
                    aiJ = new a();
                }
            }
        }
        return aiJ;
    }

    public boolean xh() {
        return this.aiI;
    }

    public int xi() {
        return this.aiK;
    }

    public String xj() {
        return this.aiI ? "pub_env=" + this.aiK + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR : "";
    }
}
