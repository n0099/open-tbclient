package com.baidu.tieba.im.chat;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdTypeListView;
import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cb extends CustomMessageListener {
    final /* synthetic */ ca aXV;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cb(ca caVar, int i) {
        super(i);
        this.aXV = caVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        List list;
        BdTypeListView bdTypeListView;
        List list2;
        if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
            bc bcVar = (bc) customResponsedMessage.getData();
            if (bcVar.aXi != null && bcVar.context != null) {
                list = this.aXV.aKj;
                list.addAll(bcVar.aXi);
                bdTypeListView = this.aXV.aJU;
                list2 = this.aXV.aKj;
                bdTypeListView.g(new ArrayList(list2));
            }
        }
    }
}
