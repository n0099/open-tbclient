package com.baidu.tbadk.coreExtra.b;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.Disk.ops.d;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
/* loaded from: classes.dex */
public class a {
    private static volatile a ezF = null;
    private boolean ezE;
    private int ezG;

    private a() {
        this.ezE = false;
        this.ezG = 0;
        try {
            d dVar = new d("", "apk_ab_test.txt", DiskFileOperate.Action.READ);
            dVar.setSdCard(true);
            dVar.a(DiskFileOperate.OperateType.MUST_SUCCESS);
            if (dVar.call()) {
                String content = dVar.getContent();
                if (content != null) {
                    this.ezG = Integer.parseInt(content);
                }
                if (this.ezG == 1 || this.ezG == 2) {
                    this.ezE = true;
                }
            }
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }

    public static a bmk() {
        if (ezF == null) {
            synchronized (a.class) {
                if (ezF == null) {
                    ezF = new a();
                }
            }
        }
        return ezF;
    }

    public boolean bml() {
        return this.ezE;
    }

    public int bmm() {
        return this.ezG;
    }

    public String bmn() {
        return this.ezE ? "pub_env=" + this.ezG + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR : "";
    }
}
