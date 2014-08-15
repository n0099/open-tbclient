package com.baidu.tbadk;

import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.bd;
/* loaded from: classes.dex */
public class j {
    private static j a = new j();
    private com.baidu.adp.base.a.c b;
    private com.baidu.adp.base.a.c c;

    private j() {
    }

    public static j a() {
        return a;
    }

    public com.baidu.adp.base.a.c b() {
        com.baidu.adp.base.a.c cVar;
        if (this.b != null) {
            return this.b;
        }
        synchronized (a) {
            if (this.b != null) {
                cVar = this.b;
            } else {
                this.b = new com.baidu.adp.base.a.c(new bc(TbadkApplication.m252getInst()));
                cVar = this.b;
            }
        }
        return cVar;
    }

    public com.baidu.adp.base.a.c c() {
        com.baidu.adp.base.a.c cVar;
        if (this.c != null) {
            return this.c;
        }
        synchronized (a) {
            if (this.c != null) {
                cVar = this.c;
            } else {
                this.c = new com.baidu.adp.base.a.c(new bd());
                cVar = this.c;
            }
        }
        return cVar;
    }
}
