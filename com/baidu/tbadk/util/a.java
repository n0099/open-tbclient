package com.baidu.tbadk.util;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.coreExtra.data.ABTestExtraData;
/* loaded from: classes.dex */
public class a {
    private static a dGd;
    private com.baidu.tbadk.coreExtra.data.a dpk;
    private ABTestExtraData dpl;

    public static a aRJ() {
        if (dGd == null) {
            synchronized (a.class) {
                if (dGd == null) {
                    dGd = new a();
                }
            }
        }
        return dGd;
    }

    public void a(com.baidu.tbadk.coreExtra.data.a aVar) {
        b(aVar);
    }

    private void b(com.baidu.tbadk.coreExtra.data.a aVar) {
        boolean z = false;
        z = (aVar == null || this.dpk == null || aVar.aIW() != this.dpk.aIW()) ? true : true;
        this.dpk = aVar;
        if (z) {
            vO("zan_or_cai_smallflow");
        }
    }

    public boolean aIW() {
        if (this.dpk == null) {
            this.dpk = new com.baidu.tbadk.coreExtra.data.a();
            this.dpk.aIX();
        }
        return this.dpk.aIW();
    }

    private void vO(String str) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2156670, str));
    }

    public void a(ABTestExtraData aBTestExtraData) {
        this.dpl = aBTestExtraData;
    }

    public String aRK() {
        if (this.dpl == null) {
            this.dpl = new ABTestExtraData();
            this.dpl.parserABTestExtraFormSharedPref();
        }
        return this.dpl.getABTestResult();
    }
}
