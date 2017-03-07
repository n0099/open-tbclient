package com.baidu.tbadk.editortools.imagetool;

import android.view.View;
import android.widget.FrameLayout;
import com.baidu.tbadk.editortools.imagetool.MultiImgToolView;
/* loaded from: classes.dex */
class h implements View.OnClickListener {
    private final /* synthetic */ FrameLayout aAb;
    final /* synthetic */ MultiImgToolView.b azZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(MultiImgToolView.b bVar, FrameLayout frameLayout) {
        this.azZ = bVar;
        this.aAb = frameLayout;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        MultiImgToolView.a aVar;
        MultiImgToolView.a aVar2;
        aVar = this.azZ.azX;
        if (aVar != null) {
            aVar2 = this.azZ.azX;
            aVar2.G(this.aAb);
        }
    }
}
