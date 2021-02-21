package com.baidu.tbadk.util;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.coreExtra.data.ABTestExtraData;
/* loaded from: classes.dex */
public class a {
    private static a fMo;
    private com.baidu.tbadk.coreExtra.data.a ftX;
    private ABTestExtraData ftY;

    public static a bES() {
        if (fMo == null) {
            synchronized (a.class) {
                if (fMo == null) {
                    fMo = new a();
                }
            }
        }
        return fMo;
    }

    public void a(com.baidu.tbadk.coreExtra.data.a aVar) {
        b(aVar);
    }

    private void b(com.baidu.tbadk.coreExtra.data.a aVar) {
        boolean z = false;
        z = (aVar == null || this.ftX == null || aVar.bvU() != this.ftX.bvU()) ? true : true;
        this.ftX = aVar;
        if (z) {
            DD("zan_or_cai_smallflow");
        }
    }

    private void DD(String str) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2156670, str));
    }

    public void a(ABTestExtraData aBTestExtraData) {
        this.ftY = aBTestExtraData;
    }

    public String bET() {
        if (this.ftY == null) {
            this.ftY = new ABTestExtraData();
            this.ftY.parserABTestExtraFormSharedPref();
        }
        return this.ftY.getABTestResult();
    }
}
