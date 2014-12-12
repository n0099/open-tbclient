package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements View.OnClickListener {
    final /* synthetic */ LiveBroadcastCard Up;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(LiveBroadcastCard liveBroadcastCard) {
        this.Up = liveBroadcastCard;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ae aeVar;
        ae aeVar2;
        String str;
        Context context;
        String str2;
        aeVar = this.Up.mCardListener;
        if (aeVar != null) {
            aeVar2 = this.Up.mCardListener;
            aeVar2.onClick(this.Up);
            return;
        }
        str = this.Up.mStatisticsKey;
        if (!TextUtils.isEmpty(str)) {
            context = this.Up.mContext;
            str2 = this.Up.mStatisticsKey;
            com.baidu.tbadk.core.i.B(context, str2);
        }
        this.Up.goToLiveBroadcastAcvitity();
    }
}
