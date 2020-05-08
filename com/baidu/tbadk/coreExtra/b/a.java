package com.baidu.tbadk.coreExtra.b;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.Disk.ops.d;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
/* loaded from: classes.dex */
public class a {
    private static volatile a dMc = null;
    private boolean dMb;
    private int dMd;

    private a() {
        this.dMb = false;
        this.dMd = 0;
        try {
            d dVar = new d("", "apk_ab_test.txt", DiskFileOperate.Action.READ);
            dVar.setSdCard(true);
            dVar.a(DiskFileOperate.OperateType.MUST_SUCCESS);
            if (dVar.call()) {
                String content = dVar.getContent();
                if (content != null) {
                    this.dMd = Integer.parseInt(content);
                }
                if (this.dMd == 1 || this.dMd == 2) {
                    this.dMb = true;
                }
            }
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }

    public static a aRt() {
        if (dMc == null) {
            synchronized (a.class) {
                if (dMc == null) {
                    dMc = new a();
                }
            }
        }
        return dMc;
    }

    public boolean aRu() {
        return this.dMb;
    }

    public int aRv() {
        return this.dMd;
    }

    public String aRw() {
        return this.dMb ? "pub_env=" + this.dMd + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR : "";
    }
}
