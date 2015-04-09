package com.baidu.tieba.addresslist.c;

import com.baidu.adp.base.f;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.coreExtra.relationship.c;
import com.baidu.tieba.addresslist.relationship.RequestGetAddressListMessage;
import java.util.List;
/* loaded from: classes.dex */
public class a extends f<BaseActivity> {
    private com.baidu.tieba.addresslist.b.a azI;

    public a(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.azI = com.baidu.tieba.addresslist.b.a.EU();
    }

    public void a(com.baidu.tieba.addresslist.b.b bVar) {
        this.azI.a(bVar);
    }

    public void b(com.baidu.tieba.addresslist.b.b bVar) {
        this.azI.b(bVar);
    }

    public List<com.baidu.tbadk.coreExtra.relationship.a> Fs() {
        return this.azI.EV();
    }

    public void Ft() {
        sendMessage(new CustomMessage(2001182));
    }

    public void Fj() {
        super.sendMessage(new RequestGetAddressListMessage(304001));
    }

    public void z(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.azI.v(list);
    }

    public void a(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        this.azI.a(aVar);
    }

    public void G(long j) {
        this.azI.G(j);
    }

    public int fl(String str) {
        int i;
        if (c.dL(str)) {
            List<com.baidu.tbadk.coreExtra.relationship.a> EV = this.azI.EV();
            if (EV != null) {
                for (com.baidu.tbadk.coreExtra.relationship.a aVar : EV) {
                    if (str.equals(aVar.wJ())) {
                        i = EV.indexOf(aVar);
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
