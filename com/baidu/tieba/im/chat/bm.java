package com.baidu.tieba.im.chat;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tieba.im.chat.MsgAdapterScanMessage;
import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bm extends CustomMessageListener {
    final /* synthetic */ bl cUc;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bm(bl blVar, int i) {
        super(i);
        this.cUc = blVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        List list;
        BdTypeListView bdTypeListView;
        List list2;
        if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
            MsgAdapterScanMessage.a aVar = (MsgAdapterScanMessage.a) customResponsedMessage.getData();
            if (aVar.cTq != null && aVar.context != null) {
                list = this.cUc.bOr;
                list.addAll(aVar.cTq);
                bdTypeListView = this.cUc.bBT;
                list2 = this.cUc.bOr;
                bdTypeListView.g(new ArrayList(list2));
            }
        }
    }
}
