package com.baidu.tieba.frs.c;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.tieba.frs.bp;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements com.baidu.adp.lib.e.c<bp> {
    final /* synthetic */ a bYX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.bYX = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: acJ */
    public bp fF() {
        Context context;
        context = this.bYX.mContext;
        bp bpVar = new bp(LayoutInflater.from(context).inflate(w.j.frs_item_single_photolivecard, (ViewGroup) null));
        ((LinearLayout.LayoutParams) bpVar.bPU.getLayoutParams()).topMargin = 0;
        return bpVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: a */
    public void o(bp bpVar) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: b */
    public bp p(bp bpVar) {
        return bpVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: c */
    public bp q(bp bpVar) {
        return bpVar;
    }
}
