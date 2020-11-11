package com.baidu.tbadk.coreExtra.b;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.Disk.ops.d;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
/* loaded from: classes.dex */
public class a {
    private static volatile a fcb = null;
    private boolean fca;
    private int fcc;

    private a() {
        this.fca = false;
        this.fcc = 0;
        try {
            d dVar = new d("", "apk_ab_test.txt", DiskFileOperate.Action.READ);
            dVar.setSdCard(true);
            dVar.a(DiskFileOperate.OperateType.MUST_SUCCESS);
            if (dVar.call()) {
                String content = dVar.getContent();
                if (content != null) {
                    this.fcc = Integer.parseInt(content);
                }
                if (this.fcc == 1 || this.fcc == 2) {
                    this.fca = true;
                }
            }
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }

    public static a buh() {
        if (fcb == null) {
            synchronized (a.class) {
                if (fcb == null) {
                    fcb = new a();
                }
            }
        }
        return fcb;
    }

    public boolean bui() {
        return this.fca;
    }

    public int buj() {
        return this.fcc;
    }

    public String buk() {
        return this.fca ? "pub_env=" + this.fcc + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR : "";
    }
}
