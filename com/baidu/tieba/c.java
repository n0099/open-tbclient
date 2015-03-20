package com.baidu.tieba;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.widget.TbImageView;
/* loaded from: classes.dex */
class c implements com.baidu.tbadk.widget.n {
    private final /* synthetic */ Activity VF;
    final /* synthetic */ a atq;
    private final /* synthetic */ TbImageView atr;
    private final /* synthetic */ View ats;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar, TbImageView tbImageView, View view, Activity activity) {
        this.atq = aVar;
        this.atr = tbImageView;
        this.ats = view;
        this.VF = activity;
    }

    @Override // com.baidu.tbadk.widget.n
    public void onCancel() {
    }

    @Override // com.baidu.tbadk.widget.n
    public void onComplete(String str, boolean z) {
        if (this.atr.getParent() == null && (this.ats instanceof ViewGroup)) {
            ((ViewGroup) this.ats).addView(this.atr);
            com.baidu.tbadk.performanceLog.ai.CQ().A(System.currentTimeMillis());
        }
        com.baidu.tbadk.core.k.A(this.VF, "lpage_tg_pic");
    }
}
