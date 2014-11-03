package com.baidu.tieba.im.groupUpdates;

import android.view.View;
import com.baidu.lightapp.plugin.videoplayer.coreplayer.Constants;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements View.OnLongClickListener {
    final /* synthetic */ i bcu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(i iVar) {
        this.bcu = iVar;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        UpdatesActivity updatesActivity;
        View view2;
        UpdatesItemData updatesItemData;
        updatesActivity = this.bcu.bck;
        view2 = this.bcu.bcl;
        updatesItemData = this.bcu.bct;
        updatesActivity.b(view2, Constants.MEDIA_INFO, 0, 0L, updatesItemData);
        return true;
    }
}
