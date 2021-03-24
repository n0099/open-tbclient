package com.baidu.tieba.addresslist.model;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.addresslist.relationship.RequestGetAddressListMessage;
import d.b.h0.s.f.c;
import d.b.i0.q.d.a;
import java.util.List;
/* loaded from: classes4.dex */
public class AddressListModel extends BdBaseModel<BaseFragmentActivity> {

    /* renamed from: e  reason: collision with root package name */
    public a f14635e;

    public AddressListModel(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
        this.f14635e = a.d();
    }

    public void A(a.InterfaceC1473a interfaceC1473a) {
        this.f14635e.h(interfaceC1473a);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void s(d.b.h0.s.f.a aVar) {
        this.f14635e.a(aVar);
    }

    public int t(String str) {
        List<d.b.h0.s.f.a> c2;
        if (c.a(str) && (c2 = this.f14635e.c()) != null) {
            for (d.b.h0.s.f.a aVar : c2) {
                if (str.equals(aVar.a())) {
                    return c2.indexOf(aVar);
                }
            }
            return -1;
        }
        return -1;
    }

    public void u(long j) {
        this.f14635e.b(j);
    }

    public List<d.b.h0.s.f.a> v() {
        return this.f14635e.c();
    }

    public void w() {
        sendMessage(new CustomMessage(2001178));
    }

    public void x() {
        super.sendMessage(new RequestGetAddressListMessage(304001));
    }

    public void y(a.InterfaceC1473a interfaceC1473a) {
        this.f14635e.f(interfaceC1473a);
    }

    public void z(List<d.b.h0.s.f.a> list) {
        this.f14635e.g(list);
    }
}
