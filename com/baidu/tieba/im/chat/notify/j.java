package com.baidu.tieba.im.chat.notify;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j extends CustomMessageListener {
    final /* synthetic */ e a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(e eVar, int i) {
        super(i);
        this.a = eVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        n nVar;
        n nVar2;
        n nVar3;
        n nVar4;
        com.baidu.tieba.im.model.p pVar;
        a aVar;
        if (customResponsedMessage != null) {
            if (customResponsedMessage.getCmd() != 2016001) {
                if (customResponsedMessage.getCmd() != 2016003) {
                    if (customResponsedMessage.getCmd() != 2016006) {
                        if (customResponsedMessage.getCmd() == 2016000) {
                            pVar = this.a.c;
                            aVar = this.a.u;
                            pVar.a((List<ImMessageCenterPojo>) null, aVar);
                            return;
                        } else if (customResponsedMessage.getCmd() == 2016010) {
                            nVar3 = this.a.g;
                            if (nVar3 != null) {
                                nVar4 = this.a.g;
                                nVar4.notifyDataSetChanged();
                                return;
                            }
                            return;
                        } else if (customResponsedMessage.getCmd() == 2016011) {
                            nVar = this.a.g;
                            if (nVar != null) {
                                nVar2 = this.a.g;
                                nVar2.notifyDataSetChanged();
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
