package com.baidu.tieba.frs.d;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.tieba.frs.bs;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements com.baidu.adp.lib.f.c<bs> {
    final /* synthetic */ a cfQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.cfQ = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.c
    /* renamed from: agk */
    public bs ez() {
        Context context;
        context = this.cfQ.mContext;
        bs bsVar = new bs(LayoutInflater.from(context).inflate(r.h.frs_item_single_photolivecard, (ViewGroup) null));
        ((LinearLayout.LayoutParams) bsVar.bVj.getLayoutParams()).topMargin = 0;
        return bsVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.c
    /* renamed from: a */
    public void o(bs bsVar) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.c
    /* renamed from: b */
    public bs p(bs bsVar) {
        return bsVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.c
    /* renamed from: c */
    public bs q(bs bsVar) {
        return bsVar;
    }
}
