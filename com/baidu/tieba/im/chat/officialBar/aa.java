package com.baidu.tieba.im.chat.officialBar;

import android.os.Handler;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ OfficialBarHistoryActivity aRA;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aa(OfficialBarHistoryActivity officialBarHistoryActivity) {
        super(208002);
        this.aRA = officialBarHistoryActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        RequestHistoryMessage requestHistoryMessage;
        List list;
        af afVar;
        List<az> list2;
        this.aRA.hideProgressBar();
        this.aRA.aRz = false;
        if (socketResponsedMessage == null) {
            this.aRA.showToast(com.baidu.tieba.y.neterror);
        } else if (socketResponsedMessage.getError() != 0) {
            this.aRA.showToast(socketResponsedMessage.getErrorString());
        } else if (socketResponsedMessage.getCmd() == 208002 && (socketResponsedMessage instanceof ResponseHistoryMessage)) {
            ResponseHistoryMessage responseHistoryMessage = (ResponseHistoryMessage) socketResponsedMessage;
            if (!responseHistoryMessage.getMsg().isEmpty() && (requestHistoryMessage = (RequestHistoryMessage) responseHistoryMessage.getOrginalMessage()) != null) {
                if (requestHistoryMessage.getRequestId() == 0) {
                    this.aRA.aRy = responseHistoryMessage.getMsg();
                } else {
                    list = this.aRA.aRy;
                    list.addAll(responseHistoryMessage.getMsg());
                }
                afVar = this.aRA.aRv;
                list2 = this.aRA.aRy;
                afVar.setData(list2);
                if (responseHistoryMessage.getMsg().size() != 0) {
                    new Handler().post(new ab(this));
                }
            }
        } else {
            this.aRA.showToast(com.baidu.tieba.y.neterror);
        }
    }
}
