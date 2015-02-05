package com.baidu.tieba.im.groupUpdates;

import android.view.View;
import android.widget.ImageView;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tieba.im.data.UpdatesItemData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements View.OnClickListener {
    final /* synthetic */ i bhr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(i iVar) {
        this.bhr = iVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        UpdatesActivity updatesActivity;
        UpdatesActivity updatesActivity2;
        View view2;
        UpdatesItemData updatesItemData;
        ImageView imageView;
        updatesActivity = this.bhr.bhj;
        if (updatesActivity.isEditMode()) {
            imageView = this.bhr.bho;
            imageView.performClick();
            return;
        }
        updatesActivity2 = this.bhr.bhj;
        view2 = this.bhr.awv;
        updatesItemData = this.bhr.data;
        updatesActivity2.onItemViewClick(view2, PersonInfoActivityConfig.REQUSET_CHANGE, 0, 0L, updatesItemData);
    }
}
