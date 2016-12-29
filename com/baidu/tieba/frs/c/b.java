package com.baidu.tieba.frs.c;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.tieba.frs.br;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements com.baidu.adp.lib.f.c<br> {
    final /* synthetic */ a bLz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.bLz = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.c
    /* renamed from: aaG */
    public br ez() {
        Context context;
        context = this.bLz.mContext;
        br brVar = new br(LayoutInflater.from(context).inflate(r.h.frs_item_single_photolivecard, (ViewGroup) null));
        ((LinearLayout.LayoutParams) brVar.bBr.getLayoutParams()).topMargin = 0;
        return brVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.c
    /* renamed from: a */
    public void o(br brVar) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.c
    /* renamed from: b */
    public br p(br brVar) {
        return brVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.c
    /* renamed from: c */
    public br q(br brVar) {
        return brVar;
    }
}
