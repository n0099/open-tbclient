package com.baidu.tieba.im.chat.officialBar;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad extends CustomMessageListener {
    final /* synthetic */ OfficialBarHistoryActivity aZf;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ad(OfficialBarHistoryActivity officialBarHistoryActivity) {
        super(2001156);
        this.aZf = officialBarHistoryActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        List list;
        ag agVar;
        List<au> list2;
        List list3;
        this.aZf.hideProgressBar();
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001156 && (customResponsedMessage instanceof ResponseLocalHistoryMessage)) {
            ResponseLocalHistoryMessage responseLocalHistoryMessage = (ResponseLocalHistoryMessage) customResponsedMessage;
            if (!responseLocalHistoryMessage.getData().isEmpty()) {
                list = this.aZf.aEB;
                if (list != null) {
                    list3 = this.aZf.aEB;
                    if (!list3.isEmpty()) {
                        return;
                    }
                }
                this.aZf.aEB = responseLocalHistoryMessage.getData();
                agVar = this.aZf.aZb;
                list2 = this.aZf.aEB;
                agVar.setData(list2);
            }
        }
    }
}
