package com.baidu.tieba.frs;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes.dex */
class ba extends CustomMessageListener {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ba(FrsActivity frsActivity, int i) {
        super(i);
        this.a = frsActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        Integer num;
        g gVar;
        g gVar2;
        cv cvVar;
        String str;
        String str2;
        cv cvVar2;
        cv cvVar3;
        if (customResponsedMessage != null && (num = (Integer) customResponsedMessage.getData()) != null) {
            gVar = this.a.N;
            if (gVar != null) {
                gVar2 = this.a.N;
                UserData k = gVar2.k();
                if (k != null) {
                    k.setIsMem(num.intValue());
                    if (num.intValue() != 0) {
                        cvVar = this.a.B;
                        cvVar.i(num.intValue());
                        str = this.a.T;
                        if ("frs_page".equals(str)) {
                            cvVar3 = this.a.B;
                            cvVar3.N();
                            return;
                        }
                        str2 = this.a.T;
                        if ("normal_page".equals(str2)) {
                            cvVar2 = this.a.B;
                            cvVar2.M();
                        }
                    }
                }
            }
        }
    }
}
