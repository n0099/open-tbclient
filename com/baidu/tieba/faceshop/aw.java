package com.baidu.tieba.faceshop;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.widget.TbImageView;
/* loaded from: classes.dex */
final class aw implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ av a;
    private final /* synthetic */ ViewGroup b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(av avVar, ViewGroup viewGroup) {
        this.a = avVar;
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
