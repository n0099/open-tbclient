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
    private a cYm;

    public AddressListModel(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
        this.cYm = a.aBY();
    }

    public void a(a.InterfaceC0271a interfaceC0271a) {
        this.cYm.a(interfaceC0271a);
    }

    public void b(a.InterfaceC0271a interfaceC0271a) {
        this.cYm.b(interfaceC0271a);
    }

    public List<com.baidu.tbadk.coreExtra.relationship.a> aCp() {
        return this.cYm.aBZ();
    }

    public void aCq() {
        sendMessage(new CustomMessage(2001178));
    }

    public void aCl() {
        super.sendMessage(new RequestGetAddressListMessage(304001));
    }

    public void aD(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.cYm.aA(list);
    }

    public void a(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        this.cYm.a(aVar);
    }

    public void bO(long j) {
        this.cYm.bO(j);
    }

    public int sp(String str) {
        int i;
        if (c.pl(str)) {
            List<com.baidu.tbadk.coreExtra.relationship.a> aBZ = this.cYm.aBZ();
            if (aBZ != null) {
                for (com.baidu.tbadk.coreExtra.relationship.a aVar : aBZ) {
                    if (str.equals(aVar.aoN())) {
                        i = aBZ.indexOf(aVar);
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
