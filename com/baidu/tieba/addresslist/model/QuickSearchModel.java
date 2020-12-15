package com.baidu.tieba.addresslist.model;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.tieba.addresslist.QuickSearchActivity;
import com.baidu.tieba.addresslist.b.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes21.dex */
public class QuickSearchModel extends BdBaseModel<QuickSearchActivity> {
    private a gcU;
    private byte[] gcV;

    public QuickSearchModel(QuickSearchActivity quickSearchActivity) {
        super(quickSearchActivity.getPageContext());
        this.gcV = new byte[0];
        this.gcU = a.bMQ();
    }

    @SuppressLint({"DefaultLocale"})
    public List<com.baidu.tbadk.coreExtra.relationship.a> FV(String str) {
        synchronized (this.gcV) {
            ArrayList arrayList = new ArrayList();
            if (TextUtils.isEmpty(str)) {
                return arrayList;
            }
            List<com.baidu.tbadk.coreExtra.relationship.a> bMR = this.gcU.bMR();
            if (bMR == null) {
                return arrayList;
            }
            for (com.baidu.tbadk.coreExtra.relationship.a aVar : bMR) {
                String userName = aVar.getUserName();
                String quanpin = aVar.getQuanpin();
                if (!TextUtils.isEmpty(userName) && userName.toLowerCase().startsWith(str.toLowerCase())) {
                    arrayList.add(aVar);
                } else if (!TextUtils.isEmpty(quanpin) && quanpin.toLowerCase().startsWith(str.toLowerCase())) {
                    arrayList.add(aVar);
                }
            }
            for (com.baidu.tbadk.coreExtra.relationship.a aVar2 : bMR) {
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

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }
}
