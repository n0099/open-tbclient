package com.baidu.tbadk.editortools.imagetool;

import android.view.View;
import android.widget.FrameLayout;
import com.baidu.tbadk.editortools.imagetool.MultiImgToolView;
/* loaded from: classes.dex */
class h implements View.OnClickListener {
    private final /* synthetic */ FrameLayout asA;
    final /* synthetic */ MultiImgToolView.b asy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(MultiImgToolView.b bVar, FrameLayout frameLayout) {
        this.asy = bVar;
        this.asA = frameLayout;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        MultiImgToolView.a aVar;
        MultiImgToolView.a aVar2;
        aVar = this.asy.asw;
        if (aVar != null) {
            aVar2 = this.asy.asw;
            aVar2.I(this.asA);
        }
    }
}
