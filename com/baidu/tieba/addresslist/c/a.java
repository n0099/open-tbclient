package com.baidu.tieba.addresslist.c;

import com.baidu.adp.base.f;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.coreExtra.relationship.RequestGetAddressListMessage;
import com.baidu.tbadk.coreExtra.relationship.o;
import java.util.List;
/* loaded from: classes.dex */
public class a extends f<BaseFragmentActivity> {
    private com.baidu.tieba.addresslist.b.a apE;

    public a(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
        this.apE = com.baidu.tieba.addresslist.b.a.Bu();
    }

    public void a(com.baidu.tieba.addresslist.b.b bVar) {
        this.apE.a(bVar);
    }

    public void b(com.baidu.tieba.addresslist.b.b bVar) {
        this.apE.b(bVar);
    }

    public List<com.baidu.tbadk.coreExtra.relationship.b> Bw() {
        return this.apE.Bv();
    }

    public void Bx() {
        sendMessage(new CustomMessage(2001182));
    }

    public void By() {
        super.sendMessage(new RequestGetAddressListMessage(304001));
    }

    public void B(List<com.baidu.tbadk.coreExtra.relationship.b> list) {
        this.apE.A(list);
    }

    public void c(com.baidu.tbadk.coreExtra.relationship.b bVar) {
        this.apE.c(bVar);
    }

    public void G(long j) {
        this.apE.G(j);
    }

    public int eR(String str) {
        int i;
        if (o.dD(str)) {
            List<com.baidu.tbadk.coreExtra.relationship.b> Bv = this.apE.Bv();
            if (Bv != null) {
                for (com.baidu.tbadk.coreExtra.relationship.b bVar : Bv) {
                    if (str.equals(bVar.tn())) {
                        i = Bv.indexOf(bVar);
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
