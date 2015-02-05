package com.baidu.tieba.frs;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes.dex */
class d extends CustomMessageListener {
    final /* synthetic */ FrsActivity aDT;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(FrsActivity frsActivity, int i) {
        super(i);
        this.aDT = frsActivity;
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
            eVar = this.aDT.aDf;
            if (eVar != null) {
                eVar2 = this.aDT.aDf;
                UserData userData = eVar2.getUserData();
                if (userData != null) {
                    userData.setIsMem(num.intValue());
                    if (num.intValue() != 0) {
                        bpVar = this.aDT.aCV;
                        bpVar.setIsMem(num.intValue());
                        str = this.aDT.mPageType;
                        if ("frs_page".equals(str)) {
                            bpVar3 = this.aDT.aCV;
                            bpVar3.Hc();
                            return;
                        }
                        str2 = this.aDT.mPageType;
                        if ("normal_page".equals(str2)) {
                            bpVar2 = this.aDT.aCV;
                            bpVar2.Hb();
                        }
                    }
                }
            }
        }
    }
}
