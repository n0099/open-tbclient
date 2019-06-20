package com.baidu.tbadk.coreExtra.b;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.Disk.ops.d;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
/* loaded from: classes.dex */
public class a {
    private static volatile a cef = null;
    private boolean cee;
    private int ceg;

    private a() {
        this.cee = false;
        this.ceg = 0;
        try {
            d dVar = new d("", "apk_ab_test.txt", DiskFileOperate.Action.READ);
            dVar.L(true);
            dVar.a(DiskFileOperate.OperateType.MUST_SUCCESS);
            if (dVar.gu()) {
                String content = dVar.getContent();
                if (content != null) {
                    this.ceg = Integer.parseInt(content);
                }
                if (this.ceg == 1 || this.ceg == 2) {
                    this.cee = true;
                }
            }
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }

    public static a akF() {
        if (cef == null) {
            synchronized (a.class) {
                if (cef == null) {
                    cef = new a();
                }
            }
        }
        return cef;
    }

    public boolean akG() {
        return this.cee;
    }

    public int akH() {
        return this.ceg;
    }

    public String akI() {
        return this.cee ? "pub_env=" + this.ceg + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR : "";
    }
}
