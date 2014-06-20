package com.baidu.tieba.im.chat.officialBar;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.core.util.bk;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bd implements View.OnClickListener {
    final /* synthetic */ bb a;
    private final /* synthetic */ t b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bd(bb bbVar, t tVar) {
        this.a = bbVar;
        this.b = tVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        bk a = bk.a();
        context = this.a.a;
        a.a(context, new String[]{this.b.d});
    }
}
