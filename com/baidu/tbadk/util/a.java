package com.baidu.tbadk.util;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class a {
    private static a dBP;
    private com.baidu.tbadk.coreExtra.data.a dkN;

    public static a aPa() {
        if (dBP == null) {
            synchronized (a.class) {
                if (dBP == null) {
                    dBP = new a();
                }
            }
        }
        return dBP;
    }

    public void a(com.baidu.tbadk.coreExtra.data.a aVar) {
        b(aVar);
    }

    private void b(com.baidu.tbadk.coreExtra.data.a aVar) {
        boolean z = false;
        z = (aVar == null || this.dkN == null || aVar.aGp() != this.dkN.aGp()) ? true : true;
        this.dkN = aVar;
        if (z) {
            vp("zan_or_cai_smallflow");
        }
    }

    public boolean aGp() {
        if (this.dkN == null) {
            this.dkN = new com.baidu.tbadk.coreExtra.data.a();
            this.dkN.aGq();
        }
        return this.dkN.aGp();
    }

    private void vp(String str) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2156670, str));
    }
}
