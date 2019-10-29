package com.baidu.tbadk.util;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class a {
    private static a cOI;
    private com.baidu.tbadk.coreExtra.data.a cxS;

    public static a axp() {
        if (cOI == null) {
            synchronized (a.class) {
                if (cOI == null) {
                    cOI = new a();
                }
            }
        }
        return cOI;
    }

    public void a(com.baidu.tbadk.coreExtra.data.a aVar) {
        b(aVar);
    }

    private void b(com.baidu.tbadk.coreExtra.data.a aVar) {
        boolean z = false;
        z = (aVar == null || this.cxS == null || aVar.aoP() != this.cxS.aoP()) ? true : true;
        this.cxS = aVar;
        if (z) {
            qj("zan_or_cai_smallflow");
        }
    }

    public boolean aoP() {
        if (this.cxS == null) {
            this.cxS = new com.baidu.tbadk.coreExtra.data.a();
            this.cxS.aoQ();
        }
        return this.cxS.aoP();
    }

    private void qj(String str) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2156670, str));
    }
}
