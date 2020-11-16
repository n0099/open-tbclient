package com.baidu.tbadk.util;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.coreExtra.data.ABTestExtraData;
/* loaded from: classes.dex */
public class a {
    private static a fxr;
    private com.baidu.tbadk.coreExtra.data.a ffe;
    private ABTestExtraData fff;

    public static a bCu() {
        if (fxr == null) {
            synchronized (a.class) {
                if (fxr == null) {
                    fxr = new a();
                }
            }
        }
        return fxr;
    }

    public void a(com.baidu.tbadk.coreExtra.data.a aVar) {
        b(aVar);
    }

    private void b(com.baidu.tbadk.coreExtra.data.a aVar) {
        boolean z = false;
        z = (aVar == null || this.ffe == null || aVar.btB() != this.ffe.btB()) ? true : true;
        this.ffe = aVar;
        if (z) {
            DS("zan_or_cai_smallflow");
        }
    }

    private void DS(String str) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2156670, str));
    }

    public void a(ABTestExtraData aBTestExtraData) {
        this.fff = aBTestExtraData;
    }

    public String bCv() {
        if (this.fff == null) {
            this.fff = new ABTestExtraData();
            this.fff.parserABTestExtraFormSharedPref();
        }
        return this.fff.getABTestResult();
    }
}
