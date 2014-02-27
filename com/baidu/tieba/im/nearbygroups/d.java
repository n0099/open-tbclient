package com.baidu.tieba.im.nearbygroups;

import android.view.View;
/* loaded from: classes.dex */
final class d implements View.OnClickListener {
    final /* synthetic */ NearbyGroupsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(NearbyGroupsActivity nearbyGroupsActivity) {
        this.a = nearbyGroupsActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        NearbyGroupsActivity.c(this.a);
    }
}
