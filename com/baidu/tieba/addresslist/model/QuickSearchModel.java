package com.baidu.tieba.addresslist.model;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.tieba.addresslist.QuickSearchActivity;
import com.baidu.tieba.addresslist.b.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class QuickSearchModel extends BdBaseModel<QuickSearchActivity> {
    private a dXZ;
    private byte[] mLock;

    public QuickSearchModel(QuickSearchActivity quickSearchActivity) {
        super(quickSearchActivity.getPageContext());
        this.mLock = new byte[0];
        this.dXZ = a.aWm();
    }

    @SuppressLint({"DefaultLocale"})
    public List<com.baidu.tbadk.coreExtra.relationship.a> xb(String str) {
        synchronized (this.mLock) {
            ArrayList arrayList = new ArrayList();
            if (TextUtils.isEmpty(str)) {
                return arrayList;
            }
            List<com.baidu.tbadk.coreExtra.relationship.a> aWn = this.dXZ.aWn();
            if (aWn == null) {
                return arrayList;
            }
            for (com.baidu.tbadk.coreExtra.relationship.a aVar : aWn) {
                String userName = aVar.getUserName();
                String quanpin = aVar.getQuanpin();
                if (!TextUtils.isEmpty(userName) && userName.toLowerCase().startsWith(str.toLowerCase())) {
                    arrayList.add(aVar);
                } else if (!TextUtils.isEmpty(quanpin) && quanpin.toLowerCase().startsWith(str.toLowerCase())) {
                    arrayList.add(aVar);
                }
            }
            for (com.baidu.tbadk.coreExtra.relationship.a aVar2 : aWn) {
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
