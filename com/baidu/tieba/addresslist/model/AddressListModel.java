package com.baidu.tieba.addresslist.model;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.addresslist.relationship.RequestGetAddressListMessage;
import d.b.i0.s.f.c;
import d.b.j0.q.d.a;
import java.util.List;
/* loaded from: classes4.dex */
public class AddressListModel extends BdBaseModel<BaseFragmentActivity> {

    /* renamed from: e  reason: collision with root package name */
    public a f14322e;

    public AddressListModel(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
        this.f14322e = a.d();
    }

    public void A(a.InterfaceC1457a interfaceC1457a) {
        this.f14322e.h(interfaceC1457a);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void s(d.b.i0.s.f.a aVar) {
        this.f14322e.a(aVar);
    }

    public int t(String str) {
        List<d.b.i0.s.f.a> c2;
        if (c.a(str) && (c2 = this.f14322e.c()) != null) {
            for (d.b.i0.s.f.a aVar : c2) {
                if (str.equals(aVar.a())) {
                    return c2.indexOf(aVar);
                }
            }
            return -1;
        }
        return -1;
    }

    public void u(long j) {
        this.f14322e.b(j);
    }

    public List<d.b.i0.s.f.a> v() {
        return this.f14322e.c();
    }

    public void w() {
        sendMessage(new CustomMessage(2001178));
    }

    public void x() {
        super.sendMessage(new RequestGetAddressListMessage(304001));
    }

    public void y(a.InterfaceC1457a interfaceC1457a) {
        this.f14322e.f(interfaceC1457a);
    }

    public void z(List<d.b.i0.s.f.a> list) {
        this.f14322e.g(list);
    }
}
