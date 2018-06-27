package com.baidu.tieba.addresslist;

import com.baidu.adp.framework.a.j;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.addresslist.relationship.ResponseGetAddressListMessage;
import com.baidu.tieba.addresslist.relationship.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class b extends j {
    private boolean bnM;

    public b() {
        super(304001);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.a.g
    /* renamed from: d */
    public SocketResponsedMessage a(SocketResponsedMessage socketResponsedMessage) {
        if (socketResponsedMessage != null && socketResponsedMessage.getCmd() == 304001 && !socketResponsedMessage.hasError() && (socketResponsedMessage instanceof ResponseGetAddressListMessage)) {
            com.baidu.tieba.addresslist.relationship.a addressListData = ((ResponseGetAddressListMessage) socketResponsedMessage).getAddressListData();
            this.bnM = TbadkCoreApplication.getInst().appResponseToCmd(2002006);
            if (addressListData != null) {
                for (e eVar : addressListData.getAddressList()) {
                    List<com.baidu.tbadk.coreExtra.relationship.a> contacts = eVar.getContacts();
                    ArrayList arrayList = new ArrayList();
                    for (com.baidu.tbadk.coreExtra.relationship.a aVar : contacts) {
                        if (!this.bnM && aVar.getUserType() == 1) {
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
