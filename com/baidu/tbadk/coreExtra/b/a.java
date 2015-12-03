package com.baidu.tbadk.coreExtra.b;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.Disk.ops.d;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class a {
    private static volatile a ahB = null;
    private boolean ahA;
    private int ahC;

    private a() {
        this.ahA = false;
        this.ahC = 0;
        try {
            d dVar = new d("", "apk_ab_test.txt", DiskFileOperate.Action.READ);
            dVar.q(true);
            dVar.a(DiskFileOperate.OperateType.MUST_SUCCESS);
            if (dVar.fk()) {
                String content = dVar.getContent();
                if (content != null) {
                    this.ahC = Integer.parseInt(content);
                }
                if (this.ahC == 1 || this.ahC == 2) {
                    this.ahA = true;
                }
            }
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }

    public static a wT() {
        if (ahB == null) {
            synchronized (a.class) {
                if (ahB == null) {
                    ahB = new a();
                }
            }
        }
        return ahB;
    }

    public boolean wU() {
        return this.ahA;
    }

    public int wV() {
        return this.ahC;
    }

    public String wW() {
        return this.ahA ? "pub_env=" + this.ahC + ";" : "";
    }
}
