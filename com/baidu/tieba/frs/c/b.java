package com.baidu.tieba.frs.c;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.tieba.frs.eg;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements com.baidu.adp.lib.f.c<eg> {
    final /* synthetic */ a brR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.brR = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.c
    /* renamed from: Tm */
    public eg dE() {
        Context context;
        context = this.brR.mContext;
        eg egVar = new eg(LayoutInflater.from(context).inflate(t.h.frs_item_single_photolivecard, (ViewGroup) null));
        ((LinearLayout.LayoutParams) egVar.blR.getLayoutParams()).topMargin = 0;
        return egVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.c
    /* renamed from: a */
    public void l(eg egVar) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.c
    /* renamed from: b */
    public eg m(eg egVar) {
        return egVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.c
    /* renamed from: c */
    public eg n(eg egVar) {
        return egVar;
    }
}
