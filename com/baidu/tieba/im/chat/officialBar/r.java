package com.baidu.tieba.im.chat.officialBar;

import android.content.Context;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class r implements com.baidu.adp.lib.d.c<bg> {
    final /* synthetic */ m a;
    private final /* synthetic */ Context b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(m mVar, Context context) {
        this.a = mVar;
        this.b = context;
    }

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.baidu.adp.lib.d.c
    public final /* synthetic */ bg a() {
        return new bg(this.b);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.baidu.adp.lib.d.c
    public final /* bridge */ /* synthetic */ void a(bg bgVar) {
        bg bgVar2 = bgVar;
        if (bgVar2 instanceof bg) {
            bgVar2.a();
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.baidu.adp.lib.d.c
    public final /* bridge */ /* synthetic */ bg b(bg bgVar) {
        return bgVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.baidu.adp.lib.d.c
    public final /* synthetic */ bg c(bg bgVar) {
        bg bgVar2 = bgVar;
        if (bgVar2 instanceof bg) {
            bgVar2.a();
        }
        return bgVar2;
    }
}
