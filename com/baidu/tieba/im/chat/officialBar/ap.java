package com.baidu.tieba.im.chat.officialBar;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.List;
/* loaded from: classes.dex */
class ap extends CustomMessageListener {
    final /* synthetic */ OfficialBarTipActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ap(OfficialBarTipActivity officialBarTipActivity, int i) {
        super(i);
        this.a = officialBarTipActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        aw awVar;
        aw awVar2;
        aw awVar3;
        com.baidu.tieba.im.model.ar arVar;
        com.baidu.tieba.im.chat.notify.a aVar;
        if (customResponsedMessage != null) {
            if (customResponsedMessage.getCmd() != 2016001) {
                if (customResponsedMessage.getCmd() != 2016003) {
                    if (customResponsedMessage.getCmd() != 2016006) {
                        if (customResponsedMessage.getCmd() == 2016000) {
                            arVar = this.a.b;
                            aVar = this.a.e;
                            arVar.a((List<ImMessageCenterPojo>) null, aVar);
                            return;
                        } else if (customResponsedMessage.getCmd() == 2016011) {
                            awVar = this.a.c;
                            if (awVar != null) {
                                awVar2 = this.a.c;
                                if (awVar2.b() != null) {
                                    awVar3 = this.a.c;
                                    awVar3.b().notifyDataSetChanged();
                                    return;
                                }
                                return;
                            }
                            return;
                        } else {
                            return;
                        }
                    }
                    this.a.c(customResponsedMessage);
                    return;
                }
                this.a.b(customResponsedMessage);
                return;
            }
            this.a.a(customResponsedMessage);
        }
    }
}
