package com.baidu.tbadk.util;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.coreExtra.data.ABTestExtraData;
/* loaded from: classes.dex */
public class a {
    private static a ego;
    private com.baidu.tbadk.coreExtra.data.a dPE;
    private ABTestExtraData dPF;

    public static a aZZ() {
        if (ego == null) {
            synchronized (a.class) {
                if (ego == null) {
                    ego = new a();
                }
            }
        }
        return ego;
    }

    public void a(com.baidu.tbadk.coreExtra.data.a aVar) {
        b(aVar);
    }

    private void b(com.baidu.tbadk.coreExtra.data.a aVar) {
        boolean z = false;
        z = (aVar == null || this.dPE == null || aVar.aRA() != this.dPE.aRA()) ? true : true;
        this.dPE = aVar;
        if (z) {
            xe("zan_or_cai_smallflow");
        }
    }

    public boolean aRA() {
        if (this.dPE == null) {
            this.dPE = new com.baidu.tbadk.coreExtra.data.a();
            this.dPE.aRB();
        }
        return this.dPE.aRA();
    }

    private void xe(String str) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2156670, str));
    }

    public void a(ABTestExtraData aBTestExtraData) {
        this.dPF = aBTestExtraData;
    }

    public String baa() {
        if (this.dPF == null) {
            this.dPF = new ABTestExtraData();
            this.dPF.parserABTestExtraFormSharedPref();
        }
        return this.dPF.getABTestResult();
    }
}
