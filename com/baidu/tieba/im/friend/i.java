package com.baidu.tieba.im.friend;

import android.widget.ImageView;
import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ h a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.a = hVar;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        BdListView bdListView;
        BdListView bdListView2;
        if (aVar != null) {
            bdListView = this.a.d;
            ImageView imageView = (ImageView) bdListView.findViewWithTag(str);
            while (imageView != null) {
                imageView.setTag(null);
                imageView.setImageBitmap(aVar.h());
                bdListView2 = this.a.d;
                imageView = (ImageView) bdListView2.findViewWithTag(str);
            }
        }
    }
}
