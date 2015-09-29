package com.baidu.tbadk.coreExtra.view;

import android.text.TextUtils;
import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.view.LiveBroadcastCard;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements View.OnClickListener {
    final /* synthetic */ LiveBroadcastCard akI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(LiveBroadcastCard liveBroadcastCard) {
        this.akI = liveBroadcastCard;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        LiveBroadcastCard.a aVar;
        LiveBroadcastCard.b bVar;
        LiveBroadcastCard.b bVar2;
        String str;
        String str2;
        LiveBroadcastCard.a aVar2;
        aVar = this.akI.mCardOnClickDispatch;
        if (aVar != null) {
            aVar2 = this.akI.mCardOnClickDispatch;
            if (!aVar2.yX()) {
                return;
            }
        }
        bVar = this.akI.mCardListener;
        if (bVar != null) {
            bVar2 = this.akI.mCardListener;
            bVar2.onClick(this.akI);
            return;
        }
        str = this.akI.mStatisticsKey;
        if (!TextUtils.isEmpty(str)) {
            str2 = this.akI.mStatisticsKey;
            TiebaStatic.log(str2);
        }
        this.akI.goToLiveBroadcastAcvitity();
    }
}
