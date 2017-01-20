package com.baidu.tieba.h;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.newFriends.ResponseUnreadPointNum;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends CustomMessageListener {
    final /* synthetic */ a eZE;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(a aVar, int i) {
        super(i);
        this.eZE = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        int i;
        boolean z;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001176 && customResponsedMessage.getError() == 0 && (customResponsedMessage instanceof ResponseUnreadPointNum)) {
            ResponseUnreadPointNum responseUnreadPointNum = (ResponseUnreadPointNum) customResponsedMessage;
            if (responseUnreadPointNum.getNum() > 0) {
                i = this.eZE.eZo;
                if (i < responseUnreadPointNum.getNum()) {
                    this.eZE.eZp = true;
                    a aVar = this.eZE;
                    z = this.eZE.eZp;
                    aVar.eZg = z ? true : this.eZE.eZg;
                    this.eZE.eZo = responseUnreadPointNum.getNum();
                    this.eZE.bat();
                    this.eZE.bas();
                }
            }
            this.eZE.eZo = responseUnreadPointNum.getNum();
            this.eZE.eZp = false;
            this.eZE.bas();
        }
    }
}
