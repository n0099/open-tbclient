package com.baidu.tbadk.mutiprocess.showreplyinpb;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.mutiprocess.b;
/* loaded from: classes2.dex */
public class a implements b<ShowReplyInPbEvent> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mutiprocess.b
    public boolean a(ShowReplyInPbEvent showReplyInPbEvent) {
        if (showReplyInPbEvent == null) {
            return false;
        }
        if (showReplyInPbEvent.isSubPbReply) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921481, showReplyInPbEvent.writeData));
        } else {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921480, showReplyInPbEvent.writeData));
        }
        return true;
    }
}
