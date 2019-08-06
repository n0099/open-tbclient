package com.baidu.tbadk.util;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class a {
    private static a cCD;
    private com.baidu.tbadk.coreExtra.data.a cjo;

    public static a avY() {
        if (cCD == null) {
            synchronized (a.class) {
                if (cCD == null) {
                    cCD = new a();
                }
            }
        }
        return cCD;
    }

    public void a(com.baidu.tbadk.coreExtra.data.a aVar) {
        b(aVar);
    }

    private void b(com.baidu.tbadk.coreExtra.data.a aVar) {
        boolean z = false;
        z = (aVar == null || this.cjo == null || aVar.alQ() != this.cjo.alQ()) ? true : true;
        this.cjo = aVar;
        if (z) {
            ra("zan_or_cai_smallflow");
        }
    }

    public boolean alQ() {
        if (this.cjo == null) {
            this.cjo = new com.baidu.tbadk.coreExtra.data.a();
            this.cjo.alR();
        }
        return this.cjo.alQ();
    }

    private void ra(String str) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2156670, str));
    }
}
