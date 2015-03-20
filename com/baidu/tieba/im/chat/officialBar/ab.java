package com.baidu.tieba.im.chat.officialBar;

import android.os.Handler;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ OfficialBarHistoryActivity aZf;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ab(OfficialBarHistoryActivity officialBarHistoryActivity) {
        super(208002);
        this.aZf = officialBarHistoryActivity;
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
        this.aZf.hideProgressBar();
        this.aZf.aZe = false;
        if (socketResponsedMessage == null) {
            this.aZf.showToast(com.baidu.tieba.y.neterror);
            agVar7 = this.aZf.aZb;
            list8 = this.aZf.aEB;
            agVar7.av(list8);
        } else if (socketResponsedMessage.getError() != 0) {
            this.aZf.showToast(socketResponsedMessage.getErrorString());
            agVar6 = this.aZf.aZb;
            list7 = this.aZf.aEB;
            agVar6.av(list7);
        } else if (socketResponsedMessage.getCmd() != 208002 || !(socketResponsedMessage instanceof ResponseHistoryMessage)) {
            agVar = this.aZf.aZb;
            list = this.aZf.aEB;
            agVar.av(list);
            this.aZf.showToast(com.baidu.tieba.y.neterror);
        } else {
            ResponseHistoryMessage responseHistoryMessage = (ResponseHistoryMessage) socketResponsedMessage;
            if (responseHistoryMessage.getMsg().isEmpty()) {
                agVar5 = this.aZf.aZb;
                list6 = this.aZf.aEB;
                agVar5.av(list6);
                return;
            }
            RequestHistoryMessage requestHistoryMessage = (RequestHistoryMessage) responseHistoryMessage.getOrginalMessage();
            if (requestHistoryMessage == null) {
                agVar4 = this.aZf.aZb;
                list5 = this.aZf.aEB;
                agVar4.av(list5);
                return;
            }
            if (requestHistoryMessage.getRequestId() != 0) {
                list2 = this.aZf.aEB;
                list2.addAll(responseHistoryMessage.getMsg());
            } else {
                this.aZf.aEB = responseHistoryMessage.getMsg();
            }
            agVar2 = this.aZf.aZb;
            list3 = this.aZf.aEB;
            agVar2.setData(list3);
            if (responseHistoryMessage.getMsg().size() == 0) {
                agVar3 = this.aZf.aZb;
                list4 = this.aZf.aEB;
                agVar3.av(list4);
                return;
            }
            new Handler().post(new ac(this));
        }
    }
}
