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
    final /* synthetic */ bk bLN;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bl(bk bkVar, int i) {
        super(i);
        this.bLN = bkVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        List list;
        BdTypeListView bdTypeListView;
        List list2;
        if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
            MsgAdapterScanMessage.a aVar = (MsgAdapterScanMessage.a) customResponsedMessage.getData();
            if (aVar.bLa != null && aVar.context != null) {
                list = this.bLN.aVK;
                list.addAll(aVar.bLa);
                bdTypeListView = this.bLN.aVi;
                list2 = this.bLN.aVK;
                bdTypeListView.g(new ArrayList(list2));
            }
        }
    }
}
