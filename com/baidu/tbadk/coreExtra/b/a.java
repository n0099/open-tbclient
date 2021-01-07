package com.baidu.tbadk.coreExtra.b;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.Disk.ops.d;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
/* loaded from: classes.dex */
public class a {
    private static volatile a fss = null;
    private boolean fsr;
    private int fst;

    private a() {
        this.fsr = false;
        this.fst = 0;
        try {
            d dVar = new d("", "apk_ab_test.txt", DiskFileOperate.Action.READ);
            dVar.setSdCard(true);
            dVar.a(DiskFileOperate.OperateType.MUST_SUCCESS);
            if (dVar.call()) {
                String content = dVar.getContent();
                if (content != null) {
                    this.fst = Integer.parseInt(content);
                }
                if (this.fst == 1 || this.fst == 2) {
                    this.fsr = true;
                }
            }
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }

    public static a bzr() {
        if (fss == null) {
            synchronized (a.class) {
                if (fss == null) {
                    fss = new a();
                }
            }
        }
        return fss;
    }

    public boolean bzs() {
        return this.fsr;
    }

    public int bzt() {
        return this.fst;
    }

    public String bzu() {
        return this.fsr ? "pub_env=" + this.fst + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR : "";
    }
}
