package com.baidu.tbadk.coreExtra.view;

import android.text.TextUtils;
import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.view.LiveBroadcastCard;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements View.OnClickListener {
    final /* synthetic */ LiveBroadcastCard amf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(LiveBroadcastCard liveBroadcastCard) {
        this.amf = liveBroadcastCard;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        LiveBroadcastCard.a aVar;
        LiveBroadcastCard.b bVar;
        LiveBroadcastCard.b bVar2;
        String str;
        String str2;
        LiveBroadcastCard.a aVar2;
        aVar = this.amf.mCardOnClickDispatch;
        if (aVar != null) {
            aVar2 = this.amf.mCardOnClickDispatch;
            if (!aVar2.zo()) {
                return;
            }
        }
        bVar = this.amf.mCardListener;
        if (bVar != null) {
            bVar2 = this.amf.mCardListener;
            bVar2.onClick(this.amf);
            return;
        }
        str = this.amf.mStatisticsKey;
        if (!TextUtils.isEmpty(str)) {
            str2 = this.amf.mStatisticsKey;
            TiebaStatic.log(str2);
        }
        this.amf.goToLiveBroadcastAcvitity();
    }
}
