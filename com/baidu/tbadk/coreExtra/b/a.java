package com.baidu.tbadk.coreExtra.b;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.Disk.ops.d;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
/* loaded from: classes.dex */
public class a {
    private static volatile a fbj = null;
    private boolean fbi;
    private int fbk;

    private a() {
        this.fbi = false;
        this.fbk = 0;
        try {
            d dVar = new d("", "apk_ab_test.txt", DiskFileOperate.Action.READ);
            dVar.setSdCard(true);
            dVar.a(DiskFileOperate.OperateType.MUST_SUCCESS);
            if (dVar.call()) {
                String content = dVar.getContent();
                if (content != null) {
                    this.fbk = Integer.parseInt(content);
                }
                if (this.fbk == 1 || this.fbk == 2) {
                    this.fbi = true;
                }
            }
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }

    public static a btx() {
        if (fbj == null) {
            synchronized (a.class) {
                if (fbj == null) {
                    fbj = new a();
                }
            }
        }
        return fbj;
    }

    public boolean bty() {
        return this.fbi;
    }

    public int btz() {
        return this.fbk;
    }

    public String btA() {
        return this.fbi ? "pub_env=" + this.fbk + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR : "";
    }
}
