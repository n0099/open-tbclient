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
    private a bEb;

    public AddressListModel(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
        this.bEb = a.Wt();
    }

    public void a(a.InterfaceC0188a interfaceC0188a) {
        this.bEb.a(interfaceC0188a);
    }

    public void b(a.InterfaceC0188a interfaceC0188a) {
        this.bEb.b(interfaceC0188a);
    }

    public List<com.baidu.tbadk.coreExtra.relationship.a> WK() {
        return this.bEb.Wu();
    }

    public void WL() {
        sendMessage(new CustomMessage(2001178));
    }

    public void WG() {
        super.sendMessage(new RequestGetAddressListMessage(304001));
    }

    public void ai(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.bEb.af(list);
    }

    public void a(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        this.bEb.a(aVar);
    }

    public void aW(long j) {
        this.bEb.aW(j);
    }

    public int kg(String str) {
        int i;
        if (c.hb(str)) {
            List<com.baidu.tbadk.coreExtra.relationship.a> Wu = this.bEb.Wu();
            if (Wu != null) {
                for (com.baidu.tbadk.coreExtra.relationship.a aVar : Wu) {
                    if (str.equals(aVar.Kc())) {
                        i = Wu.indexOf(aVar);
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
