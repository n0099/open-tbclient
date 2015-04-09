package com.baidu.tieba.im.groupUpdates;

import android.view.View;
import android.widget.ImageView;
import com.baidu.tieba.im.data.UpdatesItemData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements View.OnClickListener {
    final /* synthetic */ i biX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(i iVar) {
        this.biX = iVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        UpdatesActivity updatesActivity;
        UpdatesActivity updatesActivity2;
        View view2;
        UpdatesItemData updatesItemData;
        ImageView imageView;
        updatesActivity = this.biX.biP;
        if (updatesActivity.isEditMode()) {
            imageView = this.biX.biU;
            imageView.performClick();
            return;
        }
        updatesActivity2 = this.biX.biP;
        view2 = this.biX.aCq;
        updatesItemData = this.biX.data;
        updatesActivity2.onItemViewClick(view2, 101, 0, 0L, updatesItemData);
    }
}
