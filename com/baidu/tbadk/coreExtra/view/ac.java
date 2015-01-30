package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements View.OnClickListener {
    final /* synthetic */ LiveBroadcastCard UW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(LiveBroadcastCard liveBroadcastCard) {
        this.UW = liveBroadcastCard;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ae aeVar;
        ae aeVar2;
        String str;
        Context context;
        String str2;
        aeVar = this.UW.mCardListener;
        if (aeVar != null) {
            aeVar2 = this.UW.mCardListener;
            aeVar2.onClick(this.UW);
            return;
        }
        str = this.UW.mStatisticsKey;
        if (!TextUtils.isEmpty(str)) {
            context = this.UW.mContext;
            str2 = this.UW.mStatisticsKey;
            com.baidu.tbadk.core.i.A(context, str2);
        }
        this.UW.goToLiveBroadcastAcvitity();
    }
}
