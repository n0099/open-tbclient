package com.baidu.tbadk.util;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class a {
    private static a cNR;
    private com.baidu.tbadk.coreExtra.data.a cxb;

    public static a axn() {
        if (cNR == null) {
            synchronized (a.class) {
                if (cNR == null) {
                    cNR = new a();
                }
            }
        }
        return cNR;
    }

    public void a(com.baidu.tbadk.coreExtra.data.a aVar) {
        b(aVar);
    }

    private void b(com.baidu.tbadk.coreExtra.data.a aVar) {
        boolean z = false;
        z = (aVar == null || this.cxb == null || aVar.aoN() != this.cxb.aoN()) ? true : true;
        this.cxb = aVar;
        if (z) {
            qj("zan_or_cai_smallflow");
        }
    }

    public boolean aoN() {
        if (this.cxb == null) {
            this.cxb = new com.baidu.tbadk.coreExtra.data.a();
            this.cxb.aoO();
        }
        return this.cxb.aoN();
    }

    private void qj(String str) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2156670, str));
    }
}
