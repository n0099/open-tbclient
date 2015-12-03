package com.baidu.tieba.emotion.editortool;

import android.view.View;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
class m implements View.OnClickListener {
    final /* synthetic */ EmotionTabHorizonScrollView aPg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(EmotionTabHorizonScrollView emotionTabHorizonScrollView) {
        this.aPg = emotionTabHorizonScrollView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        BdToast.b(this.aPg.getContext(), this.aPg.getContext().getResources().getString(n.i.emotion_cant_show)).tE();
    }
}
