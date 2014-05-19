package com.baidu.tieba.im.groupUpdates;

import android.view.View;
import com.baidu.lightapp.plugin.videoplayer.coreplayer.Constants;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements View.OnLongClickListener {
    final /* synthetic */ i a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(i iVar) {
        this.a = iVar;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        UpdatesActivity updatesActivity;
        View view2;
        UpdatesItemData updatesItemData;
        updatesActivity = this.a.k;
        view2 = this.a.b;
        updatesItemData = this.a.l;
        updatesActivity.b(view2, Constants.MEDIA_INFO, 0, 0L, updatesItemData);
        return true;
    }
}
