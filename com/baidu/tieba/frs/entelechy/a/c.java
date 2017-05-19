package com.baidu.tieba.frs.entelechy.a;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.frs.AbsDelegateAdapterList;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends CustomMessageListener {
    final /* synthetic */ b bSo;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(b bVar, int i) {
        super(i);
        this.bSo = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        List list;
        BdTypeListView bdTypeListView;
        List list2;
        BdTypeListView bdTypeListView2;
        List list3;
        com.baidu.tieba.frs.r rVar;
        com.baidu.tieba.frs.r rVar2;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2003008 && (customResponsedMessage.getData() instanceof AbsDelegateAdapterList)) {
            AbsDelegateAdapterList absDelegateAdapterList = (AbsDelegateAdapterList) customResponsedMessage.getData();
            Iterator it = absDelegateAdapterList.iterator();
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.a aVar = (com.baidu.adp.widget.ListView.a) it.next();
                if (aVar instanceof com.baidu.tieba.frs.p) {
                    rVar = this.bSo.bPw;
                    TbPageContext<BaseFragmentActivity> pageContext = rVar.getPageContext();
                    rVar2 = this.bSo.bPw;
                    ((com.baidu.tieba.frs.p) aVar).a(pageContext, rVar2.getUniqueId());
                }
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(absDelegateAdapterList);
            this.bSo.an(arrayList);
            list = this.bSo.mAdapters;
            if (list != null) {
                list3 = this.bSo.mAdapters;
                list3.addAll(absDelegateAdapterList);
            }
            bdTypeListView = this.bSo.mListView;
            if (bdTypeListView != null) {
                list2 = this.bSo.mAdapters;
                list2.addAll(arrayList);
                bdTypeListView2 = this.bSo.mListView;
                bdTypeListView2.addAdapters(arrayList);
            }
        }
    }
}
