package com.baidu.tieba.frs.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.tieba.frs.dj;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements com.baidu.adp.lib.f.c<dj> {
    final /* synthetic */ a boe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.boe = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.c
    /* renamed from: Ro */
    public dj hk() {
        Context context;
        context = this.boe.mContext;
        return new dj(LayoutInflater.from(context).inflate(t.h.frs_item, (ViewGroup) null), 0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.c
    /* renamed from: a */
    public void l(dj djVar) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.c
    /* renamed from: b */
    public dj m(dj djVar) {
        return djVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.c
    /* renamed from: c */
    public dj n(dj djVar) {
        return djVar;
    }
}
