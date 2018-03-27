package com.baidu.tbadk.coreExtra.b;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.Disk.ops.d;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
/* loaded from: classes.dex */
public class a {
    private static volatile a bgI = null;
    private boolean bgH;
    private int bgJ;

    private a() {
        this.bgH = false;
        this.bgJ = 0;
        try {
            d dVar = new d("", "apk_ab_test.txt", DiskFileOperate.Action.READ);
            dVar.ad(true);
            dVar.a(DiskFileOperate.OperateType.MUST_SUCCESS);
            if (dVar.lm()) {
                String content = dVar.getContent();
                if (content != null) {
                    this.bgJ = Integer.parseInt(content);
                }
                if (this.bgJ == 1 || this.bgJ == 2) {
                    this.bgH = true;
                }
            }
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }

    public static a Fe() {
        if (bgI == null) {
            synchronized (a.class) {
                if (bgI == null) {
                    bgI = new a();
                }
            }
        }
        return bgI;
    }

    public boolean Ff() {
        return this.bgH;
    }

    public int Fg() {
        return this.bgJ;
    }

    public String Fh() {
        return this.bgH ? "pub_env=" + this.bgJ + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR : "";
    }
}
