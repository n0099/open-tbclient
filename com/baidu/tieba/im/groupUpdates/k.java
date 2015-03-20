package com.baidu.tieba.im.groupUpdates;

import android.view.View;
import android.widget.ImageView;
import com.baidu.tieba.im.data.UpdatesItemData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements View.OnClickListener {
    final /* synthetic */ i biH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(i iVar) {
        this.biH = iVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        UpdatesActivity updatesActivity;
        UpdatesActivity updatesActivity2;
        View view2;
        UpdatesItemData updatesItemData;
        ImageView imageView;
        updatesActivity = this.biH.biz;
        if (updatesActivity.isEditMode()) {
            imageView = this.biH.biE;
            imageView.performClick();
            return;
        }
        updatesActivity2 = this.biH.biz;
        view2 = this.biH.aCi;
        updatesItemData = this.biH.data;
        updatesActivity2.onItemViewClick(view2, 101, 0, 0L, updatesItemData);
    }
}
