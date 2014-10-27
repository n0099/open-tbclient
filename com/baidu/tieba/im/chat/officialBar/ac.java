package com.baidu.tieba.im.chat.officialBar;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac extends CustomMessageListener {
    final /* synthetic */ OfficialBarHistoryActivity aRm;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ac(OfficialBarHistoryActivity officialBarHistoryActivity) {
        super(2001156);
        this.aRm = officialBarHistoryActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        List list;
        af afVar;
        List<az> list2;
        List list3;
        this.aRm.hideProgressBar();
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001156 && (customResponsedMessage instanceof ResponseLocalHistoryMessage)) {
            ResponseLocalHistoryMessage responseLocalHistoryMessage = (ResponseLocalHistoryMessage) customResponsedMessage;
            if (!responseLocalHistoryMessage.getData().isEmpty()) {
                list = this.aRm.aRk;
                if (list != null) {
                    list3 = this.aRm.aRk;
                    if (!list3.isEmpty()) {
                        return;
                    }
                }
                this.aRm.aRk = responseLocalHistoryMessage.getData();
                afVar = this.aRm.aRh;
                list2 = this.aRm.aRk;
                afVar.setData(list2);
            }
        }
    }
}
