package com.baidu.tieba.emotion.editortool;

import android.view.View;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
class l implements View.OnClickListener {
    final /* synthetic */ EmotionTabHorizonScrollView aKG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(EmotionTabHorizonScrollView emotionTabHorizonScrollView) {
        this.aKG = emotionTabHorizonScrollView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        BdToast.b(this.aKG.getContext(), this.aKG.getContext().getResources().getString(i.h.emotion_cant_show)).sZ();
    }
}
