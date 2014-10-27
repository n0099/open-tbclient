package com.baidu.tieba.addresslist.c;

import android.content.Context;
import com.baidu.adp.base.e;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.coreExtra.relationship.RequestGetAddressListMessage;
import com.baidu.tbadk.coreExtra.relationship.o;
import java.util.List;
/* loaded from: classes.dex */
public class a extends e {
    private com.baidu.tieba.addresslist.b.a ahh;

    public a(Context context) {
        super(context);
        this.ahh = com.baidu.tieba.addresslist.b.a.xz();
    }

    public void a(com.baidu.tieba.addresslist.b.b bVar) {
        this.ahh.a(bVar);
    }

    public void b(com.baidu.tieba.addresslist.b.b bVar) {
        this.ahh.b(bVar);
    }

    public List<com.baidu.tbadk.coreExtra.relationship.b> xB() {
        return this.ahh.xA();
    }

    public void xC() {
        sendMessage(new CustomMessage(2001182));
    }

    public void xD() {
        super.sendMessage(new RequestGetAddressListMessage(304001));
    }

    public void w(List<com.baidu.tbadk.coreExtra.relationship.b> list) {
        this.ahh.v(list);
    }

    public void c(com.baidu.tbadk.coreExtra.relationship.b bVar) {
        this.ahh.c(bVar);
    }

    public void w(long j) {
        this.ahh.w(j);
    }

    public int ej(String str) {
        int i;
        if (o.cG(str)) {
            List<com.baidu.tbadk.coreExtra.relationship.b> xA = this.ahh.xA();
            if (xA != null) {
                for (com.baidu.tbadk.coreExtra.relationship.b bVar : xA) {
                    if (str.equals(bVar.pA())) {
                        i = xA.indexOf(bVar);
                        break;
                    }
                }
            }
            i = -1;
            return i;
        }
        return -1;
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        return false;
    }
}
