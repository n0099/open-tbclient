package com.baidu.tieba.frs.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.tieba.frs.ed;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements com.baidu.adp.lib.f.c<ed> {
    final /* synthetic */ a boe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.boe = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.c
    /* renamed from: Rn */
    public ed hk() {
        Context context;
        context = this.boe.mContext;
        ed edVar = new ed(LayoutInflater.from(context).inflate(t.h.frs_item_single_photolivecard, (ViewGroup) null));
        ((LinearLayout.LayoutParams) edVar.blk.getLayoutParams()).topMargin = 0;
        return edVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.c
    /* renamed from: a */
    public void l(ed edVar) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.c
    /* renamed from: b */
    public ed m(ed edVar) {
        return edVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.c
    /* renamed from: c */
    public ed n(ed edVar) {
        return edVar;
    }
}
