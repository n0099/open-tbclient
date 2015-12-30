package com.baidu.tbadk.coreExtra.view;

import android.view.View;
import com.baidu.tbadk.coreExtra.view.PhotoLiveCardView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements View.OnClickListener {
    final /* synthetic */ PhotoLiveCardView aph;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(PhotoLiveCardView photoLiveCardView) {
        this.aph = photoLiveCardView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PhotoLiveCardView.b bVar;
        PhotoLiveCardView.b bVar2;
        bVar = this.aph.anW;
        if (bVar != null) {
            bVar2 = this.aph.anW;
            bVar2.onPortraitClick(view);
        }
    }
}
