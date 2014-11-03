package com.baidu.tieba.addresslist;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbadkApplication;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends CustomMessageListener {
    final /* synthetic */ d agQ;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(d dVar) {
        super(2001182);
        this.agQ = dVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tieba.addresslist.c.a aVar;
        BdListView bdListView;
        if (!com.baidu.tbadk.core.sharedPref.b.lk().getBoolean("get_addresslist_switch" + TbadkApplication.getCurrentAccount(), true)) {
            bdListView = this.agQ.agL;
            bdListView.hN();
        }
        if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
            aVar = this.agQ.agC;
            aVar.w((List) customResponsedMessage.getData());
        }
    }
}
