package com.baidu.tieba.im.chat.officialBar;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac extends CustomMessageListener {
    final /* synthetic */ OfficialBarHistoryActivity aRA;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ac(OfficialBarHistoryActivity officialBarHistoryActivity) {
        super(2001156);
        this.aRA = officialBarHistoryActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        List list;
        af afVar;
        List<az> list2;
        List list3;
        this.aRA.hideProgressBar();
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001156 && (customResponsedMessage instanceof ResponseLocalHistoryMessage)) {
            ResponseLocalHistoryMessage responseLocalHistoryMessage = (ResponseLocalHistoryMessage) customResponsedMessage;
            if (!responseLocalHistoryMessage.getData().isEmpty()) {
                list = this.aRA.aRy;
                if (list != null) {
                    list3 = this.aRA.aRy;
                    if (!list3.isEmpty()) {
                        return;
                    }
                }
                this.aRA.aRy = responseLocalHistoryMessage.getData();
                afVar = this.aRA.aRv;
                list2 = this.aRA.aRy;
                afVar.setData(list2);
            }
        }
    }
}
