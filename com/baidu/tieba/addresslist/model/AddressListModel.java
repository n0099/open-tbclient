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
    private a bER;

    public AddressListModel(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
        this.bER = a.WS();
    }

    public void a(a.InterfaceC0188a interfaceC0188a) {
        this.bER.a(interfaceC0188a);
    }

    public void b(a.InterfaceC0188a interfaceC0188a) {
        this.bER.b(interfaceC0188a);
    }

    public List<com.baidu.tbadk.coreExtra.relationship.a> Xj() {
        return this.bER.WT();
    }

    public void Xk() {
        sendMessage(new CustomMessage(2001178));
    }

    public void Xf() {
        super.sendMessage(new RequestGetAddressListMessage(304001));
    }

    public void aj(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.bER.ag(list);
    }

    public void a(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        this.bER.a(aVar);
    }

    public void aX(long j) {
        this.bER.aX(j);
    }

    public int kx(String str) {
        int i;
        if (c.hp(str)) {
            List<com.baidu.tbadk.coreExtra.relationship.a> WT = this.bER.WT();
            if (WT != null) {
                for (com.baidu.tbadk.coreExtra.relationship.a aVar : WT) {
                    if (str.equals(aVar.Ks())) {
                        i = WT.indexOf(aVar);
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
