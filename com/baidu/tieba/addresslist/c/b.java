package com.baidu.tieba.addresslist.c;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import com.baidu.adp.base.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class b extends e {
    private com.baidu.tieba.addresslist.b.a a;
    private byte[] b;

    public b(Context context) {
        super(context);
        this.b = new byte[0];
        this.a = com.baidu.tieba.addresslist.b.a.a();
    }

    @SuppressLint({"DefaultLocale"})
    public List<com.baidu.tbadk.coreExtra.relationship.b> a(String str) {
        synchronized (this.b) {
            ArrayList arrayList = new ArrayList();
            if (TextUtils.isEmpty(str)) {
                return arrayList;
            }
            List<com.baidu.tbadk.coreExtra.relationship.b> b = this.a.b();
            if (b == null) {
                return arrayList;
            }
            for (com.baidu.tbadk.coreExtra.relationship.b bVar : b) {
                String b2 = bVar.b();
                String e = bVar.e();
                if (!TextUtils.isEmpty(b2) && b2.toLowerCase().startsWith(str.toLowerCase())) {
                    arrayList.add(bVar);
                } else if (!TextUtils.isEmpty(e) && e.toLowerCase().startsWith(str.toLowerCase())) {
                    arrayList.add(bVar);
                }
            }
            for (com.baidu.tbadk.coreExtra.relationship.b bVar2 : b) {
                String b3 = bVar2.b();
                String e2 = bVar2.e();
                if (!arrayList.contains(bVar2)) {
                    if (!TextUtils.isEmpty(b3) && b3.toLowerCase().contains(str.toLowerCase())) {
                        arrayList.add(bVar2);
                    } else if (!TextUtils.isEmpty(e2) && e2.toLowerCase().contains(str.toLowerCase())) {
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
