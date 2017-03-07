package com.baidu.tieba.emotion.editortool;

import android.view.View;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class m implements View.OnClickListener {
    final /* synthetic */ EmotionTabHorizonScrollView bCZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(EmotionTabHorizonScrollView emotionTabHorizonScrollView) {
        this.bCZ = emotionTabHorizonScrollView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        BdToast.a(this.bCZ.getContext(), this.bCZ.getContext().getResources().getString(w.l.emotion_cant_show)).tA();
    }
}
