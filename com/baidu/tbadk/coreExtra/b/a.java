package com.baidu.tbadk.coreExtra.b;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.Disk.ops.d;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
/* loaded from: classes.dex */
public class a {
    private static volatile a ajX = null;
    private boolean ajW;
    private int ajY;

    private a() {
        this.ajW = false;
        this.ajY = 0;
        try {
            d dVar = new d("", "apk_ab_test.txt", DiskFileOperate.Action.READ);
            dVar.t(true);
            dVar.a(DiskFileOperate.OperateType.MUST_SUCCESS);
            if (dVar.cC()) {
                String content = dVar.getContent();
                if (content != null) {
                    this.ajY = Integer.parseInt(content);
                }
                if (this.ajY == 1 || this.ajY == 2) {
                    this.ajW = true;
                }
            }
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }

    public static a xz() {
        if (ajX == null) {
            synchronized (a.class) {
                if (ajX == null) {
                    ajX = new a();
                }
            }
        }
        return ajX;
    }

    public boolean xA() {
        return this.ajW;
    }

    public int xB() {
        return this.ajY;
    }

    public String xC() {
        return this.ajW ? "pub_env=" + this.ajY + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR : "";
    }
}
