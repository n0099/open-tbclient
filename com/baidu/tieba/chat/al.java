package com.baidu.tieba.chat;

import android.widget.ImageView;
import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al implements com.baidu.tbadk.imageManager.c {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ai f1128a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(ai aiVar) {
        this.f1128a = aiVar;
    }

    @Override // com.baidu.tbadk.imageManager.c
    public void a(com.baidu.adp.widget.ImageView.e eVar, String str, boolean z) {
        BdListView bdListView;
        BdListView bdListView2;
        if (eVar != null) {
            bdListView = this.f1128a.g;
            ImageView imageView = (ImageView) bdListView.findViewWithTag(str);
            while (imageView != null) {
                imageView.setTag(null);
                eVar.a(imageView);
                bdListView2 = this.f1128a.g;
                imageView = (ImageView) bdListView2.findViewWithTag(str);
            }
        }
    }
}
