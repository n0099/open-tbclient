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
    private a bAE;

    public AddressListModel(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
        this.bAE = a.Vn();
    }

    public void a(a.InterfaceC0178a interfaceC0178a) {
        this.bAE.a(interfaceC0178a);
    }

    public void b(a.InterfaceC0178a interfaceC0178a) {
        this.bAE.b(interfaceC0178a);
    }

    public List<com.baidu.tbadk.coreExtra.relationship.a> VE() {
        return this.bAE.Vo();
    }

    public void VF() {
        sendMessage(new CustomMessage(2001178));
    }

    public void VA() {
        super.sendMessage(new RequestGetAddressListMessage(304001));
    }

    public void ai(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.bAE.af(list);
    }

    public void a(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        this.bAE.a(aVar);
    }

    public void aP(long j) {
        this.bAE.aP(j);
    }

    public int jO(String str) {
        int i;
        if (c.gJ(str)) {
            List<com.baidu.tbadk.coreExtra.relationship.a> Vo = this.bAE.Vo();
            if (Vo != null) {
                for (com.baidu.tbadk.coreExtra.relationship.a aVar : Vo) {
                    if (str.equals(aVar.IY())) {
                        i = Vo.indexOf(aVar);
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
