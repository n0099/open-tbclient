package com.baidu.tieba.frs.d;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.tieba.frs.cu;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements com.baidu.adp.lib.f.c<cu> {
    final /* synthetic */ a cct;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.cct = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.c
    /* renamed from: aeS */
    public cu ez() {
        Context context;
        context = this.cct.mContext;
        cu cuVar = new cu(LayoutInflater.from(context).inflate(r.h.frs_item_single_photolivecard, (ViewGroup) null));
        ((LinearLayout.LayoutParams) cuVar.bTd.getLayoutParams()).topMargin = 0;
        return cuVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.c
    /* renamed from: a */
    public void o(cu cuVar) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.c
    /* renamed from: b */
    public cu p(cu cuVar) {
        return cuVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.c
    /* renamed from: c */
    public cu q(cu cuVar) {
        return cuVar;
    }
}
