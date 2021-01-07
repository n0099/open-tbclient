package com.baidu.tbadk.util;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.coreExtra.data.ABTestExtraData;
/* loaded from: classes.dex */
public class a {
    private static a fOK;
    private com.baidu.tbadk.coreExtra.data.a fwo;
    private ABTestExtraData fwp;

    public static a bIr() {
        if (fOK == null) {
            synchronized (a.class) {
                if (fOK == null) {
                    fOK = new a();
                }
            }
        }
        return fOK;
    }

    public void a(com.baidu.tbadk.coreExtra.data.a aVar) {
        b(aVar);
    }

    private void b(com.baidu.tbadk.coreExtra.data.a aVar) {
        boolean z = false;
        z = (aVar == null || this.fwo == null || aVar.bzv() != this.fwo.bzv()) ? true : true;
        this.fwo = aVar;
        if (z) {
            Ez("zan_or_cai_smallflow");
        }
    }

    private void Ez(String str) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2156670, str));
    }

    public void a(ABTestExtraData aBTestExtraData) {
        this.fwp = aBTestExtraData;
    }

    public String bIs() {
        if (this.fwp == null) {
            this.fwp = new ABTestExtraData();
            this.fwp.parserABTestExtraFormSharedPref();
        }
        return this.fwp.getABTestResult();
    }
}
