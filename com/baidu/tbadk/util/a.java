package com.baidu.tbadk.util;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class a {
    private static a csV;
    private com.baidu.tbadk.coreExtra.data.a cae;

    public static a apJ() {
        if (csV == null) {
            synchronized (a.class) {
                if (csV == null) {
                    csV = new a();
                }
            }
        }
        return csV;
    }

    public void a(com.baidu.tbadk.coreExtra.data.a aVar) {
        b(aVar);
    }

    private void b(com.baidu.tbadk.coreExtra.data.a aVar) {
        boolean z = false;
        z = (aVar == null || this.cae == null || aVar.afK() != this.cae.afK()) ? true : true;
        this.cae = aVar;
        if (z) {
            pB("zan_or_cai_smallflow");
        }
    }

    public boolean afK() {
        if (this.cae == null) {
            this.cae = new com.baidu.tbadk.coreExtra.data.a();
            this.cae.afL();
        }
        return this.cae.afK();
    }

    private void pB(String str) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2156670, str));
    }
}
