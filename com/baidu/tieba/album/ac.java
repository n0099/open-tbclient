package com.baidu.tieba.album;

import android.view.ViewGroup;
import com.baidu.tbadk.core.view.HeadImageView;
/* loaded from: classes.dex */
class ac implements com.baidu.tbadk.imageManager.d {
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
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        HeadImageView headImageView = (HeadImageView) this.b.findViewWithTag(str);
        if (headImageView != null && aVar != null) {
            headImageView.invalidate();
        } else {
            this.c.a = false;
        }
    }
}
