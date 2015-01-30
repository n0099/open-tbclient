package com.baidu.tieba.im.groupUpdates;

import android.view.View;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tieba.im.data.UpdatesItemData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements View.OnClickListener {
    final /* synthetic */ i bhs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(i iVar) {
        this.bhs = iVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        UpdatesActivity updatesActivity;
        View view2;
        UpdatesItemData updatesItemData;
        updatesActivity = this.bhs.bhk;
        view2 = this.bhs.awy;
        updatesItemData = this.bhs.data;
        updatesActivity.onItemViewClick(view2, PersonInfoActivityConfig.REQUSET_CHANGE, 0, 0L, updatesItemData);
    }
}
