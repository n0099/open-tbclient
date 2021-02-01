package com.baidu.tbadk.coreExtra.b;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.Disk.ops.d;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
/* loaded from: classes.dex */
public class a {
    private static volatile a fqa = null;
    private boolean fpZ;
    private int fqb;

    private a() {
        this.fpZ = false;
        this.fqb = 0;
        try {
            d dVar = new d("", "apk_ab_test.txt", DiskFileOperate.Action.READ);
            dVar.setSdCard(true);
            dVar.a(DiskFileOperate.OperateType.MUST_SUCCESS);
            if (dVar.call()) {
                String content = dVar.getContent();
                if (content != null) {
                    this.fqb = Integer.parseInt(content);
                }
                if (this.fqb == 1 || this.fqb == 2) {
                    this.fpZ = true;
                }
            }
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }

    public static a bvQ() {
        if (fqa == null) {
            synchronized (a.class) {
                if (fqa == null) {
                    fqa = new a();
                }
            }
        }
        return fqa;
    }

    public boolean bvR() {
        return this.fpZ;
    }

    public int bvS() {
        return this.fqb;
    }

    public String bvT() {
        return this.fpZ ? "pub_env=" + this.fqb + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR : "";
    }
}
