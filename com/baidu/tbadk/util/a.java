package com.baidu.tbadk.util;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class a {
    private static a beK;
    private com.baidu.tbadk.coreExtra.data.a aNs;

    public static a OB() {
        if (beK == null) {
            synchronized (a.class) {
                if (beK == null) {
                    beK = new a();
                }
            }
        }
        return beK;
    }

    public void a(com.baidu.tbadk.coreExtra.data.a aVar) {
        b(aVar);
    }

    private void b(com.baidu.tbadk.coreExtra.data.a aVar) {
        boolean z = false;
        z = (aVar == null || this.aNs == null || aVar.Fb() != this.aNs.Fb()) ? true : true;
        this.aNs = aVar;
        if (z) {
            m17if("zan_or_cai_smallflow");
        }
    }

    public boolean Fb() {
        if (this.aNs == null) {
            this.aNs = new com.baidu.tbadk.coreExtra.data.a();
            this.aNs.Fc();
        }
        return this.aNs.Fb();
    }

    /* renamed from: if  reason: not valid java name */
    private void m17if(String str) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2156670, str));
    }
}
