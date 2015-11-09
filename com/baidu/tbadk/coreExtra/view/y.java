package com.baidu.tbadk.coreExtra.view;

import android.view.View;
import com.baidu.tbadk.coreExtra.view.PhotoLiveCardView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements View.OnClickListener {
    final /* synthetic */ PhotoLiveCardView alU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(PhotoLiveCardView photoLiveCardView) {
        this.alU = photoLiveCardView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PhotoLiveCardView.a aVar;
        PhotoLiveCardView.a aVar2;
        aVar = this.alU.ala;
        if (aVar != null) {
            aVar2 = this.alU.ala;
            aVar2.onDeleteClick(view);
        }
    }
}
