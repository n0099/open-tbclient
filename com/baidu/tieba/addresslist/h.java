package com.baidu.tieba.addresslist;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends CustomMessageListener {
    final /* synthetic */ e azl;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(e eVar) {
        super(2001182);
        this.azl = eVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tieba.addresslist.c.a aVar;
        BdListView bdListView;
        if (!com.baidu.tbadk.core.sharedPref.b.sl().getBoolean("get_addresslist_switch" + TbadkCoreApplication.getCurrentAccount(), true)) {
            bdListView = this.azl.azf;
            bdListView.completePullRefresh();
        }
        if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
            aVar = this.azl.ayX;
            aVar.A((List) customResponsedMessage.getData());
        }
    }
}
