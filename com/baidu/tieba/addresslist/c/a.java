package com.baidu.tieba.addresslist.c;

import com.baidu.adp.base.f;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.coreExtra.relationship.c;
import com.baidu.tieba.addresslist.relationship.RequestGetAddressListMessage;
import java.util.List;
/* loaded from: classes.dex */
public class a extends f<BaseFragmentActivity> {
    private com.baidu.tieba.addresslist.b.a aBt;

    public a(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
        this.aBt = com.baidu.tieba.addresslist.b.a.FN();
    }

    public void a(com.baidu.tieba.addresslist.b.b bVar) {
        this.aBt.a(bVar);
    }

    public void b(com.baidu.tieba.addresslist.b.b bVar) {
        this.aBt.b(bVar);
    }

    public List<com.baidu.tbadk.coreExtra.relationship.a> Gl() {
        return this.aBt.FO();
    }

    public void Gm() {
        sendMessage(new CustomMessage(2001182));
    }

    public void Gc() {
        super.sendMessage(new RequestGetAddressListMessage(304001));
    }

    public void A(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.aBt.w(list);
    }

    public void a(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        this.aBt.a(aVar);
    }

    public void F(long j) {
        this.aBt.F(j);
    }

    public int fG(String str) {
        int i;
        if (c.ec(str)) {
            List<com.baidu.tbadk.coreExtra.relationship.a> FO = this.aBt.FO();
            if (FO != null) {
                for (com.baidu.tbadk.coreExtra.relationship.a aVar : FO) {
                    if (str.equals(aVar.xw())) {
                        i = FO.indexOf(aVar);
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
