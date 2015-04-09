package com.baidu.tieba.addresslist;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.addresslist.relationship.ResponseGetAddressListMessage;
import com.baidu.tieba.y;
import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ AddressListActivity axz;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(AddressListActivity addressListActivity) {
        super(304001);
        this.axz = addressListActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        BdListView bdListView;
        com.baidu.tieba.addresslist.c.a aVar;
        if (socketResponsedMessage != null && socketResponsedMessage.getCmd() == 304001) {
            bdListView = this.axz.axu;
            bdListView.mW();
            if (socketResponsedMessage.hasError() || !(socketResponsedMessage instanceof ResponseGetAddressListMessage)) {
                this.axz.showToast(StringUtils.isNull(socketResponsedMessage.getErrorString()) ? this.axz.getResources().getString(y.neterror) : socketResponsedMessage.getErrorString(), false);
                return;
            }
            com.baidu.tieba.addresslist.relationship.a addressListData = ((ResponseGetAddressListMessage) socketResponsedMessage).getAddressListData();
            ArrayList arrayList = new ArrayList();
            if (addressListData != null) {
                for (com.baidu.tieba.addresslist.relationship.f fVar : addressListData.getAddressList()) {
                    List<com.baidu.tbadk.coreExtra.relationship.a> contacts = fVar.getContacts();
                    if (contacts.size() > 0) {
                        com.baidu.tbadk.coreExtra.relationship.a aVar2 = new com.baidu.tbadk.coreExtra.relationship.a();
                        aVar2.dJ(fVar.getKey());
                        arrayList.add(aVar2);
                    }
                    for (com.baidu.tbadk.coreExtra.relationship.a aVar3 : contacts) {
                        arrayList.add(aVar3);
                    }
                }
            }
            aVar = this.axz.axl;
            aVar.z(arrayList);
        }
    }
}
