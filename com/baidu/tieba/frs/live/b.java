package com.baidu.tieba.frs.live;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.tieba.frs.dy;
import com.baidu.tieba.n;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements com.baidu.adp.lib.f.c<dy> {
    final /* synthetic */ a blh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.blh = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.c
    /* renamed from: Pj */
    public dy hc() {
        Context context;
        context = this.blh.mContext;
        dy dyVar = new dy(LayoutInflater.from(context).inflate(n.h.frs_item_single_photolivecard, (ViewGroup) null));
        ((LinearLayout.LayoutParams) dyVar.biu.getLayoutParams()).topMargin = 0;
        return dyVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.c
    /* renamed from: a */
    public void l(dy dyVar) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.c
    /* renamed from: b */
    public dy m(dy dyVar) {
        return dyVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.c
    /* renamed from: c */
    public dy n(dy dyVar) {
        return dyVar;
    }
}
