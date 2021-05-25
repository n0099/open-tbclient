package com.baidu.tieba.addresslist.model;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.addresslist.relationship.RequestGetAddressListMessage;
import d.a.m0.s.f.c;
import d.a.n0.s.d.a;
import java.util.List;
/* loaded from: classes4.dex */
public class AddressListModel extends BdBaseModel<BaseFragmentActivity> {

    /* renamed from: e  reason: collision with root package name */
    public a f13616e;

    public AddressListModel(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
        this.f13616e = a.d();
    }

    public void A(a.InterfaceC1586a interfaceC1586a) {
        this.f13616e.h(interfaceC1586a);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void s(d.a.m0.s.f.a aVar) {
        this.f13616e.a(aVar);
    }

    public int t(String str) {
        List<d.a.m0.s.f.a> c2;
        if (c.a(str) && (c2 = this.f13616e.c()) != null) {
            for (d.a.m0.s.f.a aVar : c2) {
                if (str.equals(aVar.a())) {
                    return c2.indexOf(aVar);
                }
            }
            return -1;
        }
        return -1;
    }

    public void u(long j) {
        this.f13616e.b(j);
    }

    public List<d.a.m0.s.f.a> v() {
        return this.f13616e.c();
    }

    public void w() {
        sendMessage(new CustomMessage(2001178));
    }

    public void x() {
        super.sendMessage(new RequestGetAddressListMessage(304001));
    }

    public void y(a.InterfaceC1586a interfaceC1586a) {
        this.f13616e.f(interfaceC1586a);
    }

    public void z(List<d.a.m0.s.f.a> list) {
        this.f13616e.g(list);
    }
}
