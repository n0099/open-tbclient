package com.baidu.tieba.frs.entelechy.a;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends CustomMessageListener {
    final /* synthetic */ b bEQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(b bVar, int i) {
        super(i);
        this.bEQ = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        List list;
        ArrayList<com.baidu.adp.widget.ListView.v> arrayList;
        com.baidu.tieba.tbadkCore.o oVar;
        if (customResponsedMessage != null) {
            list = this.bEQ.bEG;
            if (!com.baidu.tbadk.core.util.x.t(list)) {
                return;
            }
            this.bEQ.YR();
            b bVar = this.bEQ;
            arrayList = this.bEQ.bnZ;
            oVar = this.bEQ.bEL;
            bVar.b(arrayList, oVar);
        }
    }
}
