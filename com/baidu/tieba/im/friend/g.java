package com.baidu.tieba.im.friend;

import android.widget.ImageView;
import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class g implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ f a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar) {
        this.a = fVar;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public final void a(com.baidu.adp.widget.ImageView.b bVar, String str, boolean z) {
        BdListView bdListView;
        BdListView bdListView2;
        if (bVar != null) {
            bdListView = this.a.g;
            ImageView imageView = (ImageView) bdListView.findViewWithTag(str);
            while (imageView != null) {
                imageView.setTag(null);
                imageView.setImageBitmap(bVar.h());
                bdListView2 = this.a.g;
                imageView = (ImageView) bdListView2.findViewWithTag(str);
            }
        }
    }
}
