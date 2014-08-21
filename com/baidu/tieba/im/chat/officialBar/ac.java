package com.baidu.tieba.im.chat.officialBar;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac extends CustomMessageListener {
    final /* synthetic */ OfficialBarHistoryActivity a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ac(OfficialBarHistoryActivity officialBarHistoryActivity) {
        super(2001156);
        this.a = officialBarHistoryActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        List list;
        af afVar;
        List<bb> list2;
        List list3;
        this.a.hideProgressBar();
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001156 && (customResponsedMessage instanceof ResponseLocalHistoryMessage)) {
            ResponseLocalHistoryMessage responseLocalHistoryMessage = (ResponseLocalHistoryMessage) customResponsedMessage;
            if (!responseLocalHistoryMessage.getData().isEmpty()) {
                list = this.a.e;
                if (list != null) {
                    list3 = this.a.e;
                    if (!list3.isEmpty()) {
                        return;
                    }
                }
                this.a.e = responseLocalHistoryMessage.getData();
                afVar = this.a.b;
                list2 = this.a.e;
                afVar.a(list2);
            }
        }
    }
}
