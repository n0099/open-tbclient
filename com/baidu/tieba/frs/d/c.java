package com.baidu.tieba.frs.d;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.tieba.frs.ce;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements com.baidu.adp.lib.f.c<ce> {
    final /* synthetic */ a bRh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.bRh = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.c
    /* renamed from: ZV */
    public ce dE() {
        Context context;
        context = this.bRh.mContext;
        return new ce(LayoutInflater.from(context).inflate(u.h.frs_item, (ViewGroup) null), 0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.c
    /* renamed from: a */
    public void o(ce ceVar) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.c
    /* renamed from: b */
    public ce p(ce ceVar) {
        return ceVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.c
    /* renamed from: c */
    public ce q(ce ceVar) {
        return ceVar;
    }
}
