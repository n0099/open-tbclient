package com.baidu.tieba.im.chat.officialBar;

import android.os.Handler;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ OfficialBarHistoryActivity aZv;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ab(OfficialBarHistoryActivity officialBarHistoryActivity) {
        super(208002);
        this.aZv = officialBarHistoryActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        ag agVar;
        List<au> list;
        List list2;
        ag agVar2;
        List<au> list3;
        ag agVar3;
        List<au> list4;
        ag agVar4;
        List<au> list5;
        ag agVar5;
        List<au> list6;
        ag agVar6;
        List<au> list7;
        ag agVar7;
        List<au> list8;
        this.aZv.hideProgressBar();
        this.aZv.aZu = false;
        if (socketResponsedMessage == null) {
            this.aZv.showToast(com.baidu.tieba.y.neterror);
            agVar7 = this.aZv.aZr;
            list8 = this.aZv.aEJ;
            agVar7.ax(list8);
        } else if (socketResponsedMessage.getError() != 0) {
            this.aZv.showToast(socketResponsedMessage.getErrorString());
            agVar6 = this.aZv.aZr;
            list7 = this.aZv.aEJ;
            agVar6.ax(list7);
        } else if (socketResponsedMessage.getCmd() != 208002 || !(socketResponsedMessage instanceof ResponseHistoryMessage)) {
            agVar = this.aZv.aZr;
            list = this.aZv.aEJ;
            agVar.ax(list);
            this.aZv.showToast(com.baidu.tieba.y.neterror);
        } else {
            ResponseHistoryMessage responseHistoryMessage = (ResponseHistoryMessage) socketResponsedMessage;
            if (responseHistoryMessage.getMsg().isEmpty()) {
                agVar5 = this.aZv.aZr;
                list6 = this.aZv.aEJ;
                agVar5.ax(list6);
                return;
            }
            RequestHistoryMessage requestHistoryMessage = (RequestHistoryMessage) responseHistoryMessage.getOrginalMessage();
            if (requestHistoryMessage == null) {
                agVar4 = this.aZv.aZr;
                list5 = this.aZv.aEJ;
                agVar4.ax(list5);
                return;
            }
            if (requestHistoryMessage.getRequestId() != 0) {
                list2 = this.aZv.aEJ;
                list2.addAll(responseHistoryMessage.getMsg());
            } else {
                this.aZv.aEJ = responseHistoryMessage.getMsg();
            }
            agVar2 = this.aZv.aZr;
            list3 = this.aZv.aEJ;
            agVar2.setData(list3);
            if (responseHistoryMessage.getMsg().size() == 0) {
                agVar3 = this.aZv.aZr;
                list4 = this.aZv.aEJ;
                agVar3.ax(list4);
                return;
            }
            new Handler().post(new ac(this));
        }
    }
}
