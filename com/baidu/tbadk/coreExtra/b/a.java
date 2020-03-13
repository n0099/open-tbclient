package com.baidu.tbadk.coreExtra.b;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.Disk.ops.d;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
/* loaded from: classes.dex */
public class a {
    private static volatile a dlQ = null;
    private boolean dlP;
    private int dlR;

    private a() {
        this.dlP = false;
        this.dlR = 0;
        try {
            d dVar = new d("", "apk_ab_test.txt", DiskFileOperate.Action.READ);
            dVar.setSdCard(true);
            dVar.a(DiskFileOperate.OperateType.MUST_SUCCESS);
            if (dVar.call()) {
                String content = dVar.getContent();
                if (content != null) {
                    this.dlR = Integer.parseInt(content);
                }
                if (this.dlR == 1 || this.dlR == 2) {
                    this.dlP = true;
                }
            }
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }

    public static a aIV() {
        if (dlQ == null) {
            synchronized (a.class) {
                if (dlQ == null) {
                    dlQ = new a();
                }
            }
        }
        return dlQ;
    }

    public boolean aIW() {
        return this.dlP;
    }

    public int aIX() {
        return this.dlR;
    }

    public String aIY() {
        return this.dlP ? "pub_env=" + this.dlR + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR : "";
    }
}
