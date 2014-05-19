package com.baidu.tieba.im.randchat;

import android.view.View;
import com.baidu.tbadk.core.view.HeadImageView;
/* loaded from: classes.dex */
class d implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ RingLayoutView a;
    private final /* synthetic */ e b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(RingLayoutView ringLayoutView, e eVar) {
        this.a = ringLayoutView;
        this.b = eVar;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        View findViewWithTag;
        if (aVar != null && (findViewWithTag = this.a.findViewWithTag(str)) != null && (findViewWithTag instanceof HeadImageView)) {
            ((HeadImageView) findViewWithTag).setImageBitmap(aVar.h());
            if (this.b != null) {
                this.b.a(str);
            }
        }
    }
}
