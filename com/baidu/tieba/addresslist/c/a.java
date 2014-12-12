package com.baidu.tieba.addresslist.c;

import com.baidu.adp.base.f;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.coreExtra.relationship.RequestGetAddressListMessage;
import com.baidu.tbadk.coreExtra.relationship.o;
import java.util.List;
/* loaded from: classes.dex */
public class a extends f<BaseFragmentActivity> {
    private com.baidu.tieba.addresslist.b.a aoG;

    public a(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
        this.aoG = com.baidu.tieba.addresslist.b.a.AU();
    }

    public void a(com.baidu.tieba.addresslist.b.b bVar) {
        this.aoG.a(bVar);
    }

    public void b(com.baidu.tieba.addresslist.b.b bVar) {
        this.aoG.b(bVar);
    }

    public List<com.baidu.tbadk.coreExtra.relationship.b> AW() {
        return this.aoG.AV();
    }

    public void AX() {
        sendMessage(new CustomMessage(2001182));
    }

    public void AY() {
        super.sendMessage(new RequestGetAddressListMessage(304001));
    }

    public void B(List<com.baidu.tbadk.coreExtra.relationship.b> list) {
        this.aoG.A(list);
    }

    public void c(com.baidu.tbadk.coreExtra.relationship.b bVar) {
        this.aoG.c(bVar);
    }

    public void G(long j) {
        this.aoG.G(j);
    }

    public int eP(String str) {
        int i;
        if (o.dE(str)) {
            List<com.baidu.tbadk.coreExtra.relationship.b> AV = this.aoG.AV();
            if (AV != null) {
                for (com.baidu.tbadk.coreExtra.relationship.b bVar : AV) {
                    if (str.equals(bVar.sW())) {
                        i = AV.indexOf(bVar);
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
