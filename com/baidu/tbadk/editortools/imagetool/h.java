package com.baidu.tbadk.editortools.imagetool;

import android.view.View;
import android.widget.FrameLayout;
import com.baidu.tbadk.editortools.imagetool.MultiImgToolView;
/* loaded from: classes.dex */
class h implements View.OnClickListener {
    private final /* synthetic */ FrameLayout avB;
    final /* synthetic */ MultiImgToolView.b avz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(MultiImgToolView.b bVar, FrameLayout frameLayout) {
        this.avz = bVar;
        this.avB = frameLayout;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        MultiImgToolView.a aVar;
        MultiImgToolView.a aVar2;
        aVar = this.avz.avx;
        if (aVar != null) {
            aVar2 = this.avz.avx;
            aVar2.K(this.avB);
        }
    }
}
