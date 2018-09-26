package com.baidu.tbadk.util;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class a {
    private static a aZv;
    private com.baidu.tbadk.coreExtra.data.a aIa;

    public static a Mu() {
        if (aZv == null) {
            synchronized (a.class) {
                if (aZv == null) {
                    aZv = new a();
                }
            }
        }
        return aZv;
    }

    public void a(com.baidu.tbadk.coreExtra.data.a aVar) {
        b(aVar);
    }

    private void b(com.baidu.tbadk.coreExtra.data.a aVar) {
        boolean z = false;
        z = (aVar == null || this.aIa == null || aVar.CM() != this.aIa.CM()) ? true : true;
        this.aIa = aVar;
        if (z) {
            hP("zan_or_cai_smallflow");
        }
    }

    public boolean CM() {
        if (this.aIa == null) {
            this.aIa = new com.baidu.tbadk.coreExtra.data.a();
            this.aIa.CN();
        }
        return this.aIa.CM();
    }

    private void hP(String str) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2156670, str));
    }
}
