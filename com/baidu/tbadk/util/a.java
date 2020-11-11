package com.baidu.tbadk.util;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.coreExtra.data.ABTestExtraData;
/* loaded from: classes.dex */
public class a {
    private static a fyc;
    private com.baidu.tbadk.coreExtra.data.a ffW;
    private ABTestExtraData ffX;

    public static a bDb() {
        if (fyc == null) {
            synchronized (a.class) {
                if (fyc == null) {
                    fyc = new a();
                }
            }
        }
        return fyc;
    }

    public void a(com.baidu.tbadk.coreExtra.data.a aVar) {
        b(aVar);
    }

    private void b(com.baidu.tbadk.coreExtra.data.a aVar) {
        boolean z = false;
        z = (aVar == null || this.ffW == null || aVar.bul() != this.ffW.bul()) ? true : true;
        this.ffW = aVar;
        if (z) {
            Et("zan_or_cai_smallflow");
        }
    }

    private void Et(String str) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2156670, str));
    }

    public void a(ABTestExtraData aBTestExtraData) {
        this.ffX = aBTestExtraData;
    }

    public String bDc() {
        if (this.ffX == null) {
            this.ffX = new ABTestExtraData();
            this.ffX.parserABTestExtraFormSharedPref();
        }
        return this.ffX.getABTestResult();
    }
}
