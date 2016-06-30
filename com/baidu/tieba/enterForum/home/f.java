package com.baidu.tieba.enterForum.home;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.enterForum.home.e;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends CustomMessageListener {
    final /* synthetic */ e btd;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(e eVar, int i) {
        super(i);
        this.btd = eVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tieba.enterForum.d.b SF;
        e.a aVar;
        e.a aVar2;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016461 && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.enterForum.d.a) && (SF = ((com.baidu.tieba.enterForum.d.a) customResponsedMessage.getData()).SF()) != null) {
            this.btd.bsV = SF.SG();
            if (this.btd.bsV != null && this.btd.bsV.bui != null) {
                this.btd.bsV.bui.g(this.btd);
                aVar = this.btd.bta;
                if (aVar != null) {
                    aVar2 = this.btd.bta;
                    aVar2.notifyDataSetChanged();
                }
            }
        }
    }
}
