package com.baidu.tieba.im.groupUpdates;

import android.view.View;
import android.widget.ImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements View.OnClickListener {
    final /* synthetic */ i bcg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(i iVar) {
        this.bcg = iVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        UpdatesActivity updatesActivity;
        UpdatesActivity updatesActivity2;
        View view2;
        UpdatesItemData updatesItemData;
        ImageView imageView;
        updatesActivity = this.bcg.bbW;
        if (updatesActivity.Pe()) {
            imageView = this.bcg.bcc;
            imageView.performClick();
            return;
        }
        updatesActivity2 = this.bcg.bbW;
        view2 = this.bcg.bbX;
        updatesItemData = this.bcg.bcf;
        updatesActivity2.a(view2, 101, 0, 0L, updatesItemData);
    }
}
