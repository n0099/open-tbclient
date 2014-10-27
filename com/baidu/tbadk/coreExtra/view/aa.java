package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa implements View.OnClickListener {
    final /* synthetic */ LiveBroadcastCard Oz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(LiveBroadcastCard liveBroadcastCard) {
        this.Oz = liveBroadcastCard;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ac acVar;
        ac acVar2;
        String str;
        Context context;
        String str2;
        acVar = this.Oz.mCardListener;
        if (acVar != null) {
            acVar2 = this.Oz.mCardListener;
            acVar2.onClick(this.Oz);
            return;
        }
        str = this.Oz.mStatisticsKey;
        if (!TextUtils.isEmpty(str)) {
            context = this.Oz.mContext;
            str2 = this.Oz.mStatisticsKey;
            com.baidu.tbadk.core.i.l(context, str2);
        }
        this.Oz.goToLiveBroadcastAcvitity();
    }
}
