package com.baidu.tieba.im.groupUpdates;

import android.view.View;
import com.baidu.browser.webpool.BdWebPoolView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements View.OnLongClickListener {
    final /* synthetic */ f a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(f fVar) {
        this.a = fVar;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        UpdatesActivity updatesActivity;
        View view2;
        UpdatesItemData updatesItemData;
        updatesActivity = this.a.l;
        view2 = this.a.c;
        updatesItemData = this.a.m;
        updatesActivity.b(view2, BdWebPoolView.DELAYED_TIME, 0, 0L, updatesItemData);
        return true;
    }
}
