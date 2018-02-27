package com.baidu.tbadk.coreExtra.b;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.Disk.ops.d;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
/* loaded from: classes.dex */
public class a {
    private static volatile a bgF = null;
    private boolean bgE;
    private int bgG;

    private a() {
        this.bgE = false;
        this.bgG = 0;
        try {
            d dVar = new d("", "apk_ab_test.txt", DiskFileOperate.Action.READ);
            dVar.ad(true);
            dVar.a(DiskFileOperate.OperateType.MUST_SUCCESS);
            if (dVar.lm()) {
                String content = dVar.getContent();
                if (content != null) {
                    this.bgG = Integer.parseInt(content);
                }
                if (this.bgG == 1 || this.bgG == 2) {
                    this.bgE = true;
                }
            }
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }

    public static a Fd() {
        if (bgF == null) {
            synchronized (a.class) {
                if (bgF == null) {
                    bgF = new a();
                }
            }
        }
        return bgF;
    }

    public boolean Fe() {
        return this.bgE;
    }

    public int Ff() {
        return this.bgG;
    }

    public String Fg() {
        return this.bgE ? "pub_env=" + this.bgG + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR : "";
    }
}
