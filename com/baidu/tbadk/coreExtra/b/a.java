package com.baidu.tbadk.coreExtra.b;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.Disk.ops.d;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
/* loaded from: classes.dex */
public class a {
    private static volatile a cup = null;
    private boolean cuo;
    private int cuq;

    private a() {
        this.cuo = false;
        this.cuq = 0;
        try {
            d dVar = new d("", "apk_ab_test.txt", DiskFileOperate.Action.READ);
            dVar.setSdCard(true);
            dVar.a(DiskFileOperate.OperateType.MUST_SUCCESS);
            if (dVar.call()) {
                String content = dVar.getContent();
                if (content != null) {
                    this.cuq = Integer.parseInt(content);
                }
                if (this.cuq == 1 || this.cuq == 2) {
                    this.cuo = true;
                }
            }
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }

    public static a aoL() {
        if (cup == null) {
            synchronized (a.class) {
                if (cup == null) {
                    cup = new a();
                }
            }
        }
        return cup;
    }

    public boolean aoM() {
        return this.cuo;
    }

    public int aoN() {
        return this.cuq;
    }

    public String aoO() {
        return this.cuo ? "pub_env=" + this.cuq + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR : "";
    }
}
