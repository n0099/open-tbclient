package com.baidu.tbadk.coreExtra.view;

import android.view.View;
import com.baidu.tbadk.coreExtra.view.PhotoLiveCardView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements View.OnClickListener {
    final /* synthetic */ PhotoLiveCardView aqq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(PhotoLiveCardView photoLiveCardView) {
        this.aqq = photoLiveCardView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PhotoLiveCardView.b bVar;
        PhotoLiveCardView.b bVar2;
        bVar = this.aqq.ape;
        if (bVar != null) {
            bVar2 = this.aqq.ape;
            bVar2.onPortraitClick(view);
        }
    }
}
