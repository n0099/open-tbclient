package com.baidu.tieba.im.groupUpdates;

import android.view.View;
import android.widget.ImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements View.OnClickListener {
    final /* synthetic */ i bcu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(i iVar) {
        this.bcu = iVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        UpdatesActivity updatesActivity;
        UpdatesActivity updatesActivity2;
        View view2;
        UpdatesItemData updatesItemData;
        ImageView imageView;
        updatesActivity = this.bcu.bck;
        if (updatesActivity.Ph()) {
            imageView = this.bcu.bcq;
            imageView.performClick();
            return;
        }
        updatesActivity2 = this.bcu.bck;
        view2 = this.bcu.bcl;
        updatesItemData = this.bcu.bct;
        updatesActivity2.a(view2, 101, 0, 0L, updatesItemData);
    }
}
