package com.baidu.tieba.frs.live;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.tieba.frs.db;
import com.baidu.tieba.n;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements com.baidu.adp.lib.f.c<db> {
    final /* synthetic */ a bhq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.bhq = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.c
    /* renamed from: OS */
    public db hc() {
        Context context;
        context = this.bhq.mContext;
        return new db(LayoutInflater.from(context).inflate(n.g.frs_item, (ViewGroup) null), 0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.c
    /* renamed from: a */
    public void l(db dbVar) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.c
    /* renamed from: b */
    public db m(db dbVar) {
        return dbVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.c
    /* renamed from: c */
    public db n(db dbVar) {
        return dbVar;
    }
}
