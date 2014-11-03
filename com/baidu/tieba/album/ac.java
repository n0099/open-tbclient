package com.baidu.tieba.album;

import android.view.ViewGroup;
import com.baidu.tbadk.core.view.HeadImageView;
/* loaded from: classes.dex */
class ac implements com.baidu.tbadk.imageManager.d {
    private final /* synthetic */ ViewGroup ahT;
    final /* synthetic */ ab aiC;
    private final /* synthetic */ af aiD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(ab abVar, ViewGroup viewGroup, af afVar) {
        this.aiC = abVar;
        this.ahT = viewGroup;
        this.aiD = afVar;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        HeadImageView headImageView = (HeadImageView) this.ahT.findViewWithTag(str);
        if (headImageView != null && aVar != null) {
            headImageView.invalidate();
        } else {
            this.aiD.aiH = false;
        }
    }
}
