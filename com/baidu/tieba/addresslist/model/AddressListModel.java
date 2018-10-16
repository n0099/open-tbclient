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
    private a bzT;

    public AddressListModel(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
        this.bzT = a.Ve();
    }

    public void a(a.InterfaceC0154a interfaceC0154a) {
        this.bzT.a(interfaceC0154a);
    }

    public void b(a.InterfaceC0154a interfaceC0154a) {
        this.bzT.b(interfaceC0154a);
    }

    public List<com.baidu.tbadk.coreExtra.relationship.a> Vv() {
        return this.bzT.Vf();
    }

    public void Vw() {
        sendMessage(new CustomMessage(2001178));
    }

    public void Vr() {
        super.sendMessage(new RequestGetAddressListMessage(304001));
    }

    public void aj(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.bzT.ag(list);
    }

    public void a(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        this.bzT.a(aVar);
    }

    public void aN(long j) {
        this.bzT.aN(j);
    }

    public int jM(String str) {
        int i;
        if (c.gI(str)) {
            List<com.baidu.tbadk.coreExtra.relationship.a> Vf = this.bzT.Vf();
            if (Vf != null) {
                for (com.baidu.tbadk.coreExtra.relationship.a aVar : Vf) {
                    if (str.equals(aVar.IM())) {
                        i = Vf.indexOf(aVar);
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
