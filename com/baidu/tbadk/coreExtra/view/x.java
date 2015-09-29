package com.baidu.tbadk.coreExtra.view;

import android.view.View;
import com.baidu.tbadk.coreExtra.view.PhotoLiveCardView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements View.OnClickListener {
    final /* synthetic */ PhotoLiveCardView alO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(PhotoLiveCardView photoLiveCardView) {
        this.alO = photoLiveCardView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PhotoLiveCardView.b bVar;
        PhotoLiveCardView.b bVar2;
        bVar = this.alO.akV;
        if (bVar != null) {
            bVar2 = this.alO.akV;
            bVar2.onPortraitClick(view);
        }
    }
}
