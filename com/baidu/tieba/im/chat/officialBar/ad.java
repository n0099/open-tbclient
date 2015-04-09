package com.baidu.tieba.im.chat.officialBar;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad extends CustomMessageListener {
    final /* synthetic */ OfficialBarHistoryActivity aZv;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ad(OfficialBarHistoryActivity officialBarHistoryActivity) {
        super(2001156);
        this.aZv = officialBarHistoryActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        List list;
        ag agVar;
        List<au> list2;
        List list3;
        this.aZv.hideProgressBar();
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001156 && (customResponsedMessage instanceof ResponseLocalHistoryMessage)) {
            ResponseLocalHistoryMessage responseLocalHistoryMessage = (ResponseLocalHistoryMessage) customResponsedMessage;
            if (!responseLocalHistoryMessage.getData().isEmpty()) {
                list = this.aZv.aEJ;
                if (list != null) {
                    list3 = this.aZv.aEJ;
                    if (!list3.isEmpty()) {
                        return;
                    }
                }
                this.aZv.aEJ = responseLocalHistoryMessage.getData();
                agVar = this.aZv.aZr;
                list2 = this.aZv.aEJ;
                agVar.setData(list2);
            }
        }
    }
}
