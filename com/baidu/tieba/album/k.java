package com.baidu.tieba.album;

import android.view.ViewGroup;
import com.baidu.tieba.view.HeadImageView;
/* loaded from: classes.dex */
class k implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ j a;
    private final /* synthetic */ ViewGroup b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar, ViewGroup viewGroup) {
        this.a = jVar;
        this.b = viewGroup;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public void a(com.baidu.adp.widget.ImageView.b bVar, String str, boolean z) {
        HeadImageView headImageView = (HeadImageView) this.b.findViewWithTag(str);
        if (headImageView != null && bVar != null) {
            headImageView.invalidate();
        }
    }
}
