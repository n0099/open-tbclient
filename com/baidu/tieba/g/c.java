package com.baidu.tieba.g;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.newFriends.ResponseUnreadPointNum;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends CustomMessageListener {
    final /* synthetic */ a fhS;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(a aVar, int i) {
        super(i);
        this.fhS = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        int i;
        boolean z;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001176 && customResponsedMessage.getError() == 0 && (customResponsedMessage instanceof ResponseUnreadPointNum)) {
            ResponseUnreadPointNum responseUnreadPointNum = (ResponseUnreadPointNum) customResponsedMessage;
            if (responseUnreadPointNum.getNum() > 0) {
                i = this.fhS.fhC;
                if (i < responseUnreadPointNum.getNum()) {
                    this.fhS.fhD = true;
                    a aVar = this.fhS;
                    z = this.fhS.fhD;
                    aVar.fhu = z ? true : this.fhS.fhu;
                    this.fhS.fhC = responseUnreadPointNum.getNum();
                    this.fhS.bbO();
                    this.fhS.bbN();
                }
            }
            this.fhS.fhC = responseUnreadPointNum.getNum();
            this.fhS.fhD = false;
            this.fhS.bbN();
        }
    }
}
