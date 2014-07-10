package com.baidu.tieba;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.widget.TbImageView;
/* loaded from: classes.dex */
class c implements com.baidu.tbadk.widget.k {
    final /* synthetic */ a a;
    private final /* synthetic */ View b;
    private final /* synthetic */ TbImageView c;
    private final /* synthetic */ Activity d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar, View view, TbImageView tbImageView, Activity activity) {
        this.a = aVar;
        this.b = view;
        this.c = tbImageView;
        this.d = activity;
    }

    @Override // com.baidu.tbadk.widget.k
    public void a() {
    }

    @Override // com.baidu.tbadk.widget.k
    public void a(String str, boolean z) {
        if (this.b instanceof ViewGroup) {
            ((ViewGroup) this.b).addView(this.c);
        }
        com.baidu.tbadk.core.f.a(this.d, "lpage_tg_pic");
    }
}
