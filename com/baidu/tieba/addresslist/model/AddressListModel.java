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
    private a bVM;

    public AddressListModel(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
        this.bVM = a.UM();
    }

    public void a(a.InterfaceC0127a interfaceC0127a) {
        this.bVM.a(interfaceC0127a);
    }

    public void b(a.InterfaceC0127a interfaceC0127a) {
        this.bVM.b(interfaceC0127a);
    }

    public List<com.baidu.tbadk.coreExtra.relationship.a> Ve() {
        return this.bVM.UN();
    }

    public void Vf() {
        sendMessage(new CustomMessage(2001178));
    }

    public void Va() {
        super.sendMessage(new RequestGetAddressListMessage(304001));
    }

    public void af(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.bVM.ac(list);
    }

    public void a(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        this.bVM.a(aVar);
    }

    public void aI(long j) {
        this.bVM.aI(j);
    }

    public int iv(String str) {
        int i;
        if (c.fF(str)) {
            List<com.baidu.tbadk.coreExtra.relationship.a> UN = this.bVM.UN();
            if (UN != null) {
                for (com.baidu.tbadk.coreExtra.relationship.a aVar : UN) {
                    if (str.equals(aVar.IU())) {
                        i = UN.indexOf(aVar);
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
