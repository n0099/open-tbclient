package com.baidu.tieba.addresslist.c;

import android.text.TextUtils;
import com.baidu.adp.base.f;
import com.baidu.tieba.addresslist.QuickSearchActivity;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class b extends f<QuickSearchActivity> {
    private com.baidu.tieba.addresslist.b.a apB;
    private byte[] apC;

    public b(QuickSearchActivity quickSearchActivity) {
        super(quickSearchActivity.getPageContext());
        this.apC = new byte[0];
        this.apB = com.baidu.tieba.addresslist.b.a.Bo();
    }

    public List<com.baidu.tbadk.coreExtra.relationship.b> eP(String str) {
        synchronized (this.apC) {
            ArrayList arrayList = new ArrayList();
            if (TextUtils.isEmpty(str)) {
                return arrayList;
            }
            List<com.baidu.tbadk.coreExtra.relationship.b> Bp = this.apB.Bp();
            if (Bp == null) {
                return arrayList;
            }
            for (com.baidu.tbadk.coreExtra.relationship.b bVar : Bp) {
                String userName = bVar.getUserName();
                String quanpin = bVar.getQuanpin();
                if (!TextUtils.isEmpty(userName) && userName.toLowerCase().startsWith(str.toLowerCase())) {
                    arrayList.add(bVar);
                } else if (!TextUtils.isEmpty(quanpin) && quanpin.toLowerCase().startsWith(str.toLowerCase())) {
                    arrayList.add(bVar);
                }
            }
            for (com.baidu.tbadk.coreExtra.relationship.b bVar2 : Bp) {
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

    @Override // com.baidu.adp.base.f
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.f
    public boolean cancelLoadData() {
        return false;
    }
}
