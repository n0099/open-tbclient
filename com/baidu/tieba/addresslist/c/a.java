package com.baidu.tieba.addresslist.c;

import com.baidu.adp.base.f;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.coreExtra.relationship.c;
import com.baidu.tieba.addresslist.relationship.RequestGetAddressListMessage;
import java.util.List;
/* loaded from: classes.dex */
public class a extends f<BaseFragmentActivity> {
    private com.baidu.tieba.addresslist.b.a aBu;

    public a(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
        this.aBu = com.baidu.tieba.addresslist.b.a.FO();
    }

    public void a(com.baidu.tieba.addresslist.b.b bVar) {
        this.aBu.a(bVar);
    }

    public void b(com.baidu.tieba.addresslist.b.b bVar) {
        this.aBu.b(bVar);
    }

    public List<com.baidu.tbadk.coreExtra.relationship.a> Gm() {
        return this.aBu.FP();
    }

    public void Gn() {
        sendMessage(new CustomMessage(2001182));
    }

    public void Gd() {
        super.sendMessage(new RequestGetAddressListMessage(304001));
    }

    public void A(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.aBu.w(list);
    }

    public void a(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        this.aBu.a(aVar);
    }

    public void F(long j) {
        this.aBu.F(j);
    }

    public int fG(String str) {
        int i;
        if (c.ec(str)) {
            List<com.baidu.tbadk.coreExtra.relationship.a> FP = this.aBu.FP();
            if (FP != null) {
                for (com.baidu.tbadk.coreExtra.relationship.a aVar : FP) {
                    if (str.equals(aVar.xx())) {
                        i = FP.indexOf(aVar);
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
