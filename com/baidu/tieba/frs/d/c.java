package com.baidu.tieba.frs.d;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.tieba.frs.ce;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements com.baidu.adp.lib.f.c<ce> {
    final /* synthetic */ a bPu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.bPu = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.c
    /* renamed from: Zz */
    public ce dF() {
        Context context;
        context = this.bPu.mContext;
        return new ce(LayoutInflater.from(context).inflate(u.h.frs_item, (ViewGroup) null), 0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.c
    /* renamed from: a */
    public void l(ce ceVar) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.c
    /* renamed from: b */
    public ce m(ce ceVar) {
        return ceVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.c
    /* renamed from: c */
    public ce n(ce ceVar) {
        return ceVar;
    }
}
