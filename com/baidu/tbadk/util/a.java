package com.baidu.tbadk.util;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.coreExtra.data.ABTestExtraData;
/* loaded from: classes.dex */
public class a {
    private static a eXz;
    private com.baidu.tbadk.coreExtra.data.a eFC;
    private ABTestExtraData eFD;

    public static a bvZ() {
        if (eXz == null) {
            synchronized (a.class) {
                if (eXz == null) {
                    eXz = new a();
                }
            }
        }
        return eXz;
    }

    public void a(com.baidu.tbadk.coreExtra.data.a aVar) {
        b(aVar);
    }

    private void b(com.baidu.tbadk.coreExtra.data.a aVar) {
        boolean z = false;
        z = (aVar == null || this.eFC == null || aVar.bni() != this.eFC.bni()) ? true : true;
        this.eFC = aVar;
        if (z) {
            Da("zan_or_cai_smallflow");
        }
    }

    private void Da(String str) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2156670, str));
    }

    public void a(ABTestExtraData aBTestExtraData) {
        this.eFD = aBTestExtraData;
    }

    public String bwa() {
        if (this.eFD == null) {
            this.eFD = new ABTestExtraData();
            this.eFD.parserABTestExtraFormSharedPref();
        }
        return this.eFD.getABTestResult();
    }
}
