package com.baidu.tbadk.util;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class a {
    private static a csV;
    private com.baidu.tbadk.coreExtra.data.a cab;

    public static a apM() {
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
        z = (aVar == null || this.cab == null || aVar.afN() != this.cab.afN()) ? true : true;
        this.cab = aVar;
        if (z) {
            pB("zan_or_cai_smallflow");
        }
    }

    public boolean afN() {
        if (this.cab == null) {
            this.cab = new com.baidu.tbadk.coreExtra.data.a();
            this.cab.afO();
        }
        return this.cab.afN();
    }

    private void pB(String str) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2156670, str));
    }
}
