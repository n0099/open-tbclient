package com.baidu.tieba.addresslist;

import com.baidu.adp.framework.b.j;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.addresslist.relationship.ResponseGetAddressListMessage;
import com.baidu.tieba.addresslist.relationship.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes21.dex */
public class b extends j {
    private boolean gbo;

    public b() {
        super(CmdConfigSocket.CMD_GET_ADDRESSLIST);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.b.g
    /* renamed from: e */
    public SocketResponsedMessage a(SocketResponsedMessage socketResponsedMessage) {
        if (socketResponsedMessage != null && socketResponsedMessage.getCmd() == 304001 && !socketResponsedMessage.hasError() && (socketResponsedMessage instanceof ResponseGetAddressListMessage)) {
            com.baidu.tieba.addresslist.relationship.a addressListData = ((ResponseGetAddressListMessage) socketResponsedMessage).getAddressListData();
            this.gbo = TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.START_OFFICIAL_BAR_CHAT);
            if (addressListData != null) {
                for (e eVar : addressListData.getAddressList()) {
                    List<com.baidu.tbadk.coreExtra.relationship.a> contacts = eVar.getContacts();
                    ArrayList arrayList = new ArrayList();
                    for (com.baidu.tbadk.coreExtra.relationship.a aVar : contacts) {
                        if (!this.gbo && aVar.getUserType() == 1) {
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
