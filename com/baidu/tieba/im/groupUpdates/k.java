package com.baidu.tieba.im.groupUpdates;

import android.view.View;
import android.widget.ImageView;
import com.baidu.tieba.im.data.UpdatesItemData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements View.OnClickListener {
    final /* synthetic */ i bga;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(i iVar) {
        this.bga = iVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        UpdatesActivity updatesActivity;
        UpdatesActivity updatesActivity2;
        View view2;
        UpdatesItemData updatesItemData;
        ImageView imageView;
        updatesActivity = this.bga.bfS;
        if (updatesActivity.isEditMode()) {
            imageView = this.bga.bfX;
            imageView.performClick();
            return;
        }
        updatesActivity2 = this.bga.bfS;
        view2 = this.bga.avy;
        updatesItemData = this.bga.data;
        updatesActivity2.onItemViewClick(view2, 101, 0, 0L, updatesItemData);
    }
}
