package com.baidu.tbadk.coreExtra.b;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.Disk.ops.d;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class a {
    private static volatile a afW = null;
    private boolean afV;
    private int afX;

    private a() {
        this.afV = false;
        this.afX = 0;
        try {
            d dVar = new d("", "apk_ab_test.txt", DiskFileOperate.Action.READ);
            dVar.q(true);
            dVar.a(DiskFileOperate.OperateType.MUST_SUCCESS);
            if (dVar.fk()) {
                String content = dVar.getContent();
                if (content != null) {
                    this.afX = Integer.parseInt(content);
                }
                if (this.afX == 1 || this.afX == 2) {
                    this.afV = true;
                }
            }
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }

    public static a wc() {
        if (afW == null) {
            synchronized (a.class) {
                if (afW == null) {
                    afW = new a();
                }
            }
        }
        return afW;
    }

    public boolean wd() {
        return this.afV;
    }

    public int we() {
        return this.afX;
    }

    public String wf() {
        return this.afV ? "pub_env=" + this.afX + ";" : "";
    }
}
