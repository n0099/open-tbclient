package com.baidu.tieba.chat;

import android.widget.ImageView;
import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag implements com.baidu.tbadk.a.d {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ad f940a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(ad adVar) {
        this.f940a = adVar;
    }

    @Override // com.baidu.tbadk.a.d
    public void a(com.baidu.adp.widget.a.b bVar, String str, boolean z) {
        BdListView bdListView;
        BdListView bdListView2;
        if (bVar != null) {
            bdListView = this.f940a.g;
            ImageView imageView = (ImageView) bdListView.findViewWithTag(str);
            while (imageView != null) {
                imageView.setTag(null);
                bVar.a(imageView);
                bdListView2 = this.f940a.g;
                imageView = (ImageView) bdListView2.findViewWithTag(str);
            }
        }
    }
}
