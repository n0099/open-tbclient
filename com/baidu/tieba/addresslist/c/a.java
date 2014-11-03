package com.baidu.tieba.addresslist.c;

import android.content.Context;
import com.baidu.adp.base.e;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.coreExtra.relationship.RequestGetAddressListMessage;
import com.baidu.tbadk.coreExtra.relationship.o;
import java.util.List;
/* loaded from: classes.dex */
public class a extends e {
    private com.baidu.tieba.addresslist.b.a ahq;

    public a(Context context) {
        super(context);
        this.ahq = com.baidu.tieba.addresslist.b.a.xB();
    }

    public void a(com.baidu.tieba.addresslist.b.b bVar) {
        this.ahq.a(bVar);
    }

    public void b(com.baidu.tieba.addresslist.b.b bVar) {
        this.ahq.b(bVar);
    }

    public List<com.baidu.tbadk.coreExtra.relationship.b> xD() {
        return this.ahq.xC();
    }

    public void xE() {
        sendMessage(new CustomMessage(2001182));
    }

    public void xF() {
        super.sendMessage(new RequestGetAddressListMessage(304001));
    }

    public void w(List<com.baidu.tbadk.coreExtra.relationship.b> list) {
        this.ahq.v(list);
    }

    public void c(com.baidu.tbadk.coreExtra.relationship.b bVar) {
        this.ahq.c(bVar);
    }

    public void w(long j) {
        this.ahq.w(j);
    }

    public int ej(String str) {
        int i;
        if (o.cH(str)) {
            List<com.baidu.tbadk.coreExtra.relationship.b> xC = this.ahq.xC();
            if (xC != null) {
                for (com.baidu.tbadk.coreExtra.relationship.b bVar : xC) {
                    if (str.equals(bVar.pC())) {
                        i = xC.indexOf(bVar);
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
