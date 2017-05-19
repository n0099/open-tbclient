package com.baidu.tbadk.editortools.imagetool;

import android.view.ViewGroup;
import com.baidu.tbadk.editortools.imagetool.MultiImgToolView;
import com.baidu.tbadk.widget.TbImageView;
/* loaded from: classes.dex */
class f implements com.baidu.tbadk.imageManager.b {
    final /* synthetic */ MultiImgToolView.b aAp;
    private final /* synthetic */ ViewGroup aAq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(MultiImgToolView.b bVar, ViewGroup viewGroup) {
        this.aAp = bVar;
        this.aAq = viewGroup;
    }

    @Override // com.baidu.tbadk.imageManager.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        TbImageView tbImageView = (TbImageView) this.aAq.findViewWithTag(str);
        if (tbImageView != null && aVar != null) {
            tbImageView.invalidate();
        }
    }
}
