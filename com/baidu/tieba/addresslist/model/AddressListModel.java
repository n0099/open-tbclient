package com.baidu.tieba.addresslist.model;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.addresslist.relationship.RequestGetAddressListMessage;
import d.a.j0.s.f.c;
import d.a.k0.q.d.a;
import java.util.List;
/* loaded from: classes4.dex */
public class AddressListModel extends BdBaseModel<BaseFragmentActivity> {

    /* renamed from: e  reason: collision with root package name */
    public a f13713e;

    public AddressListModel(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
        this.f13713e = a.d();
    }

    public void A(a.InterfaceC1470a interfaceC1470a) {
        this.f13713e.h(interfaceC1470a);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void s(d.a.j0.s.f.a aVar) {
        this.f13713e.a(aVar);
    }

    public int t(String str) {
        List<d.a.j0.s.f.a> c2;
        if (c.a(str) && (c2 = this.f13713e.c()) != null) {
            for (d.a.j0.s.f.a aVar : c2) {
                if (str.equals(aVar.a())) {
                    return c2.indexOf(aVar);
                }
            }
            return -1;
        }
        return -1;
    }

    public void u(long j) {
        this.f13713e.b(j);
    }

    public List<d.a.j0.s.f.a> v() {
        return this.f13713e.c();
    }

    public void w() {
        sendMessage(new CustomMessage(2001178));
    }

    public void x() {
        super.sendMessage(new RequestGetAddressListMessage(304001));
    }

    public void y(a.InterfaceC1470a interfaceC1470a) {
        this.f13713e.f(interfaceC1470a);
    }

    public void z(List<d.a.j0.s.f.a> list) {
        this.f13713e.g(list);
    }
}
