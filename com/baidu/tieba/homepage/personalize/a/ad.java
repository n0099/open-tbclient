package com.baidu.tieba.homepage.personalize.a;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad extends CustomMessageListener {
    final /* synthetic */ ac cGG;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ad(ac acVar, int i) {
        super(i);
        this.cGG = acVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        List list;
        List<com.baidu.adp.widget.ListView.v> list2;
        if (customResponsedMessage == null) {
            return;
        }
        this.cGG.acW();
        list = this.cGG.cGr;
        if (list != null) {
            ac acVar = this.cGG;
            list2 = this.cGG.cGr;
            acVar.bv(list2);
        }
    }
}
