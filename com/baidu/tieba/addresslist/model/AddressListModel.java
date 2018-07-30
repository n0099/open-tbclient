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
    private a bpZ;

    public AddressListModel(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
        this.bpZ = a.Rp();
    }

    public void a(a.InterfaceC0130a interfaceC0130a) {
        this.bpZ.a(interfaceC0130a);
    }

    public void b(a.InterfaceC0130a interfaceC0130a) {
        this.bpZ.b(interfaceC0130a);
    }

    public List<com.baidu.tbadk.coreExtra.relationship.a> RG() {
        return this.bpZ.Rq();
    }

    public void RH() {
        sendMessage(new CustomMessage(2001178));
    }

    public void RC() {
        super.sendMessage(new RequestGetAddressListMessage(304001));
    }

    public void Z(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.bpZ.W(list);
    }

    public void a(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        this.bpZ.a(aVar);
    }

    public void aH(long j) {
        this.bpZ.aH(j);
    }

    public int iW(String str) {
        int i;
        if (c.fX(str)) {
            List<com.baidu.tbadk.coreExtra.relationship.a> Rq = this.bpZ.Rq();
            if (Rq != null) {
                for (com.baidu.tbadk.coreExtra.relationship.a aVar : Rq) {
                    if (str.equals(aVar.Fv())) {
                        i = Rq.indexOf(aVar);
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
