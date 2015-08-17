package com.baidu.tbadk.coreExtra.view;

import android.text.TextUtils;
import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.view.LiveBroadcastCard;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements View.OnClickListener {
    final /* synthetic */ LiveBroadcastCard alq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(LiveBroadcastCard liveBroadcastCard) {
        this.alq = liveBroadcastCard;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        LiveBroadcastCard.a aVar;
        LiveBroadcastCard.b bVar;
        LiveBroadcastCard.b bVar2;
        String str;
        String str2;
        LiveBroadcastCard.a aVar2;
        aVar = this.alq.mCardOnClickDispatch;
        if (aVar != null) {
            aVar2 = this.alq.mCardOnClickDispatch;
            if (!aVar2.zd()) {
                return;
            }
        }
        bVar = this.alq.mCardListener;
        if (bVar != null) {
            bVar2 = this.alq.mCardListener;
            bVar2.onClick(this.alq);
            return;
        }
        str = this.alq.mStatisticsKey;
        if (!TextUtils.isEmpty(str)) {
            str2 = this.alq.mStatisticsKey;
            TiebaStatic.log(str2);
        }
        this.alq.goToLiveBroadcastAcvitity();
    }
}
