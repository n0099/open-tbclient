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
    private a cZP;

    public AddressListModel(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
        this.cZP = a.aDp();
    }

    public void a(a.InterfaceC0273a interfaceC0273a) {
        this.cZP.a(interfaceC0273a);
    }

    public void b(a.InterfaceC0273a interfaceC0273a) {
        this.cZP.b(interfaceC0273a);
    }

    public List<com.baidu.tbadk.coreExtra.relationship.a> aDH() {
        return this.cZP.aDq();
    }

    public void aDI() {
        sendMessage(new CustomMessage(2001178));
    }

    public void aDD() {
        super.sendMessage(new RequestGetAddressListMessage(304001));
    }

    public void aD(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.cZP.aA(list);
    }

    public void a(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        this.cZP.a(aVar);
    }

    public void bP(long j) {
        this.cZP.bP(j);
    }

    public int sI(String str) {
        int i;
        if (c.pC(str)) {
            List<com.baidu.tbadk.coreExtra.relationship.a> aDq = this.cZP.aDq();
            if (aDq != null) {
                for (com.baidu.tbadk.coreExtra.relationship.a aVar : aDq) {
                    if (str.equals(aVar.apV())) {
                        i = aDq.indexOf(aVar);
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
