package com.baidu.tieba.im.groupUpdates;

import android.view.View;
import android.widget.ImageView;
import com.baidu.tieba.person.PersonInfoActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class k implements View.OnClickListener {
    final /* synthetic */ i a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(i iVar) {
        this.a = iVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        UpdatesActivity updatesActivity;
        UpdatesActivity updatesActivity2;
        UpdatesItemData updatesItemData;
        ImageView imageView;
        View unused;
        updatesActivity = this.a.l;
        if (updatesActivity.b()) {
            imageView = this.a.i;
            imageView.performClick();
            return;
        }
        updatesActivity2 = this.a.l;
        unused = this.a.c;
        updatesItemData = this.a.m;
        updatesActivity2.a(PersonInfoActivity.REQUSET_CHANGE, updatesItemData);
    }
}
