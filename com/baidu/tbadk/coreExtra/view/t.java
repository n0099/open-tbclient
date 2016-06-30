package com.baidu.tbadk.coreExtra.view;

import android.view.View;
import com.baidu.tbadk.coreExtra.view.PhotoLiveCardView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements View.OnClickListener {
    final /* synthetic */ PhotoLiveCardView amK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(PhotoLiveCardView photoLiveCardView) {
        this.amK = photoLiveCardView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PhotoLiveCardView.a aVar;
        PhotoLiveCardView.a aVar2;
        aVar = this.amK.aly;
        if (aVar != null) {
            aVar2 = this.amK.aly;
            aVar2.onDeleteClick(view);
        }
    }
}
