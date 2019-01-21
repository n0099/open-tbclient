package com.baidu.tbadk.util;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class a {
    private static a biY;
    private com.baidu.tbadk.coreExtra.data.a aRy;

    public static a Qb() {
        if (biY == null) {
            synchronized (a.class) {
                if (biY == null) {
                    biY = new a();
                }
            }
        }
        return biY;
    }

    public void a(com.baidu.tbadk.coreExtra.data.a aVar) {
        b(aVar);
    }

    private void b(com.baidu.tbadk.coreExtra.data.a aVar) {
        boolean z = false;
        z = (aVar == null || this.aRy == null || aVar.Gt() != this.aRy.Gt()) ? true : true;
        this.aRy = aVar;
        if (z) {
            iM("zan_or_cai_smallflow");
        }
    }

    public boolean Gt() {
        if (this.aRy == null) {
            this.aRy = new com.baidu.tbadk.coreExtra.data.a();
            this.aRy.Gu();
        }
        return this.aRy.Gt();
    }

    private void iM(String str) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2156670, str));
    }
}
