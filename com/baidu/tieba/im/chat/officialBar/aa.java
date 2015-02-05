package com.baidu.tieba.im.chat.officialBar;

import android.os.Handler;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ OfficialBarHistoryActivity aUv;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aa(OfficialBarHistoryActivity officialBarHistoryActivity) {
        super(208002);
        this.aUv = officialBarHistoryActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        RequestHistoryMessage requestHistoryMessage;
        List list;
        af afVar;
        List<aq> list2;
        this.aUv.hideProgressBar();
        this.aUv.aUu = false;
        if (socketResponsedMessage == null) {
            this.aUv.showToast(com.baidu.tieba.z.neterror);
        } else if (socketResponsedMessage.getError() != 0) {
            this.aUv.showToast(socketResponsedMessage.getErrorString());
        } else if (socketResponsedMessage.getCmd() == 208002 && (socketResponsedMessage instanceof ResponseHistoryMessage)) {
            ResponseHistoryMessage responseHistoryMessage = (ResponseHistoryMessage) socketResponsedMessage;
            if (!responseHistoryMessage.getMsg().isEmpty() && (requestHistoryMessage = (RequestHistoryMessage) responseHistoryMessage.getOrginalMessage()) != null) {
                if (requestHistoryMessage.getRequestId() == 0) {
                    this.aUv.aUt = responseHistoryMessage.getMsg();
                } else {
                    list = this.aUv.aUt;
                    list.addAll(responseHistoryMessage.getMsg());
                }
                afVar = this.aUv.aUq;
                list2 = this.aUv.aUt;
                afVar.setData(list2);
                if (responseHistoryMessage.getMsg().size() != 0) {
                    new Handler().post(new ab(this));
                }
            }
        } else {
            this.aUv.showToast(com.baidu.tieba.z.neterror);
        }
    }
}
