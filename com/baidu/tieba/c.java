package com.baidu.tieba;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.widget.TbImageView;
/* loaded from: classes.dex */
class c implements com.baidu.tbadk.widget.p {
    private final /* synthetic */ Activity Ft;
    private final /* synthetic */ TbImageView acA;
    private final /* synthetic */ View acB;
    final /* synthetic */ a acz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar, TbImageView tbImageView, View view, Activity activity) {
        this.acz = aVar;
        this.acA = tbImageView;
        this.acB = view;
        this.Ft = activity;
    }

    @Override // com.baidu.tbadk.widget.p
    public void onCancel() {
    }

    @Override // com.baidu.tbadk.widget.p
    public void q(String str, boolean z) {
        if (this.acA.getParent() == null && (this.acB instanceof ViewGroup)) {
            ((ViewGroup) this.acB).addView(this.acA);
        }
        com.baidu.tbadk.core.i.l(this.Ft, "lpage_tg_pic");
    }
}
