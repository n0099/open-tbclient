package com.baidu.tbadk.util;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.coreExtra.data.ABTestExtraData;
/* loaded from: classes.dex */
public class a {
    private static a dGH;
    private com.baidu.tbadk.coreExtra.data.a dpL;
    private ABTestExtraData dpM;

    public static a aRQ() {
        if (dGH == null) {
            synchronized (a.class) {
                if (dGH == null) {
                    dGH = new a();
                }
            }
        }
        return dGH;
    }

    public void a(com.baidu.tbadk.coreExtra.data.a aVar) {
        b(aVar);
    }

    private void b(com.baidu.tbadk.coreExtra.data.a aVar) {
        boolean z = false;
        z = (aVar == null || this.dpL == null || aVar.aJd() != this.dpL.aJd()) ? true : true;
        this.dpL = aVar;
        if (z) {
            vP("zan_or_cai_smallflow");
        }
    }

    public boolean aJd() {
        if (this.dpL == null) {
            this.dpL = new com.baidu.tbadk.coreExtra.data.a();
            this.dpL.aJe();
        }
        return this.dpL.aJd();
    }

    private void vP(String str) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2156670, str));
    }

    public void a(ABTestExtraData aBTestExtraData) {
        this.dpM = aBTestExtraData;
    }

    public String aRR() {
        if (this.dpM == null) {
            this.dpM = new ABTestExtraData();
            this.dpM.parserABTestExtraFormSharedPref();
        }
        return this.dpM.getABTestResult();
    }
}
