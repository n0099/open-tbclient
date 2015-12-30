package com.baidu.tieba.emotion.editortool;

import android.view.View;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tieba.n;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements View.OnClickListener {
    final /* synthetic */ EmotionTabHorizonScrollView aSY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(EmotionTabHorizonScrollView emotionTabHorizonScrollView) {
        this.aSY = emotionTabHorizonScrollView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        BdToast.b(this.aSY.getContext(), this.aSY.getContext().getResources().getString(n.j.emotion_cant_show)).to();
    }
}
