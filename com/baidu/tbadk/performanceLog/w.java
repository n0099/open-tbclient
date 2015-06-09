package com.baidu.tbadk.performanceLog;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import java.util.ArrayList;
/* loaded from: classes.dex */
class w extends CustomMessageListener {
    final /* synthetic */ u aqu;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(u uVar, int i) {
        super(i);
        this.aqu = uVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        x xVar;
        ArrayList arrayList;
        ArrayList arrayList2;
        if (customResponsedMessage != null && (xVar = (x) customResponsedMessage.getData()) != null && customResponsedMessage.getOrginalMessage().getTag() == this.aqu.mId) {
            this.aqu.eW(xVar.apZ);
            this.aqu.ek(xVar.aqa);
            this.aqu.eX(xVar.aqv);
            arrayList = this.aqu.apP;
            if (arrayList != null) {
                arrayList2 = this.aqu.apP;
                if (arrayList2.size() >= 20) {
                    this.aqu.Dr();
                }
            }
        }
    }
}
