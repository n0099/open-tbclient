package com.baidu.tieba.frs;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes.dex */
class i extends CustomMessageListener {
    final /* synthetic */ FrsActivity aBk;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(FrsActivity frsActivity, int i) {
        super(i);
        this.aBk = frsActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        Integer num;
        b bVar;
        b bVar2;
        bu buVar;
        String str;
        String str2;
        bu buVar2;
        bu buVar3;
        if (customResponsedMessage != null && (num = (Integer) customResponsedMessage.getData()) != null) {
            bVar = this.aBk.azE;
            if (bVar != null) {
                bVar2 = this.aBk.azE;
                UserData userData = bVar2.getUserData();
                if (userData != null) {
                    userData.setIsMem(num.intValue());
                    if (num.intValue() != 0) {
                        buVar = this.aBk.aAv;
                        buVar.setIsMem(num.intValue());
                        str = this.aBk.mPageType;
                        if ("frs_page".equals(str)) {
                            buVar3 = this.aBk.aAv;
                            buVar3.GE();
                            return;
                        }
                        str2 = this.aBk.mPageType;
                        if ("normal_page".equals(str2)) {
                            buVar2 = this.aBk.aAv;
                            buVar2.GD();
                        }
                    }
                }
            }
        }
    }
}
