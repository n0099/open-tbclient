package com.baidu.tieba.frs.entelechy.a;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tieba.frs.AbsDelegateAdapterList;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.au;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends CustomMessageListener {
    final /* synthetic */ b bEQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(b bVar, int i) {
        super(i);
        this.bEQ = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        List list;
        BdTypeListView bdTypeListView;
        List list2;
        BdTypeListView bdTypeListView2;
        List list3;
        FrsActivity frsActivity;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2003008 && (customResponsedMessage.getData() instanceof AbsDelegateAdapterList)) {
            AbsDelegateAdapterList absDelegateAdapterList = (AbsDelegateAdapterList) customResponsedMessage.getData();
            Iterator it = absDelegateAdapterList.iterator();
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.a aVar = (com.baidu.adp.widget.ListView.a) it.next();
                if (aVar instanceof au) {
                    frsActivity = this.bEQ.bzH;
                    ((au) aVar).e(frsActivity);
                }
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(absDelegateAdapterList);
            this.bEQ.ap(arrayList);
            list = this.bEQ.bbV;
            if (list != null) {
                list3 = this.bEQ.bbV;
                list3.addAll(absDelegateAdapterList);
            }
            bdTypeListView = this.bEQ.aMc;
            if (bdTypeListView != null) {
                list2 = this.bEQ.bbV;
                list2.addAll(arrayList);
                bdTypeListView2 = this.bEQ.aMc;
                bdTypeListView2.g(arrayList);
            }
        }
    }
}
