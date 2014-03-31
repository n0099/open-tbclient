package com.baidu.tieba.im.groupUpdates;

import android.view.View;
import com.baidu.tieba.person.PersonInfoActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class m implements View.OnClickListener {
    final /* synthetic */ i a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(i iVar) {
        this.a = iVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        UpdatesActivity updatesActivity;
        UpdatesItemData updatesItemData;
        View unused;
        updatesActivity = this.a.l;
        unused = this.a.c;
        updatesItemData = this.a.m;
        updatesActivity.a(PersonInfoActivity.REQUSET_CHANGE, updatesItemData);
    }
}
