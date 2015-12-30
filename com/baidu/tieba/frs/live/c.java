package com.baidu.tieba.frs.live;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.tieba.frs.de;
import com.baidu.tieba.n;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements com.baidu.adp.lib.f.c<de> {
    final /* synthetic */ a blh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.blh = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.c
    /* renamed from: Pk */
    public de hc() {
        Context context;
        context = this.blh.mContext;
        return new de(LayoutInflater.from(context).inflate(n.h.frs_item, (ViewGroup) null), 0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.c
    /* renamed from: a */
    public void l(de deVar) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.c
    /* renamed from: b */
    public de m(de deVar) {
        return deVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.c
    /* renamed from: c */
    public de n(de deVar) {
        return deVar;
    }
}
