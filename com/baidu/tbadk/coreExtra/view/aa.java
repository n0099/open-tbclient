package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa implements View.OnClickListener {
    final /* synthetic */ LiveBroadcastCard OD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(LiveBroadcastCard liveBroadcastCard) {
        this.OD = liveBroadcastCard;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ac acVar;
        ac acVar2;
        String str;
        Context context;
        String str2;
        acVar = this.OD.mCardListener;
        if (acVar != null) {
            acVar2 = this.OD.mCardListener;
            acVar2.onClick(this.OD);
            return;
        }
        str = this.OD.mStatisticsKey;
        if (!TextUtils.isEmpty(str)) {
            context = this.OD.mContext;
            str2 = this.OD.mStatisticsKey;
            com.baidu.tbadk.core.j.l(context, str2);
        }
        this.OD.goToLiveBroadcastAcvitity();
    }
}
