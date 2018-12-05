package com.baidu.tbadk.util;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class a {
    private static a bil;
    private com.baidu.tbadk.coreExtra.data.a aQR;

    public static a PH() {
        if (bil == null) {
            synchronized (a.class) {
                if (bil == null) {
                    bil = new a();
                }
            }
        }
        return bil;
    }

    public void a(com.baidu.tbadk.coreExtra.data.a aVar) {
        b(aVar);
    }

    private void b(com.baidu.tbadk.coreExtra.data.a aVar) {
        boolean z = false;
        z = (aVar == null || this.aQR == null || aVar.Gf() != this.aQR.Gf()) ? true : true;
        this.aQR = aVar;
        if (z) {
            ix("zan_or_cai_smallflow");
        }
    }

    public boolean Gf() {
        if (this.aQR == null) {
            this.aQR = new com.baidu.tbadk.coreExtra.data.a();
            this.aQR.Gg();
        }
        return this.aQR.Gf();
    }

    private void ix(String str) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2156670, str));
    }
}
