package com.baidu.tieba.emotion.editortool;

import android.view.View;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements View.OnClickListener {
    final /* synthetic */ EmotionTabHorizonScrollView bRD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(EmotionTabHorizonScrollView emotionTabHorizonScrollView) {
        this.bRD = emotionTabHorizonScrollView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        BdToast.a(this.bRD.getContext(), this.bRD.getContext().getResources().getString(w.l.emotion_cant_show)).ti();
    }
}
