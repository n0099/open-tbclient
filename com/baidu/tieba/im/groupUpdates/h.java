package com.baidu.tieba.im.groupUpdates;

import android.view.View;
import android.widget.ImageView;
import com.baidu.cloudsdk.social.core.util.SocialAPIErrorCodes;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements View.OnClickListener {
    final /* synthetic */ f a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(f fVar) {
        this.a = fVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        UpdatesActivity updatesActivity;
        UpdatesActivity updatesActivity2;
        View view2;
        UpdatesItemData updatesItemData;
        ImageView imageView;
        updatesActivity = this.a.l;
        if (updatesActivity.b()) {
            imageView = this.a.i;
            imageView.performClick();
            return;
        }
        updatesActivity2 = this.a.l;
        view2 = this.a.c;
        updatesItemData = this.a.m;
        updatesActivity2.a(view2, SocialAPIErrorCodes.ERROR_INVALID_CLIENT_ID, 0, 0L, updatesItemData);
    }
}
