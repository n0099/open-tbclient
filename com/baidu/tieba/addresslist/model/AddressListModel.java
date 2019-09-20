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
    private a dbB;

    public AddressListModel(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
        this.dbB = a.aDT();
    }

    public void a(a.InterfaceC0282a interfaceC0282a) {
        this.dbB.a(interfaceC0282a);
    }

    public void b(a.InterfaceC0282a interfaceC0282a) {
        this.dbB.b(interfaceC0282a);
    }

    public List<com.baidu.tbadk.coreExtra.relationship.a> aEl() {
        return this.dbB.aDU();
    }

    public void aEm() {
        sendMessage(new CustomMessage(2001178));
    }

    public void aEh() {
        super.sendMessage(new RequestGetAddressListMessage(304001));
    }

    public void aD(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.dbB.aA(list);
    }

    public void a(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        this.dbB.a(aVar);
    }

    public void bS(long j) {
        this.dbB.bS(j);
    }

    public int th(String str) {
        int i;
        if (c.pN(str)) {
            List<com.baidu.tbadk.coreExtra.relationship.a> aDU = this.dbB.aDU();
            if (aDU != null) {
                for (com.baidu.tbadk.coreExtra.relationship.a aVar : aDU) {
                    if (str.equals(aVar.aqh())) {
                        i = aDU.indexOf(aVar);
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
