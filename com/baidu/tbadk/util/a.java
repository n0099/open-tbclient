package com.baidu.tbadk.util;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.coreExtra.data.ABTestExtraData;
/* loaded from: classes.dex */
public class a {
    private static a fFg;
    private com.baidu.tbadk.coreExtra.data.a fmE;
    private ABTestExtraData fmF;

    public static a bFV() {
        if (fFg == null) {
            synchronized (a.class) {
                if (fFg == null) {
                    fFg = new a();
                }
            }
        }
        return fFg;
    }

    public void a(com.baidu.tbadk.coreExtra.data.a aVar) {
        b(aVar);
    }

    private void b(com.baidu.tbadk.coreExtra.data.a aVar) {
        boolean z = false;
        z = (aVar == null || this.fmE == null || aVar.bxb() != this.fmE.bxb()) ? true : true;
        this.fmE = aVar;
        if (z) {
            ED("zan_or_cai_smallflow");
        }
    }

    private void ED(String str) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2156670, str));
    }

    public void a(ABTestExtraData aBTestExtraData) {
        this.fmF = aBTestExtraData;
    }

    public String bFW() {
        if (this.fmF == null) {
            this.fmF = new ABTestExtraData();
            this.fmF.parserABTestExtraFormSharedPref();
        }
        return this.fmF.getABTestResult();
    }
}
