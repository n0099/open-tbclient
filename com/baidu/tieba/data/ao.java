package com.baidu.tieba.data;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.baidu.tbadk.data.IconData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ao implements com.baidu.adp.widget.s {
    final /* synthetic */ an a;
    private final /* synthetic */ IconData b;
    private final /* synthetic */ Context c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(an anVar, IconData iconData, Context context) {
        this.a = anVar;
        this.b = iconData;
        this.c = context;
    }

    @Override // com.baidu.adp.widget.s
    public Drawable a(com.baidu.adp.widget.r rVar) {
        com.baidu.adp.widget.a.a aVar = (com.baidu.adp.widget.a.a) com.baidu.adp.lib.resourceLoader.d.a().a(this.b.getIcon(), 21, new Object[0]);
        if (aVar == null) {
            ap apVar = new ap(this, rVar, this.c);
            if (this.c instanceof com.baidu.adp.base.i) {
                com.baidu.adp.lib.resourceLoader.d.a().a(this.b.getIcon(), 21, apVar, ((com.baidu.adp.base.i) this.c).getUniqueId());
            }
        }
        return this.a.a(aVar);
    }
}
