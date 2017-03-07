package com.baidu.tieba.frs.c;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.tieba.frs.bg;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements com.baidu.adp.lib.e.c<bg> {
    final /* synthetic */ a bYX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.bYX = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: acK */
    public bg fF() {
        Context context;
        context = this.bYX.mContext;
        return new bg(LayoutInflater.from(context).inflate(w.j.frs_item, (ViewGroup) null), 0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: a */
    public void o(bg bgVar) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: b */
    public bg p(bg bgVar) {
        return bgVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: c */
    public bg q(bg bgVar) {
        return bgVar;
    }
}
