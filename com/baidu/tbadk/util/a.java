package com.baidu.tbadk.util;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class a {
    private static a cCw;
    private com.baidu.tbadk.coreExtra.data.a cjh;

    public static a avW() {
        if (cCw == null) {
            synchronized (a.class) {
                if (cCw == null) {
                    cCw = new a();
                }
            }
        }
        return cCw;
    }

    public void a(com.baidu.tbadk.coreExtra.data.a aVar) {
        b(aVar);
    }

    private void b(com.baidu.tbadk.coreExtra.data.a aVar) {
        boolean z = false;
        z = (aVar == null || this.cjh == null || aVar.alO() != this.cjh.alO()) ? true : true;
        this.cjh = aVar;
        if (z) {
            ra("zan_or_cai_smallflow");
        }
    }

    public boolean alO() {
        if (this.cjh == null) {
            this.cjh = new com.baidu.tbadk.coreExtra.data.a();
            this.cjh.alP();
        }
        return this.cjh.alO();
    }

    private void ra(String str) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2156670, str));
    }
}
