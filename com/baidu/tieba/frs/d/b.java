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
    final /* synthetic */ a bPu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.bPu = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.c
    /* renamed from: Zy */
    public cy dF() {
        Context context;
        context = this.bPu.mContext;
        cy cyVar = new cy(LayoutInflater.from(context).inflate(u.h.frs_item_single_photolivecard, (ViewGroup) null));
        ((LinearLayout.LayoutParams) cyVar.bGI.getLayoutParams()).topMargin = 0;
        return cyVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.c
    /* renamed from: a */
    public void l(cy cyVar) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.c
    /* renamed from: b */
    public cy m(cy cyVar) {
        return cyVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.c
    /* renamed from: c */
    public cy n(cy cyVar) {
        return cyVar;
    }
}
