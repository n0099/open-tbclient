package com.baidu.tbadk.editortools.imagetool;

import android.view.ViewGroup;
import com.baidu.tbadk.editortools.imagetool.MultiImgToolView;
import com.baidu.tbadk.widget.TbImageView;
/* loaded from: classes.dex */
class f implements com.baidu.tbadk.imageManager.b {
    final /* synthetic */ MultiImgToolView.b arY;
    private final /* synthetic */ ViewGroup arZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(MultiImgToolView.b bVar, ViewGroup viewGroup) {
        this.arY = bVar;
        this.arZ = viewGroup;
    }

    @Override // com.baidu.tbadk.imageManager.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        TbImageView tbImageView = (TbImageView) this.arZ.findViewWithTag(str);
        if (tbImageView != null && aVar != null) {
            tbImageView.invalidate();
        }
    }
}
