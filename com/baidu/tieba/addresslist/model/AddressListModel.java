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
    private a bVA;

    public AddressListModel(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
        this.bVA = a.UL();
    }

    public void a(a.InterfaceC0128a interfaceC0128a) {
        this.bVA.a(interfaceC0128a);
    }

    public void b(a.InterfaceC0128a interfaceC0128a) {
        this.bVA.b(interfaceC0128a);
    }

    public List<com.baidu.tbadk.coreExtra.relationship.a> Vd() {
        return this.bVA.UM();
    }

    public void Ve() {
        sendMessage(new CustomMessage(2001178));
    }

    public void UZ() {
        super.sendMessage(new RequestGetAddressListMessage(304001));
    }

    public void af(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.bVA.ac(list);
    }

    public void a(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        this.bVA.a(aVar);
    }

    public void aI(long j) {
        this.bVA.aI(j);
    }

    public int iv(String str) {
        int i;
        if (c.fF(str)) {
            List<com.baidu.tbadk.coreExtra.relationship.a> UM = this.bVA.UM();
            if (UM != null) {
                for (com.baidu.tbadk.coreExtra.relationship.a aVar : UM) {
                    if (str.equals(aVar.IT())) {
                        i = UM.indexOf(aVar);
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
