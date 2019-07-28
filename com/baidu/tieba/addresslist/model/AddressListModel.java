package com.baidu.tieba.addresslist.model;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.coreExtra.relationship.c;
import com.baidu.tieba.addresslist.b.a;
import com.baidu.tieba.addresslist.relationship.RequestGetAddressListMessage;
import java.util.List;
/* loaded from: classes3.dex */
public class AddressListModel extends BdBaseModel<BaseFragmentActivity> {
    private a cZI;

    public AddressListModel(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
        this.cZI = a.aDn();
    }

    public void a(a.InterfaceC0273a interfaceC0273a) {
        this.cZI.a(interfaceC0273a);
    }

    public void b(a.InterfaceC0273a interfaceC0273a) {
        this.cZI.b(interfaceC0273a);
    }

    public List<com.baidu.tbadk.coreExtra.relationship.a> aDF() {
        return this.cZI.aDo();
    }

    public void aDG() {
        sendMessage(new CustomMessage(2001178));
    }

    public void aDB() {
        super.sendMessage(new RequestGetAddressListMessage(304001));
    }

    public void aD(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.cZI.aA(list);
    }

    public void a(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        this.cZI.a(aVar);
    }

    public void bP(long j) {
        this.cZI.bP(j);
    }

    public int sI(String str) {
        int i;
        if (c.pC(str)) {
            List<com.baidu.tbadk.coreExtra.relationship.a> aDo = this.cZI.aDo();
            if (aDo != null) {
                for (com.baidu.tbadk.coreExtra.relationship.a aVar : aDo) {
                    if (str.equals(aVar.apT())) {
                        i = aDo.indexOf(aVar);
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
