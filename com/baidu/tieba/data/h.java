package com.baidu.tieba.data;

import android.content.Context;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends com.baidu.tieba.util.k {
    final /* synthetic */ g akh;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(g gVar, Context context) {
        super(context);
        this.akh = gVar;
    }

    @Override // com.baidu.tieba.util.k, android.text.style.ClickableSpan
    public void onClick(View view) {
        String str;
        str = this.akh.text;
        hC(str);
    }
}
