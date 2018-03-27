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
    private a bVD;

    public AddressListModel(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
        this.bVD = a.UM();
    }

    public void a(a.InterfaceC0128a interfaceC0128a) {
        this.bVD.a(interfaceC0128a);
    }

    public void b(a.InterfaceC0128a interfaceC0128a) {
        this.bVD.b(interfaceC0128a);
    }

    public List<com.baidu.tbadk.coreExtra.relationship.a> Ve() {
        return this.bVD.UN();
    }

    public void Vf() {
        sendMessage(new CustomMessage(2001178));
    }

    public void Va() {
        super.sendMessage(new RequestGetAddressListMessage(304001));
    }

    public void af(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.bVD.ac(list);
    }

    public void a(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        this.bVD.a(aVar);
    }

    public void aI(long j) {
        this.bVD.aI(j);
    }

    public int iv(String str) {
        int i;
        if (c.fF(str)) {
            List<com.baidu.tbadk.coreExtra.relationship.a> UN = this.bVD.UN();
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
