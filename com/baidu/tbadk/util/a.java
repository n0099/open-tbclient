package com.baidu.tbadk.util;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.coreExtra.data.ABTestExtraData;
/* loaded from: classes.dex */
public class a {
    private static a egt;
    private com.baidu.tbadk.coreExtra.data.a dPJ;
    private ABTestExtraData dPK;

    public static a aZX() {
        if (egt == null) {
            synchronized (a.class) {
                if (egt == null) {
                    egt = new a();
                }
            }
        }
        return egt;
    }

    public void a(com.baidu.tbadk.coreExtra.data.a aVar) {
        b(aVar);
    }

    private void b(com.baidu.tbadk.coreExtra.data.a aVar) {
        boolean z = false;
        z = (aVar == null || this.dPJ == null || aVar.aRx() != this.dPJ.aRx()) ? true : true;
        this.dPJ = aVar;
        if (z) {
            xh("zan_or_cai_smallflow");
        }
    }

    public boolean aRx() {
        if (this.dPJ == null) {
            this.dPJ = new com.baidu.tbadk.coreExtra.data.a();
            this.dPJ.aRy();
        }
        return this.dPJ.aRx();
    }

    private void xh(String str) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2156670, str));
    }

    public void a(ABTestExtraData aBTestExtraData) {
        this.dPK = aBTestExtraData;
    }

    public String aZY() {
        if (this.dPK == null) {
            this.dPK = new ABTestExtraData();
            this.dPK.parserABTestExtraFormSharedPref();
        }
        return this.dPK.getABTestResult();
    }
}
