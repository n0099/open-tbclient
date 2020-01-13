package com.baidu.tbadk.coreExtra.b;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.Disk.ops.d;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
/* loaded from: classes.dex */
public class a {
    private static volatile a dhw = null;
    private boolean dhv;
    private int dhx;

    private a() {
        this.dhv = false;
        this.dhx = 0;
        try {
            d dVar = new d("", "apk_ab_test.txt", DiskFileOperate.Action.READ);
            dVar.setSdCard(true);
            dVar.a(DiskFileOperate.OperateType.MUST_SUCCESS);
            if (dVar.call()) {
                String content = dVar.getContent();
                if (content != null) {
                    this.dhx = Integer.parseInt(content);
                }
                if (this.dhx == 1 || this.dhx == 2) {
                    this.dhv = true;
                }
            }
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }

    public static a aGE() {
        if (dhw == null) {
            synchronized (a.class) {
                if (dhw == null) {
                    dhw = new a();
                }
            }
        }
        return dhw;
    }

    public boolean aGF() {
        return this.dhv;
    }

    public int aGG() {
        return this.dhx;
    }

    public String aGH() {
        return this.dhv ? "pub_env=" + this.dhx + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR : "";
    }
}
