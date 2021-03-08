package com.baidu.tbadk.coreExtra.b;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.Disk.ops.d;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
/* loaded from: classes.dex */
public class a {
    private static volatile a frB = null;
    private boolean frA;
    private int frC;

    private a() {
        this.frA = false;
        this.frC = 0;
        try {
            d dVar = new d("", "apk_ab_test.txt", DiskFileOperate.Action.READ);
            dVar.setSdCard(true);
            dVar.a(DiskFileOperate.OperateType.MUST_SUCCESS);
            if (dVar.call()) {
                String content = dVar.getContent();
                if (content != null) {
                    this.frC = Integer.parseInt(content);
                }
                if (this.frC == 1 || this.frC == 2) {
                    this.frA = true;
                }
            }
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }

    public static a bvT() {
        if (frB == null) {
            synchronized (a.class) {
                if (frB == null) {
                    frB = new a();
                }
            }
        }
        return frB;
    }

    public boolean bvU() {
        return this.frA;
    }

    public int bvV() {
        return this.frC;
    }

    public String bvW() {
        return this.frA ? "pub_env=" + this.frC + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR : "";
    }
}
