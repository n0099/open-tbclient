package com.baidu.tieba.home;

import android.view.View;
import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements com.baidu.tbadk.a.d {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ s f1195a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(s sVar) {
        this.f1195a = sVar;
    }

    @Override // com.baidu.tbadk.a.d
    public void a(com.baidu.adp.widget.a.b bVar, String str, boolean z) {
        BdListView bdListView;
        if (bVar != null) {
            bdListView = this.f1195a.c;
            View findViewWithTag = bdListView.findViewWithTag(str);
            if (findViewWithTag != null) {
                findViewWithTag.invalidate();
            }
        }
    }
}
