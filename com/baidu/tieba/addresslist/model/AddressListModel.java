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
    private a bqb;

    public AddressListModel(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
        this.bqb = a.Ru();
    }

    public void a(a.InterfaceC0130a interfaceC0130a) {
        this.bqb.a(interfaceC0130a);
    }

    public void b(a.InterfaceC0130a interfaceC0130a) {
        this.bqb.b(interfaceC0130a);
    }

    public List<com.baidu.tbadk.coreExtra.relationship.a> RL() {
        return this.bqb.Rv();
    }

    public void RM() {
        sendMessage(new CustomMessage(2001178));
    }

    public void RH() {
        super.sendMessage(new RequestGetAddressListMessage(304001));
    }

    public void Z(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.bqb.W(list);
    }

    public void a(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        this.bqb.a(aVar);
    }

    public void aH(long j) {
        this.bqb.aH(j);
    }

    public int iX(String str) {
        int i;
        if (c.fX(str)) {
            List<com.baidu.tbadk.coreExtra.relationship.a> Rv = this.bqb.Rv();
            if (Rv != null) {
                for (com.baidu.tbadk.coreExtra.relationship.a aVar : Rv) {
                    if (str.equals(aVar.Fv())) {
                        i = Rv.indexOf(aVar);
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
