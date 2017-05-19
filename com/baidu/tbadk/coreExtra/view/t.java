package com.baidu.tbadk.coreExtra.view;

import android.view.View;
import com.baidu.tbadk.coreExtra.view.PhotoLiveCardView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements View.OnClickListener {
    final /* synthetic */ PhotoLiveCardView avH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(PhotoLiveCardView photoLiveCardView) {
        this.avH = photoLiveCardView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PhotoLiveCardView.a aVar;
        PhotoLiveCardView.a aVar2;
        aVar = this.avH.auu;
        if (aVar != null) {
            aVar2 = this.avH.auu;
            aVar2.onDeleteClick(view);
        }
    }
}
