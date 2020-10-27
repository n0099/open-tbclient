package com.baidu.tieba.addresslist.model;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.coreExtra.relationship.c;
import com.baidu.tieba.addresslist.b.a;
import com.baidu.tieba.addresslist.relationship.RequestGetAddressListMessage;
import java.util.List;
/* loaded from: classes21.dex */
public class AddressListModel extends BdBaseModel<BaseFragmentActivity> {
    private a fPl;

    public AddressListModel(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
        this.fPl = a.bHp();
    }

    public void a(a.InterfaceC0598a interfaceC0598a) {
        this.fPl.a(interfaceC0598a);
    }

    public void b(a.InterfaceC0598a interfaceC0598a) {
        this.fPl.b(interfaceC0598a);
    }

    public List<com.baidu.tbadk.coreExtra.relationship.a> bHI() {
        return this.fPl.bHq();
    }

    public void bHJ() {
        sendMessage(new CustomMessage(CmdConfigCustom.CMD_QUERY_LOCAL_ADDRESSLIST));
    }

    public void bHF() {
        super.sendMessage(new RequestGetAddressListMessage(CmdConfigSocket.CMD_GET_ADDRESSLIST));
    }

    public void bM(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.fPl.bI(list);
    }

    public void a(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        this.fPl.a(aVar);
    }

    public void dN(long j) {
        this.fPl.dN(j);
    }

    public int Fr(String str) {
        int i;
        if (c.CM(str)) {
            List<com.baidu.tbadk.coreExtra.relationship.a> bHq = this.fPl.bHq();
            if (bHq != null) {
                for (com.baidu.tbadk.coreExtra.relationship.a aVar : bHq) {
                    if (str.equals(aVar.buR())) {
                        i = bHq.indexOf(aVar);
                        break;
                    }
                }
            }
            i = -1;
            return i;
        }
        return -1;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }
}
