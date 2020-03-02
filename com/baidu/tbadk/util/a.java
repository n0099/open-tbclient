package com.baidu.tbadk.util;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.coreExtra.data.ABTestExtraData;
/* loaded from: classes.dex */
public class a {
    private static a dGe;
    private com.baidu.tbadk.coreExtra.data.a dpl;
    private ABTestExtraData dpm;

    public static a aRL() {
        if (dGe == null) {
            synchronized (a.class) {
                if (dGe == null) {
                    dGe = new a();
                }
            }
        }
        return dGe;
    }

    public void a(com.baidu.tbadk.coreExtra.data.a aVar) {
        b(aVar);
    }

    private void b(com.baidu.tbadk.coreExtra.data.a aVar) {
        boolean z = false;
        z = (aVar == null || this.dpl == null || aVar.aIY() != this.dpl.aIY()) ? true : true;
        this.dpl = aVar;
        if (z) {
            vO("zan_or_cai_smallflow");
        }
    }

    public boolean aIY() {
        if (this.dpl == null) {
            this.dpl = new com.baidu.tbadk.coreExtra.data.a();
            this.dpl.aIZ();
        }
        return this.dpl.aIY();
    }

    private void vO(String str) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2156670, str));
    }

    public void a(ABTestExtraData aBTestExtraData) {
        this.dpm = aBTestExtraData;
    }

    public String aRM() {
        if (this.dpm == null) {
            this.dpm = new ABTestExtraData();
            this.dpm.parserABTestExtraFormSharedPref();
        }
        return this.dpm.getABTestResult();
    }
}
