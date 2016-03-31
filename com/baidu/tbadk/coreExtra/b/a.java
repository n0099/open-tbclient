package com.baidu.tbadk.coreExtra.b;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.Disk.ops.d;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
/* loaded from: classes.dex */
public class a {
    private static volatile a ajH = null;
    private boolean ajG;
    private int ajI;

    private a() {
        this.ajG = false;
        this.ajI = 0;
        try {
            d dVar = new d("", "apk_ab_test.txt", DiskFileOperate.Action.READ);
            dVar.p(true);
            dVar.a(DiskFileOperate.OperateType.MUST_SUCCESS);
            if (dVar.ft()) {
                String content = dVar.getContent();
                if (content != null) {
                    this.ajI = Integer.parseInt(content);
                }
                if (this.ajI == 1 || this.ajI == 2) {
                    this.ajG = true;
                }
            }
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }

    public static a yr() {
        if (ajH == null) {
            synchronized (a.class) {
                if (ajH == null) {
                    ajH = new a();
                }
            }
        }
        return ajH;
    }

    public boolean ys() {
        return this.ajG;
    }

    public int yt() {
        return this.ajI;
    }

    public String yu() {
        return this.ajG ? "pub_env=" + this.ajI + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR : "";
    }
}
