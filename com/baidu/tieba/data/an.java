package com.baidu.tieba.data;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.baidu.tbadk.data.IconData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class an implements com.baidu.adp.widget.s {
    final /* synthetic */ am a;
    private final /* synthetic */ IconData b;
    private final /* synthetic */ com.baidu.tbadk.editortool.aa c;
    private final /* synthetic */ Context d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(am amVar, IconData iconData, com.baidu.tbadk.editortool.aa aaVar, Context context) {
        this.a = amVar;
        this.b = iconData;
        this.c = aaVar;
        this.d = context;
    }

    @Override // com.baidu.adp.widget.s
    public Drawable a(com.baidu.adp.widget.r rVar) {
        com.baidu.adp.widget.a.a c = com.baidu.tbadk.imageManager.e.a().c(this.b.getIcon());
        if (c == null) {
            this.c.b(this.b.getIcon(), new ao(this, rVar, this.d));
        }
        return this.a.a(c);
    }
}
