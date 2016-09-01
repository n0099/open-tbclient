package com.baidu.tieba.g;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.newFriends.ResponseUnreadPointNum;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends CustomMessageListener {
    final /* synthetic */ a fcn;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(a aVar, int i) {
        super(i);
        this.fcn = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        int i;
        boolean z;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001180 && customResponsedMessage.getError() == 0 && (customResponsedMessage instanceof ResponseUnreadPointNum)) {
            ResponseUnreadPointNum responseUnreadPointNum = (ResponseUnreadPointNum) customResponsedMessage;
            if (responseUnreadPointNum.getNum() > 0) {
                i = this.fcn.fbZ;
                if (i < responseUnreadPointNum.getNum()) {
                    this.fcn.fca = true;
                    a aVar = this.fcn;
                    z = this.fcn.fca;
                    aVar.fbS = z ? true : this.fcn.fbS;
                    this.fcn.fbZ = responseUnreadPointNum.getNum();
                    this.fcn.bbF();
                    this.fcn.bbE();
                }
            }
            this.fcn.fbZ = responseUnreadPointNum.getNum();
            this.fcn.fca = false;
            this.fcn.bbE();
        }
    }
}
