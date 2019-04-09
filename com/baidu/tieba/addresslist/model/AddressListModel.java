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
    private a cPZ;

    public AddressListModel(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
        this.cPZ = a.awP();
    }

    public void a(a.InterfaceC0256a interfaceC0256a) {
        this.cPZ.a(interfaceC0256a);
    }

    public void b(a.InterfaceC0256a interfaceC0256a) {
        this.cPZ.b(interfaceC0256a);
    }

    public List<com.baidu.tbadk.coreExtra.relationship.a> axg() {
        return this.cPZ.awQ();
    }

    public void axh() {
        sendMessage(new CustomMessage(2001178));
    }

    public void axc() {
        super.sendMessage(new RequestGetAddressListMessage(304001));
    }

    public void aw(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.cPZ.at(list);
    }

    public void a(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        this.cPZ.a(aVar);
    }

    public void bz(long j) {
        this.cPZ.bz(j);
    }

    public int rh(String str) {
        int i;
        if (c.oc(str)) {
            List<com.baidu.tbadk.coreExtra.relationship.a> awQ = this.cPZ.awQ();
            if (awQ != null) {
                for (com.baidu.tbadk.coreExtra.relationship.a aVar : awQ) {
                    if (str.equals(aVar.ajM())) {
                        i = awQ.indexOf(aVar);
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
