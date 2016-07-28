package com.baidu.tieba.frs.d;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.tieba.frs.cy;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements com.baidu.adp.lib.f.c<cy> {
    final /* synthetic */ a bRh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.bRh = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.c
    /* renamed from: ZU */
    public cy dE() {
        Context context;
        context = this.bRh.mContext;
        cy cyVar = new cy(LayoutInflater.from(context).inflate(u.h.frs_item_single_photolivecard, (ViewGroup) null));
        ((LinearLayout.LayoutParams) cyVar.bIe.getLayoutParams()).topMargin = 0;
        return cyVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.c
    /* renamed from: a */
    public void o(cy cyVar) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.c
    /* renamed from: b */
    public cy p(cy cyVar) {
        return cyVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.c
    /* renamed from: c */
    public cy q(cy cyVar) {
        return cyVar;
    }
}
