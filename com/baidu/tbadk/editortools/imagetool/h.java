package com.baidu.tbadk.editortools.imagetool;

import android.view.View;
import android.widget.FrameLayout;
import com.baidu.tbadk.editortools.imagetool.MultiImgToolView;
/* loaded from: classes.dex */
class h implements View.OnClickListener {
    final /* synthetic */ MultiImgToolView.b aqb;
    private final /* synthetic */ FrameLayout aqd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(MultiImgToolView.b bVar, FrameLayout frameLayout) {
        this.aqb = bVar;
        this.aqd = frameLayout;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        MultiImgToolView.a aVar;
        MultiImgToolView.a aVar2;
        aVar = this.aqb.apZ;
        if (aVar != null) {
            aVar2 = this.aqb.apZ;
            aVar2.t(this.aqd);
        }
    }
}
