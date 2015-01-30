package com.baidu.tieba.frs;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes.dex */
class d extends CustomMessageListener {
    final /* synthetic */ FrsActivity aDW;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(FrsActivity frsActivity, int i) {
        super(i);
        this.aDW = frsActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        Integer num;
        com.baidu.tieba.tbadkCore.e eVar;
        com.baidu.tieba.tbadkCore.e eVar2;
        bp bpVar;
        String str;
        String str2;
        bp bpVar2;
        bp bpVar3;
        if (customResponsedMessage != null && (num = (Integer) customResponsedMessage.getData()) != null) {
            eVar = this.aDW.aDi;
            if (eVar != null) {
                eVar2 = this.aDW.aDi;
                UserData userData = eVar2.getUserData();
                if (userData != null) {
                    userData.setIsMem(num.intValue());
                    if (num.intValue() != 0) {
                        bpVar = this.aDW.aCY;
                        bpVar.setIsMem(num.intValue());
                        str = this.aDW.mPageType;
                        if ("frs_page".equals(str)) {
                            bpVar3 = this.aDW.aCY;
                            bpVar3.Hi();
                            return;
                        }
                        str2 = this.aDW.mPageType;
                        if ("normal_page".equals(str2)) {
                            bpVar2 = this.aDW.aCY;
                            bpVar2.Hh();
                        }
                    }
                }
            }
        }
    }
}
