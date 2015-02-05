package com.baidu.tieba.album;

import android.view.ViewGroup;
import com.baidu.tbadk.core.view.HeadImageView;
/* loaded from: classes.dex */
class ab implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ aa aqN;
    private final /* synthetic */ af aqO;
    private final /* synthetic */ ViewGroup aqe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(aa aaVar, ViewGroup viewGroup, af afVar) {
        this.aqN = aaVar;
        this.aqe = viewGroup;
        this.aqO = afVar;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        HeadImageView headImageView = (HeadImageView) this.aqe.findViewWithTag(str);
        if (headImageView != null && aVar != null) {
            headImageView.invalidate();
        } else {
            this.aqO.aqS = false;
        }
    }
}
