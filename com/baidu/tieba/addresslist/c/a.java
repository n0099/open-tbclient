package com.baidu.tieba.addresslist.c;

import com.baidu.adp.base.f;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.coreExtra.relationship.c;
import com.baidu.tieba.addresslist.relationship.RequestGetAddressListMessage;
import java.util.List;
/* loaded from: classes.dex */
public class a extends f<BaseActivity> {
    private com.baidu.tieba.addresslist.b.a azA;

    public a(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.azA = com.baidu.tieba.addresslist.b.a.EO();
    }

    public void a(com.baidu.tieba.addresslist.b.b bVar) {
        this.azA.a(bVar);
    }

    public void b(com.baidu.tieba.addresslist.b.b bVar) {
        this.azA.b(bVar);
    }

    public List<com.baidu.tbadk.coreExtra.relationship.a> Fm() {
        return this.azA.EP();
    }

    public void Fn() {
        sendMessage(new CustomMessage(2001182));
    }

    public void Fd() {
        super.sendMessage(new RequestGetAddressListMessage(304001));
    }

    public void z(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.azA.v(list);
    }

    public void a(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        this.azA.a(aVar);
    }

    public void G(long j) {
        this.azA.G(j);
    }

    public int fi(String str) {
        int i;
        if (c.dI(str)) {
            List<com.baidu.tbadk.coreExtra.relationship.a> EP = this.azA.EP();
            if (EP != null) {
                for (com.baidu.tbadk.coreExtra.relationship.a aVar : EP) {
                    if (str.equals(aVar.wD())) {
                        i = EP.indexOf(aVar);
                        break;
                    }
                }
            }
            i = -1;
            return i;
        }
        return -1;
    }

    @Override // com.baidu.adp.base.f
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.f
    public boolean cancelLoadData() {
        return false;
    }
}
