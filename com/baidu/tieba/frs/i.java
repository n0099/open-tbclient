package com.baidu.tieba.frs;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes.dex */
class i extends CustomMessageListener {
    final /* synthetic */ FrsActivity aBu;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(FrsActivity frsActivity, int i) {
        super(i);
        this.aBu = frsActivity;
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
            bVar = this.aBu.azN;
            if (bVar != null) {
                bVar2 = this.aBu.azN;
                UserData userData = bVar2.getUserData();
                if (userData != null) {
                    userData.setIsMem(num.intValue());
                    if (num.intValue() != 0) {
                        buVar = this.aBu.aAF;
                        buVar.setIsMem(num.intValue());
                        str = this.aBu.mPageType;
                        if ("frs_page".equals(str)) {
                            buVar3 = this.aBu.aAF;
                            buVar3.GG();
                            return;
                        }
                        str2 = this.aBu.mPageType;
                        if ("normal_page".equals(str2)) {
                            buVar2 = this.aBu.aAF;
                            buVar2.GF();
                        }
                    }
                }
            }
        }
    }
}
