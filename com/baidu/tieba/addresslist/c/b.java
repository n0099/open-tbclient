package com.baidu.tieba.addresslist.c;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.adp.base.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class b extends e {
    private com.baidu.tieba.addresslist.b.a ahq;
    private byte[] ahr;

    public b(Context context) {
        super(context);
        this.ahr = new byte[0];
        this.ahq = com.baidu.tieba.addresslist.b.a.xB();
    }

    public List<com.baidu.tbadk.coreExtra.relationship.b> ek(String str) {
        synchronized (this.ahr) {
            ArrayList arrayList = new ArrayList();
            if (TextUtils.isEmpty(str)) {
                return arrayList;
            }
            List<com.baidu.tbadk.coreExtra.relationship.b> xC = this.ahq.xC();
            if (xC == null) {
                return arrayList;
            }
            for (com.baidu.tbadk.coreExtra.relationship.b bVar : xC) {
                String userName = bVar.getUserName();
                String quanpin = bVar.getQuanpin();
                if (!TextUtils.isEmpty(userName) && userName.toLowerCase().startsWith(str.toLowerCase())) {
                    arrayList.add(bVar);
                } else if (!TextUtils.isEmpty(quanpin) && quanpin.toLowerCase().startsWith(str.toLowerCase())) {
                    arrayList.add(bVar);
                }
            }
            for (com.baidu.tbadk.coreExtra.relationship.b bVar2 : xC) {
                String userName2 = bVar2.getUserName();
                String quanpin2 = bVar2.getQuanpin();
                if (!arrayList.contains(bVar2)) {
                    if (!TextUtils.isEmpty(userName2) && userName2.toLowerCase().contains(str.toLowerCase())) {
                        arrayList.add(bVar2);
                    } else if (!TextUtils.isEmpty(quanpin2) && quanpin2.toLowerCase().contains(str.toLowerCase())) {
                        arrayList.add(bVar2);
                    }
                }
            }
            return arrayList;
        }
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
