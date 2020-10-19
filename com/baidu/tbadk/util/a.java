package com.baidu.tbadk.util;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.coreExtra.data.ABTestExtraData;
/* loaded from: classes.dex */
public class a {
    private static a fjL;
    private com.baidu.tbadk.coreExtra.data.a eRJ;
    private ABTestExtraData eRK;

    public static a byJ() {
        if (fjL == null) {
            synchronized (a.class) {
                if (fjL == null) {
                    fjL = new a();
                }
            }
        }
        return fjL;
    }

    public void a(com.baidu.tbadk.coreExtra.data.a aVar) {
        b(aVar);
    }

    private void b(com.baidu.tbadk.coreExtra.data.a aVar) {
        boolean z = false;
        z = (aVar == null || this.eRJ == null || aVar.bpS() != this.eRJ.bpS()) ? true : true;
        this.eRJ = aVar;
        if (z) {
            DM("zan_or_cai_smallflow");
        }
    }

    private void DM(String str) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2156670, str));
    }

    public void a(ABTestExtraData aBTestExtraData) {
        this.eRK = aBTestExtraData;
    }

    public String byK() {
        if (this.eRK == null) {
            this.eRK = new ABTestExtraData();
            this.eRK.parserABTestExtraFormSharedPref();
        }
        return this.eRK.getABTestResult();
    }
}
