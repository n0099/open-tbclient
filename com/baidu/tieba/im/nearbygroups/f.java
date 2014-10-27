package com.baidu.tieba.im.nearbygroups;

import android.view.View;
/* loaded from: classes.dex */
class f implements View.OnClickListener {
    final /* synthetic */ NearbyGroupsActivity bgc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(NearbyGroupsActivity nearbyGroupsActivity) {
        this.bgc = nearbyGroupsActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.bgc.Eh();
    }
}
