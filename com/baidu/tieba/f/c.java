package com.baidu.tieba.f;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.newFriends.ResponseUnreadPointNum;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends CustomMessageListener {
    final /* synthetic */ a eQj;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(a aVar, int i) {
        super(i);
        this.eQj = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        int i;
        boolean z;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001176 && customResponsedMessage.getError() == 0 && (customResponsedMessage instanceof ResponseUnreadPointNum)) {
            ResponseUnreadPointNum responseUnreadPointNum = (ResponseUnreadPointNum) customResponsedMessage;
            if (responseUnreadPointNum.getNum() > 0) {
                i = this.eQj.ePT;
                if (i < responseUnreadPointNum.getNum()) {
                    this.eQj.ePU = true;
                    a aVar = this.eQj;
                    z = this.eQj.ePU;
                    aVar.ePL = z ? true : this.eQj.ePL;
                    this.eQj.ePT = responseUnreadPointNum.getNum();
                    this.eQj.aYE();
                    this.eQj.aYD();
                }
            }
            this.eQj.ePT = responseUnreadPointNum.getNum();
            this.eQj.ePU = false;
            this.eQj.aYD();
        }
    }
}
