package com.baidu.tieba.addresslist.model;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.addresslist.relationship.RequestGetAddressListMessage;
import d.a.i0.s.f.c;
import d.a.j0.q.d.a;
import java.util.List;
/* loaded from: classes4.dex */
public class AddressListModel extends BdBaseModel<BaseFragmentActivity> {

    /* renamed from: e  reason: collision with root package name */
    public a f14377e;

    public AddressListModel(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
        this.f14377e = a.d();
    }

    public void A(a.InterfaceC1396a interfaceC1396a) {
        this.f14377e.h(interfaceC1396a);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void s(d.a.i0.s.f.a aVar) {
        this.f14377e.a(aVar);
    }

    public int t(String str) {
        List<d.a.i0.s.f.a> c2;
        if (c.a(str) && (c2 = this.f14377e.c()) != null) {
            for (d.a.i0.s.f.a aVar : c2) {
                if (str.equals(aVar.a())) {
                    return c2.indexOf(aVar);
                }
            }
            return -1;
        }
        return -1;
    }

    public void u(long j) {
        this.f14377e.b(j);
    }

    public List<d.a.i0.s.f.a> v() {
        return this.f14377e.c();
    }

    public void w() {
        sendMessage(new CustomMessage(2001178));
    }

    public void x() {
        super.sendMessage(new RequestGetAddressListMessage(304001));
    }

    public void y(a.InterfaceC1396a interfaceC1396a) {
        this.f14377e.f(interfaceC1396a);
    }

    public void z(List<d.a.i0.s.f.a> list) {
        this.f14377e.g(list);
    }
}
