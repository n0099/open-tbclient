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
    private a cPW;

    public AddressListModel(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
        this.cPW = a.awS();
    }

    public void a(a.InterfaceC0256a interfaceC0256a) {
        this.cPW.a(interfaceC0256a);
    }

    public void b(a.InterfaceC0256a interfaceC0256a) {
        this.cPW.b(interfaceC0256a);
    }

    public List<com.baidu.tbadk.coreExtra.relationship.a> axj() {
        return this.cPW.awT();
    }

    public void axk() {
        sendMessage(new CustomMessage(2001178));
    }

    public void axf() {
        super.sendMessage(new RequestGetAddressListMessage(304001));
    }

    public void aw(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.cPW.at(list);
    }

    public void a(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        this.cPW.a(aVar);
    }

    public void bz(long j) {
        this.cPW.bz(j);
    }

    public int rg(String str) {
        int i;
        if (c.ob(str)) {
            List<com.baidu.tbadk.coreExtra.relationship.a> awT = this.cPW.awT();
            if (awT != null) {
                for (com.baidu.tbadk.coreExtra.relationship.a aVar : awT) {
                    if (str.equals(aVar.ajP())) {
                        i = awT.indexOf(aVar);
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
