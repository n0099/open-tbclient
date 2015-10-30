package com.baidu.tbadk.coreExtra.view;

import android.text.TextUtils;
import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.view.LiveBroadcastCard;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements View.OnClickListener {
    final /* synthetic */ LiveBroadcastCard akJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(LiveBroadcastCard liveBroadcastCard) {
        this.akJ = liveBroadcastCard;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        LiveBroadcastCard.a aVar;
        LiveBroadcastCard.b bVar;
        LiveBroadcastCard.b bVar2;
        String str;
        String str2;
        LiveBroadcastCard.a aVar2;
        aVar = this.akJ.mCardOnClickDispatch;
        if (aVar != null) {
            aVar2 = this.akJ.mCardOnClickDispatch;
            if (!aVar2.yU()) {
                return;
            }
        }
        bVar = this.akJ.mCardListener;
        if (bVar != null) {
            bVar2 = this.akJ.mCardListener;
            bVar2.onClick(this.akJ);
            return;
        }
        str = this.akJ.mStatisticsKey;
        if (!TextUtils.isEmpty(str)) {
            str2 = this.akJ.mStatisticsKey;
            TiebaStatic.log(str2);
        }
        this.akJ.goToLiveBroadcastAcvitity();
    }
}
