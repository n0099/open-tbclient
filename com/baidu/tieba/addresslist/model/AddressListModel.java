package com.baidu.tieba.addresslist.model;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.addresslist.relationship.RequestGetAddressListMessage;
import d.a.n0.s.f.c;
import d.a.o0.s.d.a;
import java.util.List;
/* loaded from: classes4.dex */
public class AddressListModel extends BdBaseModel<BaseFragmentActivity> {

    /* renamed from: e  reason: collision with root package name */
    public a f13763e;

    public AddressListModel(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
        this.f13763e = a.d();
    }

    public void A() {
        sendMessage(new CustomMessage(2001178));
    }

    public void B() {
        super.sendMessage(new RequestGetAddressListMessage(304001));
    }

    public void C(a.InterfaceC1646a interfaceC1646a) {
        this.f13763e.f(interfaceC1646a);
    }

    public void D(List<d.a.n0.s.f.a> list) {
        this.f13763e.g(list);
    }

    public void E(a.InterfaceC1646a interfaceC1646a) {
        this.f13763e.h(interfaceC1646a);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void w(d.a.n0.s.f.a aVar) {
        this.f13763e.a(aVar);
    }

    public int x(String str) {
        List<d.a.n0.s.f.a> c2;
        if (c.a(str) && (c2 = this.f13763e.c()) != null) {
            for (d.a.n0.s.f.a aVar : c2) {
                if (str.equals(aVar.a())) {
                    return c2.indexOf(aVar);
                }
            }
            return -1;
        }
        return -1;
    }

    public void y(long j) {
        this.f13763e.b(j);
    }

    public List<d.a.n0.s.f.a> z() {
        return this.f13763e.c();
    }
}
