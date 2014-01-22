package com.baidu.tieba.im.randchat;

import android.view.View;
import com.baidu.tieba.view.HeadImageView;
/* loaded from: classes.dex */
class d implements com.baidu.tbadk.imageManager.c {
    final /* synthetic */ e a;
    final /* synthetic */ RingLayoutView b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(RingLayoutView ringLayoutView, e eVar) {
        this.b = ringLayoutView;
        this.a = eVar;
    }

    @Override // com.baidu.tbadk.imageManager.c
    public void a(com.baidu.adp.widget.ImageView.d dVar, String str, boolean z) {
        View findViewWithTag;
        if (dVar != null && (findViewWithTag = this.b.findViewWithTag(str)) != null && (findViewWithTag instanceof HeadImageView)) {
            ((HeadImageView) findViewWithTag).setImageBitmap(dVar.h());
            if (this.a != null) {
                this.a.a(str);
            }
        }
    }
}
