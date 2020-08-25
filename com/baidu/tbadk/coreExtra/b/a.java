package com.baidu.tbadk.coreExtra.b;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.Disk.ops.d;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
/* loaded from: classes2.dex */
public class a {
    private static volatile a ezB = null;
    private boolean ezA;
    private int ezC;

    private a() {
        this.ezA = false;
        this.ezC = 0;
        try {
            d dVar = new d("", "apk_ab_test.txt", DiskFileOperate.Action.READ);
            dVar.setSdCard(true);
            dVar.a(DiskFileOperate.OperateType.MUST_SUCCESS);
            if (dVar.call()) {
                String content = dVar.getContent();
                if (content != null) {
                    this.ezC = Integer.parseInt(content);
                }
                if (this.ezC == 1 || this.ezC == 2) {
                    this.ezA = true;
                }
            }
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }

    public static a bmk() {
        if (ezB == null) {
            synchronized (a.class) {
                if (ezB == null) {
                    ezB = new a();
                }
            }
        }
        return ezB;
    }

    public boolean bml() {
        return this.ezA;
    }

    public int bmm() {
        return this.ezC;
    }

    public String bmn() {
        return this.ezA ? "pub_env=" + this.ezC + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR : "";
    }
}
