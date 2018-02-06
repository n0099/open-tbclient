package com.baidu.tbadk.coreExtra.b;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.Disk.ops.d;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
/* loaded from: classes.dex */
public class a {
    private static volatile a bgR = null;
    private boolean bgQ;
    private int bgS;

    private a() {
        this.bgQ = false;
        this.bgS = 0;
        try {
            d dVar = new d("", "apk_ab_test.txt", DiskFileOperate.Action.READ);
            dVar.ad(true);
            dVar.a(DiskFileOperate.OperateType.MUST_SUCCESS);
            if (dVar.lm()) {
                String content = dVar.getContent();
                if (content != null) {
                    this.bgS = Integer.parseInt(content);
                }
                if (this.bgS == 1 || this.bgS == 2) {
                    this.bgQ = true;
                }
            }
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }

    public static a Fe() {
        if (bgR == null) {
            synchronized (a.class) {
                if (bgR == null) {
                    bgR = new a();
                }
            }
        }
        return bgR;
    }

    public boolean Ff() {
        return this.bgQ;
    }

    public int Fg() {
        return this.bgS;
    }

    public String Fh() {
        return this.bgQ ? "pub_env=" + this.bgS + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR : "";
    }
}
