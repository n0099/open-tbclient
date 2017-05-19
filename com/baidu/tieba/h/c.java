package com.baidu.tieba.h;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.newFriends.ResponseUnreadPointNum;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends CustomMessageListener {
    final /* synthetic */ a fdP;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(a aVar, int i) {
        super(i);
        this.fdP = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        int i;
        boolean z;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001176 && customResponsedMessage.getError() == 0 && (customResponsedMessage instanceof ResponseUnreadPointNum)) {
            ResponseUnreadPointNum responseUnreadPointNum = (ResponseUnreadPointNum) customResponsedMessage;
            if (responseUnreadPointNum.getNum() > 0) {
                i = this.fdP.fdx;
                if (i < responseUnreadPointNum.getNum()) {
                    this.fdP.fdz = true;
                    a aVar = this.fdP;
                    z = this.fdP.fdz;
                    aVar.fdo = z ? true : this.fdP.fdo;
                    this.fdP.fdx = responseUnreadPointNum.getNum();
                    this.fdP.aZn();
                    this.fdP.aZm();
                }
            }
            this.fdP.fdx = responseUnreadPointNum.getNum();
            this.fdP.fdz = false;
            this.fdP.aZm();
        }
    }
}
