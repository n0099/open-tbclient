package com.baidu.tieba;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.widget.TbImageView;
/* loaded from: classes.dex */
class c implements com.baidu.tbadk.widget.p {
    private final /* synthetic */ Activity Fu;
    final /* synthetic */ a acE;
    private final /* synthetic */ TbImageView acF;
    private final /* synthetic */ View acG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar, TbImageView tbImageView, View view, Activity activity) {
        this.acE = aVar;
        this.acF = tbImageView;
        this.acG = view;
        this.Fu = activity;
    }

    @Override // com.baidu.tbadk.widget.p
    public void onCancel() {
    }

    @Override // com.baidu.tbadk.widget.p
    public void q(String str, boolean z) {
        if (this.acF.getParent() == null && (this.acG instanceof ViewGroup)) {
            ((ViewGroup) this.acG).addView(this.acF);
        }
        com.baidu.tbadk.core.j.l(this.Fu, "lpage_tg_pic");
    }
}
