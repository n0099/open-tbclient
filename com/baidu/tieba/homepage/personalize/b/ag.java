package com.baidu.tieba.homepage.personalize.b;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag extends CustomMessageListener {
    final /* synthetic */ af cKF;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ag(af afVar, int i) {
        super(i);
        this.cKF = afVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        List list;
        List<com.baidu.adp.widget.ListView.v> list2;
        if (customResponsedMessage == null) {
            return;
        }
        this.cKF.afv();
        list = this.cKF.cKp;
        if (list != null) {
            af afVar = this.cKF;
            list2 = this.cKF.cKp;
            afVar.bg(list2);
        }
    }
}
