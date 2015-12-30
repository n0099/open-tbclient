package com.baidu.tbadk.editortools.imagetool;

import android.view.View;
import android.widget.FrameLayout;
import com.baidu.tbadk.editortools.imagetool.MultiImgToolView;
/* loaded from: classes.dex */
class h implements View.OnClickListener {
    final /* synthetic */ MultiImgToolView.b atC;
    private final /* synthetic */ FrameLayout atE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(MultiImgToolView.b bVar, FrameLayout frameLayout) {
        this.atC = bVar;
        this.atE = frameLayout;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        MultiImgToolView.a aVar;
        MultiImgToolView.a aVar2;
        aVar = this.atC.atA;
        if (aVar != null) {
            aVar2 = this.atC.atA;
            aVar2.t(this.atE);
        }
    }
}
