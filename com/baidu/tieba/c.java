package com.baidu.tieba;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.performanceLog.ad;
import com.baidu.tbadk.widget.TbImageView;
/* loaded from: classes.dex */
class c implements com.baidu.tbadk.widget.p {
    private final /* synthetic */ Activity JD;
    final /* synthetic */ a akp;
    private final /* synthetic */ TbImageView akq;
    private final /* synthetic */ View akr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar, TbImageView tbImageView, View view, Activity activity) {
        this.akp = aVar;
        this.akq = tbImageView;
        this.akr = view;
        this.JD = activity;
    }

    @Override // com.baidu.tbadk.widget.p
    public void onCancel() {
    }

    @Override // com.baidu.tbadk.widget.p
    public void onComplete(String str, boolean z) {
        if (this.akq.getParent() == null && (this.akr instanceof ViewGroup)) {
            ((ViewGroup) this.akr).addView(this.akq);
            ad.zl().A(System.currentTimeMillis());
        }
        com.baidu.tbadk.core.i.B(this.JD, "lpage_tg_pic");
    }
}
