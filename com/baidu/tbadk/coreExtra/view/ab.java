package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements View.OnClickListener {
    final /* synthetic */ LiveBroadcastCard afi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(LiveBroadcastCard liveBroadcastCard) {
        this.afi = liveBroadcastCard;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ad adVar;
        ad adVar2;
        String str;
        Context context;
        String str2;
        adVar = this.afi.mCardListener;
        if (adVar != null) {
            adVar2 = this.afi.mCardListener;
            adVar2.onClick(this.afi);
            return;
        }
        str = this.afi.mStatisticsKey;
        if (!TextUtils.isEmpty(str)) {
            context = this.afi.mContext;
            str2 = this.afi.mStatisticsKey;
            com.baidu.tbadk.core.k.A(context, str2);
        }
        this.afi.goToLiveBroadcastAcvitity();
    }
}
