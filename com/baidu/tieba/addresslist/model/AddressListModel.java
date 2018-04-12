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
    private a bfK;

    public AddressListModel(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
        this.bfK = a.Nn();
    }

    public void a(a.InterfaceC0115a interfaceC0115a) {
        this.bfK.a(interfaceC0115a);
    }

    public void b(a.InterfaceC0115a interfaceC0115a) {
        this.bfK.b(interfaceC0115a);
    }

    public List<com.baidu.tbadk.coreExtra.relationship.a> NF() {
        return this.bfK.No();
    }

    public void NG() {
        sendMessage(new CustomMessage(2001178));
    }

    public void NB() {
        super.sendMessage(new RequestGetAddressListMessage(304001));
    }

    public void W(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.bfK.T(list);
    }

    public void a(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        this.bfK.a(aVar);
    }

    public void az(long j) {
        this.bfK.az(j);
    }

    public int ir(String str) {
        int i;
        if (c.fx(str)) {
            List<com.baidu.tbadk.coreExtra.relationship.a> No = this.bfK.No();
            if (No != null) {
                for (com.baidu.tbadk.coreExtra.relationship.a aVar : No) {
                    if (str.equals(aVar.BI())) {
                        i = No.indexOf(aVar);
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
