package com.baidu.tieba.frs;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes.dex */
class d extends CustomMessageListener {
    final /* synthetic */ FrsActivity aCV;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(FrsActivity frsActivity, int i) {
        super(i);
        this.aCV = frsActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        Integer num;
        com.baidu.tieba.tbadkCore.e eVar;
        com.baidu.tieba.tbadkCore.e eVar2;
        bq bqVar;
        String str;
        String str2;
        bq bqVar2;
        bq bqVar3;
        if (customResponsedMessage != null && (num = (Integer) customResponsedMessage.getData()) != null) {
            eVar = this.aCV.aCh;
            if (eVar != null) {
                eVar2 = this.aCV.aCh;
                UserData userData = eVar2.getUserData();
                if (userData != null) {
                    userData.setIsMem(num.intValue());
                    if (num.intValue() != 0) {
                        bqVar = this.aCV.aBX;
                        bqVar.setIsMem(num.intValue());
                        str = this.aCV.mPageType;
                        if ("frs_page".equals(str)) {
                            bqVar3 = this.aCV.aBX;
                            bqVar3.GL();
                            return;
                        }
                        str2 = this.aCV.mPageType;
                        if ("normal_page".equals(str2)) {
                            bqVar2 = this.aCV.aBX;
                            bqVar2.GK();
                        }
                    }
                }
            }
        }
    }
}
