package com.baidu.tbadk.util;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class a {
    private static a biX;
    private com.baidu.tbadk.coreExtra.data.a aRx;

    public static a Qb() {
        if (biX == null) {
            synchronized (a.class) {
                if (biX == null) {
                    biX = new a();
                }
            }
        }
        return biX;
    }

    public void a(com.baidu.tbadk.coreExtra.data.a aVar) {
        b(aVar);
    }

    private void b(com.baidu.tbadk.coreExtra.data.a aVar) {
        boolean z = false;
        z = (aVar == null || this.aRx == null || aVar.Gt() != this.aRx.Gt()) ? true : true;
        this.aRx = aVar;
        if (z) {
            iM("zan_or_cai_smallflow");
        }
    }

    public boolean Gt() {
        if (this.aRx == null) {
            this.aRx = new com.baidu.tbadk.coreExtra.data.a();
            this.aRx.Gu();
        }
        return this.aRx.Gt();
    }

    private void iM(String str) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2156670, str));
    }
}
