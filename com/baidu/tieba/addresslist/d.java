package com.baidu.tieba.addresslist;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends CustomMessageListener {
    final /* synthetic */ AddressListActivity axz;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(AddressListActivity addressListActivity) {
        super(2001182);
        this.axz = addressListActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tieba.addresslist.c.a aVar;
        BdListView bdListView;
        if (!com.baidu.tbadk.core.sharedPref.b.rB().getBoolean("get_addresslist_switch" + TbadkCoreApplication.getCurrentAccount(), true)) {
            bdListView = this.axz.axu;
            bdListView.mW();
        }
        if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
            aVar = this.axz.axl;
            aVar.z((List) customResponsedMessage.getData());
        }
    }
}
