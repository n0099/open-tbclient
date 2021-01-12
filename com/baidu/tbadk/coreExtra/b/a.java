package com.baidu.tbadk.coreExtra.b;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.Disk.ops.d;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
/* loaded from: classes.dex */
public class a {
    private static volatile a fnH = null;
    private boolean fnG;
    private int fnI;

    private a() {
        this.fnG = false;
        this.fnI = 0;
        try {
            d dVar = new d("", "apk_ab_test.txt", DiskFileOperate.Action.READ);
            dVar.setSdCard(true);
            dVar.a(DiskFileOperate.OperateType.MUST_SUCCESS);
            if (dVar.call()) {
                String content = dVar.getContent();
                if (content != null) {
                    this.fnI = Integer.parseInt(content);
                }
                if (this.fnI == 1 || this.fnI == 2) {
                    this.fnG = true;
                }
            }
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }

    public static a bvx() {
        if (fnH == null) {
            synchronized (a.class) {
                if (fnH == null) {
                    fnH = new a();
                }
            }
        }
        return fnH;
    }

    public boolean bvy() {
        return this.fnG;
    }

    public int bvz() {
        return this.fnI;
    }

    public String bvA() {
        return this.fnG ? "pub_env=" + this.fnI + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR : "";
    }
}
