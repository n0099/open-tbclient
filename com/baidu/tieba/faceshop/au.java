package com.baidu.tieba.faceshop;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.widget.TbImageView;
/* loaded from: classes.dex */
final class au implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ at a;
    private final /* synthetic */ ViewGroup b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(at atVar, ViewGroup viewGroup) {
        this.a = atVar;
        this.b = viewGroup;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public final void a(com.baidu.adp.widget.ImageView.b bVar, String str, boolean z) {
        View findViewWithTag = this.b.findViewWithTag(str);
        if (bVar != null && findViewWithTag != null && (findViewWithTag instanceof TbImageView)) {
            TbImageView tbImageView = (TbImageView) findViewWithTag;
            bVar.a(tbImageView);
            tbImageView.setTag(null);
        }
    }
}
