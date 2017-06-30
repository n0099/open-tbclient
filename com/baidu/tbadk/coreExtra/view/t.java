package com.baidu.tbadk.coreExtra.view;

import android.view.View;
import com.baidu.tbadk.coreExtra.view.PhotoLiveCardView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements View.OnClickListener {
    final /* synthetic */ PhotoLiveCardView awu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(PhotoLiveCardView photoLiveCardView) {
        this.awu = photoLiveCardView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PhotoLiveCardView.a aVar;
        PhotoLiveCardView.a aVar2;
        aVar = this.awu.avh;
        if (aVar != null) {
            aVar2 = this.awu.avh;
            aVar2.onDeleteClick(view);
        }
    }
}
