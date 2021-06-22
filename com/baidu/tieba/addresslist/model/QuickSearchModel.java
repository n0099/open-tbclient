package com.baidu.tieba.addresslist.model;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.tieba.addresslist.QuickSearchActivity;
import d.a.o0.s.d.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class QuickSearchModel extends BdBaseModel<QuickSearchActivity> {

    /* renamed from: e  reason: collision with root package name */
    public a f13764e;

    /* renamed from: f  reason: collision with root package name */
    public byte[] f13765f;

    public QuickSearchModel(QuickSearchActivity quickSearchActivity) {
        super(quickSearchActivity.getPageContext());
        this.f13765f = new byte[0];
        this.f13764e = a.d();
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    @SuppressLint({"DefaultLocale"})
    public List<d.a.n0.s.f.a> w(String str) {
        synchronized (this.f13765f) {
            ArrayList arrayList = new ArrayList();
            if (TextUtils.isEmpty(str)) {
                return arrayList;
            }
            List<d.a.n0.s.f.a> c2 = this.f13764e.c();
            if (c2 == null) {
                return arrayList;
            }
            for (d.a.n0.s.f.a aVar : c2) {
                String f2 = aVar.f();
                String d2 = aVar.d();
                if (!TextUtils.isEmpty(f2) && f2.toLowerCase().startsWith(str.toLowerCase())) {
                    arrayList.add(aVar);
                } else if (!TextUtils.isEmpty(d2) && d2.toLowerCase().startsWith(str.toLowerCase())) {
                    arrayList.add(aVar);
                }
            }
            for (d.a.n0.s.f.a aVar2 : c2) {
                String f3 = aVar2.f();
                String d3 = aVar2.d();
                if (!arrayList.contains(aVar2)) {
                    if (!TextUtils.isEmpty(f3) && f3.toLowerCase().contains(str.toLowerCase())) {
                        arrayList.add(aVar2);
                    } else if (!TextUtils.isEmpty(d3) && d3.toLowerCase().contains(str.toLowerCase())) {
                        arrayList.add(aVar2);
                    }
                }
            }
            return arrayList;
        }
    }
}
