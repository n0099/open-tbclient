package com.baidu.tieba.im.live.livenotify;

import android.view.View;
import com.baidu.tieba.im.groupUpdates.UpdatesItemData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements View.OnClickListener {
    final /* synthetic */ k a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(k kVar) {
        this.a = kVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        LiveNotifyActivity liveNotifyActivity;
        UpdatesItemData updatesItemData;
        view.setSelected(!view.isSelected());
        liveNotifyActivity = this.a.b;
        boolean isSelected = view.isSelected();
        updatesItemData = this.a.c;
        liveNotifyActivity.a(view, isSelected, updatesItemData);
    }
}
