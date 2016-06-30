package com.baidu.tieba.frs.entelechy.a;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tieba.frs.AbsDelegateAdapterList;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.bj;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends CustomMessageListener {
    final /* synthetic */ c bJd;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(c cVar, int i) {
        super(i);
        this.bJd = cVar;
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
                if (aVar instanceof bj) {
                    frsActivity = this.bJd.bET;
                    ((bj) aVar).e(frsActivity);
                }
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(absDelegateAdapterList);
            this.bJd.aq(arrayList);
            list = this.bJd.bAz;
            if (list != null) {
                list3 = this.bJd.bAz;
                list3.addAll(absDelegateAdapterList);
            }
            bdTypeListView = this.bJd.bou;
            if (bdTypeListView != null) {
                list2 = this.bJd.bAz;
                list2.addAll(arrayList);
                bdTypeListView2 = this.bJd.bou;
                bdTypeListView2.g(arrayList);
            }
        }
    }
}
