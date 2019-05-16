package com.baidu.tbadk.util;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class a {
    private static a cBe;
    private com.baidu.tbadk.coreExtra.data.a cia;

    public static a auN() {
        if (cBe == null) {
            synchronized (a.class) {
                if (cBe == null) {
                    cBe = new a();
                }
            }
        }
        return cBe;
    }

    public void a(com.baidu.tbadk.coreExtra.data.a aVar) {
        b(aVar);
    }

    private void b(com.baidu.tbadk.coreExtra.data.a aVar) {
        boolean z = false;
        z = (aVar == null || this.cia == null || aVar.akJ() != this.cia.akJ()) ? true : true;
        this.cia = aVar;
        if (z) {
            qK("zan_or_cai_smallflow");
        }
    }

    public boolean akJ() {
        if (this.cia == null) {
            this.cia = new com.baidu.tbadk.coreExtra.data.a();
            this.cia.akK();
        }
        return this.cia.akJ();
    }

    private void qK(String str) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2156670, str));
    }
}
