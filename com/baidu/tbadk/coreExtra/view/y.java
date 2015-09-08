package com.baidu.tbadk.coreExtra.view;

import android.view.View;
import com.baidu.tbadk.coreExtra.view.PhotoLiveCardView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements View.OnClickListener {
    final /* synthetic */ PhotoLiveCardView anw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(PhotoLiveCardView photoLiveCardView) {
        this.anw = photoLiveCardView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PhotoLiveCardView.b bVar;
        PhotoLiveCardView.b bVar2;
        bVar = this.anw.ams;
        if (bVar != null) {
            bVar2 = this.anw.ams;
            bVar2.onPortraitClick(view);
        }
    }
}
