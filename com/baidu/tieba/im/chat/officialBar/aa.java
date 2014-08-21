package com.baidu.tieba.im.chat.officialBar;

import android.os.Handler;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa extends com.baidu.adp.framework.listener.d {
    final /* synthetic */ OfficialBarHistoryActivity a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aa(OfficialBarHistoryActivity officialBarHistoryActivity) {
        super(208002);
        this.a = officialBarHistoryActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        RequestHistoryMessage requestHistoryMessage;
        List list;
        af afVar;
        List<bb> list2;
        this.a.hideProgressBar();
        this.a.f = false;
        if (socketResponsedMessage == null) {
            this.a.showToast(com.baidu.tieba.x.neterror);
        } else if (socketResponsedMessage.getError() != 0) {
            this.a.showToast(socketResponsedMessage.getErrorString());
        } else if (socketResponsedMessage.getCmd() == 208002 && (socketResponsedMessage instanceof ResponseHistoryMessage)) {
            ResponseHistoryMessage responseHistoryMessage = (ResponseHistoryMessage) socketResponsedMessage;
            if (!responseHistoryMessage.getMsg().isEmpty() && (requestHistoryMessage = (RequestHistoryMessage) responseHistoryMessage.getOrginalMessage()) != null) {
                if (requestHistoryMessage.getRequestId() == 0) {
                    this.a.e = responseHistoryMessage.getMsg();
                } else {
                    list = this.a.e;
                    list.addAll(responseHistoryMessage.getMsg());
                }
                afVar = this.a.b;
                list2 = this.a.e;
                afVar.a(list2);
                if (responseHistoryMessage.getMsg().size() != 0) {
                    new Handler().post(new ab(this));
                }
            }
        } else {
            this.a.showToast(com.baidu.tieba.x.neterror);
        }
    }
}
