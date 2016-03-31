package com.baidu.tieba.frs.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.tieba.frs.el;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements com.baidu.adp.lib.f.c<el> {
    final /* synthetic */ a btb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.btb = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.c
    /* renamed from: Ta */
    public el hq() {
        Context context;
        context = this.btb.mContext;
        el elVar = new el(LayoutInflater.from(context).inflate(t.h.frs_item_single_photolivecard, (ViewGroup) null));
        ((LinearLayout.LayoutParams) elVar.bqC.getLayoutParams()).topMargin = 0;
        return elVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.c
    /* renamed from: a */
    public void l(el elVar) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.c
    /* renamed from: b */
    public el m(el elVar) {
        return elVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.c
    /* renamed from: c */
    public el n(el elVar) {
        return elVar;
    }
}
