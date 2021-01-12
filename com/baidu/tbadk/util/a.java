package com.baidu.tbadk.util;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.coreExtra.data.ABTestExtraData;
/* loaded from: classes.dex */
public class a {
    private static a fKd;
    private com.baidu.tbadk.coreExtra.data.a frF;
    private ABTestExtraData frG;

    public static a bEz() {
        if (fKd == null) {
            synchronized (a.class) {
                if (fKd == null) {
                    fKd = new a();
                }
            }
        }
        return fKd;
    }

    public void a(com.baidu.tbadk.coreExtra.data.a aVar) {
        b(aVar);
    }

    private void b(com.baidu.tbadk.coreExtra.data.a aVar) {
        boolean z = false;
        z = (aVar == null || this.frF == null || aVar.bvB() != this.frF.bvB()) ? true : true;
        this.frF = aVar;
        if (z) {
            Do("zan_or_cai_smallflow");
        }
    }

    private void Do(String str) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2156670, str));
    }

    public void a(ABTestExtraData aBTestExtraData) {
        this.frG = aBTestExtraData;
    }

    public String bEA() {
        if (this.frG == null) {
            this.frG = new ABTestExtraData();
            this.frG.parserABTestExtraFormSharedPref();
        }
        return this.frG.getABTestResult();
    }
}
