package com.baidu.tbadk.coreExtra.b;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.Disk.ops.d;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
/* loaded from: classes.dex */
public class a {
    private static volatile a eat = null;
    private boolean eas;
    private int eau;

    private a() {
        this.eas = false;
        this.eau = 0;
        try {
            d dVar = new d("", "apk_ab_test.txt", DiskFileOperate.Action.READ);
            dVar.setSdCard(true);
            dVar.a(DiskFileOperate.OperateType.MUST_SUCCESS);
            if (dVar.call()) {
                String content = dVar.getContent();
                if (content != null) {
                    this.eau = Integer.parseInt(content);
                }
                if (this.eau == 1 || this.eau == 2) {
                    this.eas = true;
                }
            }
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }

    public static a aXB() {
        if (eat == null) {
            synchronized (a.class) {
                if (eat == null) {
                    eat = new a();
                }
            }
        }
        return eat;
    }

    public boolean aXC() {
        return this.eas;
    }

    public int aXD() {
        return this.eau;
    }

    public String aXE() {
        return this.eas ? "pub_env=" + this.eau + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR : "";
    }
}
