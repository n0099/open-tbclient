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
    private a bvR;

    public AddressListModel(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
        this.bvR = a.Ti();
    }

    public void a(a.InterfaceC0130a interfaceC0130a) {
        this.bvR.a(interfaceC0130a);
    }

    public void b(a.InterfaceC0130a interfaceC0130a) {
        this.bvR.b(interfaceC0130a);
    }

    public List<com.baidu.tbadk.coreExtra.relationship.a> Tz() {
        return this.bvR.Tj();
    }

    public void TA() {
        sendMessage(new CustomMessage(2001178));
    }

    public void Tv() {
        super.sendMessage(new RequestGetAddressListMessage(304001));
    }

    public void aa(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.bvR.X(list);
    }

    public void a(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        this.bvR.a(aVar);
    }

    public void aL(long j) {
        this.bvR.aL(j);
    }

    public int jz(String str) {
        int i;
        if (c.gu(str)) {
            List<com.baidu.tbadk.coreExtra.relationship.a> Tj = this.bvR.Tj();
            if (Tj != null) {
                for (com.baidu.tbadk.coreExtra.relationship.a aVar : Tj) {
                    if (str.equals(aVar.GL())) {
                        i = Tj.indexOf(aVar);
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
