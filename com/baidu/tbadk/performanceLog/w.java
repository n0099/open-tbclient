package com.baidu.tbadk.performanceLog;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import java.util.ArrayList;
/* loaded from: classes.dex */
class w extends CustomMessageListener {
    final /* synthetic */ u aph;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(u uVar, int i) {
        super(i);
        this.aph = uVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        x xVar;
        ArrayList arrayList;
        ArrayList arrayList2;
        if (customResponsedMessage != null && (xVar = (x) customResponsedMessage.getData()) != null && customResponsedMessage.getOrginalMessage().getTag() == this.aph.mId) {
            this.aph.eC(xVar.aoM);
            this.aph.ea(xVar.aoN);
            this.aph.eD(xVar.apj);
            arrayList = this.aph.aoC;
            if (arrayList != null) {
                arrayList2 = this.aph.aoC;
                if (arrayList2.size() >= 20) {
                    this.aph.Cz();
                }
            }
        }
    }
}
