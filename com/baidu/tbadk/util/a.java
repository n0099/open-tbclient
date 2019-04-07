package com.baidu.tbadk.util;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class a {
    private static a csU;
    private com.baidu.tbadk.coreExtra.data.a cad;

    public static a apJ() {
        if (csU == null) {
            synchronized (a.class) {
                if (csU == null) {
                    csU = new a();
                }
            }
        }
        return csU;
    }

    public void a(com.baidu.tbadk.coreExtra.data.a aVar) {
        b(aVar);
    }

    private void b(com.baidu.tbadk.coreExtra.data.a aVar) {
        boolean z = false;
        z = (aVar == null || this.cad == null || aVar.afK() != this.cad.afK()) ? true : true;
        this.cad = aVar;
        if (z) {
            pB("zan_or_cai_smallflow");
        }
    }

    public boolean afK() {
        if (this.cad == null) {
            this.cad = new com.baidu.tbadk.coreExtra.data.a();
            this.cad.afL();
        }
        return this.cad.afK();
    }

    private void pB(String str) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2156670, str));
    }
}
