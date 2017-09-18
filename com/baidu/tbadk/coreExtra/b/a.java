package com.baidu.tbadk.coreExtra.b;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.Disk.ops.d;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
/* loaded from: classes.dex */
public class a {
    private static volatile a aqX = null;
    private boolean aqW;
    private int aqY;

    private a() {
        this.aqW = false;
        this.aqY = 0;
        try {
            d dVar = new d("", "apk_ab_test.txt", DiskFileOperate.Action.READ);
            dVar.v(true);
            dVar.a(DiskFileOperate.OperateType.MUST_SUCCESS);
            if (dVar.dJ()) {
                String content = dVar.getContent();
                if (content != null) {
                    this.aqY = Integer.parseInt(content);
                }
                if (this.aqY == 1 || this.aqY == 2) {
                    this.aqW = true;
                }
            }
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }

    public static a xS() {
        if (aqX == null) {
            synchronized (a.class) {
                if (aqX == null) {
                    aqX = new a();
                }
            }
        }
        return aqX;
    }

    public boolean xT() {
        return this.aqW;
    }

    public int xU() {
        return this.aqY;
    }

    public String xV() {
        return this.aqW ? "pub_env=" + this.aqY + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR : "";
    }
}
