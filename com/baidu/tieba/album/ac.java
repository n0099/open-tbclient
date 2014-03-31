package com.baidu.tieba.album;

import android.view.ViewGroup;
import com.baidu.tbadk.core.view.HeadImageView;
/* loaded from: classes.dex */
final class ac implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ ab a;
    private final /* synthetic */ ViewGroup b;
    private final /* synthetic */ af c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(ab abVar, ViewGroup viewGroup, af afVar) {
        this.a = abVar;
        this.b = viewGroup;
        this.c = afVar;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public final void a(com.baidu.adp.widget.ImageView.b bVar, String str, boolean z) {
        HeadImageView headImageView = (HeadImageView) this.b.findViewWithTag(str);
        if (headImageView != null && bVar != null) {
            headImageView.invalidate();
        } else {
            this.c.a = false;
        }
    }
}
