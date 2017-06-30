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
    final /* synthetic */ bk cXY;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bl(bk bkVar, int i) {
        super(i);
        this.cXY = bkVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        List list;
        BdTypeListView bdTypeListView;
        List list2;
        if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
            MsgAdapterScanMessage.a aVar = (MsgAdapterScanMessage.a) customResponsedMessage.getData();
            if (aVar.cXm != null && aVar.context != null) {
                list = this.cXY.mAdapters;
                list.addAll(aVar.cXm);
                bdTypeListView = this.cXY.mListView;
                list2 = this.cXY.mAdapters;
                bdTypeListView.addAdapters(new ArrayList(list2));
            }
        }
    }
}
