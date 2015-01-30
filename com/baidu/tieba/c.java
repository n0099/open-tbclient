package com.baidu.tieba;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.widget.TbImageView;
/* loaded from: classes.dex */
class c implements com.baidu.tbadk.widget.p {
    private final /* synthetic */ Activity JW;
    final /* synthetic */ a akT;
    private final /* synthetic */ TbImageView akU;
    private final /* synthetic */ View akV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar, TbImageView tbImageView, View view, Activity activity) {
        this.akT = aVar;
        this.akU = tbImageView;
        this.akV = view;
        this.JW = activity;
    }

    @Override // com.baidu.tbadk.widget.p
    public void onCancel() {
    }

    @Override // com.baidu.tbadk.widget.p
    public void onComplete(String str, boolean z) {
        if (this.akU.getParent() == null && (this.akV instanceof ViewGroup)) {
            ((ViewGroup) this.akV).addView(this.akU);
            com.baidu.tbadk.performanceLog.ad.zC().A(System.currentTimeMillis());
        }
        com.baidu.tbadk.core.i.A(this.JW, "lpage_tg_pic");
    }
}
