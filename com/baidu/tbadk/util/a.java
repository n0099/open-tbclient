package com.baidu.tbadk.util;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.coreExtra.data.ABTestExtraData;
/* loaded from: classes.dex */
public class a {
    private static a fsk;
    private com.baidu.tbadk.coreExtra.data.a faf;
    private ABTestExtraData fag;

    public static a bAC() {
        if (fsk == null) {
            synchronized (a.class) {
                if (fsk == null) {
                    fsk = new a();
                }
            }
        }
        return fsk;
    }

    public void a(com.baidu.tbadk.coreExtra.data.a aVar) {
        b(aVar);
    }

    private void b(com.baidu.tbadk.coreExtra.data.a aVar) {
        boolean z = false;
        z = (aVar == null || this.faf == null || aVar.brL() != this.faf.brL()) ? true : true;
        this.faf = aVar;
        if (z) {
            Ef("zan_or_cai_smallflow");
        }
    }

    private void Ef(String str) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2156670, str));
    }

    public void a(ABTestExtraData aBTestExtraData) {
        this.fag = aBTestExtraData;
    }

    public String bAD() {
        if (this.fag == null) {
            this.fag = new ABTestExtraData();
            this.fag.parserABTestExtraFormSharedPref();
        }
        return this.fag.getABTestResult();
    }
}
