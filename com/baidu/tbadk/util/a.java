package com.baidu.tbadk.util;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.coreExtra.data.ABTestExtraData;
/* loaded from: classes.dex */
public class a {
    private static a eDL;
    private com.baidu.tbadk.coreExtra.data.a emJ;
    private ABTestExtraData emK;

    public static a biv() {
        if (eDL == null) {
            synchronized (a.class) {
                if (eDL == null) {
                    eDL = new a();
                }
            }
        }
        return eDL;
    }

    public void a(com.baidu.tbadk.coreExtra.data.a aVar) {
        b(aVar);
    }

    private void b(com.baidu.tbadk.coreExtra.data.a aVar) {
        boolean z = false;
        z = (aVar == null || this.emJ == null || aVar.aZL() != this.emJ.aZL()) ? true : true;
        this.emJ = aVar;
        if (z) {
            zg("zan_or_cai_smallflow");
        }
    }

    private void zg(String str) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2156670, str));
    }

    public void a(ABTestExtraData aBTestExtraData) {
        this.emK = aBTestExtraData;
    }

    public String biw() {
        if (this.emK == null) {
            this.emK = new ABTestExtraData();
            this.emK.parserABTestExtraFormSharedPref();
        }
        return this.emK.getABTestResult();
    }
}
