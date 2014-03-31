package com.baidu.tieba.editortool;

import android.view.ViewGroup;
import com.baidu.tbadk.widget.TbImageView;
/* loaded from: classes.dex */
final class p implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ o a;
    private final /* synthetic */ ViewGroup b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(o oVar, ViewGroup viewGroup) {
        this.a = oVar;
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
