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
    private a bfL;

    public AddressListModel(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
        this.bfL = a.Nl();
    }

    public void a(a.InterfaceC0115a interfaceC0115a) {
        this.bfL.a(interfaceC0115a);
    }

    public void b(a.InterfaceC0115a interfaceC0115a) {
        this.bfL.b(interfaceC0115a);
    }

    public List<com.baidu.tbadk.coreExtra.relationship.a> ND() {
        return this.bfL.Nm();
    }

    public void NE() {
        sendMessage(new CustomMessage(2001178));
    }

    public void Nz() {
        super.sendMessage(new RequestGetAddressListMessage(304001));
    }

    public void W(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.bfL.T(list);
    }

    public void a(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        this.bfL.a(aVar);
    }

    public void az(long j) {
        this.bfL.az(j);
    }

    public int is(String str) {
        int i;
        if (c.fx(str)) {
            List<com.baidu.tbadk.coreExtra.relationship.a> Nm = this.bfL.Nm();
            if (Nm != null) {
                for (com.baidu.tbadk.coreExtra.relationship.a aVar : Nm) {
                    if (str.equals(aVar.BG())) {
                        i = Nm.indexOf(aVar);
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
