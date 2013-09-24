package com.baidu.tieba.chat;

import android.widget.ImageView;
import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class af implements com.baidu.tbadk.a.d {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ac f957a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(ac acVar) {
        this.f957a = acVar;
    }

    @Override // com.baidu.tbadk.a.d
    public void a(com.baidu.adp.widget.a.c cVar, String str, boolean z) {
        BdListView bdListView;
        BdListView bdListView2;
        if (cVar != null) {
            bdListView = this.f957a.g;
            ImageView imageView = (ImageView) bdListView.findViewWithTag(str);
            while (imageView != null) {
                imageView.setTag(null);
                cVar.a(imageView);
                bdListView2 = this.f957a.g;
                imageView = (ImageView) bdListView2.findViewWithTag(str);
            }
        }
    }
}
