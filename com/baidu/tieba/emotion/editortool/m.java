package com.baidu.tieba.emotion.editortool;

import android.view.View;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
class m implements View.OnClickListener {
    final /* synthetic */ EmotionTabHorizonScrollView bvT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(EmotionTabHorizonScrollView emotionTabHorizonScrollView) {
        this.bvT = emotionTabHorizonScrollView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        BdToast.a(this.bvT.getContext(), this.bvT.getContext().getResources().getString(r.l.emotion_cant_show)).td();
    }
}
