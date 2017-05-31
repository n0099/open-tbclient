package com.baidu.tbadk.editortools.imagetool;

import android.view.View;
import android.widget.FrameLayout;
import com.baidu.tbadk.editortools.imagetool.MultiImgToolView;
/* loaded from: classes.dex */
class h implements View.OnClickListener {
    final /* synthetic */ MultiImgToolView.b aAb;
    private final /* synthetic */ FrameLayout aAd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(MultiImgToolView.b bVar, FrameLayout frameLayout) {
        this.aAb = bVar;
        this.aAd = frameLayout;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        MultiImgToolView.a aVar;
        MultiImgToolView.a aVar2;
        aVar = this.aAb.azZ;
        if (aVar != null) {
            aVar2 = this.aAb.azZ;
            aVar2.F(this.aAd);
        }
    }
}
