package com.baidu.tieba.addresslist.c;

import android.text.TextUtils;
import com.baidu.adp.base.e;
import com.baidu.tieba.addresslist.QuickSearchActivity;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class b extends e<QuickSearchActivity> {
    private com.baidu.tieba.addresslist.b.a aJY;
    private byte[] aJZ;

    public b(QuickSearchActivity quickSearchActivity) {
        super(quickSearchActivity.getPageContext());
        this.aJZ = new byte[0];
        this.aJY = com.baidu.tieba.addresslist.b.a.Hi();
    }

    public List<com.baidu.tbadk.coreExtra.relationship.a> gz(String str) {
        synchronized (this.aJZ) {
            ArrayList arrayList = new ArrayList();
            if (TextUtils.isEmpty(str)) {
                return arrayList;
            }
            List<com.baidu.tbadk.coreExtra.relationship.a> Hj = this.aJY.Hj();
            if (Hj == null) {
                return arrayList;
            }
            for (com.baidu.tbadk.coreExtra.relationship.a aVar : Hj) {
                String userName = aVar.getUserName();
                String quanpin = aVar.getQuanpin();
                if (!TextUtils.isEmpty(userName) && userName.toLowerCase().startsWith(str.toLowerCase())) {
                    arrayList.add(aVar);
                } else if (!TextUtils.isEmpty(quanpin) && quanpin.toLowerCase().startsWith(str.toLowerCase())) {
                    arrayList.add(aVar);
                }
            }
            for (com.baidu.tbadk.coreExtra.relationship.a aVar2 : Hj) {
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

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        return false;
    }
}
