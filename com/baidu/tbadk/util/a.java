package com.baidu.tbadk.util;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class a {
    private static a csS;
    private com.baidu.tbadk.coreExtra.data.a cab;

    public static a apM() {
        if (csS == null) {
            synchronized (a.class) {
                if (csS == null) {
                    csS = new a();
                }
            }
        }
        return csS;
    }

    public void a(com.baidu.tbadk.coreExtra.data.a aVar) {
        b(aVar);
    }

    private void b(com.baidu.tbadk.coreExtra.data.a aVar) {
        boolean z = false;
        z = (aVar == null || this.cab == null || aVar.afN() != this.cab.afN()) ? true : true;
        this.cab = aVar;
        if (z) {
            pA("zan_or_cai_smallflow");
        }
    }

    public boolean afN() {
        if (this.cab == null) {
            this.cab = new com.baidu.tbadk.coreExtra.data.a();
            this.cab.afO();
        }
        return this.cab.afN();
    }

    private void pA(String str) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2156670, str));
    }
}
