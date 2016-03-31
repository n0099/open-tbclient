package com.baidu.tieba.frs.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.tieba.frs.dp;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements com.baidu.adp.lib.f.c<dp> {
    final /* synthetic */ a btb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.btb = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.c
    /* renamed from: Tb */
    public dp hq() {
        Context context;
        context = this.btb.mContext;
        return new dp(LayoutInflater.from(context).inflate(t.h.frs_item, (ViewGroup) null), 0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.c
    /* renamed from: a */
    public void l(dp dpVar) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.c
    /* renamed from: b */
    public dp m(dp dpVar) {
        return dpVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.c
    /* renamed from: c */
    public dp n(dp dpVar) {
        return dpVar;
    }
}
