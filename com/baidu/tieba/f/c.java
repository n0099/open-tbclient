package com.baidu.tieba.f;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.newFriends.ResponseUnreadPointNum;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends CustomMessageListener {
    final /* synthetic */ a fmo;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(a aVar, int i) {
        super(i);
        this.fmo = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        int i;
        boolean z;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001180 && customResponsedMessage.getError() == 0 && (customResponsedMessage instanceof ResponseUnreadPointNum)) {
            ResponseUnreadPointNum responseUnreadPointNum = (ResponseUnreadPointNum) customResponsedMessage;
            if (responseUnreadPointNum.getNum() > 0) {
                i = this.fmo.fma;
                if (i < responseUnreadPointNum.getNum()) {
                    this.fmo.fmb = true;
                    a aVar = this.fmo;
                    z = this.fmo.fmb;
                    aVar.flT = z ? true : this.fmo.flT;
                    this.fmo.fma = responseUnreadPointNum.getNum();
                    this.fmo.beQ();
                    this.fmo.beP();
                }
            }
            this.fmo.fma = responseUnreadPointNum.getNum();
            this.fmo.fmb = false;
            this.fmo.beP();
        }
    }
}
