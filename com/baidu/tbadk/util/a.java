package com.baidu.tbadk.util;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.coreExtra.data.ABTestExtraData;
/* loaded from: classes2.dex */
public class a {
    private static a eUF;
    private com.baidu.tbadk.coreExtra.data.a eDt;
    private ABTestExtraData eDu;

    public static a buU() {
        if (eUF == null) {
            synchronized (a.class) {
                if (eUF == null) {
                    eUF = new a();
                }
            }
        }
        return eUF;
    }

    public void a(com.baidu.tbadk.coreExtra.data.a aVar) {
        b(aVar);
    }

    private void b(com.baidu.tbadk.coreExtra.data.a aVar) {
        boolean z = false;
        z = (aVar == null || this.eDt == null || aVar.bmo() != this.eDt.bmo()) ? true : true;
        this.eDt = aVar;
        if (z) {
            CD("zan_or_cai_smallflow");
        }
    }

    private void CD(String str) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2156670, str));
    }

    public void a(ABTestExtraData aBTestExtraData) {
        this.eDu = aBTestExtraData;
    }

    public String buV() {
        if (this.eDu == null) {
            this.eDu = new ABTestExtraData();
            this.eDu.parserABTestExtraFormSharedPref();
        }
        return this.eDu.getABTestResult();
    }
}
