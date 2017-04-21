package com.baidu.tieba.frs.entelechy.a;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.tbadkCore.n;
import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends CustomMessageListener {
    final /* synthetic */ b bUu;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(b bVar, int i) {
        super(i);
        this.bUu = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        List list;
        ArrayList<com.baidu.adp.widget.ListView.v> arrayList;
        n nVar;
        if (customResponsedMessage != null) {
            list = this.bUu.bUk;
            if (!com.baidu.tbadk.core.util.x.q(list)) {
                return;
            }
            this.bUu.acp();
            b bVar = this.bUu;
            arrayList = this.bUu.bFc;
            nVar = this.bUu.bUp;
            bVar.b(arrayList, nVar);
        }
    }
}
