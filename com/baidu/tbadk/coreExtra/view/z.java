package com.baidu.tbadk.coreExtra.view;

import android.view.View;
import com.baidu.tbadk.coreExtra.view.PhotoLiveCardView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements View.OnClickListener {
    final /* synthetic */ PhotoLiveCardView anw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(PhotoLiveCardView photoLiveCardView) {
        this.anw = photoLiveCardView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PhotoLiveCardView.a aVar;
        PhotoLiveCardView.a aVar2;
        aVar = this.anw.amr;
        if (aVar != null) {
            aVar2 = this.anw.amr;
            aVar2.onDeleteClick(view);
        }
    }
}
