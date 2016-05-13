package com.baidu.tbadk.coreExtra.b;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.Disk.ops.d;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
/* loaded from: classes.dex */
public class a {
    private static volatile a aft = null;
    private boolean afs;
    private int afu;

    private a() {
        this.afs = false;
        this.afu = 0;
        try {
            d dVar = new d("", "apk_ab_test.txt", DiskFileOperate.Action.READ);
            dVar.p(true);
            dVar.a(DiskFileOperate.OperateType.MUST_SUCCESS);
            if (dVar.bH()) {
                String content = dVar.getContent();
                if (content != null) {
                    this.afu = Integer.parseInt(content);
                }
                if (this.afu == 1 || this.afu == 2) {
                    this.afs = true;
                }
            }
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }

    public static a wl() {
        if (aft == null) {
            synchronized (a.class) {
                if (aft == null) {
                    aft = new a();
                }
            }
        }
        return aft;
    }

    public boolean wm() {
        return this.afs;
    }

    public int wn() {
        return this.afu;
    }

    public String wo() {
        return this.afs ? "pub_env=" + this.afu + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR : "";
    }
}
