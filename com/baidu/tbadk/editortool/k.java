package com.baidu.tbadk.editortool;

import android.view.View;
import com.baidu.tbadk.core.dialog.BdToast;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements View.OnClickListener {
    final /* synthetic */ EmotionTabHorizonScrollView aiJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(EmotionTabHorizonScrollView emotionTabHorizonScrollView) {
        this.aiJ = emotionTabHorizonScrollView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        BdToast.a(this.aiJ.getContext(), this.aiJ.getContext().getResources().getString(com.baidu.tieba.y.emotion_cant_show)).ri();
    }
}
