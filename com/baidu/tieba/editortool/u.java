package com.baidu.tieba.editortool;

import android.view.ViewGroup;
import com.baidu.tbadk.widget.TbImageView;
/* loaded from: classes.dex */
class u implements com.baidu.tbadk.imageManager.d {
    private final /* synthetic */ ViewGroup ahK;
    final /* synthetic */ t aqY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(t tVar, ViewGroup viewGroup) {
        this.aqY = tVar;
        this.ahK = viewGroup;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        TbImageView tbImageView = (TbImageView) this.ahK.findViewWithTag(str);
        if (tbImageView != null && aVar != null) {
            tbImageView.invalidate();
        }
    }
}
