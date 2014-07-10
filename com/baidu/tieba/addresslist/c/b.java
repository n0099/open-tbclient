package com.baidu.tieba.addresslist.c;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import com.baidu.adp.base.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class b extends e {
    private byte[] b = new byte[0];
    private com.baidu.tieba.addresslist.b.a a = com.baidu.tieba.addresslist.b.a.a();

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
                if (!TextUtils.isEmpty(b2) && b2.toLowerCase().contains(str.toLowerCase())) {
                    arrayList.add(bVar);
                } else if (!TextUtils.isEmpty(e) && e.toLowerCase().contains(str.toLowerCase())) {
                    arrayList.add(bVar);
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
