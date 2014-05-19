package com.baidu.tieba.im.live.livenotify;

import android.view.View;
import android.widget.ImageView;
import com.baidu.tieba.im.groupUpdates.UpdatesItemData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements View.OnClickListener {
    final /* synthetic */ k a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(k kVar) {
        this.a = kVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        LiveNotifyActivity liveNotifyActivity;
        LiveNotifyActivity liveNotifyActivity2;
        View view2;
        UpdatesItemData updatesItemData;
        ImageView imageView;
        liveNotifyActivity = this.a.b;
        if (!liveNotifyActivity.b()) {
            liveNotifyActivity2 = this.a.b;
            view2 = this.a.d;
            updatesItemData = this.a.c;
            liveNotifyActivity2.a(view2, 101, 0, 0L, updatesItemData);
            return;
        }
        imageView = this.a.g;
        imageView.performClick();
    }
}
