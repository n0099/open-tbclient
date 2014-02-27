package com.baidu.tieba.im.groupUpdates;

import android.view.View;
import com.baidu.cloudsdk.social.core.util.SocialAPIErrorCodes;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class j implements View.OnClickListener {
    final /* synthetic */ f a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(f fVar) {
        this.a = fVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        UpdatesActivity updatesActivity;
        UpdatesItemData updatesItemData;
        View unused;
        updatesActivity = this.a.l;
        unused = this.a.c;
        updatesItemData = this.a.m;
        updatesActivity.a(SocialAPIErrorCodes.ERROR_INVALID_CLIENT_ID, updatesItemData);
    }
}
