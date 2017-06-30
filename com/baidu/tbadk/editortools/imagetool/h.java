package com.baidu.tbadk.editortools.imagetool;

import android.view.View;
import android.widget.FrameLayout;
import com.baidu.tbadk.editortools.imagetool.MultiImgToolView;
/* loaded from: classes.dex */
class h implements View.OnClickListener {
    final /* synthetic */ MultiImgToolView.b aBe;
    private final /* synthetic */ FrameLayout aBg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(MultiImgToolView.b bVar, FrameLayout frameLayout) {
        this.aBe = bVar;
        this.aBg = frameLayout;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        MultiImgToolView.a aVar;
        MultiImgToolView.a aVar2;
        aVar = this.aBe.aBc;
        if (aVar != null) {
            aVar2 = this.aBe.aBc;
            aVar2.G(this.aBg);
        }
    }
}
