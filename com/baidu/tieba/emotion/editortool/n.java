package com.baidu.tieba.emotion.editortool;

import android.view.View;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class n implements View.OnClickListener {
    final /* synthetic */ EmotionTabHorizonScrollView bLf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(EmotionTabHorizonScrollView emotionTabHorizonScrollView) {
        this.bLf = emotionTabHorizonScrollView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        BdToast.a(this.bLf.getContext(), this.bLf.getContext().getResources().getString(w.l.emotion_cant_show)).tk();
    }
}
