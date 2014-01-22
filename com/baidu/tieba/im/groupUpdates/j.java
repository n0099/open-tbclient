package com.baidu.tieba.im.groupUpdates;

import android.view.View;
import com.baidu.cloudsdk.social.core.util.SocialAPIErrorCodes;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements View.OnClickListener {
    final /* synthetic */ f a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(f fVar) {
        this.a = fVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        UpdatesActivity updatesActivity;
        View view2;
        UpdatesItemData updatesItemData;
        updatesActivity = this.a.l;
        view2 = this.a.c;
        updatesItemData = this.a.m;
        updatesActivity.a(view2, SocialAPIErrorCodes.ERROR_INVALID_CLIENT_ID, 0, 0L, updatesItemData);
    }
}
