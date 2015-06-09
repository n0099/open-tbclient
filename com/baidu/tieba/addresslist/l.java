package com.baidu.tieba.addresslist;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.addresslist.relationship.ResponseGetAddressListMessage;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class l extends com.baidu.adp.framework.a.j {
    private boolean azn;

    public l() {
        super(304001);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.a.g
    /* renamed from: d */
    public SocketResponsedMessage a(SocketResponsedMessage socketResponsedMessage) {
        if (socketResponsedMessage != null && socketResponsedMessage.getCmd() == 304001 && !socketResponsedMessage.hasError() && (socketResponsedMessage instanceof ResponseGetAddressListMessage)) {
            com.baidu.tieba.addresslist.relationship.a addressListData = ((ResponseGetAddressListMessage) socketResponsedMessage).getAddressListData();
            this.azn = TbadkCoreApplication.m411getInst().appResponseToCmd(2002006);
            if (addressListData != null) {
                for (com.baidu.tieba.addresslist.relationship.f fVar : addressListData.getAddressList()) {
                    List<com.baidu.tbadk.coreExtra.relationship.a> contacts = fVar.getContacts();
                    ArrayList arrayList = new ArrayList();
                    for (com.baidu.tbadk.coreExtra.relationship.a aVar : contacts) {
                        if (!this.azn && aVar.getUserType() == 1) {
                            arrayList.add(aVar);
                        }
                    }
                    contacts.removeAll(arrayList);
                }
            }
        }
        return socketResponsedMessage;
    }
}
