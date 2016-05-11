package com.baidu.tbadk.editortools.imagetool;

import android.view.View;
import android.widget.FrameLayout;
import com.baidu.tbadk.editortools.imagetool.MultiImgToolView;
/* loaded from: classes.dex */
class h implements View.OnClickListener {
    final /* synthetic */ MultiImgToolView.b aqT;
    private final /* synthetic */ FrameLayout aqV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(MultiImgToolView.b bVar, FrameLayout frameLayout) {
        this.aqT = bVar;
        this.aqV = frameLayout;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        MultiImgToolView.a aVar;
        MultiImgToolView.a aVar2;
        aVar = this.aqT.aqR;
        if (aVar != null) {
            aVar2 = this.aqT.aqR;
            aVar2.J(this.aqV);
        }
    }
}
