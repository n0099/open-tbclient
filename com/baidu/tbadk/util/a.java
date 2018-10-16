package com.baidu.tbadk.util;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class a {
    private static a bdV;
    private com.baidu.tbadk.coreExtra.data.a aMC;

    public static a Os() {
        if (bdV == null) {
            synchronized (a.class) {
                if (bdV == null) {
                    bdV = new a();
                }
            }
        }
        return bdV;
    }

    public void a(com.baidu.tbadk.coreExtra.data.a aVar) {
        b(aVar);
    }

    private void b(com.baidu.tbadk.coreExtra.data.a aVar) {
        boolean z = false;
        z = (aVar == null || this.aMC == null || aVar.EQ() != this.aMC.EQ()) ? true : true;
        this.aMC = aVar;
        if (z) {
            ie("zan_or_cai_smallflow");
        }
    }

    public boolean EQ() {
        if (this.aMC == null) {
            this.aMC = new com.baidu.tbadk.coreExtra.data.a();
            this.aMC.ER();
        }
        return this.aMC.EQ();
    }

    private void ie(String str) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2156670, str));
    }
}
