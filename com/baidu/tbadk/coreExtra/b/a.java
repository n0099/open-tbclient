package com.baidu.tbadk.coreExtra.b;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.Disk.ops.d;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
/* loaded from: classes.dex */
public class a {
    private static volatile a cee = null;
    private boolean ced;
    private int cef;

    private a() {
        this.ced = false;
        this.cef = 0;
        try {
            d dVar = new d("", "apk_ab_test.txt", DiskFileOperate.Action.READ);
            dVar.L(true);
            dVar.a(DiskFileOperate.OperateType.MUST_SUCCESS);
            if (dVar.gu()) {
                String content = dVar.getContent();
                if (content != null) {
                    this.cef = Integer.parseInt(content);
                }
                if (this.cef == 1 || this.cef == 2) {
                    this.ced = true;
                }
            }
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }

    public static a akF() {
        if (cee == null) {
            synchronized (a.class) {
                if (cee == null) {
                    cee = new a();
                }
            }
        }
        return cee;
    }

    public boolean akG() {
        return this.ced;
    }

    public int akH() {
        return this.cef;
    }

    public String akI() {
        return this.ced ? "pub_env=" + this.cef + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR : "";
    }
}
