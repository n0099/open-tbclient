package com.baidu.tieba.addresslist.c;

import com.baidu.adp.base.e;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.coreExtra.relationship.RequestGetAddressListMessage;
import com.baidu.tbadk.coreExtra.relationship.n;
import java.util.List;
/* loaded from: classes.dex */
public class a extends e {
    private com.baidu.tieba.addresslist.b.a a = com.baidu.tieba.addresslist.b.a.a();

    public void a(com.baidu.tieba.addresslist.b.b bVar) {
        this.a.a(bVar);
    }

    public void b(com.baidu.tieba.addresslist.b.b bVar) {
        this.a.b(bVar);
    }

    public List<com.baidu.tbadk.coreExtra.relationship.b> a() {
        return this.a.b();
    }

    public void b() {
        sendMessage(new CustomMessage(2001182));
    }

    public void c() {
        super.sendMessage(new RequestGetAddressListMessage(304001));
    }

    public void a(List<com.baidu.tbadk.coreExtra.relationship.b> list) {
        this.a.a(list);
    }

    public void a(com.baidu.tbadk.coreExtra.relationship.b bVar) {
        this.a.a(bVar);
    }

    public void a(long j) {
        this.a.a(j);
    }

    public int a(String str) {
        int i;
        if (n.a(str)) {
            List<com.baidu.tbadk.coreExtra.relationship.b> b = this.a.b();
            if (b != null) {
                for (com.baidu.tbadk.coreExtra.relationship.b bVar : b) {
                    if (str.equals(bVar.f())) {
                        i = b.indexOf(bVar);
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
