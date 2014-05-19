package com.baidu.tieba.im.chat.officialBar;

import android.os.Handler;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.core.frameworkData.MessageTypes;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab extends com.baidu.adp.framework.listener.b {
    final /* synthetic */ OfficialBarHistoryActivity a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ab(OfficialBarHistoryActivity officialBarHistoryActivity) {
        super(MessageTypes.CMD_QUERY_OFFICIAL_BAR_HISTORY);
        this.a = officialBarHistoryActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        RequestHistoryMessage requestHistoryMessage;
        List list;
        ag agVar;
        List<ba> list2;
        this.a.hideProgressBar();
        this.a.f = false;
        if (socketResponsedMessage == null) {
            this.a.showToast(com.baidu.tieba.u.neterror);
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
                agVar = this.a.b;
                list2 = this.a.e;
                agVar.a(list2);
                if (responseHistoryMessage.getMsg().size() != 0) {
                    new Handler().post(new ac(this));
                }
            }
        } else {
            this.a.showToast(com.baidu.tieba.u.neterror);
        }
    }
}
