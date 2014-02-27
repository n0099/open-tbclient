package com.baidu.tieba.editortool;

import android.view.ViewGroup;
import com.baidu.tbadk.widget.TbImageView;
/* loaded from: classes.dex */
final class h implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ g a;
    private final /* synthetic */ ViewGroup b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar, ViewGroup viewGroup) {
        this.a = gVar;
        this.b = viewGroup;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public final void a(com.baidu.adp.widget.ImageView.b bVar, String str, boolean z) {
        TbImageView tbImageView = (TbImageView) this.b.findViewWithTag(str);
        if (tbImageView != null && bVar != null) {
            tbImageView.invalidate();
        }
    }
}
