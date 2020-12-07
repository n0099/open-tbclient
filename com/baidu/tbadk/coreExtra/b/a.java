package com.baidu.tbadk.coreExtra.b;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.Disk.ops.d;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
/* loaded from: classes.dex */
public class a {
    private static volatile a fiJ = null;
    private boolean fiI;
    private int fiK;

    private a() {
        this.fiI = false;
        this.fiK = 0;
        try {
            d dVar = new d("", "apk_ab_test.txt", DiskFileOperate.Action.READ);
            dVar.setSdCard(true);
            dVar.a(DiskFileOperate.OperateType.MUST_SUCCESS);
            if (dVar.call()) {
                String content = dVar.getContent();
                if (content != null) {
                    this.fiK = Integer.parseInt(content);
                }
                if (this.fiK == 1 || this.fiK == 2) {
                    this.fiI = true;
                }
            }
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }

    public static a bwX() {
        if (fiJ == null) {
            synchronized (a.class) {
                if (fiJ == null) {
                    fiJ = new a();
                }
            }
        }
        return fiJ;
    }

    public boolean bwY() {
        return this.fiI;
    }

    public int bwZ() {
        return this.fiK;
    }

    public String bxa() {
        return this.fiI ? "pub_env=" + this.fiK + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR : "";
    }
}
