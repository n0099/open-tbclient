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
    private a bEe;

    public AddressListModel(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
        this.bEe = a.Wv();
    }

    public void a(a.InterfaceC0188a interfaceC0188a) {
        this.bEe.a(interfaceC0188a);
    }

    public void b(a.InterfaceC0188a interfaceC0188a) {
        this.bEe.b(interfaceC0188a);
    }

    public List<com.baidu.tbadk.coreExtra.relationship.a> WM() {
        return this.bEe.Ww();
    }

    public void WN() {
        sendMessage(new CustomMessage(2001178));
    }

    public void WI() {
        super.sendMessage(new RequestGetAddressListMessage(304001));
    }

    public void ai(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.bEe.af(list);
    }

    public void a(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        this.bEe.a(aVar);
    }

    public void aX(long j) {
        this.bEe.aX(j);
    }

    public int kh(String str) {
        int i;
        if (c.hc(str)) {
            List<com.baidu.tbadk.coreExtra.relationship.a> Ww = this.bEe.Ww();
            if (Ww != null) {
                for (com.baidu.tbadk.coreExtra.relationship.a aVar : Ww) {
                    if (str.equals(aVar.Kd())) {
                        i = Ww.indexOf(aVar);
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
