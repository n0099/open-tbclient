package com.baidu.tbadk.util;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.coreExtra.data.ABTestExtraData;
/* loaded from: classes.dex */
public class a {
    private static a eUJ;
    private com.baidu.tbadk.coreExtra.data.a eDx;
    private ABTestExtraData eDy;

    public static a buV() {
        if (eUJ == null) {
            synchronized (a.class) {
                if (eUJ == null) {
                    eUJ = new a();
                }
            }
        }
        return eUJ;
    }

    public void a(com.baidu.tbadk.coreExtra.data.a aVar) {
        b(aVar);
    }

    private void b(com.baidu.tbadk.coreExtra.data.a aVar) {
        boolean z = false;
        z = (aVar == null || this.eDx == null || aVar.bmo() != this.eDx.bmo()) ? true : true;
        this.eDx = aVar;
        if (z) {
            CE("zan_or_cai_smallflow");
        }
    }

    private void CE(String str) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2156670, str));
    }

    public void a(ABTestExtraData aBTestExtraData) {
        this.eDy = aBTestExtraData;
    }

    public String buW() {
        if (this.eDy == null) {
            this.eDy = new ABTestExtraData();
            this.eDy.parserABTestExtraFormSharedPref();
        }
        return this.eDy.getABTestResult();
    }
}
