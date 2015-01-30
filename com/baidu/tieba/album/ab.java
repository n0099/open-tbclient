package com.baidu.tieba.album;

import android.view.ViewGroup;
import com.baidu.tbadk.core.view.HeadImageView;
/* loaded from: classes.dex */
class ab implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ aa aqQ;
    private final /* synthetic */ af aqR;
    private final /* synthetic */ ViewGroup aqh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(aa aaVar, ViewGroup viewGroup, af afVar) {
        this.aqQ = aaVar;
        this.aqh = viewGroup;
        this.aqR = afVar;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        HeadImageView headImageView = (HeadImageView) this.aqh.findViewWithTag(str);
        if (headImageView != null && aVar != null) {
            headImageView.invalidate();
        } else {
            this.aqR.aqV = false;
        }
    }
}
