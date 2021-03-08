package com.baidu.tbadk.util;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.coreExtra.data.ABTestExtraData;
/* loaded from: classes.dex */
public class a {
    private static a fNO;
    private com.baidu.tbadk.coreExtra.data.a fvw;
    private ABTestExtraData fvx;

    public static a bEW() {
        if (fNO == null) {
            synchronized (a.class) {
                if (fNO == null) {
                    fNO = new a();
                }
            }
        }
        return fNO;
    }

    public void a(com.baidu.tbadk.coreExtra.data.a aVar) {
        b(aVar);
    }

    private void b(com.baidu.tbadk.coreExtra.data.a aVar) {
        boolean z = false;
        z = (aVar == null || this.fvw == null || aVar.bvX() != this.fvw.bvX()) ? true : true;
        this.fvw = aVar;
        if (z) {
            DK("zan_or_cai_smallflow");
        }
    }

    private void DK(String str) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2156670, str));
    }

    public void a(ABTestExtraData aBTestExtraData) {
        this.fvx = aBTestExtraData;
    }

    public String bEX() {
        if (this.fvx == null) {
            this.fvx = new ABTestExtraData();
            this.fvx.parserABTestExtraFormSharedPref();
        }
        return this.fvx.getABTestResult();
    }
}
