package com.baidu.tieba.im.groupUpdates;

import android.view.View;
import android.widget.ImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ f f1770a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(f fVar) {
        this.f1770a = fVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        UpdatesActivity updatesActivity;
        UpdatesActivity updatesActivity2;
        View view2;
        UpdatesItemData updatesItemData;
        ImageView imageView;
        updatesActivity = this.f1770a.l;
        if (updatesActivity.b()) {
            imageView = this.f1770a.i;
            imageView.performClick();
            return;
        }
        updatesActivity2 = this.f1770a.l;
        view2 = this.f1770a.c;
        updatesItemData = this.f1770a.m;
        updatesActivity2.a(view2, 101, 0, 0L, updatesItemData);
    }
}
