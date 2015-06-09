package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements View.OnClickListener {
    final /* synthetic */ LiveBroadcastCard agj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(LiveBroadcastCard liveBroadcastCard) {
        this.agj = liveBroadcastCard;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ad adVar;
        ae aeVar;
        ae aeVar2;
        String str;
        Context context;
        String str2;
        ad adVar2;
        adVar = this.agj.mCardOnClickDispatch;
        if (adVar != null) {
            adVar2 = this.agj.mCardOnClickDispatch;
            if (!adVar2.xU()) {
                return;
            }
        }
        aeVar = this.agj.mCardListener;
        if (aeVar != null) {
            aeVar2 = this.agj.mCardListener;
            aeVar2.onClick(this.agj);
            return;
        }
        str = this.agj.mStatisticsKey;
        if (!TextUtils.isEmpty(str)) {
            context = this.agj.mContext;
            str2 = this.agj.mStatisticsKey;
            com.baidu.tbadk.core.k.A(context, str2);
        }
        this.agj.goToLiveBroadcastAcvitity();
    }
}
