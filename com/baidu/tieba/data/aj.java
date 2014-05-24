package com.baidu.tieba.data;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.baidu.tbadk.data.IconData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aj implements com.baidu.adp.widget.s {
    final /* synthetic */ ai a;
    private final /* synthetic */ IconData b;
    private final /* synthetic */ com.baidu.tbadk.editortool.ab c;
    private final /* synthetic */ Context d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(ai aiVar, IconData iconData, com.baidu.tbadk.editortool.ab abVar, Context context) {
        this.a = aiVar;
        this.b = iconData;
        this.c = abVar;
        this.d = context;
    }

    @Override // com.baidu.adp.widget.s
    public Drawable a(com.baidu.adp.widget.r rVar) {
        com.baidu.adp.widget.a.a c = com.baidu.tbadk.imageManager.e.a().c(this.b.getIcon());
        if (c == null) {
            this.c.b(this.b.getIcon(), new ak(this, rVar, this.d));
        }
        return this.a.a(c);
    }
}
