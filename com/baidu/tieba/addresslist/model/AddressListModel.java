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
    private a cPY;

    public AddressListModel(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
        this.cPY = a.awP();
    }

    public void a(a.InterfaceC0256a interfaceC0256a) {
        this.cPY.a(interfaceC0256a);
    }

    public void b(a.InterfaceC0256a interfaceC0256a) {
        this.cPY.b(interfaceC0256a);
    }

    public List<com.baidu.tbadk.coreExtra.relationship.a> axg() {
        return this.cPY.awQ();
    }

    public void axh() {
        sendMessage(new CustomMessage(2001178));
    }

    public void axc() {
        super.sendMessage(new RequestGetAddressListMessage(304001));
    }

    public void aw(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.cPY.at(list);
    }

    public void a(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        this.cPY.a(aVar);
    }

    public void bz(long j) {
        this.cPY.bz(j);
    }

    public int rh(String str) {
        int i;
        if (c.oc(str)) {
            List<com.baidu.tbadk.coreExtra.relationship.a> awQ = this.cPY.awQ();
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
