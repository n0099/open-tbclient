package com.baidu.tieba.addresslist.c;

import android.text.TextUtils;
import com.baidu.adp.base.f;
import com.baidu.tieba.addresslist.QuickSearchActivity;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class b extends f<QuickSearchActivity> {
    private com.baidu.tieba.addresslist.b.a aBt;
    private byte[] aBu;

    public b(QuickSearchActivity quickSearchActivity) {
        super(quickSearchActivity.getPageContext());
        this.aBu = new byte[0];
        this.aBt = com.baidu.tieba.addresslist.b.a.FN();
    }

    public List<com.baidu.tbadk.coreExtra.relationship.a> fH(String str) {
        synchronized (this.aBu) {
            ArrayList arrayList = new ArrayList();
            if (TextUtils.isEmpty(str)) {
                return arrayList;
            }
            List<com.baidu.tbadk.coreExtra.relationship.a> FO = this.aBt.FO();
            if (FO == null) {
                return arrayList;
            }
            for (com.baidu.tbadk.coreExtra.relationship.a aVar : FO) {
                String userName = aVar.getUserName();
                String quanpin = aVar.getQuanpin();
                if (!TextUtils.isEmpty(userName) && userName.toLowerCase().startsWith(str.toLowerCase())) {
                    arrayList.add(aVar);
                } else if (!TextUtils.isEmpty(quanpin) && quanpin.toLowerCase().startsWith(str.toLowerCase())) {
                    arrayList.add(aVar);
                }
            }
            for (com.baidu.tbadk.coreExtra.relationship.a aVar2 : FO) {
                String userName2 = aVar2.getUserName();
                String quanpin2 = aVar2.getQuanpin();
                if (!arrayList.contains(aVar2)) {
                    if (!TextUtils.isEmpty(userName2) && userName2.toLowerCase().contains(str.toLowerCase())) {
                        arrayList.add(aVar2);
                    } else if (!TextUtils.isEmpty(quanpin2) && quanpin2.toLowerCase().contains(str.toLowerCase())) {
                        arrayList.add(aVar2);
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
