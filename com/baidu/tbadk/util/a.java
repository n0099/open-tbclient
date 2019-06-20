package com.baidu.tbadk.util;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class a {
    private static a cBf;
    private com.baidu.tbadk.coreExtra.data.a cib;

    public static a auN() {
        if (cBf == null) {
            synchronized (a.class) {
                if (cBf == null) {
                    cBf = new a();
                }
            }
        }
        return cBf;
    }

    public void a(com.baidu.tbadk.coreExtra.data.a aVar) {
        b(aVar);
    }

    private void b(com.baidu.tbadk.coreExtra.data.a aVar) {
        boolean z = false;
        z = (aVar == null || this.cib == null || aVar.akJ() != this.cib.akJ()) ? true : true;
        this.cib = aVar;
        if (z) {
            qJ("zan_or_cai_smallflow");
        }
    }

    public boolean akJ() {
        if (this.cib == null) {
            this.cib = new com.baidu.tbadk.coreExtra.data.a();
            this.cib.akK();
        }
        return this.cib.akJ();
    }

    private void qJ(String str) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2156670, str));
    }
}
