package com.baidu.tieba.im.groupUpdates;

import android.view.View;
import com.baidu.lightapp.plugin.videoplayer.coreplayer.Constants;
import com.baidu.tieba.im.data.UpdatesItemData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements View.OnLongClickListener {
    final /* synthetic */ i bga;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(i iVar) {
        this.bga = iVar;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        UpdatesActivity updatesActivity;
        View view2;
        UpdatesItemData updatesItemData;
        updatesActivity = this.bga.bfS;
        view2 = this.bga.avy;
        updatesItemData = this.bga.data;
        updatesActivity.onItemViewLongClick(view2, Constants.MEDIA_INFO, 0, 0L, updatesItemData);
        return true;
    }
}
