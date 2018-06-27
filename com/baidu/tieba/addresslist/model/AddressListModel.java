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
    private a bps;

    public AddressListModel(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
        this.bps = a.Ri();
    }

    public void a(a.InterfaceC0132a interfaceC0132a) {
        this.bps.a(interfaceC0132a);
    }

    public void b(a.InterfaceC0132a interfaceC0132a) {
        this.bps.b(interfaceC0132a);
    }

    public List<com.baidu.tbadk.coreExtra.relationship.a> Rz() {
        return this.bps.Rj();
    }

    public void RA() {
        sendMessage(new CustomMessage(2001178));
    }

    public void Rv() {
        super.sendMessage(new RequestGetAddressListMessage(304001));
    }

    public void aa(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.bps.X(list);
    }

    public void a(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        this.bps.a(aVar);
    }

    public void aE(long j) {
        this.bps.aE(j);
    }

    public int iZ(String str) {
        int i;
        if (c.fZ(str)) {
            List<com.baidu.tbadk.coreExtra.relationship.a> Rj = this.bps.Rj();
            if (Rj != null) {
                for (com.baidu.tbadk.coreExtra.relationship.a aVar : Rj) {
                    if (str.equals(aVar.Fz())) {
                        i = Rj.indexOf(aVar);
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
