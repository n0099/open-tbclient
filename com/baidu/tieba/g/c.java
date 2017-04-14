package com.baidu.tieba.g;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.newFriends.ResponseUnreadPointNum;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends CustomMessageListener {
    final /* synthetic */ a ffB;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(a aVar, int i) {
        super(i);
        this.ffB = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        int i;
        boolean z;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001176 && customResponsedMessage.getError() == 0 && (customResponsedMessage instanceof ResponseUnreadPointNum)) {
            ResponseUnreadPointNum responseUnreadPointNum = (ResponseUnreadPointNum) customResponsedMessage;
            if (responseUnreadPointNum.getNum() > 0) {
                i = this.ffB.ffl;
                if (i < responseUnreadPointNum.getNum()) {
                    this.ffB.ffm = true;
                    a aVar = this.ffB;
                    z = this.ffB.ffm;
                    aVar.ffd = z ? true : this.ffB.ffd;
                    this.ffB.ffl = responseUnreadPointNum.getNum();
                    this.ffB.baN();
                    this.ffB.baM();
                }
            }
            this.ffB.ffl = responseUnreadPointNum.getNum();
            this.ffB.ffm = false;
            this.ffB.baM();
        }
    }
}
