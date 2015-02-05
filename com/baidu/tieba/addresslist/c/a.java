package com.baidu.tieba.addresslist.c;

import com.baidu.adp.base.f;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.coreExtra.relationship.RequestGetAddressListMessage;
import com.baidu.tbadk.coreExtra.relationship.o;
import java.util.List;
/* loaded from: classes.dex */
public class a extends f<BaseFragmentActivity> {
    private com.baidu.tieba.addresslist.b.a apB;

    public a(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
        this.apB = com.baidu.tieba.addresslist.b.a.Bo();
    }

    public void a(com.baidu.tieba.addresslist.b.b bVar) {
        this.apB.a(bVar);
    }

    public void b(com.baidu.tieba.addresslist.b.b bVar) {
        this.apB.b(bVar);
    }

    public List<com.baidu.tbadk.coreExtra.relationship.b> Bq() {
        return this.apB.Bp();
    }

    public void Br() {
        sendMessage(new CustomMessage(2001182));
    }

    public void Bs() {
        super.sendMessage(new RequestGetAddressListMessage(304001));
    }

    public void B(List<com.baidu.tbadk.coreExtra.relationship.b> list) {
        this.apB.A(list);
    }

    public void c(com.baidu.tbadk.coreExtra.relationship.b bVar) {
        this.apB.c(bVar);
    }

    public void G(long j) {
        this.apB.G(j);
    }

    public int eO(String str) {
        int i;
        if (o.dA(str)) {
            List<com.baidu.tbadk.coreExtra.relationship.b> Bp = this.apB.Bp();
            if (Bp != null) {
                for (com.baidu.tbadk.coreExtra.relationship.b bVar : Bp) {
                    if (str.equals(bVar.th())) {
                        i = Bp.indexOf(bVar);
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
