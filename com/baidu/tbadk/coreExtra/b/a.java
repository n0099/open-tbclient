package com.baidu.tbadk.coreExtra.b;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.Disk.ops.d;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
/* loaded from: classes.dex */
public class a {
    private static volatile a cty = null;
    private boolean ctx;
    private int ctz;

    private a() {
        this.ctx = false;
        this.ctz = 0;
        try {
            d dVar = new d("", "apk_ab_test.txt", DiskFileOperate.Action.READ);
            dVar.setSdCard(true);
            dVar.a(DiskFileOperate.OperateType.MUST_SUCCESS);
            if (dVar.call()) {
                String content = dVar.getContent();
                if (content != null) {
                    this.ctz = Integer.parseInt(content);
                }
                if (this.ctz == 1 || this.ctz == 2) {
                    this.ctx = true;
                }
            }
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }

    public static a aoJ() {
        if (cty == null) {
            synchronized (a.class) {
                if (cty == null) {
                    cty = new a();
                }
            }
        }
        return cty;
    }

    public boolean aoK() {
        return this.ctx;
    }

    public int aoL() {
        return this.ctz;
    }

    public String aoM() {
        return this.ctx ? "pub_env=" + this.ctz + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR : "";
    }
}
