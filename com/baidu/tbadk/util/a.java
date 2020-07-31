package com.baidu.tbadk.util;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.coreExtra.data.ABTestExtraData;
/* loaded from: classes.dex */
public class a {
    private static a eKa;
    private com.baidu.tbadk.coreExtra.data.a esV;
    private ABTestExtraData esW;

    public static a bmh() {
        if (eKa == null) {
            synchronized (a.class) {
                if (eKa == null) {
                    eKa = new a();
                }
            }
        }
        return eKa;
    }

    public void a(com.baidu.tbadk.coreExtra.data.a aVar) {
        b(aVar);
    }

    private void b(com.baidu.tbadk.coreExtra.data.a aVar) {
        boolean z = false;
        z = (aVar == null || this.esV == null || aVar.bdI() != this.esV.bdI()) ? true : true;
        this.esV = aVar;
        if (z) {
            An("zan_or_cai_smallflow");
        }
    }

    private void An(String str) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2156670, str));
    }

    public void a(ABTestExtraData aBTestExtraData) {
        this.esW = aBTestExtraData;
    }

    public String bmi() {
        if (this.esW == null) {
            this.esW = new ABTestExtraData();
            this.esW.parserABTestExtraFormSharedPref();
        }
        return this.esW.getABTestResult();
    }
}
