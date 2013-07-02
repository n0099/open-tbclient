package com.baidu.tieba.chat;

import android.widget.ImageView;
import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag implements com.baidu.tbadk.a.d {
    final /* synthetic */ ad a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(ad adVar) {
        this.a = adVar;
    }

    @Override // com.baidu.tbadk.a.d
    public void a(com.baidu.adp.widget.a.b bVar, String str, boolean z) {
        BdListView bdListView;
        BdListView bdListView2;
        if (bVar != null) {
            bdListView = this.a.g;
            ImageView imageView = (ImageView) bdListView.findViewWithTag(str);
            while (imageView != null) {
                imageView.setTag(null);
                bVar.a(imageView);
                bdListView2 = this.a.g;
                imageView = (ImageView) bdListView2.findViewWithTag(str);
            }
        }
    }
}
