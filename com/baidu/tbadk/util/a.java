package com.baidu.tbadk.util;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class a {
    private static a dBZ;
    private com.baidu.tbadk.coreExtra.data.a dld;

    public static a aPt() {
        if (dBZ == null) {
            synchronized (a.class) {
                if (dBZ == null) {
                    dBZ = new a();
                }
            }
        }
        return dBZ;
    }

    public void a(com.baidu.tbadk.coreExtra.data.a aVar) {
        b(aVar);
    }

    private void b(com.baidu.tbadk.coreExtra.data.a aVar) {
        boolean z = false;
        z = (aVar == null || this.dld == null || aVar.aGI() != this.dld.aGI()) ? true : true;
        this.dld = aVar;
        if (z) {
            vu("zan_or_cai_smallflow");
        }
    }

    public boolean aGI() {
        if (this.dld == null) {
            this.dld = new com.baidu.tbadk.coreExtra.data.a();
            this.dld.aGJ();
        }
        return this.dld.aGI();
    }

    private void vu(String str) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2156670, str));
    }
}
