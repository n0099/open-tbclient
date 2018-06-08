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
    private a bnS;

    public AddressListModel(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
        this.bnS = a.QL();
    }

    public void a(a.InterfaceC0131a interfaceC0131a) {
        this.bnS.a(interfaceC0131a);
    }

    public void b(a.InterfaceC0131a interfaceC0131a) {
        this.bnS.b(interfaceC0131a);
    }

    public List<com.baidu.tbadk.coreExtra.relationship.a> Rc() {
        return this.bnS.QM();
    }

    public void Rd() {
        sendMessage(new CustomMessage(2001178));
    }

    public void QY() {
        super.sendMessage(new RequestGetAddressListMessage(304001));
    }

    public void Z(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.bnS.W(list);
    }

    public void a(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        this.bnS.a(aVar);
    }

    public void aD(long j) {
        this.bnS.aD(j);
    }

    public int iU(String str) {
        int i;
        if (c.fV(str)) {
            List<com.baidu.tbadk.coreExtra.relationship.a> QM = this.bnS.QM();
            if (QM != null) {
                for (com.baidu.tbadk.coreExtra.relationship.a aVar : QM) {
                    if (str.equals(aVar.Fh())) {
                        i = QM.indexOf(aVar);
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
