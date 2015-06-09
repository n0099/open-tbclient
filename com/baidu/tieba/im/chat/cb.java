package com.baidu.tieba.im.chat;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdTypeListView;
import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cb extends CustomMessageListener {
    final /* synthetic */ ca baT;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cb(ca caVar, int i) {
        super(i);
        this.baT = caVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        List list;
        BdTypeListView bdTypeListView;
        List list2;
        if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
            bc bcVar = (bc) customResponsedMessage.getData();
            if (bcVar.baf != null && bcVar.context != null) {
                list = this.baT.aMB;
                list.addAll(bcVar.baf);
                bdTypeListView = this.baT.aMm;
                list2 = this.baT.aMB;
                bdTypeListView.h(new ArrayList(list2));
            }
        }
    }
}
