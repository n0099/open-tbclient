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
    private a cYk;

    public AddressListModel(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
        this.cYk = a.aBV();
    }

    public void a(a.InterfaceC0271a interfaceC0271a) {
        this.cYk.a(interfaceC0271a);
    }

    public void b(a.InterfaceC0271a interfaceC0271a) {
        this.cYk.b(interfaceC0271a);
    }

    public List<com.baidu.tbadk.coreExtra.relationship.a> aCm() {
        return this.cYk.aBW();
    }

    public void aCn() {
        sendMessage(new CustomMessage(2001178));
    }

    public void aCi() {
        super.sendMessage(new RequestGetAddressListMessage(304001));
    }

    public void aD(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.cYk.aA(list);
    }

    public void a(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        this.cYk.a(aVar);
    }

    public void bO(long j) {
        this.cYk.bO(j);
    }

    public int sq(String str) {
        int i;
        if (c.pm(str)) {
            List<com.baidu.tbadk.coreExtra.relationship.a> aBW = this.cYk.aBW();
            if (aBW != null) {
                for (com.baidu.tbadk.coreExtra.relationship.a aVar : aBW) {
                    if (str.equals(aVar.aoN())) {
                        i = aBW.indexOf(aVar);
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
