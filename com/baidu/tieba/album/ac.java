package com.baidu.tieba.album;

import android.view.ViewGroup;
import com.baidu.tbadk.core.view.HeadImageView;
/* loaded from: classes.dex */
class ac implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ ab apP;
    private final /* synthetic */ af apQ;
    private final /* synthetic */ ViewGroup aph;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(ab abVar, ViewGroup viewGroup, af afVar) {
        this.apP = abVar;
        this.aph = viewGroup;
        this.apQ = afVar;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        HeadImageView headImageView = (HeadImageView) this.aph.findViewWithTag(str);
        if (headImageView != null && aVar != null) {
            headImageView.invalidate();
        } else {
            this.apQ.apU = false;
        }
    }
}
