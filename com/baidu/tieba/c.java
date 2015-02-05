package com.baidu.tieba;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.widget.TbImageView;
/* loaded from: classes.dex */
class c implements com.baidu.tbadk.widget.p {
    private final /* synthetic */ Activity JT;
    final /* synthetic */ a akQ;
    private final /* synthetic */ TbImageView akR;
    private final /* synthetic */ View akS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar, TbImageView tbImageView, View view, Activity activity) {
        this.akQ = aVar;
        this.akR = tbImageView;
        this.akS = view;
        this.JT = activity;
    }

    @Override // com.baidu.tbadk.widget.p
    public void onCancel() {
    }

    @Override // com.baidu.tbadk.widget.p
    public void onComplete(String str, boolean z) {
        if (this.akR.getParent() == null && (this.akS instanceof ViewGroup)) {
            ((ViewGroup) this.akS).addView(this.akR);
            com.baidu.tbadk.performanceLog.ad.zw().A(System.currentTimeMillis());
        }
        com.baidu.tbadk.core.i.A(this.JT, "lpage_tg_pic");
    }
}
