package com.baidu.tieba.im.chat.officialBar;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.MessageTypes;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad extends CustomMessageListener {
    final /* synthetic */ OfficialBarHistoryActivity a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ad(OfficialBarHistoryActivity officialBarHistoryActivity) {
        super(MessageTypes.CMD_QUERY_OFFICIAL_LOCAL_HISTORY);
        this.a = officialBarHistoryActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        List list;
        ag agVar;
        List<ba> list2;
        List list3;
        this.a.hideProgressBar();
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2003156 && (customResponsedMessage instanceof ResponseLocalHistoryMessage)) {
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
                agVar = this.a.b;
                list2 = this.a.e;
                agVar.a(list2);
            }
        }
    }
}
