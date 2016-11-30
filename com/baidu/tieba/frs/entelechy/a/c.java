package com.baidu.tieba.frs.entelechy.a;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tieba.tbadkCore.p;
import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends CustomMessageListener {
    final /* synthetic */ a bZc;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(a aVar, int i) {
        super(i);
        this.bZc = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        List list;
        ArrayList<v> arrayList;
        p pVar;
        if (customResponsedMessage != null) {
            list = this.bZc.bYT;
            if (!com.baidu.tbadk.core.util.x.t(list)) {
                return;
            }
            this.bZc.aex();
            a aVar = this.bZc;
            arrayList = this.bZc.bHW;
            pVar = this.bZc.bYX;
            aVar.b(arrayList, pVar);
        }
    }
}
