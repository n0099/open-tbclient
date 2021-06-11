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
    public a f13681e;

    public AddressListModel(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
        this.f13681e = a.d();
    }

    public void A() {
        sendMessage(new CustomMessage(2001178));
    }

    public void B() {
        super.sendMessage(new RequestGetAddressListMessage(304001));
    }

    public void C(a.InterfaceC1642a interfaceC1642a) {
        this.f13681e.f(interfaceC1642a);
    }

    public void D(List<d.a.m0.s.f.a> list) {
        this.f13681e.g(list);
    }

    public void E(a.InterfaceC1642a interfaceC1642a) {
        this.f13681e.h(interfaceC1642a);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void w(d.a.m0.s.f.a aVar) {
        this.f13681e.a(aVar);
    }

    public int x(String str) {
        List<d.a.m0.s.f.a> c2;
        if (c.a(str) && (c2 = this.f13681e.c()) != null) {
            for (d.a.m0.s.f.a aVar : c2) {
                if (str.equals(aVar.a())) {
                    return c2.indexOf(aVar);
                }
            }
            return -1;
        }
        return -1;
    }

    public void y(long j) {
        this.f13681e.b(j);
    }

    public List<d.a.m0.s.f.a> z() {
        return this.f13681e.c();
    }
}
