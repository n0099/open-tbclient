package com.baidu.tieba;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.widget.TbImageView;
/* loaded from: classes.dex */
class c implements com.baidu.tbadk.widget.n {
    private final /* synthetic */ Activity VH;
    private final /* synthetic */ View atA;
    final /* synthetic */ a aty;
    private final /* synthetic */ TbImageView atz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar, TbImageView tbImageView, View view, Activity activity) {
        this.aty = aVar;
        this.atz = tbImageView;
        this.atA = view;
        this.VH = activity;
    }

    @Override // com.baidu.tbadk.widget.n
    public void onCancel() {
    }

    @Override // com.baidu.tbadk.widget.n
    public void onComplete(String str, boolean z) {
        if (this.atz.getParent() == null && (this.atA instanceof ViewGroup)) {
            ((ViewGroup) this.atA).addView(this.atz);
            com.baidu.tbadk.performanceLog.ai.CW().A(System.currentTimeMillis());
        }
        com.baidu.tbadk.core.k.A(this.VH, "lpage_tg_pic");
    }
}
