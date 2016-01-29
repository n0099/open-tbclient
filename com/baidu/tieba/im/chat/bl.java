package com.baidu.tieba.im.chat;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tieba.im.chat.MsgAdapterScanMessage;
import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bl extends CustomMessageListener {
    final /* synthetic */ bk bPB;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bl(bk bkVar, int i) {
        super(i);
        this.bPB = bkVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        List list;
        BdTypeListView bdTypeListView;
        List list2;
        if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
            MsgAdapterScanMessage.a aVar = (MsgAdapterScanMessage.a) customResponsedMessage.getData();
            if (aVar.bOO != null && aVar.context != null) {
                list = this.bPB.aXX;
                list.addAll(aVar.bOO);
                bdTypeListView = this.bPB.aXu;
                list2 = this.bPB.aXX;
                bdTypeListView.g(new ArrayList(list2));
            }
        }
    }
}
