package com.baidu.tieba.im.groupUpdates;

import android.view.View;
import android.widget.ImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements View.OnClickListener {
    final /* synthetic */ i a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(i iVar) {
        this.a = iVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        UpdatesActivity updatesActivity;
        UpdatesActivity updatesActivity2;
        View view2;
        UpdatesItemData updatesItemData;
        ImageView imageView;
        updatesActivity = this.a.k;
        if (updatesActivity.b()) {
            imageView = this.a.h;
            imageView.performClick();
            return;
        }
        updatesActivity2 = this.a.k;
        view2 = this.a.b;
        updatesItemData = this.a.l;
        updatesActivity2.a(view2, 101, 0, 0L, updatesItemData);
    }
}
