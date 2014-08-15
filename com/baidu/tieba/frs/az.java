package com.baidu.tieba.frs;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes.dex */
class az extends CustomMessageListener {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public az(FrsActivity frsActivity, int i) {
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
        cu cuVar;
        String str;
        String str2;
        cu cuVar2;
        cu cuVar3;
        if (customResponsedMessage != null && (num = (Integer) customResponsedMessage.getData()) != null) {
            gVar = this.a.L;
            if (gVar != null) {
                gVar2 = this.a.L;
                UserData k = gVar2.k();
                if (k != null) {
                    k.setIsMem(num.intValue());
                    if (num.intValue() != 0) {
                        cuVar = this.a.z;
                        cuVar.i(num.intValue());
                        str = this.a.R;
                        if ("frs_page".equals(str)) {
                            cuVar3 = this.a.z;
                            cuVar3.N();
                            return;
                        }
                        str2 = this.a.R;
                        if ("normal_page".equals(str2)) {
                            cuVar2 = this.a.z;
                            cuVar2.M();
                        }
                    }
                }
            }
        }
    }
}
