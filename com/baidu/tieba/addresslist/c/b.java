package com.baidu.tieba.addresslist.c;

import android.text.TextUtils;
import com.baidu.adp.base.f;
import com.baidu.tieba.addresslist.QuickSearchActivity;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class b extends f<QuickSearchActivity> {
    private com.baidu.tieba.addresslist.b.a aoG;
    private byte[] aoH;

    public b(QuickSearchActivity quickSearchActivity) {
        super(quickSearchActivity.getPageContext());
        this.aoH = new byte[0];
        this.aoG = com.baidu.tieba.addresslist.b.a.AU();
    }

    public List<com.baidu.tbadk.coreExtra.relationship.b> eQ(String str) {
        synchronized (this.aoH) {
            ArrayList arrayList = new ArrayList();
            if (TextUtils.isEmpty(str)) {
                return arrayList;
            }
            List<com.baidu.tbadk.coreExtra.relationship.b> AV = this.aoG.AV();
            if (AV == null) {
                return arrayList;
            }
            for (com.baidu.tbadk.coreExtra.relationship.b bVar : AV) {
                String userName = bVar.getUserName();
                String quanpin = bVar.getQuanpin();
                if (!TextUtils.isEmpty(userName) && userName.toLowerCase().startsWith(str.toLowerCase())) {
                    arrayList.add(bVar);
                } else if (!TextUtils.isEmpty(quanpin) && quanpin.toLowerCase().startsWith(str.toLowerCase())) {
                    arrayList.add(bVar);
                }
            }
            for (com.baidu.tbadk.coreExtra.relationship.b bVar2 : AV) {
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
