package com.baidu.tbadk.coreExtra.view;

import android.view.View;
import com.baidu.tbadk.coreExtra.view.PhotoLiveCardView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements View.OnClickListener {
    final /* synthetic */ PhotoLiveCardView ari;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(PhotoLiveCardView photoLiveCardView) {
        this.ari = photoLiveCardView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PhotoLiveCardView.b bVar;
        PhotoLiveCardView.b bVar2;
        bVar = this.ari.apX;
        if (bVar != null) {
            bVar2 = this.ari.apX;
            bVar2.onPortraitClick(view);
        }
    }
}
