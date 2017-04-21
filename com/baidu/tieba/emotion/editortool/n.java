package com.baidu.tieba.emotion.editortool;

import android.view.View;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class n implements View.OnClickListener {
    final /* synthetic */ EmotionTabHorizonScrollView bFj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(EmotionTabHorizonScrollView emotionTabHorizonScrollView) {
        this.bFj = emotionTabHorizonScrollView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        BdToast.a(this.bFj.getContext(), this.bFj.getContext().getResources().getString(w.l.emotion_cant_show)).tY();
    }
}
