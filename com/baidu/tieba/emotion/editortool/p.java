package com.baidu.tieba.emotion.editortool;

import android.view.View;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements View.OnClickListener {
    final /* synthetic */ EmotionTabHorizonScrollView bFq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(EmotionTabHorizonScrollView emotionTabHorizonScrollView) {
        this.bFq = emotionTabHorizonScrollView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        BdToast.a(this.bFq.getContext(), this.bFq.getContext().getResources().getString(w.l.emotion_cant_show)).tl();
    }
}
